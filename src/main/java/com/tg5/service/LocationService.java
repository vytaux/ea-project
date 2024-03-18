package com.tg5.service;

import com.tg5.domain.Location;
import com.tg5.service.contract.LocationPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface LocationService extends BaseReadWriteService<LocationPayload, Location, Long> {
}
