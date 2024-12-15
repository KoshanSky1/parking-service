package parking_service.dto.user;

import lombok.Builder;
import parking_service.model.embedded.Role;

@Builder
public record NewUserDto (
    String login,
    String fullName,
    String password,
    Role role
) {
}