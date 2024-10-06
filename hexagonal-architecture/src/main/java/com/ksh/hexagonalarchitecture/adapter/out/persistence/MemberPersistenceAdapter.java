package com.ksh.hexagonalarchitecture.adapter.out.persistence;

import com.ksh.hexagonalarchitecture.application.port.out.FindMemberPort;
import com.ksh.hexagonalarchitecture.application.port.out.SaveMemberPort;
import com.ksh.hexagonalarchitecture.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberPersistenceAdapter implements SaveMemberPort, FindMemberPort {
    private final MemberRepository memberRepository;

    @Override
    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

}
