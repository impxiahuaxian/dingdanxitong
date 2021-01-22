package services;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import models.Stock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.StockDao;

@Service
@Transactional	//���ô˷��������������
public class StockService {

	@Resource
	private StockDao stockDao;
	
	//��ȡ���н�����Ϣ
	public List<Stock> getStocks() {
		return stockDao.getStocks();
	}

	//����id��ȡ������Ϣ
	public Stock getStock(Stock stock) {
		return stockDao.getStock(stock);
	}

	//���½�����Ϣ
	public boolean update(Stock stock) {
		stock.setDate(new Date());
		return stockDao.update(stock);
	}

	//ɾ��������Ϣ
	public boolean delete(Stock stock) {
		return stockDao.delete(stock);
	}

	//��ӽ�����Ϣ
	public boolean add(Stock stock) {
		stock.setDate(new Date());
		return stockDao.save(stock);
	}
	
}
