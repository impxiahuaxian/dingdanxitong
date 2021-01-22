package actions;

import java.util.List;

import javax.annotation.Resource;

import models.Factory;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import services.FactoryService;

@Action("factory")
@Results({
	@Result(name="factorylist",location="/market/pages/factory-list.jsp"),
	@Result(name="update",location="/market/pages/factory-update.jsp"),
	@Result(name="refactorylist",type="redirectAction",location="factory!factorylist.action"),
})
public class FactoryAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource
	private FactoryService factoryService;
	private Factory factory;//���ڲ�������
	
	//��ȡ���й�������Ϣ
	public String factorylist(){
		List<Factory> factories = factoryService.getFactorys();
		getRequest().put("factorys", factories);
		return "factorylist";
	}
	
	//���¹�������Ϣ
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ��������
			factoryService.update(factory);
			return "refactorylist";
		}else {//����Ϊ�޸�ҳ���ṩ������Ϣ
			Factory result = factoryService.getFactory(factory);
			getRequest().put("factory", result);
			return "update";
		}
	}
	
	//ɾ����������Ϣ
	public String delete(){
		factoryService.delete(factory);
		return "refactorylist";
	}

	//��ӹ�������Ϣ
	public String add(){
		factoryService.add(factory);
		return "refactorylist";
	}
	
	
	
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}


	
}
