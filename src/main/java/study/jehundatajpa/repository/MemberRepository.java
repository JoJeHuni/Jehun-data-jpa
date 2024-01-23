package study.jehundatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.jehundatajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
}
