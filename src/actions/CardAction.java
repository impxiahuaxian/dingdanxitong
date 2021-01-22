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
	
	//��ȡ�������۵���Ϣ
	public String cardlist(){
		List<Card> cards = cardService.getCards();
		getRequest().put("cards", cards);
		return "cardlist";
	}
	
	//ɾ�����۵���Ϣ
	public String delete(){
		cardService.delete(card);
		return "recardlist";
	}

	//������۵���Ϣ
	public String add(){
		String vip_id = getServletRequest().getParameter("vip_id");
		if (vip_id!=null && !vip_id.equals("")) {//����ǻ�Ա�������¼��Ա��Ϣ
			card.setVip(vipService.getVip(Integer.parseInt(vip_id)));
		}else {card.setVip(null);}
		card.setEmp((Emp)getSession().get("emp"));//���þ�����
		cardService.add(card);	//�������۵�
		return "recardlist";
	}
	
	//����˵���¼
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
