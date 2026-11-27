package kh.edu.istad.restfulapi.dto;
import lombok.Builder;

import java.util.UUID;
@Builder
public record UserResponse(
        UUID id,
        String fullName,
        Boolean isActive
) {

}