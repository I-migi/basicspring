package springproject.basicspring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springproject.basicspring.member.Grade;
import springproject.basicspring.member.Member;
import springproject.basicspring.member.MemberService;
import springproject.basicspring.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}
