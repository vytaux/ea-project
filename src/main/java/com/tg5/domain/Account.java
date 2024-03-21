/**
 * Author: Dip Ranjon Das
 * Date: 03/18/2023
 * Feature: Account
**/

package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

//Domain class Accounts
@Entity
@Data
@Table(name = "accounts")
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double balance;

    //Account have accountType
    @ManyToOne
    private AccountType accountType;

    //One Member can have many Accounts
    @ManyToOne
    private Member member;
}
