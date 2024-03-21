package com.tg5.service.contract;

import lombok.Data;

<<<<<<< HEAD
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class MemberPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private List<RolePayload> roles = new ArrayList<>();
}
=======
import java.io.Serializable;

@Data
public class MemberPayload implements Serializable {
    private static final long serialVersionUID = 2L;
    private int id;
    private String firstname;
    private String lastname;

    private String email;
}
>>>>>>> main
