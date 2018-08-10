package pers.zy.springcloud.study.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.zy.springcloud.study.client.UserClient;
import pers.zy.springcloud.study.dto.User;


@RestController
public class MovieController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userClient.findById(id);
    }
}
