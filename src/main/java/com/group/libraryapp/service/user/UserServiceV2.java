package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UpdateUserRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void SaveUser(String name, int age)
    {
        userRepository.save(new User(name, age));
    }

    @Transactional(readOnly = true)
    public List<UserResponse> GetUser()
    {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUser(UpdateUserRequest req) {
        User user = userRepository.findById(req.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(req.getName());

        //userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }
}
