package com.lh.cloudapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class AccessFilter2 extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(AccessFilter2.class);

    @Override
    public String filterType() {
//        return  "pre";
        return PRE_TYPE;
    }

    /**
     * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
     * 
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.info("I am AccessFilter2");
        return null;
    }
}
