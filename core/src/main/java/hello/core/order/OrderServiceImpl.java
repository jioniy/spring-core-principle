package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    /* 할인 정책 교체
     * * GOOD * * *
     * 역할과 구현을 충실히 분리했다.
     * 다형성을 활용하고 인터페이스와 구현 객체를 분리했다.
     * * PROBLEM * * *
     * DIP 위반: interface(DiscountPolicy)뿐만 아니라 구현 class(Fix, RateDiscountPolicy)에도 의존하고 있다.
     * OCP 위반: 클라이언트 코드를 변경하지 않고 확장해야 하지만, 클라이언트 코드에 영향(변경)이 있다.
     * * SOLUTION * * *
     * 인터페이스에만 의존하도록 설계를 변경
     * */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }




    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
