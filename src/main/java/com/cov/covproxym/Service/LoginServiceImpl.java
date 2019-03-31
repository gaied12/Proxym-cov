package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.Service.LoginService;
import com.cov.covproxym.exception.Error;
import com.cov.covproxym.exception.Inscription;
import com.cov.covproxym.model.User;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchResult;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.core.*;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
import org.springframework.security.ldap.search.LdapUserSearch;
import org.springframework.stereotype.Service;
import sun.net.www.protocol.http.AuthenticationHeader;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class LoginServiceImpl implements LoginService  {
    @Autowired
    UserRepository userRepository ;
    @Autowired
   private LdapTemplate ldapTemplate;




    //@Override
    //public boolean authenticated(String pass , String userame) throws Exception {
//        auth
//                .ldapAuthentication()
//                .userDnPatterns("uid={0},ou=people")
//                .groupSearchBase("ou=groups")
//                .contextSource()
//                .url("ldap://localhost:389/dc=covproxym,dc=org")
//                .and()
//                .passwordCompare()
//                .passwordAttribute("userPassword");
//        Optional<User> user=userRepository.findByUsername(userame);
//        userame= user.get().getUsername();
//        if (auth.isConfigured()==false)
//            throw new Error();
//        if(auth.isConfigured()==true&&userame==null)
//            throw new Inscription();
//
//
//        if (auth.isConfigured()==true&userame!=null);
      //  return true ;

  //  }
    public List<String> getAllPersonNames() {
        return ldapTemplate.search(
                query().where("objectclass").is("person"),
                new AttributesMapper<String>() {
                    public String mapFromAttributes(Attributes attrs)
                            throws NamingException {
                        return (String) attrs.get("uid").get();
                    }
                });
    }
    @Override
    public void authenticated(String username , String password) throws Exception {
        LdapTemplate ldapTemplate = getLdapTemplate();
        AuthenticatedLdapEntryContextMapper<DirContextOperations> mapper = new AuthenticatedLdapEntryContextMapper<DirContextOperations>() {
            @Override
            public DirContextOperations mapWithContext(DirContext ctx, LdapEntryIdentification ldapEntryIdentification) {
                {
                    try {
                        return (DirContextOperations) ctx.lookup(ldapEntryIdentification.getRelativeName());
                    } catch (NamingException e) {
                        throw new RuntimeException("Failed to lookup " + ldapEntryIdentification.getRelativeName(), e);
                    }
                }


            }
        };
        Optional<User> user=userRepository.findByUsername(username);
        username=user.get().getUsername();
        if (username!=null)
        ldapTemplate.authenticate(query().where("uid").is(username),password,mapper);



    }
    private LdapTemplate getLdapTemplate()
    {
        LdapContextSource ldapContextSource = new LdapContextSource();
        ldapContextSource.setUrl("ldap://localhost:10389");
        ldapContextSource.setBase("dc=abc,dc=com");
        ldapContextSource.setUserDn("uid=admin,ou=system");
        ldapContextSource.setPassword("oussama12");

        try {
            ldapContextSource.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LdapTemplate ldapTemplate = new LdapTemplate();
        ldapTemplate.setContextSource(ldapContextSource);
        return ldapTemplate;
    }

}









