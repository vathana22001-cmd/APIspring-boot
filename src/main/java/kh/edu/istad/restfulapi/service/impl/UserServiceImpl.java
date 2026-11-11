package kh.edu.istad.restfulapi.service.impl;

import kh.edu.istad.restfulapi.dto.UserCreateRequest;
import kh.edu.istad.restfulapi.dto.UserResponse;
import kh.edu.istad.restfulapi.model.User;
import kh.edu.istad.restfulapi.repository.UserRepository;
import kh.edu.istad.restfulapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public void deleteById(UUID id) {
        // validate user ID
        if (!userRepository.checkById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User not found!"
            );
        }

        userRepository.deleteOne(id);
    }

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {

        User user = new User();
        user.setUsername(userCreateRequest.username());
        user.setPassword(userCreateRequest.password());
        user.setFullName(userCreateRequest.fullName());

        user.setId(UUID.randomUUID());
        user.setIsActive(true);

        // TODO: write your business logic here

        userRepository.insertOne(user);

        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getIsActive()
        );
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.selectAll()
                .stream()
                .map(user -> new UserResponse(user.getId(),
                        user.getFullName(),
                        user.getIsActive()))
                .toList();
    }

    @Override
    public User getById(UUID id) {
        return null;
    }

}