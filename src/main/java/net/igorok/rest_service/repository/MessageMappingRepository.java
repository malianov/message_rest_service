package net.igorok.rest_service.repository;

import net.igorok.rest_service.entity.Message;
import net.igorok.rest_service.entity.MessageMapping;
import net.igorok.rest_service.entity.User;
import org.eclipse.persistence.internal.oxm.Root;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class MessageMappingRepository {

    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public List<MessageMapping> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteria = criteriaBuilder.createQuery(MessageMapping.class);
        return entityManager.createQuery(criteria).getResultList();
    }

    public MessageMapping getById(long id) {
        logger.info("Get message mapping by id " + id);
        return entityManager.find(MessageMapping.class, id);
    }

    public List<MessageMapping> getByFromId(User from_id) {
        logger.info("Get message mapping by user from id: " + from_id);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteriaQuery = criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> element = criteriaQuery.from(MessageMapping.class);
        criteriaQuery.select(element).where(criteriaBuilder.equal(element.get("from_id"),from_id));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
