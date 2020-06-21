package com.gautam.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

    //to created encoded password for new user
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        for(int i=0;i<10;i++){
            String encoded = encoder.encode("password@123#$%");
            System.out.println(encoded);
        }
    }
}
