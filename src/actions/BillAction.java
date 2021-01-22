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
	

	//��ȡ�˵���¼�б�
	public String billlist(){
		List<Bill> bills = billService.getBills(card.getId());//����card_id��ȡ���м�¼
		Card cardx = cardService.getCard(card.getId());//����card_id��ȡ��card����Ϣ
		getRequest().put("bills", bills);//���ض�����¼
		getRequest().put("card", cardx);//����card��Ϣ
		return "billlist";
	}
	
	//����˵���¼
	public String add(){
		if (getServletRequest().getParameter("type")==null) {//�������û�������־ �������Ϣ���
			bill.setCard(card);	//�������ۼ�¼��ĳ�����۵�
			bill.setGoods(goodsService.getGoods(bill.getGoods()));	//������Ʒ
			bill.setTotal(bill.getAmount()*bill.getGoods().getPrice());	//�����ܼ�=����*����
			Store store = goodsService.getStore(bill.getGoods().getId());	//��ȡ�����Ϣ
			store.setSales(store.getSales()+bill.getAmount());	//���Ӹ���Ʒ��������¼
			goodsService.updateStore(store);//���¿����Ϣ
			Card oldcard = cardService.getCard(card);	//��ȡ�ü�¼�����۵���Ϣ
			if (oldcard.getVip()==null) {	//�������ͨ�ͻ�
				oldcard.setTotal(oldcard.getTotal()+bill.getTotal());	//�ܼ��ۼ�
			}else {//�����vip
				oldcard.setTotal(oldcard.getTotal()+bill.getTotal());	//�ܼ��ۼ�
				oldcard.setTotal_vip(String.valueOf(oldcard.getTotal()*oldcard.getVip().getRebate()));//���û�Ա�ۺ��
				oldcard.getVip().setGrade((int)(oldcard.getVip().getGrade()+bill.getTotal()));//��Ա�ۼӻ���
				if (oldcard.getVip().getGrade()<1000) {//����Ա�������û�Ա�ȼ����ۿ�
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
				vipService.upgrade(oldcard.getVip());//���»�Ա��Ϣ
			}
			billService.add(bill);	//������ۼ�¼
			cardService.update(oldcard);	//���������˵�
			return "rebilllist";
		}else {	//���������������־ �򷵻���Ʒ��Ϣ ��ת�����ҳ��
			List<Goods> goodses = goodsService.getGoodses();
			getRequest().put("goodses", goodses);
			return "add";
		}
	}
	
	//ɾ���˵���¼
	public String delete(){
		Bill oldbill = billService.getBill(bill);
		Card oldcard = cardService.getCard(oldbill.getCard());
		if (oldcard.getVip()==null) {	//�������ͨ�ͻ�
			oldcard.setTotal(oldcard.getTotal()-oldbill.getTotal());	//���۵��м�ȥɾ����¼�ļ۸�
		}else {
			oldcard.setTotal(oldcard.getTotal()-oldbill.getTotal());	//���۵��м�ȥɾ����¼�ļ۸�
			oldcard.setTotal_vip(String.valueOf(oldcard.getTotal()*oldcard.getVip().getRebate()));//�����趨�ۺ��
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
