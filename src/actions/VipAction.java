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
	
	//��ȡ���л�Ա��Ϣ
	public String viplist(){
		List<Vip> vips = vipService.getVips();
		getRequest().put("vips", vips);
		return "viplist";
	}
	
	//���»�Ա��Ϣ
	public String update(){
		if (getServletRequest().getParameter("type")==null) {//���������Ϊ�� ��˵��Ҫ��������
			vipService.update(vip);
			return "reviplist";
		}else {//����Ϊ�޸�ҳ���ṩ������Ϣ
			Vip result = vipService.getVip(vip);
			getRequest().put("vip", result);
			return "update";
		}
	}
	
	//ɾ����Ա��Ϣ
	public String delete(){
		vipService.delete(vip);
		return "reviplist";
	}

	//��ӻ�Ա��Ϣ
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
