package com.weblog.data.repository;

import com.weblog.data.models.Users;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Long> {

  @Query("select u from Users u " +
      "where lower(u.firstName) like lower(concat('%', :searchTerm, '%')) " +
      "or lower(u.lastName) like lower(concat('%', :searchTerm, '%'))")
  List<Users> search(@Param("searchTerm") String searchTerm);
}
