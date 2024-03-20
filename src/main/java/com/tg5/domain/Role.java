package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;



    @ManyToMany(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AccountType> defaultAccountTypes = new ArrayList<>();

}
