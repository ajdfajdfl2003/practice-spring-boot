package idv.angus.springboot.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    public String name = "jar";

    public String getName() {
        return name;
    }
}
