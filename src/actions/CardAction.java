package actions;

import java.util.List;
import javax.annotation.Resource;
import models.Card;
import models.Emp;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import services.CardService;
import services.VipService;

@Action("card")
@Results({
	@Result(name="cardlist",location="/market/pages/card-list.jsp"),
	@Result(name="billlist",location="/market/pages/bill-list.jsp"),
	@Result(name="add",location="/market/pages/card-add.jsp"),
	@Result(name="recardlist",type="redirect",location="card!cardlist.action"),
	@Result(name="rebilllist",type="redirect",location="card!billlist.action"),
})
public class CardAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Autowired
	private CardService cardService;
	@Autowired
	private VipService vipService;
	private Card card;
	
	//获取所有销售单信息
	public String cardlist(){
		List<Card> cards = cardService.getCards();
		getRequest().put("cards", cards);
		return "cardlist";
	}
	
	//删除销售单信息
	public String delete(){
		cardService.delete(card);
		return "recardlist";
	}

	//添加销售单信息
	public String add(){
		String vip_id = getServletRequest().getParameter("vip_id");
		if (vip_id!=null && !vip_id.equals("")) {//如果是会员购物则记录会员信息
			card.setVip(vipService.getVip(Integer.parseInt(vip_id)));
		}else {card.setVip(null);}
		card.setEmp((Emp)getSession().get("emp"));//设置经手人
		cardService.add(card);	//创建销售单
		return "recardlist";
	}
	
	//添加账单记录
	public String addbill(){
		return "rebilllist";
	}
	
	
	
	
	
	
	
	
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
}
