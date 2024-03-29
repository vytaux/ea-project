package com.tg5.repository;

import com.tg5.domain.Role;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends BaseRepository<Role, Long> {

}
