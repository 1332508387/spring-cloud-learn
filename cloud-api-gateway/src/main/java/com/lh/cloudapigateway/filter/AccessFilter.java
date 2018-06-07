package com.lh.cloudapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 过滤器
 */
public class AccessFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。pre，代表会在请求被路由之前执行。
     *      PRE_TYPE: 在 RequestContext 中设置数据，以便在下游的过滤器中使用。主要的用例是设置路由过滤器所需的信息。
     *      ROUTE_TYPE: 在预过滤器之后运行并用于向其他服务提出请求。这里的大部分工作是将请求和响应数据转换为客户机所需的模型。
     *      POST_TYPE: 后过滤器通常操纵响应。例如转换响应体，更复杂，计算密集
     *
     * @return
     */
    @Override
    public String filterType() {
//        return  "pre";
        return PRE_TYPE;
    }

    /**
     * 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行，值小的将先执行。
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 判断该过滤器是否需要被执行。true：该过滤器对所有请求都会生效。可以利用方法来指定过滤器的有效范围。
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        logger.info("send {} to {}", request.getMethod(), request.getRequestURL());

        String accessToken = request.getParameter("accessToken");
        if (Objects.isNull(accessToken)) {
            logger.warn("accessToken is null");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }

        logger.info("access token success");
        return null;
    }
}
