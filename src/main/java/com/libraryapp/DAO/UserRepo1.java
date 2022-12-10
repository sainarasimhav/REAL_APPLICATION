package com.libraryapp.DAO;

import com.libraryapp.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo1 extends CrudRepository<User, Long> {
    @Query(value="Select * from Users", nativeQuery = true)
    public List<User> someUsers();
}
