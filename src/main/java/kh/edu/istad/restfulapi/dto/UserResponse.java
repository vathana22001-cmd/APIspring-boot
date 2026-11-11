package kh.edu.istad.restfulapi.dto;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String fullName,
        Boolean isActive
) {

}