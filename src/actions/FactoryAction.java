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
	private Factory factory;//用于参数传递
	
	//获取所有供货商信息
	public String factorylist(){
		List<Factory> factories = factoryService.getFactorys();
		getRequest().put("factorys", factories);
		return "factorylist";
	}
	
	//更新供货商信息
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//如果请求标记为空 则说明要更新数据
			factoryService.update(factory);
			return "refactorylist";
		}else {//否则为修改页面提供所有信息
			Factory result = factoryService.getFactory(factory);
			getRequest().put("factory", result);
			return "update";
		}
	}
	
	//删除供货商信息
	public String delete(){
		factoryService.delete(factory);
		return "refactorylist";
	}

	//添加供货商信息
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
