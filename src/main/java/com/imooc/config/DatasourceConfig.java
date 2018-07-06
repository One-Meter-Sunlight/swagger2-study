package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author ck
 * @version 1.0
 * @since 2018-07-06
 */
@Configuration
public class DatasourceConfig {

    @Resource
    private DataSource dataSource;
}
