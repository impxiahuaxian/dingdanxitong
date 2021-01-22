package services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.VipDao;
import models.Vip;

@Service
@Transactional	//���ô˷��������������
public class VipService {

	@Resource
	private VipDao vipDao;

	//��ȡ���л�Ա��Ϣ
	public List<Vip> getVips() {
		return vipDao.getVips();
	}

	//����id��ȡ��Ա��Ϣ
	public Vip getVip(Vip vip) {
		return vipDao.getVip(vip);
	}

	//���»�Ա��Ϣ
	public boolean update(Vip vip) {
		String name = vip.getName();//������º������
		String phone = vip.getPhone();
		String sex = vip.getSex();
		String address = vip.getAddress();
		String birthday = "";
		if (vip.getIdent().length()==18) {//�����������������֤�����ȡ����
			birthday = vip.getIdent().substring(6,14);
		}
		vip = vipDao.getVip(vip);//��ȡ��Ա������Ϣ,���ñ����
		vip.setName(name);//��������
		vip.setPhone(phone);
		vip.setSex(sex);
		vip.setAddress(address);
		vip.setBirthday(birthday);
		return vipDao.update(vip);//д�����ݿ�
	}

	//ɾ����Ա��Ϣ
	public boolean delete(Vip vip) {
		return vipDao.delete(vip);
	}

	//��ӻ�Ա��Ϣ
	public boolean add(Vip vip) {
		if (vip.getIdent().length()==18) {//�����������������֤�����ȡ����
			vip.setBirthday(vip.getIdent().substring(6,14));
		}
		vip.setGrade(0);//��ʼ����Ա����
		vip.setLevel(1);
		vip.setRebate(0.95f);
		return vipDao.save(vip);
	}

	//����id��ȡvip��Ϣ
	public Vip getVip(int id) {
		return vipDao.getVip(id);
	}
	
	//��������ӻ��ּ���Ա����
	public boolean upgrade(Vip vip){
		return vipDao.update(vip);
	}
	
}
