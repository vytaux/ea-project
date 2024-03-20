package com.tg5.repository;

import com.tg5.domain.Member;
import com.tg5.domain.Scanner;
import com.tg5.domain.Session;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScannerRepository extends BaseRepository<Scanner, Long> {
    Optional<Scanner> getScannerByScannerCode(String scannerCode);
}