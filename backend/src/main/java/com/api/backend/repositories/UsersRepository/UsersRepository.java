
package com.api.backend.repositories.UsersRepository;

import com.api.backend.models.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Double> {

}
