package example.shoppingmall.enitity;

import example.shoppingmall.constant.Role;
import example.shoppingmall.dto.MemberFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFormDto memberFormDto) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        member.setPassword(memberFormDto.getPassword());
        member.setRole(Role.USER);
        return member;
    }
}
