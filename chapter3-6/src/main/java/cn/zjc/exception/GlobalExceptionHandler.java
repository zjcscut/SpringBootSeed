package cn.zjc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangjinci
 * @version 2016/9/22 15:47
 * @function 全局异常处理
 */


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.setViewName(ERROR_VIEW);
        return modelAndView;
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandlerJson(HttpServletRequest request, CustomException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(500);
        r.setData("some data");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }

}
