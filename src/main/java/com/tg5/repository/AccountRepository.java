package com.tg5.repository;

import com.tg5.domain.Account;
import com.tg5.domain.Member;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends BaseRepository<Account, Long> {
}
