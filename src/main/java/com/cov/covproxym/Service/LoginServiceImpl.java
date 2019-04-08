package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.Service.LoginService;
import com.cov.covproxym.exception.Error;
import com.cov.covproxym.exception.Inscription;
import com.cov.covproxym.exception.Interdit;
import com.cov.covproxym.exception.NoUser;
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
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private LdapTemplate ldapTemplate;



    public List<String> getAllPersonNames() {
        return ldapTemplate.search(query().where("objectclass").is("person"), new AttributesMapper<String>() {
            public String mapFromAttributes(Attributes attrs) throws NamingException {
                return (String) attrs.get("uid").get();
            }
        });
    }

    @Override
    public List<String> gellAllPassword() {
        return ldapTemplate.search(query().where("objectclass").is("person"), new AttributesMapper<java.lang.String>() {
            public java.lang.String mapFromAttributes(Attributes attrs) throws NamingException {
                return (java.lang.String) attrs.get("userpassword").get();
            }
        });
    }


    @Override
    public void authenticated(String username, String password) throws Exception {
      String uid=getAllPersonNames().toString();
        boolean isStringExists=uid.contains(username);

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()&&isStringExists==true) {

            ldapTemplate.authenticate(query().where("uid").is(username), password, mapper);
        }


       if  (isStringExists==false){
            throw  new Interdit () ;

       }



        if(isStringExists==true&& user.isPresent()==false)  {

          throw new Inscription();
      }

    }

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

    }









