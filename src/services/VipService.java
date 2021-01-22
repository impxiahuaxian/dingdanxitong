package services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.VipDao;
import models.Vip;

@Service
@Transactional	//配置此方法加入事务管理
public class VipService {

	@Resource
	private VipDao vipDao;

	//获取所有会员信息
	public List<Vip> getVips() {
		return vipDao.getVips();
	}

	//根据id获取会员信息
	public Vip getVip(Vip vip) {
		return vipDao.getVip(vip);
	}

	//更新会员信息
	public boolean update(Vip vip) {
		String name = vip.getName();//保存更新后的数据
		String phone = vip.getPhone();
		String sex = vip.getSex();
		String address = vip.getAddress();
		String birthday = "";
		if (vip.getIdent().length()==18) {//如果输入的是正常身份证号则截取生日
			birthday = vip.getIdent().substring(6,14);
		}
		vip = vipDao.getVip(vip);//获取会员其他信息,放置被情况
		vip.setName(name);//更新数据
		vip.setPhone(phone);
		vip.setSex(sex);
		vip.setAddress(address);
		vip.setBirthday(birthday);
		return vipDao.update(vip);//写回数据库
	}

	//删除会员信息
	public boolean delete(Vip vip) {
		return vipDao.delete(vip);
	}

	//添加会员信息
	public boolean add(Vip vip) {
		if (vip.getIdent().length()==18) {//如果输入的是正常身份证号则截取生日
			vip.setBirthday(vip.getIdent().substring(6,14));
		}
		vip.setGrade(0);//初始化会员参数
		vip.setLevel(1);
		vip.setRebate(0.95f);
		return vipDao.save(vip);
	}

	//根据id获取vip信息
	public Vip getVip(int id) {
		return vipDao.getVip(id);
	}
	
	//购物后增加积分及会员升级
	public boolean upgrade(Vip vip){
		return vipDao.update(vip);
	}
	
}
