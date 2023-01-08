package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링으로 전환하기
 * @Configuration - 설정을 구성함
 * @Bean - 스프링 컨테이너에서 스프링 빈으로 자동 등록
 * @Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록
 *
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

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    /* 중복 제거*/
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
