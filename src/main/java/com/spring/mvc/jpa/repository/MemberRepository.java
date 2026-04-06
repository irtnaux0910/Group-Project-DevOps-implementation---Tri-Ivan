package com.spring.mvc.jpa.repository;

import com.spring.mvc.jpa.model.Member;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByPaymentStatus(String status);
}