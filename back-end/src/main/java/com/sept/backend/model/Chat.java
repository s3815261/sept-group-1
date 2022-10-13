package com.sept.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sept.backend.enums.ChatStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import com.sept.backend.model.User;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CHAT")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;

    private Long patient_id;
    private Long doctor_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "patient_id", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "FK_PATIENT"))
    private User patient;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "FK_DOCTOR"))
    private User doctor;

//    @OneToOne
//    @JoinColumn(name = "appointment_id", nullable = false, foreignKey = @ForeignKey(name = "FK_APPOINTMENT"), columnDefinition = "integer default 0")
//    private Appointment appointment;

//    @OneToMany(targetEntity = Message.class, fetch = FetchType.LAZY)
//    private List<Message> messages;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false )
    private ChatStatus status = ChatStatus.SCHEDULED;
}
