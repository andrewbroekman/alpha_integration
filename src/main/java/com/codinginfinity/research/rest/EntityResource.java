package com.codinginfinity.research.rest.publication;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Reinhardt on 2016/04/05.
 */
 

@Path("entity")
public class EntityResource {

    @Inject
    private Entity entity;

}