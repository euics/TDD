package com.example.membership.repository;

import com.example.membership.domain.Membership;
import com.example.membership.util.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Membership findByUserIdAndMembershipType(final String userId, final MembershipType membershipType);
}
