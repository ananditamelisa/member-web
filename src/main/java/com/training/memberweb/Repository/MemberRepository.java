package com.training.memberweb.Repository;

import com.training.memberweb.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
}
