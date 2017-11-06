package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


import entity.Studentcourse;
import manager.ManagerHelper;

@Path("/StudentcourseService")
public class StudentcourseService {
	
	@GET
	@Path("get")
	public List<Studentcourse> getAll() {
		return  ManagerHelper.getStudentcourseManager().getAll();
	}


}
