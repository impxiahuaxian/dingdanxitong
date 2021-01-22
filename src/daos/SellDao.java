package daos;

import java.util.List;

import models.Sell;

import org.springframework.stereotype.Repository;

@Repository//ע��spring����bean
@SuppressWarnings("unchecked")
public class SellDao extends BaseDao{

	//��ȡ���г�����Ϣ
	public List<Sell> getSells() {
		return getSession().createQuery("from Sell").list();
	}

	//����id��ȡ������Ϣ
	public Sell getSell(Sell sell) {
		return (Sell) getSession().get(Sell.class, sell.getId());
	}
	
}
