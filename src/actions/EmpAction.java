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
	
	
	//员工登录
	public String login(){
		Emp logEmp = empService.CheckEmp(emp);
		if (logEmp == null) {
			getRequest().put("msg", "用户名或密码错误!!");
			return "login";
		}getSession().put("emp", logEmp);
		return "main";
	}
	
	//获取所有会员信息
	public String emplist(){
		List<Emp> emps = empService.getEmps();
		getRequest().put("emps", emps);
		return "emplist";
	}
	
	//更新员工信息
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//如果请求标记为空 则说明要更新数据
			empService.update(emp);
			return "reemplist";
		}else {//否则为修改页面提供所有信息
			Emp result = empService.getEmp(emp);
			getRequest().put("emp", result);
			return "update";
		}
	}
	
	//删除员工信息
	public String delete(){
		empService.delete(emp);
		return "reemplist";
	}

	//添加员工信息
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
