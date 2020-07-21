package org.shargin.testkuber.controllers;

import org.shargin.testkuber.domain.Message;
import org.shargin.testkuber.repository.MessageRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;


@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    @Inject
    private MessageRepository messageRepository;

    @Context
    UriInfo uriInfo;

    @GET
    public List<Message> getMessages() {
        return messageRepository.getAllMessages();
    }

    @GET
    @Path("{id}")
    public Message getMessage(@PathParam("id") long id) {
        return messageRepository.getMessage(id);
    }

    @POST
    @Path("{message}")
    public Response createMessage(@PathParam("message") String message) {
        final Message entity = messageRepository.createMessageFromString(message);
        return Response.created(buildUri(entity)).build();
    }

    private URI buildUri(Message message) {
        return uriInfo
                .getBaseUriBuilder()
                .path(MessageResource.class)
                .path(MessageResource.class, "getMessage")
                .build(message.getId());
    }
}
