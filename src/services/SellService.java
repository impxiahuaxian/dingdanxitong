package services;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import models.Sell;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.SellDao;

@Service
@Transactional	//���ô˷��������������
public class SellService {

	@Resource
	private SellDao sellDao;
	
	//��ȡ���г�����Ϣ
	public List<Sell> getSells() {
		return sellDao.getSells();
	}

	//����id��ȡ������Ϣ
	public Sell getSell(Sell sell) {
		return sellDao.getSell(sell);
	}

	//���³�����Ϣ
	public boolean update(Sell sell) {
		sell.setDate(new Date());
		return sellDao.update(sell);
	}

	//ɾ��������Ϣ
	public boolean delete(Sell sell) {
		return sellDao.delete(sell);
	}

	//��ӳ�����Ϣ
	public boolean add(Sell sell) {
		sell.setDate(new Date());
		return sellDao.save(sell);
	}
	
}
