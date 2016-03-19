package com.codinginfinity.research.rest.publication;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by andrew on 2016/03/19.
 */
@Path("publicationTypes")
public class PublicationTypeResource {

    /*
     * As teams have not yet defined interfaces, code will not compile, as we are awaiting on teams to complete there
     * interfaces.
     */
    @Inject
    private PublicationTypes publicationTypes;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(PublicationType publicationType) {
        // ToDo: Get result and check whether status was successfull
        // ToDo: Confirm if lecturers whether we are allowed to return response objects
        publicationTypes.addPublicationType(new AddPublicationTypeRequest(publicationType));
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public GetPublicationTypeResponse get(@PathParam("id") String id) {
        publicationTypes.getPublicationTypes(new GetPublicationTypeRequest(id));
        throw new NotImplementedException();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(PublicationType publicationType) {
        // ToDo: Get result and check whether status was successfull
        // ToDo: Confirm if lecturers whether we are allowed to return response objects
        publicationTypes.modifyPublicationType(new ModifyPublicationTypeRequest(publicationType));
    }


}
