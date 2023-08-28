package com.tripurari.springbootdatabase.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripurari.springbootdatabase.models.User;
import com.tripurari.springbootdatabase.repos.UserRepo;

@Service
public class UserService {
	
	private final UserRepo repo;
	
	@Autowired
	public UserService(UserRepo repo) {
		this.repo = repo;
	}
	
	public List<User> getAllUser() {
		
		return repo.findAll();
	}
	
	public User getUserById(Long id) {
		
		return repo.findById(id).orElse(null);
	}
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	public void createBulkUsers(List<User> users) {
		repo.saveAll(users);
	}
	
	public void deleteUser(Long id) {
		repo.deleteById(id);
	}
	
	// Basic Authentication
    public boolean basicAuthentication(String email, String password) {
        User user = repo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
