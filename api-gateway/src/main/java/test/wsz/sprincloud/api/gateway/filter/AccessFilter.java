package test.wsz.sprincloud.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;

;import javax.servlet.http.HttpServletRequest;

/**
 * 〈〉
 *
 * @author shuzheng_wang
 * @create 2018/5/16
 */
public class AccessFilter extends ZuulFilter {

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
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String accessKey = request.getParameter("accessToken");
        if(StringUtils.isEmpty(accessKey)){
            System.out.println("鉴权失败");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }

        System.out.println("鉴权成功！");
        return null;
    }
}
