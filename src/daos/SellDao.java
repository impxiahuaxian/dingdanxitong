package daos;

import java.util.List;

import models.Sell;

import org.springframework.stereotype.Repository;

@Repository//注册spring管理bean
@SuppressWarnings("unchecked")
public class SellDao extends BaseDao{

	//获取所有出货信息
	public List<Sell> getSells() {
		return getSession().createQuery("from Sell").list();
	}

	//根据id获取出货信息
	public Sell getSell(Sell sell) {
		return (Sell) getSession().get(Sell.class, sell.getId());
	}
	
}
