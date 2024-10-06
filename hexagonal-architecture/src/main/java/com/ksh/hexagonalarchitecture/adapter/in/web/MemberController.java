package com.ksh.hexagonalarchitecture.adapter.in.web;

import com.ksh.hexagonalarchitecture.application.port.in.FindMemberUseCase;
import com.ksh.hexagonalarchitecture.application.port.in.JoinMemberUseCase;
import com.ksh.hexagonalarchitecture.controller.MemberForm;
import com.ksh.hexagonalarchitecture.domain.Address;
import com.ksh.hexagonalarchitecture.domain.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final FindMemberUseCase findMemberUseCase;
    private final JoinMemberUseCase joinMemberUseCase;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        joinMemberUseCase.joinMember(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
//        List<Member> members = memberService.findMembers();
        List<Member> members = findMemberUseCase.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
