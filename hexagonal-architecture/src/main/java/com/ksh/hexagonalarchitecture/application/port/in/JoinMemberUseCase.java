package com.ksh.hexagonalarchitecture.application.port.in;

import com.ksh.hexagonalarchitecture.domain.Member;

import java.util.List;

public interface JoinMemberUseCase {
    void joinMember(Member member);
}