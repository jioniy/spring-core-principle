package hello.core.member;

/**
 * 회원을 가입하고 조회할 수 있다.
 */
public interface MemberRepository {
    /*회원 생성*/
    void save(Member member);

    /*회원 조회*/
    Member findById(Long memberId);
}
