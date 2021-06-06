package idv.angus.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

// 若是 application.properties or application.yml 沒有設定 web.a
// 會拿這邊來當預設值
@ConfigurationProperties(prefix = "web")
public class WebProperties {
    private String a = "fxk";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
