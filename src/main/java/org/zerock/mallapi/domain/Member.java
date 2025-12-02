package org.zerock.mallapi.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "memberRoleList")
public class Member {

    @Id
    private String email;
    private String pw;
    private String nickname;
    private boolean social;

    // 엔터티가 아니라 enum, String 같은 값 타입 컬렉션 저장용 어노테이션
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default    // 기본 로딩 설정: Member 엔티티 로딩 시 memberRoleList를 즉시 가져오지 않음
    private List<MemberRole> memberRoleList = new ArrayList<>();
    // 원래는 memberRoleList가 빈 리스트가 되어야 하나 @Builder에 의해 null이 되므로 @Builder.Default를 붙여 빈 리스트로 만듦

    public void addRole(MemberRole role) {
        this.memberRoleList.add(role);
    }

    public void clearRole() {
        this.memberRoleList.clear();
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
        }

    public void changePw(String pw) {
        this.pw = pw;
    }

    public void changeSocial(boolean social) {
        this.social = social;
    }
}

