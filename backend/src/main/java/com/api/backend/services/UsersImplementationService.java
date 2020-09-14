
package com.api.backend.services;

import com.api.backend.models.users.Users;
import com.api.backend.repositories.UsersRepository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("usersService")
public class UsersImplementationService implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    public UsersImplementationService() {
    }

    public UsersImplementationService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Optional<Users> findById(Double userId) {
        return usersRepository.findById(userId);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }


    @Override
    public Users create(Users users) {
      return usersRepository.save(users);
    }

    @Override
    public Users update(Double userId, Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users updateStatus(Double userId, Users users) {
        return null;
    }

    @Override
    public void deleteById(Double userId) {
        usersRepository.deleteById(userId);
    }
}
