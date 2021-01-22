package services;

import java.util.List;
import javax.annotation.Resource;
import models.Bill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.BillDao;

@Service
@Transactional	//���ô˷��������������
public class BillService {

	@Resource
	private BillDao billDao;

	//��ȡ�˵���¼
	public List<Bill> getBills(int card_id) {
		return billDao.getBills(card_id);
	}
	
	//��ȡ�˵���¼
	public Bill getBill(Bill bill) {
		return billDao.getBill(bill);
	}

	//����˵���¼
	public void add(Bill bill) {
		billDao.save(bill);
	}

	//ɾ���˵���¼
	public void delete(Bill bill) {
		billDao.delete(bill);
	}

}
