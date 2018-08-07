package pers.zy.springcloud.study.web;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.zy.springcloud.study.client.UserClient;
import pers.zy.springcloud.study.dto.User;

@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {
    private UserClient userUserClient;

    private UserClient adminUserClient;

    @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        // 这边的decoder、encoder、client、contract，可以debug看看是什么实例。
        this.userUserClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("user", "password1")).target(UserClient.class, "http://microservice-provider-user/");
        this.adminUserClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin", "password2"))
                .target(UserClient.class, "http://microservice-provider-user/");
    }

    @GetMapping("/user-user/{id}")
    public User findByIdUser(@PathVariable("id") Long id) {
        return userUserClient.findById(id);
    }

    @GetMapping("/user-admin/{id}")
    public User findByIdAdmin(@PathVariable("id") Long id) {
        return adminUserClient.findById(id);
    }
}
