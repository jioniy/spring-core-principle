package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 새로운 할인 정책 개발
 * VIP는 주어진 금액의 10%를 할인 받는다.
 */
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
