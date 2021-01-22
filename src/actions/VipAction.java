package actions;

import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import services.VipService;
import models.Vip;

@Action("vip")
@Results({
	@Result(name="viplist",location="/market/pages/vip-list.jsp"),
	@Result(name="update",location="/market/pages/vip-update.jsp"),
	@Result(name="reviplist",type="redirectAction",location="vip!viplist.action"),
})
public class VipAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource
	private VipService vipService;
	private Vip vip;
	
	//获取所有会员信息
	public String viplist(){
		List<Vip> vips = vipService.getVips();
		getRequest().put("vips", vips);
		return "viplist";
	}
	
	//更新会员信息
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//如果请求标记为空 则说明要更新数据
			vipService.update(vip);
			return "reviplist";
		}else {//否则为修改页面提供所有信息
			Vip result = vipService.getVip(vip);
			getRequest().put("vip", result);
			return "update";
		}
	}
	
	//删除会员信息
	public String delete(){
		vipService.delete(vip);
		return "reviplist";
	}

	//添加会员信息
	public String add(){
		vipService.add(vip);
		return "reviplist";
	}
	
	
	
	
	
	
	
	public Vip getVip() {
		return vip;
	}
	public void setVip(Vip vip) {
		this.vip = vip;
	}
	
	
}
