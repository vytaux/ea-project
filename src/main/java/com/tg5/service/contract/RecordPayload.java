package com.tg5.service.contract;

import lombok.Data;
import com.tg5.domain.Record;
import java.io.Serializable;
@Data
public class RecordPayload implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

}
