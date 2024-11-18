package com.example.springboot_testcode;

import com.example.springboot_testcode.domain.Member;
import com.example.springboot_testcode.repository.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringbootTestcodeApplicationTests {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    @DisplayName("이름 저장 test")
    public void save() {
        Member member = new Member();
        member.setName("jeongsu");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring2").get();
        assertThat(result).isEqualTo(member2);
    }


    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

        Member member3 = new Member();
        member3.setName("spring3");
        memberRepository.save(member3);

        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(3);




    }

}
