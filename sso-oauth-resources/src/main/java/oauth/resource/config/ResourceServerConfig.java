package oauth.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("SystemContent")
                .antMatchers("/view/**").hasAnyAuthority("SystemContent")
                .antMatchers("insert/**").hasAnyAuthority("SystemContent");
        // 验证所有请求，必须带access_token
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
