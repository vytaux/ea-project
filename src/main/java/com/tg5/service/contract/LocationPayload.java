package com.tg5.service.contract;

import com.tg5.domain.LocationType;
import lombok.Data;

import java.io.Serializable;

@Data
public class LocationPayload implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private LocationType type;
}