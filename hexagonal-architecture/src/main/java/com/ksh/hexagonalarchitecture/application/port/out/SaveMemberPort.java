package com.ksh.hexagonalarchitecture.application.port.out;

import com.ksh.hexagonalarchitecture.domain.Member;

public interface SaveMemberPort {
    void saveMember(Member member);
}
