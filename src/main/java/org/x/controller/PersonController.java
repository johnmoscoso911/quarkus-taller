package org.x.controller;

import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.x.model.Person;
import org.x.service.PersonService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class PersonController {

    @Inject
    PersonService service;

    @POST
    @RolesAllowed({"write"})
    public Uni<Response> create(Person person) {
        return service.create(person)
                .onItem()
                .transform(id -> String.format("persons/%s", id))
                .onItem()
                .transform(f -> f != null ? Response.created(URI.create(f)) : Response.ok())
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }

    @DELETE
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Uni<Response> delete(@PathParam("id") String id) {
        return service.delete(id)
                .onItem()
                .transform(f -> f ? Response.ok() : Response.accepted())
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }

    @GET
    @Path("/{text}")
    public Uni<Response> findByName(@PathParam("text") String text) {
        return service.findByName(text)
                .onItem()
                .transform(f -> Response.ok().entity(f))
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }

}
