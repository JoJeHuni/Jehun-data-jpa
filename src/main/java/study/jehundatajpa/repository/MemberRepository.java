package study.jehundatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.jehundatajpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
