package com.tg5.domain;

import java.math.BigDecimal;

public class Points extends AccountCurrency{


    public Points(long balance) {
        super(BigDecimal.valueOf(balance), MoneyType.Points);

    }
    @Override
    public AccountCurrency plus(AccountCurrency currency) {
        if (!(currency.getMoneyType().equals(this.getMoneyType()))) {
            new IllegalArgumentException("only points currency should be added");
        }
        return new Points((long) (this.valueOf() + currency.valueOf()));
    }

    @Override
    public AccountCurrency minus(AccountCurrency currency) {
        if (!(currency.getMoneyType().equals(this.getMoneyType()))) {
            new IllegalArgumentException("only points currency should be subtracted");
        }
        return new Points((long) (this.valueOf() - currency.valueOf()));
    }

}

