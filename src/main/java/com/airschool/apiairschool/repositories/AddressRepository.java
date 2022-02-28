package com.airschool.apiairschool.repositories;

import com.airschool.apiairschool.model.Address;
import com.airschool.apiairschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


}