/*
*Author : Ankit Ambekar
*Date : 
Created with : IntelliJ IDEA Community Edition
*/
package com.niit.controller;

import com.niit.domain.Song;
import com.niit.domain.User;
import com.niit.service.UserService;
import com.niit.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin("http://localhost:4200/")
public class UserController {
//    public List<User> getAllUser();
//    public User addUser(User user);
//    public User getUser(String id);
//    public boolean deleteUser(String id);
//    public User updateUser(User user);
//    public boolean addToPlaylist(Song song, String id);
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/user/getAll")
    public ResponseEntity<?> getAllUser (){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user),HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
        return new  ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
    @PutMapping("/user/update/{user}")
    public ResponseEntity<?> update(@PathVariable User user){
        return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
    }
    @PostMapping("/user/{id}/song")
    public ResponseEntity<?> addSong(@PathVariable String id,@RequestBody Song song){
        return new ResponseEntity<>(userService.addToPlaylist(song,id),HttpStatus.OK);
    }
    @GetMapping("/user/playlist/{id}")
    public ResponseEntity<?> getPlaylist(@PathVariable String id){
        return new ResponseEntity<>(userService.getPlaylist(id) ,HttpStatus.OK);
    }
}
