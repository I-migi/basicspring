package springproject.basicspring;

import springproject.basicspring.member.Grade;
import springproject.basicspring.member.Member;
import springproject.basicspring.member.MemberService;
import springproject.basicspring.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName() );
        System.out.println("find Member = " + findMember.getName() );
    }
}
