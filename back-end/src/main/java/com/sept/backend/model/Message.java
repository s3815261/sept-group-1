package com.sept.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "MESSAGE")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(nullable = false, columnDefinition = "text")
    private String message;

    private String chat_id;
    private String user_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "chat_id", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "FK_CHAT"))
    private Chat chat;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "FK_USER"))
    private User user;


    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp timestamp;
}

