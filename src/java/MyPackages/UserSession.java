package MyPackages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;

public class UserSession  extends HandlerInterceptorAdapter {
    
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,Object handler) throws Exception{
        
        response.getWriter().write("Please Login first");
        return true;
    }
}
