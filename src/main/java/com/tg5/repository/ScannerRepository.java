package com.tg5.repository;

import com.tg5.domain.Scanner;
import edu.miu.common.repository.BaseRepository;

import java.util.Optional;

public interface ScannerRepository extends BaseRepository<Scanner, Long> {
    Optional<Scanner> getScannerByScannerCode(String scannerCode);
}