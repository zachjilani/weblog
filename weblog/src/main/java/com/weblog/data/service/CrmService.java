package com.weblog.data.service;

import com.weblog.data.models.Users;
import com.weblog.data.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmService {

  private final UsersRepository usersRepository;

  public CrmService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public List<Users> findAllUsers(String stringFilter) {
    if (stringFilter == null || stringFilter.isEmpty()) {
      return usersRepository.findAll();
    } else {
      return usersRepository.search(stringFilter);
    }
  }

  public long countUser() {
    return usersRepository.count();
  }

  public void deleteUser(Users user) {
    usersRepository.delete(user);
  }

  public void saveContact(Users user) {
    if (user == null) {
      System.err.println("User is null. Are you sure you have connected your form to the application?");
      return;
    }
    usersRepository.save(user);
  }
}
