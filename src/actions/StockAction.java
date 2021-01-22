package actions;

import java.util.List;
import javax.annotation.Resource;

import models.Emp;
import models.Goods;
import models.Stock;
import models.Store;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import services.EmpService;
import services.GoodsService;
import services.StockService;

@Action("stock")
@Results({
	@Result(name="stocklist",location="/market/pages/stock-list.jsp"),
	@Result(name="update",location="/market/pages/stock-update.jsp"),
	@Result(name="add",location="/market/pages/stock-add.jsp"),
	@Result(name="restocklist",type="redirect",location="stock!stocklist.action"),
})
public class StockAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource
	private StockService stockService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private EmpService empService;
	private Stock stock;
	
	//��ȡ���н�����Ϣ
	public String stocklist(){
		List<Stock> stocks = stockService.getStocks();
		getRequest().put("stocks", stocks);
		return "stocklist";
	}
	
	//���½�����Ϣ
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ��������
			stock.setEmp((Emp)(getSession().get("emp")));//���þ�����
			stockService.update(stock);
			return "restocklist";
		}else {//����Ϊ�޸�ҳ���ṩ������Ϣ
			Stock result = stockService.getStock(stock);
			List<Goods> goodses = goodsService.getGoodses();
			getRequest().put("stock", result);
			getRequest().put("goodses", goodses);
			return "update";
		}
	}
	
	//ɾ��������Ϣ
	public String delete(){
		stockService.delete(stock);
		return "restocklist";
	}

	//��ӽ�����Ϣ
	public String add(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ�������
			stock.setEmp((Emp)(getSession().get("emp")));//���þ�����
			Store store = goodsService.getStore(stock.getGoods().getId());
			if (store == null) {//���������û�и���Ʒ����¼
				goodsService.addStore(stock.getGoods(),stock.getAmount());//��ӿ���¼
			}else {store.setAmount(store.getAmount()+stock.getAmount());//���¿������
				goodsService.updateStore(store);//���¿���¼
			}stockService.add(stock);
			return "restocklist";
		}else {//����Ϊ���ҳ���ṩ������Ϣ
			List<Goods> goodses = goodsService.getGoodses();
			getRequest().put("goodses", goodses);
			return "add";
		}
	}
	
	
	
	
	
	
	
	

	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	
}
