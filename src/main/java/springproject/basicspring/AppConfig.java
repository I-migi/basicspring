package springproject.basicspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springproject.basicspring.discount.DiscountPolicy;
import springproject.basicspring.discount.FixDiscountPolicy;
import springproject.basicspring.discount.RateDiscountPolicy;
import springproject.basicspring.member.MemberRepository;
import springproject.basicspring.member.MemberService;
import springproject.basicspring.member.MemberServiceImpl;
import springproject.basicspring.member.MemoryMemberRepository;
import springproject.basicspring.order.OrderService;
import springproject.basicspring.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
