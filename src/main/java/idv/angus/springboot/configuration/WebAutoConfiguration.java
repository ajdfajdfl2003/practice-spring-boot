package idv.angus.springboot.configuration;

import idv.angus.springboot.WebInfo;
import idv.angus.springboot.WebProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebConfiguration.class)
@EnableConfigurationProperties(WebProperties.class)
public class WebAutoConfiguration {
    @Autowired
    WebProperties properties;

    @Autowired
    WebConfiguration configuration;

    @Bean
    public WebInfo createInfo() {
        return new WebInfo(configuration.getName() + "_" + properties.getA());
    }
}
