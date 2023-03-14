package com.niit.service;

import com.niit.domain.Song;
import com.niit.domain.User;
import com.niit.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User addUser(User user);
    public User getUser(String id);
    public boolean deleteUser(String id);
    public User updateUser(User user);
    public boolean addToPlaylist(Song song,String id);
}
