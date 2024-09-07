package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //////////////////////////////회원가입//////////////////////////////

    //회원가입 UI
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    //회원가입 실행
    @PostMapping("/members/new")
    public String create(MemberForm memberForm) {
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        //home으로 보낸다
        return "redirect:/";
    }

    //////////////////////////////회원 목록 조회//////////////////////////////

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }

}
