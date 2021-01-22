package services;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import models.Stock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.StockDao;

@Service
@Transactional	//配置此方法加入事务管理
public class StockService {

	@Resource
	private StockDao stockDao;
	
	//获取所有进货信息
	public List<Stock> getStocks() {
		return stockDao.getStocks();
	}

	//根据id获取进货信息
	public Stock getStock(Stock stock) {
		return stockDao.getStock(stock);
	}

	//更新进货信息
	public boolean update(Stock stock) {
		stock.setDate(new Date());
		return stockDao.update(stock);
	}

	//删除进货信息
	public boolean delete(Stock stock) {
		return stockDao.delete(stock);
	}

	//添加进货信息
	public boolean add(Stock stock) {
		stock.setDate(new Date());
		return stockDao.save(stock);
	}
	
}
