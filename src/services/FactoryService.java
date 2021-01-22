package services;

import java.util.List;

import javax.annotation.Resource;

import models.Factory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.FactoryDao;

@Service
@Transactional	//配置此方法加入事务管理
public class FactoryService {

	@Resource
	private FactoryDao factoryDao;

	//获取所有供货商信息
	public List<Factory> getFactorys() {
		return factoryDao.getFactorys();
	}

	//根据id获取供货商信息
	public Factory getFactory(Factory factory) {
		return factoryDao.getFactory(factory);
	}

	//更新供货商信息
	public boolean update(Factory factory) {
		return factoryDao.update(factory);
	}

	//删除供货商信息
	public boolean delete(Factory factory) {
		return factoryDao.delete(factory);
	}

	//添加供货商信息
	public boolean add(Factory factory) {
		return factoryDao.save(factory);
	}
	
}
