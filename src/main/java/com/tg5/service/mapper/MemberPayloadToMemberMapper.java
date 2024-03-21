package com.tg5.service.mapper;

<<<<<<< HEAD
import com.tg5.domain.Account;
import com.tg5.domain.Member;
import com.tg5.domain.Role;
import com.tg5.repository.RoleRepository;
import com.tg5.service.contract.AccountPayload;
import com.tg5.service.contract.MemberPayload;
import com.tg5.service.contract.RolePayload;
import edu.miu.common.exception.ResourceNotFoundException;
=======
import com.tg5.domain.Member;
import com.tg5.service.contract.MemberPayload;
>>>>>>> main
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
<<<<<<< HEAD
public class MemberPayloadToMemberMapper extends BaseMapper<MemberPayload, Member> {


	public MemberPayloadToMemberMapper(MapperFactory mapperFactory) {
		super(mapperFactory, MemberPayload.class, Member.class);
=======
public class MemberPayloadToMemberMapper  extends BaseMapper<MemberPayload, Member> {

    public MemberPayloadToMemberMapper(MapperFactory mapperFactory) {
        super(mapperFactory, MemberPayload.class, Member.class);
>>>>>>> main
    }
}
