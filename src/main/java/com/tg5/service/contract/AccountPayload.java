/**
 * Author: Dip Ranjon Das
 * Date: 03/18/2023
 * Feature: Account
 **/

package com.tg5.service.contract;

import com.tg5.domain.AccountType;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AccountPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private Double balance;

    private MemberPayload member;

    private AccountType type;
}