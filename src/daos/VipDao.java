package daos;

import java.util.List;

import models.Vip;

import org.springframework.stereotype.Repository;

@Repository//注册spring管理bean
@SuppressWarnings("unchecked")
public class VipDao extends BaseDao{

	//获取所有会员信息
	public List<Vip> getVips() {
		return getSession().createQuery("from Vip").list();
	}

	//根据id获取会员信息
	public Vip getVip(Vip vip) {
		return (Vip) getSession().get(Vip.class, vip.getId());
	}

	//根据id获取vip信息
	public Vip getVip(int id) {
		return (Vip) getSession().get(Vip.class, id);
	}
	
}
