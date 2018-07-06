package com.imooc.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Swagger2 配置
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 登录权限，扫描包，路径，安全方面的设置
     *
     * @return
     */
    @Bean
    public Docket apiDocket() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        // 请求参数集合
        List<Parameter> params = Lists.newArrayList();
        // 令牌
        tokenPar.name("Authorization")
                .description("令牌（登录后获取令牌）")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build();
        // 加入参数
        params.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("分组一")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .globalOperationParameters(params)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.imooc.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(initApiInfo());
    }

    private ApiInfo initApiInfo() {
        // 这里有两种方式初始化ApiInfo
        return new ApiInfoBuilder()
                .title("swagger2 study demo api document")
                .description("api document")
                // 服务条款网址
                .termsOfServiceUrl("www.baidu.com")
                .version("1.0")
                .build();
    }

}
