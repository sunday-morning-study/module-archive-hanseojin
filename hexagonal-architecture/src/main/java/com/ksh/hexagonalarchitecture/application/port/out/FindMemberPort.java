package com.ksh.hexagonalarchitecture.application.port.out;

import com.ksh.hexagonalarchitecture.domain.Member;

import java.util.List;

public interface FindMemberPort {

    List<Member> findByName(String name);
    List<Member> findAll();

    Member findOne(Long id);
}
