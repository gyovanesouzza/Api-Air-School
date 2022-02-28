package com.airschool.apiairschool.repositories;

import com.airschool.apiairschool.model.Student;
import com.airschool.apiairschool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}