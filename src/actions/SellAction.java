package actions;

import java.util.List;
import javax.annotation.Resource;
import models.Emp;
import models.Goods;
import models.Sell;
import models.Store;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import services.EmpService;
import services.GoodsService;
import services.SellService;

@Action("sell")
@Results({
	@Result(name="selllist",location="/market/pages/sell-list.jsp"),
	@Result(name="update",location="/market/pages/sell-update.jsp"),
	@Result(name="add",location="/market/pages/sell-add.jsp"),
	@Result(name="reselllist",type="redirect",location="sell!selllist.action"),
})
public class SellAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource
	private SellService sellService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private EmpService empService;
	private Sell sell;
	
	
	//��ȡ���г�����Ϣ
	public String selllist(){
		List<Sell> sells = sellService.getSells();
		getRequest().put("sells", sells);
		return "selllist";
	}
	
	//���³�����Ϣ
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ��������
			sell.setEmp((Emp)(getSession().get("emp")));//���þ�����
			sellService.update(sell);
			return "reselllist";
		}else {//����Ϊ�޸�ҳ���ṩ������Ϣ
			Sell result = sellService.getSell(sell);
			List<Goods> goodses = goodsService.getGoodses();
			getRequest().put("sell", result);
			getRequest().put("goodses", goodses);
			return "update";
		}
	}
	
	//ɾ��������Ϣ
	public String delete(){
		sellService.delete(sell);
		return "reselllist";
	}

	//��ӳ�����Ϣ
	public String add(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ�������
			sell.setEmp((Emp)(getSession().get("emp")));//���þ�����
			Store store = goodsService.getStore(sell.getGoods().getId());
			if (store == null) {//���������û�и���Ʒ����¼
				getRequest().put("msg", "û�и���Ʒ�Ŀ����Ϣ!!");
				List<Goods> goodses = goodsService.getGoodses();
				getRequest().put("goodses", goodses);
				return "add";
			}else {
				if (store.getAmount()<=0) {
					getRequest().put("msg", "����Ʒ��治��!!");
					List<Goods> goodses = goodsService.getGoodses();
					getRequest().put("goodses", goodses);
					return "add";
				}
				if (sell.getAmount()>store.getAmount()) {
					getRequest().put("msg", "�����������ô��ڿ������!!");
					List<Goods> goodses = goodsService.getGoodses();
					getRequest().put("goodses", goodses);
					return "add";
				}
				store.setAmount(store.getAmount()-sell.getAmount());//���¿������
				goodsService.updateStore(store);
			}
			sellService.add(sell);
			return "reselllist";
		}else {//����Ϊ���ҳ���ṩ������Ϣ
			List<Goods> goodses = goodsService.getGoodses();
			getRequest().put("goodses", goodses);
			return "add";
		}
	}
	
	
	
	
	
	
	
	
	public Sell getSell() {
		return sell;
	}
	public void setSell(Sell sell) {
		this.sell = sell;
	}
	
	
}
