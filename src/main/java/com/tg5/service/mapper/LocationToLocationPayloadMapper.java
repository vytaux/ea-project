package com.tg5.service.mapper;

import com.tg5.domain.Location;
import com.tg5.service.contract.LocationPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class LocationToLocationPayloadMapper extends BaseMapper<Location, LocationPayload> {

    public LocationToLocationPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Location.class, LocationPayload.class);
    }
}
