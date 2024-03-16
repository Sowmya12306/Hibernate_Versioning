package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Customer;
import in.ineuron.util.HibernateUtil;

public class VersionModify {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Customer customer = null;
		Integer cid = 1;
		
		try {
			session= HibernateUtil.getSession();
			if(session!=null) {
				transaction = session.beginTransaction();
				customer = session.get(Customer.class, cid);
				if(customer!=null) {
					customer.setCname("Tasleem");
					customer.setCallerTune("Pachtaogi");
					flag = true;
					System.err.println("old versionCount is "+ customer.getVersionCount());
					// save or saveOrUpdate() methods are not used as EntityToDB update is Synchronized/ are in sync no need to externally use methods
				}
				else {
					System.out.println("Customer details not found for the given id "+ cid);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object is modified for ::" + customer.getVersionCount() + " times");
			}
			else {
				transaction.rollback();
			System.out.println("Object not modified");
			}
		}
	}

}
