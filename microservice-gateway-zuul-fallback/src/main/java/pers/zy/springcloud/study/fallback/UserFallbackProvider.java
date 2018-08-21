package pers.zy.springcloud.study.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class UserFallbackProvider implements ZuulFallbackProvider {
    @Override
    public String getRoute() { // 标识是为哪个微服务提供回退
        return "microservice-provider-user";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK; // fallback 时的返回的状态码
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value(); // fallback 对应的回退状态码的 int 值 200
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase(); // fallback 对应回退状态码的状态文本 OK
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                // fallback 返回响应体
                return new ByteArrayInputStream("当前微服务不可用，请稍后再试。".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                // 设置返回体的请求头
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
                return headers;
            }
        };
    }
}
