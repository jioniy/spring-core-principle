package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 관심사의 분리
 * Application의 전체 동작 방식을 구성
 * 실제 동작에 필요한 구현 객체를 생성 및 연결 
 * DI(Dependency Injection) - 의존성 주입
 * 
 * MemberServiceImpl
 * MemoryMemberRepository
 * OrderServiceImpl
 * FixDiscountPolicy
 */
public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    /* 중복 제거*/
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
