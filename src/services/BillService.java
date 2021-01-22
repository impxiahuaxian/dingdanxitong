package services;

import java.util.List;
import javax.annotation.Resource;
import models.Bill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.BillDao;

@Service
@Transactional	//配置此方法加入事务管理
public class BillService {

	@Resource
	private BillDao billDao;

	//获取账单记录
	public List<Bill> getBills(int card_id) {
		return billDao.getBills(card_id);
	}
	
	//获取账单记录
	public Bill getBill(Bill bill) {
		return billDao.getBill(bill);
	}

	//添加账单记录
	public void add(Bill bill) {
		billDao.save(bill);
	}

	//删除账单记录
	public void delete(Bill bill) {
		billDao.delete(bill);
	}

}
