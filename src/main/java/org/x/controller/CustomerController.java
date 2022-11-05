package org.x.controller;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.x.model.CustomerEntity;
import org.x.service.impl.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequiredArgsConstructor
@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

    private final CustomerService service;

    @GET
    public Multi<CustomerEntity> all() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public Uni<CustomerEntity> get(@PathParam("id") String id) {
        return service.findById(id);
    }

    @POST
    public Uni<CustomerEntity> create(CustomerEntity entity) {
        return service.create(entity);
    }
}
