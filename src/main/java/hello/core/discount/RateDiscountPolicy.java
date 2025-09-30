package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;


public class RateDiscountPolicy implements DiscountPolicy{

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            int rate = 10;
            return price * rate / 100;
        }
        else{
            return 0;
        }
    }
}
