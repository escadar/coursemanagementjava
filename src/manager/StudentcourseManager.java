package manager;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Instructor;
import entity.Studentcourse;

public class StudentcourseManager {

	
	
	private final EntityManager entityManager;

	public StudentcourseManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
	}

	
	
	public void update(Studentcourse  studentcourse) {
		entityManager.getTransaction().begin();
		entityManager.merge(studentcourse);
		entityManager.getTransaction().commit();
	}

	public void create(Studentcourse studentcourse) {
		entityManager.getTransaction().begin();

		entityManager.persist(studentcourse);
		entityManager.getTransaction().commit();

	}

	public void delete(Studentcourse studentcourse) {
		entityManager.getTransaction().begin();
		entityManager.remove(studentcourse);
		entityManager.getTransaction().commit();
	}

	public Studentcourse get(Integer id) {
		return entityManager.find(Studentcourse.class, id);
	} 
	
	public List<Studentcourse> getAll(){
		String sql = "select * from studentcourse ";
		
		return  (List) entityManager.createNativeQuery(sql, Studentcourse.class).getResultList();
		
	}
}
