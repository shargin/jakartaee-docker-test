package org.shargin.testkuber.domain;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@NamedQuery(name = "Message.getAll", query = "select m from Message m")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
