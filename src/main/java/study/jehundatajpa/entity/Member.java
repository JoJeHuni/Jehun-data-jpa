package study.jehundatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;
    private String username;
    private int age;

    //일대다 관계
    @ManyToOne(fetch = FetchType.LAZY) // JPA에서 모든 연관관계는 기본적으로 다 지연로딩으로 세팅해야 한다.
    @JoinColumn(name = "team_id")
    private Team team;

    //protected Member() { // JPA는 기본 생성자는 private으로 하면 안 된다. 차라리 이걸 없애고 위에 NoArgsConstructor 어노테이션 추가하자.
    //}

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}