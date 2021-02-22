package com.bdg.bank_transaction.ws.controller;

import com.bdg.bank_transaction.core.service.impl.UserServiceImpl;
import com.bdg.bank_transaction.infrastructure.entity.User;
import com.bdg.bank_transaction.infrastructure.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable ("id") int id){
        return this.userService.getById(id);

    }
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = this.userService.register(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/{role}")
    public ResponseEntity<User> updateRole(@PathVariable("id") int id,@PathVariable("role") int role ){
        User user1 = this.userService.changeRole(id,role);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

}
