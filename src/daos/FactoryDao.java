package daos;

import java.util.List;

import models.Factory;

import org.springframework.stereotype.Repository;

@Repository//注册spring管理bean
@SuppressWarnings("unchecked")
public class FactoryDao extends BaseDao{

	//获取所有供货商信息
	public List<Factory> getFactorys() {
		return getSession().createQuery("from Factory").list();
	}

	//根据id获取供货商信息
	public Factory getFactory(Factory factory) {
		return (Factory) getSession().get(Factory.class, factory.getId());
	}

}
