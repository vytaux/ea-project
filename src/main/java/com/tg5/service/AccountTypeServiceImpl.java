package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.Points;
import com.tg5.domain.VirtualDollar;
import com.tg5.repository.AccountTypeRepository;
import com.tg5.service.contract.AccountTypePayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountTypeServiceImpl extends BaseReadWriteServiceImpl<AccountTypePayload, AccountType, Long> implements AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public AccountTypePayload create(AccountTypePayload request) {
        AccountType accountType = new AccountType();
        accountType.setName(request.getName());
        accountType.setDescription(request.getDescription());
        if (request.getCurrencyType().equalsIgnoreCase("points")) {
            accountType.setInitialBalance(new Points(Long.parseLong(request.getInitialBalance())));
        } else if  (request.getCurrencyType().equalsIgnoreCase("virtualDollar")) {
            accountType.setInitialBalance(new VirtualDollar(Double.parseDouble(request.getInitialBalance())));
        }
        accountTypeRepository.save(accountType);
        request.setId(accountType.getId());
        return request;
    }
}
