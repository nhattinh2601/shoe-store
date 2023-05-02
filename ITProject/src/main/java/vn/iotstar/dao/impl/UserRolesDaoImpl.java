package vn.iotstar.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import vn.iotstar.config.JpaConfig;
import vn.iotstar.entity.UserRole;

public class UserRolesDaoImpl {
	public List<UserRole> findAll() {
		EntityManager enma = JpaConfig.getEntityManager();
		TypedQuery<UserRole> query = enma.createNamedQuery("UserRole.findAll", UserRole.class);
		return query.getResultList();
	}

	public List<UserRole> findByRolename(String roleName) {
		EntityManager enma = JpaConfig.getEntityManager();
		String jpql = "SELECT u FROM UserRole u WHERE u.roleName like :roleName";
		TypedQuery<UserRole> query = enma.createQuery(jpql, UserRole.class);
		query.setParameter("roleName", "%" + roleName + "%");
		return query.getResultList();
	}


	public void update(UserRole userrole) {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.merge(userrole);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	public void delete(int roleId) throws Exception {
		EntityManager enma = JpaConfig.getEntityManager(); //
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			UserRole userrole = enma.find(UserRole.class, roleId);
			if (userrole != null) {
				enma.remove(userrole);
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
	
	public void insert(UserRole userrole) {
		EntityManager enma = JpaConfig.getEntityManager(); 
		EntityTransaction trans = enma.getTransaction(); //
		try {
			trans.begin();
			enma.persist(userrole); 
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
		UserRolesDaoImpl dao = new UserRolesDaoImpl();

		List<UserRole> l1 = dao.findAll();
		System.out.println(l1);

		System.out.println("-----------------------------------------------------------------");

		List<UserRole> l2 = dao.findByRolename("admin");
		System.out.println(l2);

		System.out.println("-----------------------------------------------------------------");

		UserRole r1 = new UserRole();

		r1.setRoleName("nước ngọt");

		
//		dao.insert(r1);
		
		r1.setRoleId(4);
		r1.setRoleName("nước chanh");
//		dao.update(r1);
		
		try {
			dao.delete(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
