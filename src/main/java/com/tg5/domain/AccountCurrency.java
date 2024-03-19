package com.tg5.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;


@Embeddable
@Data
public  class AccountCurrency {

    AccountCurrency(BigDecimal balance, MoneyType moneyType) {
        this.balance = balance;
        this.moneyType = moneyType;
    }

    public AccountCurrency() {

    }

    public enum MoneyType {VirtualDollar, Points}
    private  BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private  MoneyType moneyType;


    public  AccountCurrency plus(AccountCurrency currency){
        return null;
    }
    public  AccountCurrency minus(AccountCurrency currency) {
        return null;
    }

    public double valueOf() {
        return balance.doubleValue();
    }

}
