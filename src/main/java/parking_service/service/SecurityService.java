package parking_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parking_service.exception.EntityNotFoundException;
import parking_service.exception.NotAuthorizedException;
import parking_service.model.User;
import parking_service.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username).orElseThrow(()
                -> new EntityNotFoundException("User with usermame=" + username + " was not found"));
        user.setEnabled(true);
        log.info("User with usermame=" + username + " is enabled");
        return user;
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthorizedException("User is not authorized");
        }

        if (authentication.getPrincipal() instanceof UserDetails) {
            return (User) authentication.getPrincipal();
        }
        throw new NotAuthorizedException("User is not authorized");
    }

}