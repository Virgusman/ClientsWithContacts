package ru.virgusman.springcourse.ClietsWithContacts.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @Column(name = "contact_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @Column(name = "contact_type")
    @Enumerated(EnumType.STRING)
    private ContactType type;

    @Column(name = "contact_value")
    private String value;
}
