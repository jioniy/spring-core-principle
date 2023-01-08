package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 직접적인 방식의 테스트는 좋은 방법이 아니다. 
 * JUnit을 사용할 것
 *
 * ApplicationContext : 스프링 컨테이너
 */
public class MemberApp {
    public static void main(String[] args) {
        /* 자바로 빈을 직접 등록 하는 경우
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
         */
        /* 스프링으로 빈을 자동 등록한 경우*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+ member.getName());
        System.out.println("find member = "+ findMember.getName());
    }
}
