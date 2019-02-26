package com.na.springboot.configurations;

import com.na.springboot.services.models.Child;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 测试从配置文件获取值
 *
 * @author fengna
 * @date 2019/2/26
 */
@Data
@Component
@ConfigurationProperties(prefix = "user")
public class UserConfigTest {

    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private List<String> tastes;
    private Map<String, String> cities;
    private Child child;

}
