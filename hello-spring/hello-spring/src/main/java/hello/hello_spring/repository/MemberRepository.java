package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //회원 등록
    Member save(Member member);
    //아이디로 회원 찾기
    Optional<Member> findById(Long id);
    //이름으로 회원 찾기
    Optional<Member> findByName(String name);
    //모든 회원 조회
    List<Member> findAll();

}
