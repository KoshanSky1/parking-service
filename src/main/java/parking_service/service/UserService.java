package parking_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parking_service.dto.user.NewUserDto;
import parking_service.dto.user.UserDtoOut;
import parking_service.exception.EntityNotFoundException;
import parking_service.exception.LoginAlreadyExistsException;
import parking_service.model.User;
import parking_service.repository.UserRepository;
import parking_service.utils.StringUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<UserDtoOut> getAllUsers() {
        log.info("A list of all users has been generated");
        return userRepository.findAll()
                .stream()
                .map(UserDtoOut::of)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserDtoOut findUserById(long id) {
        log.info("User with id=" + id + " found");
        return UserDtoOut.of(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id=" + id + " was not found")));

    }

    @Transactional
    public UserDtoOut createUser(NewUserDto dto) {
        if (userRepository.existsByLogin(dto.login())) {
            throw new LoginAlreadyExistsException("This login already exists!");
        }

        User user = new User();
        user.setLogin(dto.login());
        user.setFullName(dto.fullName());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(dto.role());
        log.info("User " + dto.fullName() + " added");
        return UserDtoOut.of(userRepository.save(user));
    }

    @Transactional
    public UserDtoOut updateUser(long id, NewUserDto dto) {

        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id=" + id + " was not found"));
        if (!StringUtils.isEmpty(dto.login())) {
            if (!user.getLogin().equals(dto.login())) {
                if (userRepository.existsByLogin(dto.login())) {
                    throw new LoginAlreadyExistsException("This login already exists!");
                }
                user.setLogin(dto.login());
            }
        }

        if (!StringUtils.isEmpty(dto.password())) {
            user.setPassword(passwordEncoder.encode(dto.password()));
        }

        if (!StringUtils.isEmpty(dto.fullName())) {
            user.setFullName(dto.fullName());
        }

        if (!StringUtils.isEmpty(dto.role().getAuthority())) {
            user.setRole(dto.role());
        }
        log.info("User " + dto.fullName() + " updated");
        return UserDtoOut.of(userRepository.save(user));
    }

    @Transactional
    public void deleteUserById(long id) {
        log.info("User with id=" + id + " was deleted");
        userRepository.deleteById(id);
    }

}