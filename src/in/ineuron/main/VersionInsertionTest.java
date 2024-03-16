package in.ineuron.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.ineuron.model.Customer;
import in.ineuron.util.HibernateUtil;

public class VersionInsertionTest {
	public static void main(String[] args) {
		Session session=null;
		boolean flag=false;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Integer idValue = null;
		
		try {
			session = HibernateUtil.getSession();
			
			if(session!=null) {
				transaction = session.beginTransaction();
			}
			if(transaction!=null)
			{
				Customer customer = new Customer();
				customer.setCname("Mohit");
				customer.setMobileNo(8904321282L);
				customer.setCallerTune("Vaaste");
				idValue = (Integer)session.save(customer);
				System.out.println(session.save(customer).getClass().getName());
				System.out.println("Generated id value is " + idValue);
				System.out.println("Generated versionCount is "+ customer.getVersionCount());
     			flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(flag ==true) {
				transaction.commit(); // stored in DB through ORM
			}
			else transaction.rollback();
			HibernateUtil.closeSession(session);
		}
		
	}

}
