package services;

import java.util.List;

import javax.annotation.Resource;

import models.Factory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.FactoryDao;

@Service
@Transactional	//���ô˷��������������
public class FactoryService {

	@Resource
	private FactoryDao factoryDao;

	//��ȡ���й�������Ϣ
	public List<Factory> getFactorys() {
		return factoryDao.getFactorys();
	}

	//����id��ȡ��������Ϣ
	public Factory getFactory(Factory factory) {
		return factoryDao.getFactory(factory);
	}

	//���¹�������Ϣ
	public boolean update(Factory factory) {
		return factoryDao.update(factory);
	}

	//ɾ����������Ϣ
	public boolean delete(Factory factory) {
		return factoryDao.delete(factory);
	}

	//��ӹ�������Ϣ
	public boolean add(Factory factory) {
		return factoryDao.save(factory);
	}
	
}
