package com.example.aplicationcrud.controller;

import com.example.aplicationcrud.model.User;
import com.example.aplicationcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
            User user = userService.findById(id);
            return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/user")
    public User save(@RequestBody @Valid User obj){
        return userService.save(obj);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        userService.delete(id);
        return null;
    }
}
