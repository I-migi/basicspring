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

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    // -> 싱글톤이 깨지는 거 아닐까??

    //AppConfig.memberService
    //AppConfig.memberRepository
    //AppConfig.memberRepository
    //AppConfig.orderService
    //AppConfig.memberRepository

    //AppConfig.memberService
    //AppConfig.memberRepository
    //AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");

        return new MemoryMemberRepository();
    }

    // 스프링 컨테이너가 @Bean 메서드를 오버라이딩하여 싱글톤을 보장하는 프록시 메커니즘을 사용
    // 아래와 같이 static을 붙이면 static 메서드는 스프링 컨테이너에 의해 오버라이딩되어 관리될 수 없기 때문에
    // 싱글톤으로 관리되지 않는다.
//    @Bean
//    public static MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
