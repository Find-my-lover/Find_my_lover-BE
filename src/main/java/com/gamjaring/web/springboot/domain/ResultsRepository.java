package com.gamjaring.web.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ResultsRepository extends JpaRepository<Results, Long> {
    Results getResultsByMember(Member member);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Results r SET r.member=:member WHERE r.id=:id")
    void joinMemberToResults(Member member, Long id);
}
