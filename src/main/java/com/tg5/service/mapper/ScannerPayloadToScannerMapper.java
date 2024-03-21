package com.tg5.service.mapper;

import com.tg5.domain.Scanner;
import com.tg5.service.contract.ScannerPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ScannerPayloadToScannerMapper extends BaseMapper<ScannerPayload, Scanner>{

	public ScannerPayloadToScannerMapper(MapperFactory mapperFactory) {
		super(mapperFactory, ScannerPayload.class, Scanner.class);
	}
}
