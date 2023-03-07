package hello.hellospring.service;

import hello.hellospring.domain.Menber;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

     MemberService memberService /*= new MemberService(memberRepository)*/;
     MemberRepository memberRepository/* = new MemoryMemberRepository()*/;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Menber menber = new Menber();
        menber.setName("hello");

        //when
        Long saveId = memberService.join(menber);

        //then
        Menber findMember = memberService.findOne(saveId).get();
        assertThat(menber.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void 중복회원예외() {
        //given
        Menber menber1 = new Menber();
        menber1.setName("hello");

        Menber member2 = new Menber();
        member2.setName("hello");

        //when
       memberService.join(menber1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//예외처리 발생
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}