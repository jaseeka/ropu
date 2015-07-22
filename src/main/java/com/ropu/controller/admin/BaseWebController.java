package com.ropu.controller.admin;

import com.ropu.base.utils.HtmlUtils;
import com.ropu.base.utils.URLUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 冬日暖阳基本Controller工程中所有WEB Controller必须继承本类，以便于处理通用框架性业务或者功能方法。
 * Created by zhangdx on 15/6/25.
 */
@Controller
public class BaseWebController {
    private static final Logger logger = Logger.getLogger(BaseWebController.class);

    /**
     * web controller 全局异常处理接口
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @return
     */
    @ExceptionHandler
    public String resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception e) {
        logger.error("Web Exception", e);
        e.printStackTrace();

        //重定向到 500 页面
        return "redirect:/error/500.html";
    }

    public final static String SUCCESS = "success";

    public final static String MSG = "msg";


    public final static String DATA = "data";

    public final static String LOGOUT_FLAG = "logoutFlag";


    /**
     * 获取IP地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 所有ActionMap 统一从这里获取
     *
     * @return
     */
    public Map<String, Object> getRootMap(HttpServletRequest request) {
        Map<String, Object> rootMap = new HashMap<String, Object>();
        //添加url到 Map中
        rootMap.putAll(URLUtils.getUrlMap(request));
        return rootMap;
    }

    public ModelAndView forword(String viewName, Map context) {
        return new ModelAndView(viewName, context);
    }

    public ModelAndView error(String errMsg) {
        return new ModelAndView("error");
    }

    /**
     * 提示成功信息
     *
     * @param message
     */
    public void sendSuccessMessage(HttpServletResponse response, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(SUCCESS, true);
        result.put(MSG, message);
        HtmlUtils.writerJson(response, result);
    }

    /**
     * 提示失败信息
     *
     * @param message
     */
    public void sendFailureMessage(HttpServletResponse response, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(SUCCESS, false);
        result.put(MSG, message);
        HtmlUtils.writerJson(response, result);
    }
}
