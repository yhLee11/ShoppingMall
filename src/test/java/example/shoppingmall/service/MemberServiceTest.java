package example.shoppingmall.service;

import example.shoppingmall.dto.MemberFormDto;
import example.shoppingmall.enitity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    public Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("test@gmail.com");
        memberFormDto.setAddress("Seoul");
        memberFormDto.setName("spring");
        memberFormDto.setPassword("1234");
        return Member.createMember(memberFormDto);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest() {
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

        Assertions.assertEquals(member,savedMember);
        System.out.println("member = " + member);
        System.out.println("savedMember = " + savedMember);
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMemberTest() {
        Member member1 = createMember();
        Member member2 = createMember();
        memberService.saveMember(member1);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.saveMember(member2);
        });
    }
}