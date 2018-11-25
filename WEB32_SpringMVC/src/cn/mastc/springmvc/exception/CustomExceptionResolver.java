package cn.mastc.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author X_JinL
 * @version 1.0.0
 * @ClassName CustomExceptionResolver.java
 * @Description  异常处理器的自定义的实现类
 * @createTime 2018/11/25 15:55
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object obj, Exception e) {
        // obj 发生异常的地方 service层 方法:包名+类名+方法名(形参)字符串
        // 日志 1.发布 Tomcat war Eclipse  2.发布Tomcat Linux Log4j

        ModelAndView mav = new ModelAndView();
        mav.addObject("error", "未知异常");
        mav.setViewName("error");
        return mav;
    }
}
