package com.ksh.hexagonalarchitecture.application;

import com.ksh.hexagonalarchitecture.application.port.in.FindMemberUseCase;
import com.ksh.hexagonalarchitecture.application.port.in.JoinMemberUseCase;
import com.ksh.hexagonalarchitecture.application.port.out.FindMemberPort;
import com.ksh.hexagonalarchitecture.application.port.out.SaveMemberPort;
import com.ksh.hexagonalarchitecture.domain.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements JoinMemberUseCase, FindMemberUseCase {

    private final FindMemberPort findMemberPort;
    private final SaveMemberPort saveMemberPort;
    /**
     * 회원 가입
     */
    @Transactional
    @Override
    public void joinMember(Member member) {
        validateDuplicateMember(member);
        saveMemberPort.saveMember(member);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = findMemberPort.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    @Transactional
    @Override
    public List<Member> findMembers() {
        return findMemberPort.findAll();
    }

    @Transactional
    @Override
    public Member findOne(Long memberId) {
        return findMemberPort.findOne(memberId);
    }

}
