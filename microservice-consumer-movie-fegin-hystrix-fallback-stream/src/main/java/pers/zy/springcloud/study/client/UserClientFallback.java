package pers.zy.springcloud.study.client;

import org.springframework.stereotype.Component;
import pers.zy.springcloud.study.dto.User;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User findById(Long id) {
        return User.builder().username("defalut user").id(1L).build();
    }
}
