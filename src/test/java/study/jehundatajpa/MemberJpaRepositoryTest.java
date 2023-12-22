package study.jehundatajpa;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import study.jehundatajpa.entity.Member;
import study.jehundatajpa.repository.MemberJpaRepository;

@SpringBootTest
@Transactional
@Rollback(false) //테스트 할 때 @Transactional은 자동으로 롤백을 하는데 이 어노테이션으로 바꿀 수 있다.
public class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;
    
    @Test
    public void testMember() throws Exception {
        //given
        Member member = new Member("memberA");

        //when
        Member savedMember = memberJpaRepository.save(member);
        Member findMember = memberJpaRepository.find(savedMember.getId());

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        // findmember와 그냥 member는 같은 것이다. -> JPA 엔티티는 동일성이 보장된다.
        Assertions.assertThat(findMember).isEqualTo(member);
        // System.out.println("findMember == member: ") + (findMember ==member));
    }
}