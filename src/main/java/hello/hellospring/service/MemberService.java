package hello.hellospring.service;

import hello.hellospring.domain.Menber;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param menber
     * @return
     */
    public Long join(Menber menber) {
        validateDuplicateMember(menber);//중복회원 검증
        memberRepository.save(menber);
        return menber.getId();
    }

    private void validateDuplicateMember(Menber menber) {
        memberRepository.findByName(menber.getName()).ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }

    /**
     * 전체 회원조회
     *
     * @return
     */
    public List<Menber> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Menber> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
