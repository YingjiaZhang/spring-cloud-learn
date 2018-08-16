package pers.zy.springcloud.study.web;

import pers.zy.springcloud.study.dao.UserRepository;
import pers.zy.springcloud.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @GetMapping("/admin/{id}")
    public User findAdminById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }
}
