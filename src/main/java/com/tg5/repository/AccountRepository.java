package com.tg5.repository;

import com.tg5.domain.Account;
import edu.miu.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BaseRepository<Account, Long> {
}
