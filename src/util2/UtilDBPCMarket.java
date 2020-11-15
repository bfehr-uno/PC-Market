/**
 */
package util2;

import java.util.List;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel2.*;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
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
	
	public static List<Listing> listListings() {
		List<Listing> resultList = new ArrayList<Listing>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Listing").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Listing allListings = (Listing) iterator.next();
				resultList.add(allListings);
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

	public static List<Motherboard> listMotherboards() {
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

	public static List<CPU> listCPUs() {
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
	
	public static List<GPU> listGPUs() {
		List<GPU> resultList = new ArrayList<GPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> GPU = session.createQuery("FROM GPU").list();
			for (Iterator<?> iterator = GPU.iterator(); iterator.hasNext();) {
				GPU gpu = (GPU) iterator.next();
				resultList.add(gpu);
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

	public static List<Hard_Drive> listHardDrives() {
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
	
	public static void createListing(String modelNa, String modelType, String price) {
	  Session session = getSessionFactory().openSession();
	  Transaction tx = null;
	  try {
	     tx = session.beginTransaction();
	     
	     session.save(new Listing(modelNa, modelType, price));
	     tx.commit();
	  } catch (HibernateException e) {
	     if (tx != null)
	        tx.rollback();
	     e.printStackTrace();
	  } finally {
	     session.close();
	  }
	}
	
	public static void createCPU(String manufacturer, 
								  String modelNa, 
								  String cores, 
								  String freq, 
								  String socketC, 
								  String price) {
	  createListing(modelNa, "CPU", price);
		
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         
         int cpuID = findID();
         session.save(new CPU(cpuID, manufacturer, modelNa, 
        		 			  cores, freq, socketC, price));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }

   public static void createGPU(String manufacturer, 
		   						 String modelNa, 
		   						 String clockSpeed, 
		   						 String interf, 
		   						 String memory, 
		   						 String price) {
	  createListing(modelNa, "GPU", price);
	   
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();

         int gpuID = findID();
         session.save(new GPU(gpuID, manufacturer, modelNa, clockSpeed, interf, memory, price));
         
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
  }
	
	public static void createHard_Drive(String manufacturer, 
										 String modelNa, 
										 String storage, 
										 String rpm, 
										 String price) {
		createListing(modelNa, "Hard Drive", price);
		
	    Session session = getSessionFactory().openSession();
	    Transaction tx = null;
	    try {
	       tx = session.beginTransaction();
	       
	       int hardDriveID = findID();
	       session.save(new Hard_Drive(hardDriveID, manufacturer, modelNa, 
	    		 			  storage, rpm, price));
	       
	       tx.commit();
	    } catch (HibernateException e) {
	       if (tx != null)
	          tx.rollback();
	       e.printStackTrace();
	    } finally {
	       session.close();
	    }
	}
	
   public static void createMotherboard(String manufacturer, 
		   								 String modelNa, 
		   								 String socket, 
		   								 String expansion, 
		   								 String price) {
	  createListing(modelNa, "Motherboard", price);
	   
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();

         int motherboardID = findID();
         session.save(new Motherboard(motherboardID, manufacturer, modelNa, 
        		 			  socket, expansion, price));
         
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void removeListing(String id, String partType) {
	   if (partType == "CPU") {
		   partType = "cpu";
	   } else if (partType == "GPU") {
		   partType = "gpu";
	   } else if (partType == "Hard_Drive") {
		   partType = "hard_drive";
	   } else if (partType == "Motherboard") {
		   partType = "motherboard";
	   }
	   
	   Session session1 = getSessionFactory().openSession();
	   Transaction tx1 = null;

		try {
			tx1 = session1.beginTransaction();
			SQLQuery query = session1.createSQLQuery("DELETE FROM listing WHERE id = '" + id + "'");
			query.executeUpdate();
			tx1.commit();
		} catch (HibernateException e) {
			if (tx1 != null)
				tx1.rollback();
			e.printStackTrace();
		} finally {
			session1.close();
		}
	   
	   Session session2 = getSessionFactory().openSession();
	   Transaction tx2 = null;

		try {
			tx2 = session2.beginTransaction();
			SQLQuery query = session2.createSQLQuery("DELETE FROM " + partType + "WHERE id = '" + id + "'");
			query.executeUpdate();
			tx2.commit();
		} catch (HibernateException e) {
			if (tx2 != null)
				tx2.rollback();
			e.printStackTrace();
		} finally {
			session2.close();
		}
   }

   public static int findID() {
		List<Listing> listings = listListings();
		int numListings = listings.size();
		if (numListings != 0) {
			return listings.get(numListings - 1).getID();
		} else {
			return 0;
		}
	}
   
   public static void setupDB() {
	   if (findID() == 0) {
		   createCPU("Intel", "Core i7-9900K Coffee Lake", "8", "3.6", "LGA 1151", "349.99");
		   createCPU("Intel", "Core i9-9900K Coffee Lake", "8", "3.6", "LGA 1151", "349.99");
		   createCPU("AMD", "RYZEN 7 3700X", "8", "3.6", "AM4", "299.99");
	
		   createGPU("Asus", "DUAL-GTX1660S-O6G-EVO", "1530", "PCI Express 3.0 x16", "6", "349.99");
		   createGPU("SAPPHIRE", "PULSE Radeon RX 5700 XT 100416P8GL", "1670", "PCI Express 4.0 x16", "8", "399.99");
		   
		   createHard_Drive("Seagate", "BarraCuda ST2000DM008", "2", "7200", "49.99");
		   createHard_Drive("Seagate", "Exos X16 ST16000NM001G", "16", "7200", "299.99");
		   
		   createMotherboard("ASUS", "ROG STRIX B550-E GAMING", "AM4", "4.0,3.0", "249.99");
		   createMotherboard("MSI", "MPG Z490 GAMING EDGE WIFI", "LGA 1200", "3.0", "174.99");
	   }
   }
   
   public static void clearListings() {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
		
	   try {
		   tx = session.beginTransaction();
		   SQLQuery query = session.createSQLQuery("TRUNCATE TABLE listing");
		   query.executeUpdate();
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
   }
   
   public static CPU getCPU(String id) {
	   List<CPU> result = new ArrayList<CPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM CPU WHERE id = " + id).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				CPU cpu = (CPU) iterator.next();
				result.add(cpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
   
   public static GPU getGPU(String id) {
	   List<GPU> result = new ArrayList<GPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM GPU WHERE id = " + id).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				GPU gpu = (GPU) iterator.next();
				result.add(gpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
   
   public static Hard_Drive getHardDrive(String id) {
	   List<Hard_Drive> result = new ArrayList<Hard_Drive>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Hard_Drive WHERE id = " + id).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Hard_Drive hardDrive= (Hard_Drive) iterator.next();
				result.add(hardDrive);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
   
   public static Motherboard getMotherboard(String id) {
	   List<Motherboard> result = new ArrayList<Motherboard>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Motherboard WHERE id = " + id).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Motherboard motherboard= (Motherboard) iterator.next();
				result.add(motherboard);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
   
   public static List<CPU> easyBuyCPU(String cores, String freq, String socketC) {
	   List<CPU> result = new ArrayList<CPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM CPU WHERE price = (SELECT MIN(price) FROM CPU WHERE cores = '" + cores + "' AND frequency = '" + freq + "' AND socket = '" + socketC + "') AND cores = '" + cores + "' AND frequency = '" + freq + "' AND socket = '" + socketC + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				CPU cpu = (CPU) iterator.next();
				result.add(cpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
   }
   
   public static List<GPU> easyBuyGPU(String clockSpeed, String interf, String memory) {
	   List<GPU> result = new ArrayList<GPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM GPU WHERE price = (SELECT MIN(price) FROM GPU WHERE clock_speed = '" + clockSpeed + "' AND interf = '" + interf + "' AND memory = '" + memory + "') AND clock_speed = '" + clockSpeed + "' AND interf = '" + interf + "' AND memory = '" + memory + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				GPU gpu = (GPU) iterator.next();
				result.add(gpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
   }
   
   public static List<Hard_Drive> easyBuyHardDrive(String storage, String rpm) {
	   List<Hard_Drive> result = new ArrayList<Hard_Drive>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM CPU WHERE price = (SELECT MIN(price) FROM CPU WHERE storage = '" + storage + "' AND rpm = '" + rpm + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Hard_Drive hardDrive = (Hard_Drive) iterator.next();
				result.add(hardDrive);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
   }
   
   public static List<Motherboard> easyBuyMotherboard(String socket, String expansionSlots) {
	   List<Motherboard> result = new ArrayList<Motherboard>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM CPU WHERE price = (SELECT MIN(price) FROM CPU WHERE socket = '" + socket + "' AND expansion_slots = '" + expansionSlots + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Motherboard motherboard = (Motherboard) iterator.next();
				result.add(motherboard);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
   }
}
