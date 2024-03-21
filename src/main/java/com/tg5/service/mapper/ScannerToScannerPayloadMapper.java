package com.tg5.service.mapper;

import com.tg5.domain.Scanner;
import com.tg5.service.contract.ScannerPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ScannerToScannerPayloadMapper extends BaseMapper<Scanner, ScannerPayload> {

	public ScannerToScannerPayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Scanner.class, ScannerPayload.class);
	}
}
