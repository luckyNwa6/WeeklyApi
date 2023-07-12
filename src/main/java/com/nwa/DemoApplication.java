package com.nwa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@MapperScan("com.nwa.mapper")
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext application = SpringApplication.run(DemoApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String property = env.getProperty("server.servlet.context-path");
        String path = property == null ? "" : property;
        System.out.println(
                "\n" +
                        "----------------------------------------------------------\n\t" +
                        "Application is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:" + port + path + "\n\t" +
                        "后台Api文档接口链接请点击: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
//                        "External: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n" +
                        "----------------------------------------------------------\n");
    }

    @org.apache.ibatis.annotations.Mapper
    public interface NoWarnMapper {
    }

}
