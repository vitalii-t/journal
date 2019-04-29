package com.journal.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "groups")
@Data @NoArgsConstructor @AllArgsConstructor
public class Group implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identifier")
    private String identifier;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "group")
    private List<User> users;

}