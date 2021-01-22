package daos;

import java.util.List;

import models.Factory;

import org.springframework.stereotype.Repository;

@Repository//ע��spring����bean
@SuppressWarnings("unchecked")
public class FactoryDao extends BaseDao{

	//��ȡ���й�������Ϣ
	public List<Factory> getFactorys() {
		return getSession().createQuery("from Factory").list();
	}

	//����id��ȡ��������Ϣ
	public Factory getFactory(Factory factory) {
		return (Factory) getSession().get(Factory.class, factory.getId());
	}

}
