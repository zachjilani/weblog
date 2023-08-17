package com.weblog.data.repository;

import com.weblog.data.models.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {

  @Query("select c from Company c " +
      "where lower(c.name) like lower(concat('%', :searchTerm, '%')) " +
      "or lower(c.position) like lower(concat('%', :searchTerm, '%'))")
  List<Company> search(@Param("searchTerm") String searchTerm);
}
