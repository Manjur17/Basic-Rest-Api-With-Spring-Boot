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
    // database

    @GetMapping("/get_users")
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add_user_body")
    public ResponseEntity addUserBody(@RequestBody(required = true) User u) {
        userService.addUserToDB(u);
        return new ResponseEntity(HttpStatus.CREATED);
    }

//    @GetMapping("/get_user/{id}")
//    public User getUser(@PathVariable("id") int x)
//    {
//        return users.get(x);
//    }

//    @DeleteMapping("/del_user/{id}")
//    public void deleteUser(@PathVariable("id") int idx)
//    {
//        users.remove(idx);
//    }
//
//    @PutMapping("/update/{id}")
//    public void updateUser(@PathVariable("id") int id,@RequestBody()User user)
//    {
//        users.put(id,user);
//    }

    //Read operation -> API
    //use annotation to create API endpoint. Here endpoint URL is /get_users
    //http://localhost:8080/get_users
//    @GetMapping("/get_users")
//    public List<User> getUsers() {
//        List<User> userList = new ArrayList<>();
//
//        for (User user : users.values()) {
//            userList.add(user);
//        }
//
//        return userList;
//    }
//
//    //Create operation -> API
//    //through "id", "name", "age", "country" we want to create users
//    //http://localhost:8080/add_user?id=12&name=manjur&age=22&country=india
//    @PostMapping("/add_user")
//    public void addUsers(@RequestParam("id") int id,
//                         @RequestParam("name") String name,
//                         @RequestParam("age") int age,
//                         @RequestParam("country") String country) {
//
//        User user = new User(id, name, country, age);
//        users.put(id, user); //add to the hashmap
//
//    }
//
//    //through body(postman) we pass parameter
//    //http://localhost:8080/add_user_body
//    @PostMapping("/add_user_body")
//    public void addUserBody(@RequestBody(required = true) User u) {
//        users.put(u.getId(), u);
//    }
//
//    //for passing 2 variables along with url
//    @GetMapping("/get_user/{id}/{country")
//    public User getUserFromId(@PathVariable("id") int x, @PathVariable("country") String country) {
//        return users.get(x); //here x is the id provided by the user
//    }
//
//    @DeleteMapping("/delete_user/{id}")
//    public void deleteUsers(@PathVariable("id") int x) {
//        users.remove(x);
//    }
//
//    @PutMapping("/update_user/{id}")
//    public void updateUser(@PathVariable("id") int id, @RequestParam() User u) {
//        users.put(id, u);
//    }
}
