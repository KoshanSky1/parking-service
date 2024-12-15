package parking_service.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import parking_service.model.embedded.Role;
import parking_service.model.User;

@Data
@AllArgsConstructor
public class UserDtoOut {

    private Long id;
    private String fullName;
    private String login;
    private Role role;

    public static UserDtoOut of(User user) {
        if (user == null) {
            return null;
        }

        return new UserDtoOut(
            user.getId(),
            user.getFullName(),
            user.getLogin(),
            user.getRole()
        );
    }
}
