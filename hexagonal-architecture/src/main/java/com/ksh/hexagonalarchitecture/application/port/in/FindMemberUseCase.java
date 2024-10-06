package com.ksh.hexagonalarchitecture.application.port.in;

import com.ksh.hexagonalarchitecture.domain.Member;

import java.util.List;

public interface FindMemberUseCase {
    //회원 전체 조회
    List<Member> findMembers();
    Member findOne(Long memberId);
}
