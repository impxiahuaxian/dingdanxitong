package services;

import java.util.List;
import javax.annotation.Resource;
import models.Emp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.EmpDao;

@Service
@Transactional	//配置此方法加入事务管理
public class EmpService {

	@Resource
	private EmpDao empDao;

	//获取员工信息
	public Emp CheckEmp(Emp emp) {
		return empDao.CheckEmp(emp.getName(),emp.getPass());
	}
	
	//获取所有员工信息
	public List<Emp> getEmps() {
		return empDao.getEmps();
	}

	//根据id获取员工信息
	public Emp getEmp(Emp emp) {
		return empDao.getEmp(emp);
	}

	//更新员工信息
	public boolean update(Emp emp) {
		return empDao.update(emp);
	}

	//删除员工信息
	public boolean delete(Emp emp) {
		return empDao.delete(emp);
	}

	//添加员工信息
	public boolean add(Emp emp) {
		return empDao.save(emp);
	}
	
}
