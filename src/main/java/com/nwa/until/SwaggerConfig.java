package com.nwa.until;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lucky友人a
 * @Date 2023/1/15 -20:06
 */
@Configuration
@EnableSwagger2 //添加依赖这个才有
//访问的地址 http://192.168.1.3:9999/swagger-ui.html
//如果添加ui插件。 http://192.168.1.3:9999/doc.html
public class SwaggerConfig {
    @Bean
    public Docket docket() {
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//        apiInfoBuilder.title("小维的后端接口说明")
//        .description("此文档详细说明了小维前后端项目端口规范...").version("v1.0")
//                .contact(new Contact("luckyNWA","www.nwa.com","1656213092@qq.com"));
//
//        ApiInfo apiInfo = apiInfoBuilder.build();
//        //指定文档中的封面信息；版本作者等
//        Docket docket = new Docket(DocumentationType.SWAGGER_2) //指定文档风格
//                .apiInfo(apiInfo).select()
//                .apis(RequestHandlerSelectors.basePackage("com.nwa.controller"))//扫描这个包下所有接口
//                .paths(PathSelectors.any())//PathSelectors.regx("/user/")//正则只要user下的接口
//                .build();
//
//        return docket;
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nwa.controller"))//扫描这个包下所有接口
                //加了ApiOperation注解的类，才生成接口文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //包下的类，才生成接口文档
                //.apis(RequestHandlerSelectors.basePackage("io.sysssc.controller"))
//                .paths(PathSelectors.any())
                .build()
                .securitySchemes(security());  //主要关注点--统一填写一次token

    }


    private ApiInfo apiInfo() {
        Contact luckyNWA = new Contact("luckyNWA", "www.nwa.com", "1656213092@qq.com");
        return new ApiInfo(
                "小维的API接口说明",
                "此文档详细说明了小维前后端项目端口规范",
                "v1.0",
                "www.nwa.com",
                luckyNWA,
                "apache 2.0",
                "www.nwa.com",
                new ArrayList()
        );
    }

    private List<ApiKey> security() {
        ArrayList<ApiKey> list = new ArrayList<>();
        list.add(new ApiKey("token", "token", "header"));
        return list;


    }

}

