package kh.edu.istad.restfulapi.service;
import kh.edu.istad.restfulapi.dto.UserCreateRequest;
import kh.edu.istad.restfulapi.dto.UserResponse;
import java.util.List;
import java.util.UUID;

public interface UserService {
    void deleteById(UUID id);
    UserResponse create(UserCreateRequest userCreateRequest);
    List<UserResponse> getAll();
    UserResponse getById(UUID id);

}