package springproject.basicspring;

import springproject.basicspring.member.Grade;
import springproject.basicspring.member.Member;
import springproject.basicspring.member.MemberService;
import springproject.basicspring.member.MemberServiceImpl;
import springproject.basicspring.order.Order;
import springproject.basicspring.order.OrderService;
import springproject.basicspring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);


    }
}
