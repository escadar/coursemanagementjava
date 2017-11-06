package manager;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Course;
import entity.Coursetag;
import entity.Instructor;
import entity.Location;
import entity.User;
import web.Reply1;

public class CourseManager {

	private final EntityManager entityManager;

	public CourseManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
	}

	public void update(Course Course) {
		entityManager.getTransaction().begin();
		entityManager.merge(Course);
		entityManager.getTransaction().commit();
	}

	public void create(Course Course) {
		entityManager.getTransaction().begin();
		entityManager.persist(Course);
		entityManager.getTransaction().commit();

	}

	public void delete(Course Course) {
		entityManager.getTransaction().begin();
		entityManager.remove(Course);
		entityManager.getTransaction().commit();
	}

	public Course get(Integer id) {
		return entityManager.find(Course.class, id);
	}

	public List<Course> getAll() {
		String sql = "select * from course ";

		return (List) entityManager.createNativeQuery(sql, Course.class).getResultList();

	}

	public List<Course> getCoursesByStudentUserId(int userId) {

		System.out.println(userId);
		String sql = " SELECT sc.id,sc.course FROM coursemanagement.studentcourse sc"
				+ " inner join student s on s.id=sc.student  " + "inner join user u  on u.id=s.user " + "where u.id = "
				+ userId;

		System.out.println(sql);

		return (List) entityManager.createNativeQuery(sql, Course.class).getResultList();

	}

	public List<Course> getCourseByInstractorId(int instractorId) {
		String sql = "SELECT * FROM coursemanagement.course c where c.instructor =" + instractorId;

		return (List) entityManager.createNativeQuery(sql, Course.class).getResultList();

	}

	public List<Course> GetCourseByInstructorUserId(int InstructorUserId) {
		System.out.println(InstructorUserId);
		String str = "SELECT * FROM coursemanagement.course c" + " inner join instructor i on i.id=c.instructor"
				+ " inner join user u on u.id=i.user" + " where u.id=" + InstructorUserId;
		System.out.println(str);
		return (List) entityManager.createNativeQuery(str, Course.class).getResultList();
	}

	public List<Course> getCourseByTagCourse(int tagId) {

		System.out.println(tagId);
	    String sql = "SELECT  c.name, c.instructor, c.starttime,c.endtime, c.agenda , c.location, c.description, c.coursetag , ct.id "
       +  "  from course c  " 
       +  "  inner join  coursetag ct  on  ct.id= c.coursetag "
       +  "  where c.coursetag  =  " + tagId ; 
	System.out.println(sql);
		return (List) entityManager.createNativeQuery(sql, Course.class).getResultList();

	}

	public Course createcourse(String name, int instructorid, int coursetagid, String starttime, String endtime,
			String agenda, int locationid, String description) {
		entityManager.getTransaction().begin();
		Location location = ManagerHelper.getLocationManager().get(locationid);
		Instructor instructor = ManagerHelper.getInstructorManager().get(instructorid);
		Coursetag coursetag = ManagerHelper.getCoursetagManager().get(coursetagid);
		Course course = new Course(name, instructor, coursetag, starttime, endtime, agenda, location, description);
		entityManager.persist(course);
		entityManager.getTransaction().commit();
		return course;
	}

	public Reply1 deletecourse(int courseid) {
		try {
			Course course = ManagerHelper.getCourseManager().get(courseid);
			entityManager.getTransaction().begin();
			entityManager.remove(course);
			entityManager.getTransaction().commit();
			return new Reply1();
		} catch (Exception e) {
			Reply1 r = new Reply1();
			r.setId(-1);
			r.setMsg(e.getMessage());
			return r;
		}
	}
	public List<Course> getAvileableCourses (){
		String sql = " SELECT * FROM coursemanagement.course where starttime > current_date()  ";
		return (List) entityManager.createNativeQuery(sql, Course.class).getResultList(); 
	}
	public  Course  getCoursesById (int id){
		String sql = " SELECT * FROM course  where  id = "+id;
		System.out.println(sql);
		System.out.println(id);
		return  (Course)entityManager.createNativeQuery(sql, Course.class).getSingleResult();
	}
}
