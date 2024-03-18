package com.tg5.controller;

import com.tg5.domain.Location;
import com.tg5.service.contract.LocationPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationsController extends BaseReadWriteController<LocationPayload, Location, Long> {

}

