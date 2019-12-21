package net.igorok.rest_service.registrator;

import net.igorok.rest_service.entity.Message;
import net.igorok.rest_service.entity.MessageMapping;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class MessageRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(Message item) {
        logger.info("Created message mapping: " + item);
        entityManager.merge(item);
    }

    public void update(Message item) {
        logger.info("Updated message mapping: " + item);
        entityManager.merge(item);
    }

    public void delete(Message item) {
        logger.info("Deleted message mapping: " + item);
        entityManager.remove(item);
    }
}

