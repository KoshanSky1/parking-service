package parking_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import parking_service.dto.user.NewUserDto;
import parking_service.dto.user.UserDtoOut;
import parking_service.service.UserService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("admin-panel")
public class AdminController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        log.info("---START GET ALL USERS ENDPOINT---");
        List<UserDtoOut> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin-panel";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") long id,
                              Model model) {
        log.info("---START GET USER BY ID ENDPOINT---");
        UserDtoOut userDtoOut = userService.findUserById(id);
        model.addAttribute("user", userDtoOut);
        return "edit-user";
    }

    @PostMapping
    public String createNewUser(NewUserDto dto, Model model) {
        log.info("---START CREATE USER ENDPOINT---");
        userService.createUser(dto);
        List<UserDtoOut> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin-panel";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, NewUserDto dto, Model model) {
        log.info("---START UPDATE USER ENDPOINT---");
        UserDtoOut updatedUser = userService.updateUser(id, dto);
        model.addAttribute("user", updatedUser);
        return "edit-user";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        log.info("---START DELETE USER ENDPOINT---");
        userService.deleteUserById(id);
        List<UserDtoOut> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin-panel";
    }

}