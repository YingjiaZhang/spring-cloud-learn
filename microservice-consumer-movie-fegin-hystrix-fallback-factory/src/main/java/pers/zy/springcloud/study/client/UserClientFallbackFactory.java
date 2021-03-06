package pers.zy.springcloud.study.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pers.zy.springcloud.study.dto.User;

@Slf4j
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        return new UserClient() {
            @Override
            public User findById(Long id) {
                log.info("fallback; reason was : ", cause);
                if (cause instanceof IllegalArgumentException) {
                    return User.builder().id(-1L).username("IllegalArgumentException default username").build();
                }
                return User.builder().id(-1L).username("other exception default username").build();
            }
        };
    }
}
