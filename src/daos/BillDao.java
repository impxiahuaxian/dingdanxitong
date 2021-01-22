package daos;

import java.util.List;

import models.Bill;

import org.springframework.stereotype.Repository;

@Repository//注册spring管理bean
@SuppressWarnings("unchecked")
public class BillDao extends BaseDao{

	//获取账单记录列表
	public List<Bill> getBills(int card_id) {
		return getSession().createQuery("from Bill where card_id=?")
				.setParameter(0, card_id).list();
	}

	//获取账单记录
	public Bill getBill(Bill bill) {
		return (Bill) getSession().get(Bill.class, bill.getId());
	}

}
