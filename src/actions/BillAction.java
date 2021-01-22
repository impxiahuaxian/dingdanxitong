package actions;

import java.util.List;
//import javax.annotation.Resource;
import models.Bill;
import models.Card;
import models.Goods;
import models.Store;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import services.BillService;
import services.CardService;
import services.GoodsService;
import services.VipService;

@Action("bill")
@Results({
	@Result(name="billlist",location="/market/pages/bill-list.jsp"),
	@Result(name="add",location="/market/pages/bill-add.jsp"),
	@Result(name="rebilllist",type="redirect",location="bill!billlist.action"),
})
public class BillAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private BillService billService;
	@Autowired
	private CardService cardService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private VipService vipService;
	private Card card;
	private Bill bill;
	

	//获取账单记录列表
	public String billlist(){
		List<Bill> bills = billService.getBills(card.getId());//根据card_id获取所有记录
		Card cardx = cardService.getCard(card.getId());//根据card_id获取该card的信息
		getRequest().put("bills", bills);//返回订单记录
		getRequest().put("card", cardx);//返回card信息
		return "billlist";
	}
	
	//添加账单记录
	public String add(){
		if (getServletRequest().getParameter("type")==null) {//如果请求没有特殊标志 则进行信息添加
			bill.setCard(card);	//设置销售记录归某张销售单
			bill.setGoods(goodsService.getGoods(bill.getGoods()));	//设置商品
			bill.setTotal(bill.getAmount()*bill.getGoods().getPrice());	//设置总价=数量*单价
			Store store = goodsService.getStore(bill.getGoods().getId());	//获取库存信息
			store.setSales(store.getSales()+bill.getAmount());	//增加该商品的销量记录
			goodsService.updateStore(store);//更新库存信息
			Card oldcard = cardService.getCard(card);	//获取该记录的销售单信息
			if (oldcard.getVip()==null) {	//如果是普通客户
				oldcard.setTotal(oldcard.getTotal()+bill.getTotal());	//总价累加
			}else {//如果是vip
				oldcard.setTotal(oldcard.getTotal()+bill.getTotal());	//总价累加
				oldcard.setTotal_vip(String.valueOf(oldcard.getTotal()*oldcard.getVip().getRebate()));//设置会员折后价
				oldcard.getVip().setGrade((int)(oldcard.getVip().getGrade()+bill.getTotal()));//会员累加积分
				if (oldcard.getVip().getGrade()<1000) {//按会员积分设置会员等级和折扣
					oldcard.getVip().setLevel(1);oldcard.getVip().setRebate(0.95f);
				}else if (oldcard.getVip().getGrade()>=1000&&oldcard.getVip().getGrade()<2000) {
					oldcard.getVip().setLevel(2);oldcard.getVip().setRebate(0.9f);
				}else if (oldcard.getVip().getGrade()>=2000&&oldcard.getVip().getGrade()<3000) {
					oldcard.getVip().setLevel(3);oldcard.getVip().setRebate(0.85f);
				}else if (oldcard.getVip().getGrade()>=3000&&oldcard.getVip().getGrade()<4000) {
					oldcard.getVip().setLevel(4);oldcard.getVip().setRebate(0.8f);
				}else if (oldcard.getVip().getGrade()>=4000&&oldcard.getVip().getGrade()<5000) {
					oldcard.getVip().setLevel(5);oldcard.getVip().setRebate(0.75f);
				}else {
					oldcard.getVip().setLevel(6);oldcard.getVip().setRebate(0.7f);
				}
				vipService.upgrade(oldcard.getVip());//更新会员信息
			}
			billService.add(bill);	//添加销售记录
			cardService.update(oldcard);	//更新销售账单
			return "rebilllist";
		}else {	//若请求中有特殊标志 则返回商品信息 跳转到添加页面
			List<Goods> goodses = goodsService.getGoodses();
			getRequest().put("goodses", goodses);
			return "add";
		}
	}
	
	//删除账单记录
	public String delete(){
		Bill oldbill = billService.getBill(bill);
		Card oldcard = cardService.getCard(oldbill.getCard());
		if (oldcard.getVip()==null) {	//如果是普通客户
			oldcard.setTotal(oldcard.getTotal()-oldbill.getTotal());	//销售单中减去删除记录的价格
		}else {
			oldcard.setTotal(oldcard.getTotal()-oldbill.getTotal());	//销售单中减去删除记录的价格
			oldcard.setTotal_vip(String.valueOf(oldcard.getTotal()*oldcard.getVip().getRebate()));//重新设定折后价
		}
		billService.delete(oldbill);
		cardService.update(oldcard);
		return "rebilllist";
	}
	
	
	
	
	
	

	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
}
