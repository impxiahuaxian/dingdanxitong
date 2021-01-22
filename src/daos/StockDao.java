package daos;

import java.util.List;

import models.Stock;

import org.springframework.stereotype.Repository;

@Repository//注册spring管理bean
@SuppressWarnings("unchecked")
public class StockDao extends BaseDao{

	//获取所有进货信息
	public List<Stock> getStocks() {
		return getSession().createQuery("from Stock").list();
	}

	//根据id获取进货信息
	public Stock getStock(Stock stock) {
		return (Stock) getSession().get(Stock.class, stock.getId());
	}
	
}
