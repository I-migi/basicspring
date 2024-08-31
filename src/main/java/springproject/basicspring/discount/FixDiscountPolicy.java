package springproject.basicspring.discount;

import springproject.basicspring.member.Grade;
import springproject.basicspring.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int disocuntFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return disocuntFixAmount;
        } else {
            return 0;
        }
    }
}
