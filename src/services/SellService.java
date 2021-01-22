package services;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import models.Sell;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.SellDao;

@Service
@Transactional	//配置此方法加入事务管理
public class SellService {

	@Resource
	private SellDao sellDao;
	
	//获取所有出货信息
	public List<Sell> getSells() {
		return sellDao.getSells();
	}

	//根据id获取出货信息
	public Sell getSell(Sell sell) {
		return sellDao.getSell(sell);
	}

	//更新出货信息
	public boolean update(Sell sell) {
		sell.setDate(new Date());
		return sellDao.update(sell);
	}

	//删除出货信息
	public boolean delete(Sell sell) {
		return sellDao.delete(sell);
	}

	//添加出货信息
	public boolean add(Sell sell) {
		sell.setDate(new Date());
		return sellDao.save(sell);
	}
	
}
