/**
 * Author: Dip Ranjon Das
 * Date: 03/18/2023
 * Feature: Account
**/

package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

//Domain class Accounts
@Entity
@Data
@Table(name = "accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Double balance;

    //Account have accountType
    @ManyToOne
    private AccountType type;

    //One Member can have many Accounts
    @ManyToOne
    private Member member;
}
