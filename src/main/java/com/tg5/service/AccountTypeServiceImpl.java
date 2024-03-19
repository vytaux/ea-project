package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.Points;
import com.tg5.domain.VirtualDollar;
import com.tg5.repository.AccountTypeRepository;
import com.tg5.service.contract.AccountTypePayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountTypeServiceImpl extends BaseReadWriteServiceImpl<AccountTypePayload, AccountType, Long> implements AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    @Override
    public AccountTypePayload create(AccountTypePayload request) {
        AccountType accountType = new AccountType();
        accountType.setName(request.getName());
        accountType.setDescription(request.getDescription());
        if (request.getCurrencyType().equalsIgnoreCase("points")) {
            accountType.setBalance(new Points(Long.parseLong(request.getBalance())));
        } else if  (request.getCurrencyType().equalsIgnoreCase("virtualDollar")) {
            accountType.setBalance(new VirtualDollar(Double.parseDouble(request.getBalance())));
        }
        accountTypeRepository.save(accountType);
        request.setId(accountType.getId());
        return request;
    }
}
