package pers.zy.springcloud.study.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.zy.springcloud.study.config.security.SecurityUser;
import pers.zy.springcloud.study.dao.UserRepository;
import pers.zy.springcloud.study.entity.User;

import java.util.stream.Collectors;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        showCurrentUser();
        return userRepository.findOne(id);
    }

    private void showCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            String userAuthorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(", ", "[", "]"));
            log.info("current user : {}, role : {}", user.getUsername(), userAuthorities);
        }
    }
}
