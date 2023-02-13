package com.mong.mmbs.service;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mong.mmbs.repository.UserRepository;

@Service
public class MemberService {

	@Autowired UserRepository userRepository;
	
    /** 이메일이 존재하는지 확인 **/
    public boolean checkEmail(String memberEmail) {
        /* 이메일이 존재하면 true, 이메일이 없으면 false  */
    	System.out.println(memberEmail);
        return userRepository.existsByUserEmail(memberEmail);
    }
    
//    /** 임시 비밀번호 생성 **/
//    public String getTmpPassword() {
//        char[] charSet = new char[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
//                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//
//        String pwd = "";
//
//        /* 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 조합 */
//        int idx = 0;
//        for(int i = 0; i < 10; i++){
//            idx = (int) (charSet.length * Math.random());
//            pwd += charSet[idx];
//        }
//
//        System.out.println("임시 비밀번호 생성");
//
//        return pwd;
//    }

//    /** 임시 비밀번호로 업데이트 **/
//    public void updatePassword(String tmpPassword, String memberEmail) {
//
//        String encryptPassword = encoder.encode(tmpPassword);
//        Member member = UserRepository.existsByUserEmail(memberEmail).orElseThrow(() ->
//                new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
//
//        member.updatePassword(encryptPassword);
//        System.out.println("임시 비밀번호 업데이트");
//    }
}
