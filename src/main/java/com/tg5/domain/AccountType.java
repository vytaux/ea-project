/**
 * Author: Dip Ranjon Das
 * Date: 03/18/2023
 * Feature: Account
 **/

package com.tg5.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

// Enum to hold AccountType information
@Data
@Entity
@Table(name = "account_types")
public class AccountType implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @Column(length = 600)
    private String description;

    @Embedded
    private AccountCurrency balance;
}
