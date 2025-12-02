package org.zerock.mallapi.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class MemberDTO extends User {
    private String email;
    private String pw;
    private String nickname;
    private boolean social;
    private List<String> roleNames = new ArrayList<>();

    public MemberDTO(String email, String pw, String nickname, boolean social, List<String> roleNames) {
        super(email,pw,roleNames.stream().map(str -> new SimpleGrantedAuthority("ROLE_" + str)).toList()     // 부모인 User 클래스의 생성자 호출
        );
        this.email = email;
        this.pw = pw;
        this.nickname = nickname;
        this.social = social;
        this.roleNames = roleNames;
    }

    public Map<String, Object> getClaims() {   // 현재 사용자 정보를 Map 타입으로 반환 → JWT 문자열 생성시 사용
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("email", email);
        dataMap.put("pw", pw);
        dataMap.put("nickname", nickname);
        dataMap.put("social", social);
        dataMap.put("roleNames", roleNames);
        return dataMap;
    }
}
