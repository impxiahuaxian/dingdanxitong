package actions;

import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import services.FactoryService;
import services.GoodsService;
import models.Factory;
import models.Goods;
import models.Store;

@Action("goods")
@Results({
	@Result(name="goodslist",location="/market/pages/goods-list.jsp"),
	@Result(name="storelist",location="/market/pages/store-list.jsp"),
	@Result(name="update",location="/market/pages/goods-update.jsp"),
	@Result(name="add",location="/market/pages/goods-add.jsp"),
	@Result(name="regoodslist",type="redirectAction",location="goods!goodslist.action"),
})
public class GoodsAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource
	private GoodsService goodsService;
	@Resource
	private FactoryService factoryService;
	private Goods goods;
	
	//��ȡ������Ʒ��Ϣ
	public String goodslist(){
		List<Goods> goodses = goodsService.getGoodses();
		getRequest().put("goodses", goodses);
		return "goodslist";
	}
	
	//������Ʒ��Ϣ
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ��������
			goodsService.update(goods);
			return "regoodslist";
		}else {//����Ϊ�޸�ҳ���ṩ������Ϣ
			Goods result = goodsService.getGoods(goods);
			getRequest().put("goods", result);
			List<Factory> factories = factoryService.getFactorys();
			getRequest().put("factories", factories);
			return "update";
		}
	}
	
	//ɾ����Ʒ��Ϣ
	public String delete(){
		goodsService.delete(goods);
		return "regoodslist";
	}

	//�����Ʒ��Ϣ
	public String add(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ�������
			goodsService.add(goods);
			return "regoodslist";
		}else {//����Ϊ���ҳ���ṩ������Ϣ
			List<Factory> factories = factoryService.getFactorys();
			getRequest().put("factories", factories);
			return "add";
		}
	}
	
	//��ȡ������Ʒ�����Ϣ
	public String storelist(){
		List<Store> stores = goodsService.getStores();
		getRequest().put("stores", stores);
		return "storelist";
	}
	
	

	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
