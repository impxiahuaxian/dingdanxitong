package daos;

import java.util.List;

import models.Vip;

import org.springframework.stereotype.Repository;

@Repository//ע��spring����bean
@SuppressWarnings("unchecked")
public class VipDao extends BaseDao{

	//��ȡ���л�Ա��Ϣ
	public List<Vip> getVips() {
		return getSession().createQuery("from Vip").list();
	}

	//����id��ȡ��Ա��Ϣ
	public Vip getVip(Vip vip) {
		return (Vip) getSession().get(Vip.class, vip.getId());
	}

	//����id��ȡvip��Ϣ
	public Vip getVip(int id) {
		return (Vip) getSession().get(Vip.class, id);
	}
	
}
