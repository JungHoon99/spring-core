package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
    * AppConfig를 사용으로 구성영역과 사용영역 분리
    * AppConfig는 애플리케이션의 전체 동작 방식을 구성(config)
    * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성하고 연결
    * AppConfig는 인터페이스에만 의존
    * AppConfig는 구체 클래스에 의존하지 않는다.
    * AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 설정
 */
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static DiscountPolicy discountPolicy() {
//        return new FIxDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
