package com.tg5.service.mapper;

<<<<<<< HEAD
import com.tg5.domain.Location;
import com.tg5.domain.Member;
import com.tg5.service.contract.LocationPayload;
=======
import com.tg5.domain.Member;
>>>>>>> main
import com.tg5.service.contract.MemberPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberToMemberPayloadMapper extends BaseMapper<Member, MemberPayload> {
<<<<<<< HEAD

=======
>>>>>>> main
    public MemberToMemberPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Member.class, MemberPayload.class);
    }
}
