package actions;

import java.util.List;
import javax.annotation.Resource;
import models.Emp;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import services.EmpService;

@Action("emp")
@Results({
	@Result(name="login",location="/market/login.jsp"),
	@Result(name="main",location="/market/main.jsp"),
	@Result(name="emplist",location="/market/pages/emp-list.jsp"),
	@Result(name="update",location="/market/pages/emp-update.jsp"),
	@Result(name="reemplist",type="redirectAction",location="emp!emplist.action"),
})
public class EmpAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource
	private EmpService empService;
	private Emp emp;
	
	
	//Ա����¼
	public String login(){
		Emp logEmp = empService.CheckEmp(emp);
		if (logEmp == null) {
			getRequest().put("msg", "�û������������!!");
			return "login";
		}getSession().put("emp", logEmp);
		return "main";
	}
	
	//��ȡ���л�Ա��Ϣ
	public String emplist(){
		List<Emp> emps = empService.getEmps();
		getRequest().put("emps", emps);
		return "emplist";
	}
	
	//����Ա����Ϣ
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ��������
			empService.update(emp);
			return "reemplist";
		}else {//����Ϊ�޸�ҳ���ṩ������Ϣ
			Emp result = empService.getEmp(emp);
			getRequest().put("emp", result);
			return "update";
		}
	}
	
	//ɾ��Ա����Ϣ
	public String delete(){
		empService.delete(emp);
		return "reemplist";
	}

	//���Ա����Ϣ
	public String add(){
		empService.add(emp);
		return "reemplist";
	}
	
	
	

	
	
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}


}
