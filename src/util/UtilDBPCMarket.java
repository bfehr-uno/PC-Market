/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.Motherboard;
import datamodel.CPU;
import datamodel.Hard_Drive;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDBPCMarket {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static List<Motherboard> listMotherboard() {
		List<Motherboard> resultList = new ArrayList<Motherboard>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Mobos = session.createQuery("FROM Motherboard").list();
			for (Iterator<?> iterator = Mobos.iterator(); iterator.hasNext();) {
				Motherboard mobo = (Motherboard) iterator.next();
				resultList.add(mobo);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<CPU> listCPU() {
		List<CPU> resultList = new ArrayList<CPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> CPU = session.createQuery("FROM CPU").list();
			for (Iterator<?> iterator = CPU.iterator(); iterator.hasNext();) {
				CPU cpu = (CPU) iterator.next();
				resultList.add(cpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<Hard_Drive> listHardDrive() {
		List<Hard_Drive> resultList = new ArrayList<Hard_Drive>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Hard_Drive = session.createQuery("FROM Hard_Drive").list();
			for (Iterator<?> iterator = Hard_Drive.iterator(); iterator.hasNext();) {
				Hard_Drive hardDrive = (Hard_Drive) iterator.next();
				resultList.add(hardDrive);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

}
