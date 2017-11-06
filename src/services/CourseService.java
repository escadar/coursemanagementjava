package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Course;
import manager.ManagerHelper;
import web.Reply1;

@Path("/course")
public class CourseService {
	
	
	@GET
	@Path("getCoursesByStudentUserId")
	public List<Course> getCoursesByStudentUserId(@QueryParam("userId") int userId){
		System.out.println("getCoursesByStudentUserId " +userId);
		return ManagerHelper.getCourseManager().getCoursesByStudentUserId(userId);
	}

	@GET
	@Path(" getCourseByInstractorId")
	public List<Course>  getCourseByInstractorId(@QueryParam("instractorId") int instractorId){
		return ManagerHelper.getCourseManager().getCourseByInstractorId(instractorId);
	}
	
	@GET
	@Path(" GetCourseByInstructorUserId")
	public List<Course>  GetCourseByInstructorUserId(@QueryParam("InstructorUserId") int InstructorUserId){
		return ManagerHelper.getCourseManager().GetCourseByInstructorUserId(InstructorUserId);
	}
	
	@GET
	@Path("getall")
	public List<Course> getall(){
		
		return ManagerHelper.getCourseManager().getAll();
	}
	
	@GET
	@Path("createcourse")
	public Course createcourse(@QueryParam("name") String name,@QueryParam("instructorid)")int instructorid,@QueryParam("coursetagid)")int coursetagid,
			@QueryParam("starttime") String starttime,@QueryParam("endtime") String endtime,@QueryParam("agenda") String agenda,
			@QueryParam("locationid") int locationid,@QueryParam("description") String description){
		
		return ManagerHelper.getCourseManager().createcourse(name, instructorid, coursetagid, starttime, endtime, agenda, locationid, description);
	}

	@GET
	@Path("deletecreate")
	public Reply1 deletecreate(@QueryParam("courseid)")int courseid){		
		return ManagerHelper.getCourseManager().deletecourse(courseid);
	}
	

	@GET
	@Path("getCourseByTagCourse")
	public List<Course> getCourseByTagCourse(@QueryParam("tagId)")int tagId){
		
		return ManagerHelper.getCourseManager().getCourseByTagCourse(tagId);
	}
	@GET
	@Path("getCoursesById")
	public Course getCoursesById(@QueryParam("id)")int id){
		System.out.println("service "+id);
		return (Course) ManagerHelper.getCourseManager().getCoursesById(id);
	}
	
}
