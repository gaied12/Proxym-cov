package com.cov.covproxym.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.core.env.Environment;


import java.util.Collections;

@Configuration
public class LdapConfiguration {
    @Autowired
    Environment env ;



    @Bean
    public LdapTemplate ldapTemplate(){
        LdapTemplate ldapTemplate = new LdapTemplate(getContextSource());
        ldapTemplate.setIgnorePartialResultException(true);
        ldapTemplate.setContextSource(getContextSource());
        return ldapTemplate;
    }
    @Bean
    public LdapContextSource getContextSource() {
        LdapContextSource ldapContextSource = new LdapContextSource();
        ldapContextSource.setUrl("ldap://localhost:10389");
        ldapContextSource.setBase("dc=abc,dc=com");
        ldapContextSource.setUserDn("uid=admin,ou=system");
        ldapContextSource.setPassword("oussama12");
        return ldapContextSource;
    }
}
