package daos;

import java.util.List;

import models.Bill;

import org.springframework.stereotype.Repository;

@Repository//ע��spring����bean
@SuppressWarnings("unchecked")
public class BillDao extends BaseDao{

	//��ȡ�˵���¼�б�
	public List<Bill> getBills(int card_id) {
		return getSession().createQuery("from Bill where card_id=?")
				.setParameter(0, card_id).list();
	}

	//��ȡ�˵���¼
	public Bill getBill(Bill bill) {
		return (Bill) getSession().get(Bill.class, bill.getId());
	}

}
