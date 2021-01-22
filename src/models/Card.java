package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.stereotype.Component;

//销售单
@Entity//hibernate实体类
@Component//注册spring受管bean
public class Card {

	@Id
	@GeneratedValue//自增地段
	private int id;
	private float total;
	private String total_vip;
	private String remark;
	private Date date;
	@ManyToOne
	private Vip vip;
	@ManyToOne
	private Emp emp;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getTotal_vip() {
		return total_vip;
	}
	public void setTotal_vip(String total_vip) {
		this.total_vip = total_vip;
	}
	public Vip getVip() {
		return vip;
	}
	public void setVip(Vip vip) {
		this.vip = vip;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
