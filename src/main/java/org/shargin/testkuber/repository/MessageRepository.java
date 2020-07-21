package org.shargin.testkuber.repository;

import org.shargin.testkuber.domain.Message;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class MessageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Message createMessageFromString(String text) {
        final Message message = new Message();
        message.setMessage(text);
        entityManager.persist(message);

        return message;
    }

    public List<Message> getAllMessages() {
        return entityManager
                .createNamedQuery("Message.getAll", Message.class)
                .getResultList();
    }

    public Message getMessage(long id) {
        return entityManager.find(Message.class, id);
    }
}
