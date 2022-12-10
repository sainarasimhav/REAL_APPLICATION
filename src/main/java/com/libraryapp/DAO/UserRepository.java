package com.libraryapp.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.libraryapp.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
//		public User findbyIdAndUserName(long Id, String userName);

//		@Query(value="Select * from Users", nativeQuery = true)
//		public List<User> someUsers();
}
