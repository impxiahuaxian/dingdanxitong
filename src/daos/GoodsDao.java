package daos;

import java.util.List;

import models.Goods;
import models.Store;

import org.springframework.stereotype.Repository;

@Repository//ע��spring����bean
@SuppressWarnings("unchecked")
public class GoodsDao extends BaseDao{

	//��ȡ������Ʒ��Ϣ
	public List<Goods> getGoodses() {
		return getSession().createQuery("from Goods").list();
	}

	//��ȡ��Ʒ��Ϣ
	public Goods getGoods(Goods goods) {
		return (Goods) getSession().get(Goods.class, goods.getId());
	}

	//��ȡ������Ʒ�����Ϣ
	public List<Store> getStores() {
		return getSession().createQuery("from Store").list();
	}

	//��ȡ��Ʒ�����Ϣ
	public Store getStore(int goods_id) {
		return (Store) getSession().createQuery("from Store where goods_id=?").setParameter(0, goods_id).uniqueResult();
	}

}
