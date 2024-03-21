package com.tg5.service.contract;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ScannerPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String scannerCode;

    private String name;

    private LocationPayload location;
}