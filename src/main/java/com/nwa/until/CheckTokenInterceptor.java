package com.nwa.until;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nwa.bean.ResultVO;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Lucky友人a
 * @Date 2023/1/24 -17:36
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//        String token = request.getParameter("token");//这个是通过请求里面带token参数来传的，默认请求头传的
        String method = request.getMethod();//这里请求是options 这里有3次握手，预检机制
        if ("OPTIONS".equalsIgnoreCase(method)) {
            return true;//放行
        }
        String token = request.getHeader("token");
        System.out.println("进入拦截器");
        System.out.println("token的值是" + token);
        if (token == null) {
            ResultVO resultVO = new ResultVO(ResStatus.FAIL, "请先登录", null);
            doResponse(response, resultVO);

        } else {
            try {
                //验证token
                //如果token正确，有效期内则这正常执行，否则抛出异常
                boolean verify = JWTUtils.verify(token);
                return verify;
            } catch (ExpiredJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.FAIL, "登录过期", null);
                doResponse(response, resultVO);
            } catch (UnsupportedJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.FAIL, "token不合法", null);
                doResponse(response, resultVO);
            } catch (Exception e) {
                ResultVO resultVO = new ResultVO(ResStatus.FAIL, "请先登录", null);
                doResponse(response, resultVO);
            }
        }
        return false;
    }

    private void doResponse(HttpServletResponse response, ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        out.println(s);
        out.flush();
        out.close();
    }
}
