package com.nwa.aop;


import com.nwa.bean.Client;
import com.nwa.service.impl.SysLogService;
import com.nwa.until.ClientInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


@Slf4j
@Aspect //切面
@Component
public class SysLogA {             //切面类
    @Resource
    private SysLogService sysLogService;

    @Pointcut("execution(* com.nwa.controller.IndexController.*(..))")    //切点
    public void logPointCut() {
    }

    @After("logPointCut()")    //后置加强
    public void logTest(JoinPoint joinPoint) throws Exception {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();


        String browser = ClientInfoUtil.getBrowserInfo(request); //获取浏览器名称
        String os = ClientInfoUtil.getOperatingSystem(request);  //获取操作系统
//
//        String userName = (String) session.getAttribute("userName");
//       if(userName==null){
//           userName="lucky";
//       }
//
//        String userId = (String) session.getAttribute("userId");
//        if(userId==null){
//            userId="2727";
//        }

        String ip = ClientInfoUtil.getIP(request); //获取ip

        try {
//            String targetName = joinPoint.getTarget().getClass().getName();
//            String methodName = joinPoint.getSignature().getName();
//            Object[] arguments = joinPoint.getArgs();

//获取自定义注解里面的值
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            SysLog sysLog = method.getAnnotation(SysLog.class);
            String operationType = sysLog.operationType();
            String operationName = sysLog.operationName();

            //*========存进数据库=========*//
            Client client1 = new Client();
            client1.setCreateBy(operationType);
//            client1.setLogMethod((targetName + "." + methodName + "()") + "." + operationType);
            client1.setRequestIp(ip);
//            client1.setLogCreateBy(userName);
            client1.setLogTip(operationName);
            client1.setLogSys(os);
            client1.setLogBrowser(browser);
            client1.setCreateDate(new Date());
            //保存数据库
            sysLogService.save(client1);

        } catch (Exception e) {
            //记录本地异常日志
            log.error("==后置通知异常==");
            log.error("异常信息:{}------" + e.getMessage());
            throw e;
        }

    }


}
