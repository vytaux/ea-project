package com.tg5.repository;

import com.tg5.domain.Account;
import edu.miu.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AccountRepository extends BaseRepository<Account, Long> {

    List<Account> findAccountsByMember_Id(Long memberId);
}
