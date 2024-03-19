package com.tg5.domain;


import java.math.BigDecimal;

public class VirtualDollar extends AccountCurrency {
    public VirtualDollar(double balance) {

        super(BigDecimal.valueOf(balance), MoneyType.VirtualDollar);
    }

    @Override
    public AccountCurrency plus(AccountCurrency currency) {
        if (!(currency.getMoneyType().equals(this.getMoneyType()))) {
            new IllegalArgumentException("only virtual currency should be added");
        }
        return new VirtualDollar((this.valueOf() + currency.valueOf()));
    }

    @Override
    public AccountCurrency minus(AccountCurrency currency) {
        if (!(currency.getMoneyType().equals(this.getMoneyType()))) {
            new IllegalArgumentException("only virtual currency should be subtracted");
        }
        return new VirtualDollar((this.valueOf() - currency.valueOf()));
    }

}
