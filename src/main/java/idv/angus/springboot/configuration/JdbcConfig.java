package idv.angus.springboot.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean("configRead")
    @ConfigurationProperties("app.datasource.config-read")
    public DataSource configRead() {
        return DataSourceBuilder.create().build();
    }

    @Bean("configReadNamedTemplate")
    public NamedParameterJdbcTemplate configReadNamedTemplate(@Qualifier("configRead") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
