package net.igorok.rest_service.rest;

import net.igorok.rest_service.entity.MessageMapping;
import net.igorok.rest_service.registrator.MessageMappingRegistrator;
import net.igorok.rest_service.repository.MessageMappingRepository;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
@Path("/message_mapping")
public class MessageMappingREST {
    @Inject
    private Logger logger;

    @Inject
    private MessageMappingRegistrator registrator;

    @Inject
    private MessageMappingRepository repository;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MessageMapping> getAll() {
        logger.info("Get full message mapping");
        List<MessageMapping> resultList = repository.getAll();
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MessageMapping getById(long id) {
        logger.info("Get mapping by id " + id);
        return repository.getById(id);
    }
}
