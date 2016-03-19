package com.codinginfinity.research.rest.publication;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by andrew on 2016/03/19.
 */
@Path("publications")
public class PublicationResource {

    @Inject
    private Publications publications;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Publication publication) {
        // ToDo: Get result and check whether status was successfull
        // ToDo: Confirm if lecturers whether we are allowed to return response objects
        publications.addPublication(new AddPublicationRequest(publication));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Publication get(@PathParam("id") String id) {
        // ToDo: Get result and check whether status was successfull
        // ToDo: Confirm if lecturers whether we are allowed to return response objects
        publications.getPublication(new GetPublicationRequest(publication));
        // ToDo: Return correct data type
        throw new NullPointerException();
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Publication publication) {
        // ToDo: Get result and check whether status was successfull
        // ToDo: Confirm if lecturers whether we are allowed to return response objects
        publications.updatePublication(new UpdatePublicationRequest(publication));
    }

}
