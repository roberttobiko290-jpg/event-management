package com.eventmanagement.eventmanagementsystem.user.Controller;



import com.eventmanagement.eventmanagementsystem.user.DTO.UserModelDTO;
import com.eventmanagement.eventmanagementsystem.user.Model.UserModel;
import com.eventmanagement.eventmanagementsystem.user.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserService userService;
    UserController(UserService userService){
        this.userService=userService;

    }
    //Register the user
    @PostMapping
    public UserModel registerUser(@RequestBody UserModelDTO userModelDTO){
        return userService.registerUser(userModelDTO);
    }
    //get all users
    @GetMapping
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }
    //get by id
    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModelDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }
    @DeleteMapping("/{id}")
    public UserModel deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
