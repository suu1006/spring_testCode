package com.example.springboot_testcode.repository;

import com.example.springboot_testcode.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member meber);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
