package study.jehundatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.jehundatajpa.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
