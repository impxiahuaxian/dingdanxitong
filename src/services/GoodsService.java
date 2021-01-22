package services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.GoodsDao;
import models.Goods;
import models.Store;

@Service
@Transactional	//配置此方法加入事务管理
public class GoodsService {

	@Resource
	private GoodsDao goodsDao;
	@Resource
	private Store store;
	
	
	//获取所有商品信息
	public List<Goods> getGoodses() {
		return goodsDao.getGoodses();		
	}

	//获取商品信息
	public Goods getGoods(Goods goods) {
		return goodsDao.getGoods(goods);	
	}
	
	//更新商品信息
	public boolean update(Goods goods) {
		return goodsDao.update(goods);		
	}

	//删除商品信息
	public boolean delete(Goods goods) {
		return goodsDao.delete(goods);
	}

	//添加商品信息
	public boolean add(Goods goods) {
		return goodsDao.save(goods);
	}

	//获取所有商品库存信息
	public List<Store> getStores() {
		return goodsDao.getStores();
	}

	//获取商品库存信息
	public Store getStore(int goods_id) {
		return goodsDao.getStore(goods_id);		
	}

	//添加库存记录
	public boolean addStore(Goods goods, int amount) {
		store.setGoods(goods);
		store.setAmount(amount);
		return goodsDao.save(store);
	}

	//更新库存记录
	public boolean updateStore(Store store) {
		return goodsDao.update(store);		
	}

	
}
