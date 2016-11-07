package com.kennywoo.manforw.web.conf;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by wuxj on 2016/11/8.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket testApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(Predicates.or(PathSelectors.regex("/api/.*")))
                .build()
                .apiInfo(testApiInfo());

        return docket;
    }

    private ApiInfo testApiInfo() {
        ApiInfo apiInfo = new ApiInfo("Test相关接口",
                "Test相关接口, 用于测试.",
                "1.0",
                "http://www.kennywoo.com",
                "Kenny Woo",
                "kw rom co.",
                "http://www.kennywoo.com");

        return apiInfo;
    }

}
