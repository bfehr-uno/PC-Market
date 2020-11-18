/**
 */
package util2;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

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
   
   public static void createSoldCPU(String freq, String numOfCores, String socket, String price, String date) {
	  Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();

         session.save(new Sold_CPU(freq, numOfCores, socket, price, date));
         
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }

   public static void createSoldGPU(String clockSpeed, String interf, String memory, String price, String date) {
	   Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();

         session.save(new Sold_GPU(clockSpeed, interf, memory, price, date));
         
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void createSoldHardDrive(String rpm, String storage, String price, String date) {
	   Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();

         session.save(new Sold_Hard_Drive(rpm, storage, price, date));
         
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void createSoldMotherboard(String expansionSlots, String socket, String price, String date) {
	   Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new Sold_Motherboard(expansionSlots, socket, price, date));
         
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
		
	   if (partType.equals("CPU")) {
		   Session session2 = getSessionFactory().openSession();
		   Transaction tx2 = null;

			try {
				tx2 = session2.beginTransaction();
				SQLQuery query = session2.createSQLQuery("DELETE FROM cpu WHERE id = '" + id + "'");
				query.executeUpdate();
				CPU cpu = getCPU(id);
				System.out.println(cpu.getFreq() + " " + cpu.getNumOfCores() + " " + cpu.getSocketCompatibility());
				createSoldCPU(cpu.getFreq(), cpu.getNumOfCores(), cpu.getSocketCompatibility(), cpu.getPrice(), getDate());
				tx2.commit();
			} catch (HibernateException e) {
				if (tx2 != null)
					tx2.rollback();
				e.printStackTrace();
			} finally {
				session2.close();
			}
	   } else if (partType.equals("GPU")) {
		   Session session2 = getSessionFactory().openSession();
		   Transaction tx2 = null;

			try {
				tx2 = session2.beginTransaction();
				SQLQuery query = session2.createSQLQuery("DELETE FROM gpu WHERE id = '" + id + "'");
				query.executeUpdate();
				GPU gpu = getGPU(id);
				System.out.println(gpu.getClockSpeed() + " " + gpu.getInterfaceType() + " " + gpu.getMemorySize());
				createSoldGPU(gpu.getClockSpeed(), gpu.getInterfaceType(), gpu.getMemorySize(), gpu.getPrice(), getDate());
				tx2.commit();
			} catch (HibernateException e) {
				if (tx2 != null)
					tx2.rollback();
				e.printStackTrace();
			} finally {
				session2.close();
			}
	   } else if (partType.equals("Hard_Drive")) {
		   Session session2 = getSessionFactory().openSession();
		   Transaction tx2 = null;

			try {
				tx2 = session2.beginTransaction();
				SQLQuery query = session2.createSQLQuery("DELETE FROM hard_drive WHERE id = '" + id + "'");
				query.executeUpdate();
				Hard_Drive hardDrive = getHardDrive(id);
				System.out.println(hardDrive.getRotationsPerMinute() + " " + hardDrive.getStorageSpace());
				createSoldHardDrive(hardDrive.getRotationsPerMinute(), hardDrive.getStorageSpace(), hardDrive.getPrice(), getDate());
				tx2.commit();
			} catch (HibernateException e) {
				if (tx2 != null)
					tx2.rollback();
				e.printStackTrace();
			} finally {
				session2.close();
			}
	   } else if (partType.equals("Motherboard")) {
		   Session session2 = getSessionFactory().openSession();
		   Transaction tx2 = null;

			try {
				tx2 = session2.beginTransaction();
				SQLQuery query = session2.createSQLQuery("DELETE FROM motherboard WHERE id = '" + id + "'");
				query.executeUpdate();
				Motherboard motherboard = getMotherboard(id);
				createSoldMotherboard(motherboard.getExpansionSlots(), motherboard.getSocket(), motherboard.getPrice(), getDate());
				tx2.commit();
			} catch (HibernateException e) {
				if (tx2 != null)
					tx2.rollback();
				e.printStackTrace();
			} finally {
				session2.close();
			}
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
		   createCPU("Intel", "Core i7-9900K Coffee Lake", "8", "3.6", "LGA 1151", "350");
		   createCPU("Intel", "Core i9-9900K Coffee Lake", "8", "3.6", "LGA 1151", "350");
		   createCPU("AMD", "RYZEN 7 3700X", "8", "3.6", "AM4", "300");
	
		   createGPU("Asus", "DUAL-GTX1660S-O6G-EVO", "1530", "PCI Express 3.0 x16", "6", "350");
		   createGPU("SAPPHIRE", "PULSE Radeon RX 5700 XT 100416P8GL", "1670", "PCI Express 4.0 x16", "8", "400");
		   
		   createHard_Drive("Seagate", "BarraCuda ST2000DM008", "2", "7200", "50");
		   createHard_Drive("Seagate", "Exos X16 ST16000NM001G", "16", "7200", "300");
		   createHard_Drive("Seagate", "Exos X16 ST16000NM001G", "16", "7200", "270");
		   
		   createMotherboard("ASUS", "ROG STRIX B550-E GAMING", "AM4", "4.0,3.0", "250");
		   createMotherboard("MSI", "MPG Z490 GAMING EDGE WIFI", "LGA 1200", "3.0", "175");
		   
		   createSoldCPU("3.6", "8", "LGA 1151", "400", "2020-11-10");
		   createSoldCPU("3.6", "8", "LGA 1151", "380", "2020-11-12");
		   createSoldCPU("3.6", "8", "LGA 1151", "360", "2020-11-14");
		   
		   createSoldGPU("1530", "PCI Express 3.0 x16", "6", "400", "2020-11-10");
		   createSoldGPU("1530", "PCI Express 3.0 x16", "6", "380", "2020-11-12");
		   createSoldGPU("1530", "PCI Express 3.0 x16", "6", "360", "2020-11-14");
		   
		   createSoldHardDrive("7200", "2", "100", "2020-11-10");
		   createSoldHardDrive("7200", "2", "80", "2020-11-12");
		   createSoldHardDrive("7200", "2", "60", "2020-11-14");
		   
		   createSoldMotherboard("4.0,3.0", "AM4", "300", "2020-11-10");
		   createSoldMotherboard("4.0,3.0", "AM4", "280", "2020-11-12");
		   createSoldMotherboard("4.0,3.0", "AM4", "260", "2020-11-14");
	   }
   }
   
   public static void clearDB() {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
		
	   try {
		   tx = session.beginTransaction();
		   SQLQuery query1 = session.createSQLQuery("TRUNCATE TABLE listing");
		   query1.executeUpdate();
		   SQLQuery query2 = session.createSQLQuery("TRUNCATE TABLE cpu");
		   query2.executeUpdate();
		   SQLQuery query3 = session.createSQLQuery("TRUNCATE TABLE gpu");
		   query3.executeUpdate();
		   SQLQuery query4 = session.createSQLQuery("TRUNCATE TABLE hard_drive");
		   query4.executeUpdate();
		   SQLQuery query5 = session.createSQLQuery("TRUNCATE TABLE motherboard");
		   query5.executeUpdate();
		   SQLQuery query6 = session.createSQLQuery("TRUNCATE TABLE sold_cpu");
		   query6.executeUpdate();
		   SQLQuery query7 = session.createSQLQuery("TRUNCATE TABLE sold_gpu");
		   query7.executeUpdate();
		   SQLQuery query8 = session.createSQLQuery("TRUNCATE TABLE sold_hard_drive");
		   query8.executeUpdate();
		   SQLQuery query9 = session.createSQLQuery("TRUNCATE TABLE sold_motherboard");
		   query9.executeUpdate();
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

		System.out.println("hello: " + storage + " " + rpm);
		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Hard_Drive WHERE price = (SELECT MIN(price) FROM Hard_Drive WHERE storage = '" + storage + "' AND rpm = '" + rpm + "') AND storage = '" + storage + "' AND rpm = '" + rpm + "'").list();
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
			List<?> Listing = session.createQuery("FROM Motherboard WHERE price = (SELECT MIN(price) FROM Motherboard WHERE socket = '" + socket + "' AND expansion_slots = '" + expansionSlots + "'").list();
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
   
   public static List<Sold_CPU> getSoldCPUs(String freq, String cores, String socketC) {
	   List<Sold_CPU> resultList = new ArrayList<Sold_CPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			System.out.println(freq + " " + cores + " " + socketC);
			List<?> Listing = session.createQuery("FROM Sold_CPU WHERE cores = '" + cores + "' AND frequency = '" + freq + "' AND socket = '" + socketC + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Sold_CPU cpu= (Sold_CPU) iterator.next();
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
   
   public static List<Sold_GPU> getSoldGPUs(String clockSpeed, String interf, String memory) {
	   List<Sold_GPU> resultList = new ArrayList<Sold_GPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			System.out.println(clockSpeed + " " + interf + " " +  memory);
			List<?> Listing = session.createQuery("FROM Sold_GPU WHERE clockSpeed = '" + clockSpeed + "' AND interf = '" + interf + "' AND memory = '" + memory + "'").list();
			System.out.println(Listing.size());
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Sold_GPU GPU= (Sold_GPU) iterator.next();
				resultList.add(GPU);
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
   
   public static List<Sold_Hard_Drive> getSoldHardDrives(String rpm, String storage) {
	   List<Sold_Hard_Drive> resultList = new ArrayList<Sold_Hard_Drive>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Sold_Hard_Drive WHERE rpm = '" + rpm + "' AND storage = '" + storage + "'").list();
			System.out.println(Listing.size());
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Sold_Hard_Drive Hard_Drive= (Sold_Hard_Drive) iterator.next();
				resultList.add(Hard_Drive);
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
   
   public static List<Sold_Motherboard> getSoldMotherboards(String expansionSlots, String socket) {
	   List<Sold_Motherboard> resultList = new ArrayList<Sold_Motherboard>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Sold_Motherboard WHERE expansion_slots = '" + expansionSlots + "' AND socket = '" + socket + "'").list();
			System.out.println(Listing.size());
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Sold_Motherboard motherboard= (Sold_Motherboard) iterator.next();
				resultList.add(motherboard);
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
   
   public static String getCPUDataPoints(String frequency, String cores, String socket) {
	   List<Sold_CPU> cpus = UtilDBPCMarket.getSoldCPUs(frequency, cores, socket);
	   Map<Object,Object> map = null;
	   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

	   for (Sold_CPU cpu : cpus) {
	   	map = new HashMap<Object, Object>();
	   	map.put("label", cpu.getDateSold());
	   	map.put("y", Integer.parseInt(cpu.getPrice()));
	   	list.add(map);
	   }
	   	
	   Gson gsonObj = new Gson();
	   String dataPoints = gsonObj.toJson(list);
	   return dataPoints;
   }
   
   public static String getGPUDataPoints(String clockSpeed, String interf, String memory) {
	   List<Sold_GPU> gpus = UtilDBPCMarket.getSoldGPUs(clockSpeed, interf, memory);
	   Map<Object,Object> map = null;
	   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

	   for (Sold_GPU gpu : gpus) {
	   	map = new HashMap<Object, Object>();
	   	map.put("label", gpu.getDateSold());
	   	map.put("y", Integer.parseInt(gpu.getPrice()));
	   	list.add(map);
	   }
	   	
	   Gson gsonObj = new Gson();
	   String dataPoints = gsonObj.toJson(list);
	   return dataPoints;
   }
   
   public static String getHardDriveDataPoints(String rpm, String storage) {
	   List<Sold_Hard_Drive> HardDrives = UtilDBPCMarket.getSoldHardDrives(rpm, storage);
	   Map<Object,Object> map = null;
	   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

	   for (Sold_Hard_Drive HardDrive : HardDrives) {
	   	map = new HashMap<Object, Object>();
	   	map.put("label", HardDrive.getDateSold());
	   	map.put("y", Integer.parseInt(HardDrive.getPrice()));
	   	list.add(map);
	   }
	   	
	   Gson gsonObj = new Gson();
	   String dataPoints = gsonObj.toJson(list);
	   return dataPoints;
   }
   
   public static String getMotherboardDataPoints(String expansionSlots, String socket) {
	   List<Sold_Motherboard> Motherboards = UtilDBPCMarket.getSoldMotherboards(expansionSlots, socket);
	   Map<Object,Object> map = null;
	   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

	   for (Sold_Motherboard Motherboard : Motherboards) {
	   	map = new HashMap<Object, Object>();
	   	map.put("label", Motherboard.getDateSold());
	   	map.put("y", Integer.parseInt(Motherboard.getPrice()));
	   	list.add(map);
	   }
	   	
	   Gson gsonObj = new Gson();
	   String dataPoints = gsonObj.toJson(list);
	   return dataPoints;
   }
   
   private static String getDate() {
	   String calendarString = Calendar.getInstance().getTime().toString();
	   String year = calendarString.substring(calendarString.length() - 5, calendarString.length());
	   String day = calendarString.substring(8, 10);
	   String month = calendarString.substring(4, 7);
	   if (month == "Jan") {
		   month = "01";
	   } else if (month.equals("Feb")) {
		   month = "02";
	   } else if (month.equals("Mar")) {
		   month = "03";
	   } else if (month.equals("Apr")) {
		   month = "04";
	   } else if (month.equals("May")) {
		   month = "05";
	   } else if (month.equals("Jun")) {
		   month = "06";
	   } else if (month.equals("Jul")) {
		   month = "07";
	   } else if (month.equals("Aug")) {
		   month = "08";
	   } else if (month.equals("Sep")) {
		   month = "09";
	   } else if (month.equals("Oct")) {
		   month = "10";
	   } else if (month.equals("Nov")) {
		   month = "11";
	   } else {
		   month = "12";
	   }
	   return year + "-" + month + "-" + day;
   }
}
