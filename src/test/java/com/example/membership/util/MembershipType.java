package com.example.membership.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MembershipType {
    NAVER("네이버"),
    LIN("라인"),
    KAKAO("카카오"),
    ;

    private final String companyName;
}
