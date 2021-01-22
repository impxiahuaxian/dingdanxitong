package daos;

import java.util.List;

import models.Goods;
import models.Store;

import org.springframework.stereotype.Repository;

@Repository//注册spring管理bean
@SuppressWarnings("unchecked")
public class GoodsDao extends BaseDao{

	//获取所有商品信息
	public List<Goods> getGoodses() {
		return getSession().createQuery("from Goods").list();
	}

	//获取商品信息
	public Goods getGoods(Goods goods) {
		return (Goods) getSession().get(Goods.class, goods.getId());
	}

	//获取所有商品库存信息
	public List<Store> getStores() {
		return getSession().createQuery("from Store").list();
	}

	//获取商品库存信息
	public Store getStore(int goods_id) {
		return (Store) getSession().createQuery("from Store where goods_id=?").setParameter(0, goods_id).uniqueResult();
	}

}
