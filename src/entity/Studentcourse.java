package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Studentcourse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="student")
	private Student student;
	@ManyToOne
	@JoinColumn(name="course")
	private Course course;

	public Studentcourse() {

	}

	public Studentcourse(Student student, Course course) {

		this.student = student;
		this.course = course;

	}

	public Studentcourse(int id, Student student, Course course) {
		this.id = id;
		this.student = student;
		this.course = course;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getcourse() {
		return course;
	}

	public void setcourse(Course course) {
		this.course = course;
	}

}
