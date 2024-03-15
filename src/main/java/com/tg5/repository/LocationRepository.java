package com.tg5.repository;

import com.tg5.domain.Location;
import com.tg5.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long>{
}
