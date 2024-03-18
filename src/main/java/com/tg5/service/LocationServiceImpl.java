package com.tg5.service;

import com.tg5.domain.Location;
import com.tg5.service.contract.LocationPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl extends BaseReadWriteServiceImpl<LocationPayload, Location, Long> implements LocationService {

}
