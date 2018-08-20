package pers.zy.springcloud.study.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class PreRequestLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; // 返回过滤器的类型: pre,route,post, error 等
    }

    @Override
    public int filterOrder() {
        return 1; // 指定过滤器执行顺序， 不同的过滤器允许返回相同的数值
    }

    @Override
    public boolean shouldFilter() {
        return true; // 该过滤器是否需要执行， true 执行
    }

    @Override
    public Object run() {
        // 过滤器的具体逻辑
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
