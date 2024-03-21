package com.tg5.repository;

import com.tg5.domain.AccountType;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountTypeRepository extends BaseRepository<AccountType,Long> {


    List<AccountType> findAccountTypesByIdIn(List<Long> accountTypeIds);
}
