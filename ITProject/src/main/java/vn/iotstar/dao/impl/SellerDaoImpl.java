package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.Seller;

public class SellerDaoImpl {
	public List<Seller> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<Seller> query = enma.createNamedQuery("Seller.findAll", Seller.class);
		return query.getResultList();
	}

	public List<Seller> findBySellername(String sellername) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT s FROM Seller s WHERE s.sellername like :sellername";
		TypedQuery<Seller> query = enma.createQuery(jpql, Seller.class);
		query.setParameter("sellername", "%" + sellername + "%");
		return query.getResultList();
	}


	public void update(Seller seller) {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.merge(seller);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	public void delete(int sellerId) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			Seller seller = enma.find(Seller.class, sellerId);
			if (seller != null) {
				enma.remove(seller);
			} else {
				throw new Exception("Không tìm thấy !");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
	
	public void insert(Seller seller) {
		EntityManager enma = JpaConfig.getEntityManager(); 
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.persist(seller); 
			trans.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback(); 
			throw e;
		} finally {
			enma.close(); 
		}
	}

	public static void main(String[] args) {
		SellerDaoImpl dao = new SellerDaoImpl();

		List<Seller> l1 = dao.findAll();
		System.out.println(l1);

		System.out.println("-----------------------------------------------------------------");

		List<Seller> l2 = dao.findBySellername("tinh");
		System.out.println(l2);

		System.out.println("-----------------------------------------------------------------");

		Seller s1 = new Seller();

		s1.setSellername("nước ngọt");
		s1.setStatus(1);

		
//		dao.insert(s1);
		s1.setSellerId(5);
		s1.setStatus(0);
		dao.update(s1);
		
//		try {
//			dao.delete(4);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
