package daos;

import java.util.List;

import models.Emp;

import org.springframework.stereotype.Repository;

@Repository//ע��spring����bean
@SuppressWarnings("unchecked")
public class EmpDao extends BaseDao{

	//�����û�������������û�
	public Emp CheckEmp(String name, String pass) {
		return (Emp) getSession().createQuery("from Emp where name=? and pass=?")
				.setParameter(0, name).setParameter(1, pass).uniqueResult();
	}

	//��ȡ���л�Ա��Ϣ
	public List<Emp> getEmps() {
		return getSession().createQuery("from Emp").list();
	}

	//����id��ȡ��Ա��Ϣ
	public Emp getEmp(Emp emp) {
		return (Emp) getSession().get(Emp.class, emp.getId());
	}
	
}
