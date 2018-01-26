package cn.aion.swagger.priperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;

/**
 * Created with IntelliJ IDEA.
 *
 * @author shenmiren
 * @name Swagger2Properties
 * @detail Swagger2 配置参数类
 * @date 2018/01/26
 */
@ConfigurationProperties(prefix = "swagger")
@Setter
@Getter
@ToString
public class Swagger2Properties {
    private Boolean enable =false;
    private String basePackage="";
    private String documentationTypeName = "swagger";
    private String documentationTypeVersion = "2.0";
    private String documentationTypeMediaType = MediaType.APPLICATION_JSON_VALUE;

    private String apiInfoTitle;
    private String apiInfoTermsOfServiceUrl;
    private String apiInfoContactName;
    private String apiInfoContactUrl;
    private String apiInfoContactEmail;
    private String apiInfoVersion;
}

    
    