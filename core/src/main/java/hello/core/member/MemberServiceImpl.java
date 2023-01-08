package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    /**
     * 외부(AppConfig)에서 구현 객체를 주입하는 것으로 설계 변경
     * * 의존 관계에 대한 고민은 외부에 맡기고 실행에만 집중
     * * DIP 완성 - 추상에만 의존하며, 구체 클래스를 몰라도 된다.
     * * MemberServiceImpl 은 MemoryMemberRepository 를 의존하지 않는다.
     * * MemberRepository 인터페이스에만 의존
     * @param memberRepository
     */
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
