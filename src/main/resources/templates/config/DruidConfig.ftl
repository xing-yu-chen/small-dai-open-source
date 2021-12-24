package ${basePackage};

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
* @Author: xing-yu-chen
* @Project: open-source
* @Description: 线程池监控信息查看配置,后台访问地址:http://ip:port/{项目名}/druid/login.html
* @Data:Created in 2021/12/21 12:37 下午
*/

@Configuration
public class DruidConfig {
    @Bean
    public ServletRegistrationBean druidServlet() {
        // 主要实现WEB监控的配置处理
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 现在要进行druid监控的配置处理操作
        // 白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1,10.1.1.1");
        // servletRegistrationBean.addInitParameter("deny", "192.168.1.200"); // 黑名单
        // 用户名
        servletRegistrationBean.addInitParameter("loginUsername", "small-dai");
        // 密码
        servletRegistrationBean.addInitParameter("loginPassword", "small-dai-open-source");
        // 是否可以重置数据源
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean ;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean() ;
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*"); // 所有请求进行监控处理
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        return filterRegistrationBean ;
    }

    @Bean(destroyMethod = "close",initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}