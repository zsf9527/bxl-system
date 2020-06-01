package com.zsf.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
public class MyFilter extends ZuulFilter {
    private static Logger log= LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if(token==null){
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false);//不转发到后续服务
            try {
                ctx.getResponse().getWriter().write("error service");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }
        return null;
    }
}
