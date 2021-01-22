package services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.GoodsDao;
import models.Goods;
import models.Store;

@Service
@Transactional	//���ô˷��������������
public class GoodsService {

	@Resource
	private GoodsDao goodsDao;
	@Resource
	private Store store;
	
	
	//��ȡ������Ʒ��Ϣ
	public List<Goods> getGoodses() {
		return goodsDao.getGoodses();		
	}

	//��ȡ��Ʒ��Ϣ
	public Goods getGoods(Goods goods) {
		return goodsDao.getGoods(goods);	
	}
	
	//������Ʒ��Ϣ
	public boolean update(Goods goods) {
		return goodsDao.update(goods);		
	}

	//ɾ����Ʒ��Ϣ
	public boolean delete(Goods goods) {
		return goodsDao.delete(goods);
	}

	//�����Ʒ��Ϣ
	public boolean add(Goods goods) {
		return goodsDao.save(goods);
	}

	//��ȡ������Ʒ�����Ϣ
	public List<Store> getStores() {
		return goodsDao.getStores();
	}

	//��ȡ��Ʒ�����Ϣ
	public Store getStore(int goods_id) {
		return goodsDao.getStore(goods_id);		
	}

	//��ӿ���¼
	public boolean addStore(Goods goods, int amount) {
		store.setGoods(goods);
		store.setAmount(amount);
		return goodsDao.save(store);
	}

	//���¿���¼
	public boolean updateStore(Store store) {
		return goodsDao.update(store);		
	}

	
}
