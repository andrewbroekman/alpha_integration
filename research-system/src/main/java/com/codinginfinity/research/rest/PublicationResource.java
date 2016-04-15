package com.codinginfinity.research.rest;

import com.codinginfinity.research.publication.IPublication;
import com.codinginfinity.research.publication.exception.PublicationDoesntExist;
import com.codinginfinity.research.publication.request.GetPublicationRequest;
import com.codinginfinity.research.publication.response.GetPublicationResponse;
import com.codinginfinity.research.services.RequestNotValidException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by reinhardt on 2016/04/15.
 */

@Path("publication")
public class PublicationResource {

    @Inject
    IPublication publication;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public javax.ws.rs.core.Response getPublication(GetPublicationRequest req){
        try {
            GetPublicationResponse resp = publication.getPublication(req);
            return javax.ws.rs.core.Response.status(200).entity(resp).build();
        }catch (PublicationDoesntExist e){
            return javax.ws.rs.core.Response.status(404).build();
        }catch (RequestNotValidException e){
            return javax.ws.rs.core.Response.status(400).build();
        }catch (Exception e){
            return javax.ws.rs.core.Response.status(500).build();
        }
    }
}
