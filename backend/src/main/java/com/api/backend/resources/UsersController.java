package com.api.backend.resources;

import com.api.backend.models.users.Users;
import com.api.backend.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersServices;

    public UsersController() {
    }

    public UsersController(UsersService usersServices) {
        this.usersServices = usersServices;
    }

    /** GET request to return specific appointments **/
    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public Optional<Users> findById(@PathVariable Double userId) {
        return usersServices.findById(userId);
    }

    /** GET request to return all appointments **/
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    List<Users> findAll() {
        return usersServices.findAll();
    }


    /** POST request to add new appointments **/
    @RequestMapping(path = "/createUsers",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody Users users) {
      return usersServices.create(users);
    }

    /** PUT request to update appointments **/
    @RequestMapping(path = "/update/{userId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Users update(@PathVariable Double userId, @RequestBody Users users) {
        return usersServices.update(userId, users);
    }

    /** PATCH request to update status of an appointment **/
    @RequestMapping(path = "/{userId}", method = RequestMethod.PATCH, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Users updateStatus(@PathVariable Double userId, @RequestBody Users users) {
        return usersServices.updateStatus(userId, users);
    }

    /** DELETE request to delete specific appointments **/
    @RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Double userId) {
        usersServices.deleteById(userId);
    }
}
