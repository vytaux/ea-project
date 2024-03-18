package com.tg5.service.mapper;

import com.tg5.domain.Location;
import com.tg5.service.contract.LocationPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class LocationPayloadToLocationMapper extends BaseMapper<LocationPayload, Location> {

    public LocationPayloadToLocationMapper(MapperFactory mapperFactory) {
        super(mapperFactory, LocationPayload.class, Location.class);
    }
}
