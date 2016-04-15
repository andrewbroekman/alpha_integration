package com.codinginfinity.research.rest;

import com.codinginfinity.research.people.IPeople;
import com.codinginfinity.research.people.exeptions.UserDoesNotExist;
import com.codinginfinity.research.people.request.EditPersonDetailsRequest;
import com.codinginfinity.research.people.response.EditPersonDetailsResponse;
import com.codinginfinity.research.services.RequestNotValidException;
import com.codinginfinity.research.services.Response;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Reinhardt on 2016/04/05.
 */
 

@Path("people")
public class PeopleResource {
	@Inject
	private IPeople people;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response editPersonDetails(EditPersonDetailsRequest req){
		try {
			EditPersonDetailsResponse resp = people.editPersonDetails(req);
			return javax.ws.rs.core.Response.status(200).entity(resp).build();
		}catch(UserDoesNotExist e){
			return javax.ws.rs.core.Response.status(404).build();
		}catch (RequestNotValidException e){
			return javax.ws.rs.core.Response.status(400).build();
		}catch(Exception e){
			return javax.ws.rs.core.Response.status(500).build();
		}
	}	
}