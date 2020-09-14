
package com.api.backend.services;

import com.api.backend.models.users.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {

  Optional<Users> findById(Double usersId);

  List<Users> findAll();

  Users create(Users users);

  Users update(Double usersId, Users users);

  Users updateStatus(Double usersId, Users users);

  void deleteById(Double usersId);

}
