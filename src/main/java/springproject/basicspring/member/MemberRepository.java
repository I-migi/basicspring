package springproject.basicspring.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
