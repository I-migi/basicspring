package springproject.basicspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springproject.basicspring.member.Grade;
import springproject.basicspring.member.Member;
import springproject.basicspring.member.MemberService;
import springproject.basicspring.member.MemberServiceImpl;
import springproject.basicspring.order.Order;
import springproject.basicspring.order.OrderService;
import springproject.basicspring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean(MemberService.class);
        OrderServiceImpl orderService = applicationContext.getBean(OrderServiceImpl.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);


    }
}
