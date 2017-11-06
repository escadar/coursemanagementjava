package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import entity.Coursetag;

import manager.ManagerHelper;

@Path("/Coursetag")
public class CoursetagService {
	
	@GET
	@Path("getall")
	public List<Coursetag> getAll() {
		return  ManagerHelper.getCoursetagManager().getAll();
	}

}
