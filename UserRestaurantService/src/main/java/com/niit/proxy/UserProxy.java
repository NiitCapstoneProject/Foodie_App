/*
*Author : Ankit Ambekar
*Date : 
Created with : IntelliJ IDEA Community Edition
*/
package com.niit.proxy;

import com.niit.domain.UserLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

 @FeignClient(name = "UserAuthenticatonService",url = "localhost:8082")
    public interface UserProxy {
        @PostMapping("/api/v2/user")
        public ResponseEntity addUser(UserLog user);
    }
