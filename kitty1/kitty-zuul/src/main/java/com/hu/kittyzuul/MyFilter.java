package com.hu.kittyzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: hy
 * @Date: 2019/8/30
 */
@Component
public class MyFilter extends ZuulFilter{

    private static Logger log= LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";       // 定义filter的类型，有pre、route、post、error四种
    }

    @Override
    public int filterOrder() {
        return 0;            // 定义filter的顺序，数字越小表示顺序越高，越先执行
    }

    @Override
    public boolean shouldFilter() {
        return false;       // 表示是否需要执行该filter，true表示执行，false表示不执行
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token =  request.getParameter("token");
        log.info(token);
        if (token == null){
            log.warn("there is no request token");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().print("there is no request token");
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
