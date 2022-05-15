package idv.angus.springboot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProxyManager {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProxyManager(@Qualifier("configReadNamedTemplate") NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Cacheable(value = "proxy", key = "#name")
//    @Cacheable(value = "proxy")
    public String get(String name) {
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("proxyName", name);

        return jdbcTemplate.queryForObject("SELECT CONF_VALUE FROM PROXY_CONFIG WHERE CONF_NAME = :proxyName", paramMap, String.class);
    }
}
