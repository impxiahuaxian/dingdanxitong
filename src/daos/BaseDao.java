package daos;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * dao�����
 * @author admin
 *
 */
public class BaseDao {

	@Resource
	private SessionFactory sessionFactory;
	private Session session;

	
	//���
	public boolean save(Object obj){
		try {
			getSession().save(obj);
		} catch (HibernateException e) {
			return false;
		}return true;
	}
	
	//�޸�
	public boolean update(Object obj){
		try {
			getSession().update(obj);
		} catch (HibernateException e) {
			return false;
		}return true;
	}
	
	//ɾ��
	public boolean delete(Object obj){
		try {
			getSession().delete(obj);
		} catch (HibernateException e) {
			return false;
		}return true;
	}
	
	//��ӻ����
	public boolean saveOrUpdate(Object obj){
		try {
		getSession().saveOrUpdate(obj);
		} catch (HibernateException e) {
			return false;
		}return true;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		this.session = sessionFactory.getCurrentSession();
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}

}
