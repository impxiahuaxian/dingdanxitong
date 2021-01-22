package daos;

import java.util.List;

import models.Stock;

import org.springframework.stereotype.Repository;

@Repository//ע��spring����bean
@SuppressWarnings("unchecked")
public class StockDao extends BaseDao{

	//��ȡ���н�����Ϣ
	public List<Stock> getStocks() {
		return getSession().createQuery("from Stock").list();
	}

	//����id��ȡ������Ϣ
	public Stock getStock(Stock stock) {
		return (Stock) getSession().get(Stock.class, stock.getId());
	}
	
}
