/*
*Author : Ankit Ambekar
*Date : 
Created with : IntelliJ IDEA Community Edition
*/
package com.niit.service;

import com.niit.domain.Song;
import com.niit.domain.User;
import com.niit.domain.UserLog;
import com.niit.proxy.UserProxy;
import com.niit.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
   private UserProxy userProxy;
    @Autowired
    private SongServiceImpl songService;
    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user) {
        if(!userRepo.findById(user.getEmail()).isPresent()){
            UserLog userLog = new UserLog();
            userLog.setPassword(user.getPassword());
            userLog.setEmail(user.getEmail());
              userProxy.addUser(userLog);
        return userRepo.save(user);}
        else {
            return null;
        }
    }

    @Override
    public User getUser(String id) {
        if(userRepo.findById(id).isPresent()){
            return userRepo.findById(id).get();
        }
        else {
            return null;
        }
    }
    public List<Song> getPlaylist(String id){
        return this.userRepo.findById(id).get().getPlaylist();
    }
    @Override
    public boolean deleteUser(String id) {
        if(userRepo.findById(id).isPresent()){
            userRepo.delete(userRepo.findById(id).get());
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public User updateUser(User user) {
        User user1 = user;
        if(userRepo.findById(user.getEmail()).isPresent()){
            if(user.getEmail()!=null){
                user1.setEmail(user.getEmail());
            }if(user.getPassword()!=null){
                user1.setPassword(user.getPassword());
            }if(user.getDob()!=null){
                user1.setDob(user.getDob());
            }if(user.getName()!=null){
                user1.setName(user.getName());
            }if(user.getPhoneNo()!=null){
                user1.setPhoneNo(user.getPhoneNo());
            }
            if(user.getPlaylist()!=null){
                user1.setPlaylist(user.getPlaylist());
            }
            return userRepo.save(user1);
        }
        return null;
    }

    @Override
    public boolean addToPlaylist(Song song,String id) {
        //User user1 = userRepo.findById(id).get();
        if(userRepo.findById(id).isPresent()){
            User user = userRepo.findById(id).get();
            if (user.getPlaylist() == null) {
                user.setPlaylist(new ArrayList<Song>());
            }
            boolean isPresent = false;
            List<Song> songs = user.getPlaylist();
            for (Song song1 : songs) {
                if(song1.getTitle().equals(song.getTitle())){
                    isPresent = true;
                    break;
                }

            }
            if(!isPresent){
            songs.add(song);
            user.setPlaylist(songs);
            userRepo.save(user);
            return true;}
        }
        return false;
    }
}
