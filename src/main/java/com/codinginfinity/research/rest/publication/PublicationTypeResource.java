package com.codinginfinity.research.rest.publication;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by andrew on 2016/03/19.
 */
@Path("publicationTypes")
public class PublicationTypeResource {

    @Inject
    private PublicationTypes publicationTypes;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(PublicationType publicationType) {
        // ToDo: Get result and check whether status was successfull
        // ToDo: Confirm if lecturers whether we are allowed to return response objects
        publicationTypes.addPublicationType(new AddPublicationTypeRequest(publicationType));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(PublicationType publicationType) {
        // ToDo: Get result and check whether status was successfull
        // ToDo: Confirm if lecturers whether we are allowed to return response objects
        publicationTypes.modifyPublicationType(new ModifyPublicationTypeRequest(publicationType));
    }


}
