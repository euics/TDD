package com.example.membership.service;

import com.example.membership.domain.Membership;
import com.example.membership.exception.MembershipException;
import com.example.membership.repository.MembershipRepository;
import com.example.membership.vo.MembershipResponse;
import com.example.membership.util.MembershipErrorResult;
import com.example.membership.util.MembershipType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {
    private final MembershipRepository membershipRepository;

    public MembershipResponse addMembership(final String userId, final MembershipType membershipType, final Integer point) {
        final Membership result = membershipRepository.findByUserIdAndMembershipType(userId, membershipType);

        if(result != null) {
            throw new MembershipException(MembershipErrorResult.DUPLICATE_MEMBERSHIP_REGISTER);
        }

        final Membership membership = Membership.builder()
                .userId(userId)
                .point(point)
                .membershipType(membershipType)
                .build();

        final Membership savedMembership = membershipRepository.save(membership);

        return MembershipResponse.builder()
                .id(savedMembership.getId())
                .membershipType(savedMembership.getMembershipType())
                .build();
    }
}
