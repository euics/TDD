package com.example.membership.service.vo;

import com.example.membership.util.MembershipType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class MembershipResponse {
    private final Long id;
    private final MembershipType membershipType;
}
