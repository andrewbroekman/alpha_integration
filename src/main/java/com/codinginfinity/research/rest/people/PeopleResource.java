package com.codinginfinity.research.rest.people;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Reinhardt on 2016/04/05.
 */
 

@Path("people")
public class PeopleResource {

	@Inject
	private Person person;
	
	@Inject
	private Group group;
	
	@Post
	@Consumes(MediaType.APPLICATION_JSON)
	public void editPersonDetails(Person person){
		
	}
	
	@Put
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPerson(Person person){
		
	}
		@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void endResearchGroupAssosciation(Person person, Group group){
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addResearchGroupAssosciation(Person person, Group group){
		
	}
	
	
}