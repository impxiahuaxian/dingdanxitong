package services;

import java.util.List;
import javax.annotation.Resource;
import models.Emp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import daos.EmpDao;

@Service
@Transactional	//���ô˷��������������
public class EmpService {

	@Resource
	private EmpDao empDao;

	//��ȡԱ����Ϣ
	public Emp CheckEmp(Emp emp) {
		return empDao.CheckEmp(emp.getName(),emp.getPass());
	}
	
	//��ȡ����Ա����Ϣ
	public List<Emp> getEmps() {
		return empDao.getEmps();
	}

	//����id��ȡԱ����Ϣ
	public Emp getEmp(Emp emp) {
		return empDao.getEmp(emp);
	}

	//����Ա����Ϣ
	public boolean update(Emp emp) {
		return empDao.update(emp);
	}

	//ɾ��Ա����Ϣ
	public boolean delete(Emp emp) {
		return empDao.delete(emp);
	}

	//���Ա����Ϣ
	public boolean add(Emp emp) {
		return empDao.save(emp);
	}
	
}
