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
}
