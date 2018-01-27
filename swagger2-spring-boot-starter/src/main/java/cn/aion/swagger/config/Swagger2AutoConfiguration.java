package cn.aion.swagger.config;

import cn.aion.swagger.priperties.Swagger2Properties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenhai
 * @detail Swagger2 配置类
 * @date 2017/10/12
 */

@EnableSwagger2
@Configuration
@EnableConfigurationProperties(value = Swagger2Properties.class)
@ConditionalOnClass({Docket.class,ApiInfoBuilder.class})
@ConditionalOnProperty(prefix = "swagger2",name ="enable",havingValue = "true")
@Setter
@Getter
public class Swagger2AutoConfiguration {
    @Autowired
    private Swagger2Properties swagger2Properties;
    //
    @Bean
    public Docket api() {
        return new Docket(new DocumentationType(swagger2Properties.getDocumentationTypeName(),
                swagger2Properties.getDocumentationTypeVersion(),
                MediaType.valueOf(swagger2Properties.getDocumentationTypeMediaType())))
                .apiInfo(new ApiInfoBuilder()
                        .title(swagger2Properties.getApiInfoTitle())
                        .termsOfServiceUrl(swagger2Properties.getApiInfoTermsOfServiceUrl())
                        .contact(new Contact(swagger2Properties.getApiInfoContactName(),
                                swagger2Properties.getApiInfoContactUrl(),
                                swagger2Properties.getApiInfoContactEmail()))
                        .version(swagger2Properties.getApiInfoVersion())
                        .build())
                .select()  // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage(swagger2Properties.getBasePackage()))  // 对该包下的api进行监控
                .paths(PathSelectors.any())   // 对该包下的所有路径进行监控
                .build();
    }

}
