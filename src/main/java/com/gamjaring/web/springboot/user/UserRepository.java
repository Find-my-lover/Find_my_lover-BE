//엔터티를 데이터 베이스에 저장
package com.gamjaring.web.springboot.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

}
