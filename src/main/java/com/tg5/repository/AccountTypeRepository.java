package com.tg5.repository;

import com.tg5.domain.AccountType;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountTypeRepository extends BaseRepository<AccountType,Long> {

    @Query(value = "select distinct a from   Role r  join  r.defaultAccountTypes a   where r.id  in (:roles)")
    List<AccountType> findByRoles(List<Long> roles);


    List<AccountType> findAccountTypesByIdIn(List<Long> accountTypeIds);
}
