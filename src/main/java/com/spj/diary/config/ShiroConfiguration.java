package com.spj.diary.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.spj.diary.config.shiro.AuthCredential;
import com.spj.diary.config.shiro.AuthRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置
 */
@Configuration
public class ShiroConfiguration {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/diary");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/res/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/error", "anon");
        filterChainDefinitionMap.put("/code/captchaImage", "anon");
        filterChainDefinitionMap.put("/code/check", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/user/doLogin", "anon");
        filterChainDefinitionMap.put("/register", "anon");
        filterChainDefinitionMap.put("/user/doRegister", "anon");


        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        // System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(authRealm());
        return securityManager;
    }

    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     *
     * @return
     */
    @Bean
    public AuthRealm authRealm() {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(new AuthCredential());
        return authRealm;
    }

    /**
     * 开启 shiro aop 注解支持.
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * Thymeleaf 使用 Shiro 标签配置
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
