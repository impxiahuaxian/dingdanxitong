package daos;

import java.util.List;

import models.Emp;

import org.springframework.stereotype.Repository;

@Repository//注册spring管理bean
@SuppressWarnings("unchecked")
public class EmpDao extends BaseDao{

	//根据用户名和密码查找用户
	public Emp CheckEmp(String name, String pass) {
		return (Emp) getSession().createQuery("from Emp where name=? and pass=?")
				.setParameter(0, name).setParameter(1, pass).uniqueResult();
	}

	//获取所有会员信息
	public List<Emp> getEmps() {
		return getSession().createQuery("from Emp").list();
	}

	//根据id获取会员信息
	public Emp getEmp(Emp emp) {
		return (Emp) getSession().get(Emp.class, emp.getId());
	}
	
}
