package com.example.RestApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController //spring knows we are making rest API
public class UserController {
    @Autowired
    UserService userService;
    // we generally add to database

    @GetMapping("/get_users")
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

//    @PostMapping("/add_user")
//    public void addUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age,
//                        @RequestParam("country") String country){
//
//        User user = new User(id,name,country,age);
//        users.put(id,user);
//    }

    @PostMapping("/add_user_body")
    public ResponseEntity addUserBody(@RequestBody(required = true) User u) {
        userService.addUserToDB(u);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
