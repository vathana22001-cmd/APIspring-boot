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

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found"
                ));

        userRepository.delete(user);
    }

    @Override
    public UserResponse create(UserCreateRequest request) {

        User user = new User();

        user.setUsername(request.username());
        user.setPassword(request.password());
        user.setFullName(request.fullName());
        user.setIsActive(true);

        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getFullName(),
                savedUser.getIsActive()
        );
    }

    @Override
    public List<UserResponse> getAll() {

        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getFullName(),
                        user.getIsActive()
                ))
                .toList();
    }

    @Override
    public UserResponse getById(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found"
                ));

        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getIsActive()
        );
    }
}