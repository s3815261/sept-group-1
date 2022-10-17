package com.sept.backend.model;

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

    @ManyToOne
    @JoinColumn(name = "chat_id", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "FK_CHAT"))
    private Chat chat;

    @ManyToOne
    @JoinColumn(updatable = false, nullable = false, foreignKey = @ForeignKey(name = "FK_USER"))
    private User user;


    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp timestamp;
}

