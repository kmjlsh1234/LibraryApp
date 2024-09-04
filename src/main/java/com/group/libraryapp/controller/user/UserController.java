package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UpdateUserRequest;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    private final UserServiceV2 userServiceV2;

    public UserController(UserServiceV2 userServiceV2) {
        this.userServiceV2 = userServiceV2;
    }

    @PostMapping("/user")
    public void SaveUser(@RequestBody UserCreateRequest req)
    {
        userServiceV2.SaveUser(req.getName(), req.getAge());
    }

    @GetMapping("/user")
    public List<UserResponse> GetUser()
    {
        return userServiceV2.GetUser();
    }

    @PutMapping("/user")
    public void UpdateUser(@RequestBody UpdateUserRequest req)
    {
        userServiceV2.updateUser(req);
    }

    @DeleteMapping("/user")
    public void DeleteUser(@RequestParam String name)
    {
        userServiceV2.deleteUser(name);
    }


}
