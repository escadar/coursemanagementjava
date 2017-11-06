package services;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


import web.PropsHelper;
import web.Reply1;

@Path("/Properties")
public class Propertiesservice {


	

	@GET
	@Path("setsyllabusProperties")
	public Reply1 setsyllabusProperties(@QueryParam("coursename") String coursename,@QueryParam("syllabus") String syllabus,
			@QueryParam("schedule") String schedule) {
		 PropsHelper.set(coursename, schedule);
		return PropsHelper.set(coursename, syllabus);
		

	}


}
