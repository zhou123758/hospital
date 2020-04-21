package com.wotrd.swagger;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    private String swagger2Title = "就诊模块";

    private boolean swagger2Enable = true;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //有@Api注解的类才生成文档
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.wotrd"))
                .paths(PathSelectors.any())
                .build()
                //生产环境可以配置成false禁用
                .enable(swagger2Enable)
                .apiInfo(new ApiInfoBuilder()
                        .description("医疗项目接口测试文档")
                        .version("1.0")
                        .title(swagger2Title)
                        .contact(new Contact("RenQAQ","https://github.com/RenQAQ/clinic","596938857@qq.com"))
                        .build());
    }
}
