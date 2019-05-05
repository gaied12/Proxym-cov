package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.exception.*;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.*;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
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
    public Optional<User> authenticated(LoginDto loginDto) throws Exception {
      String uid=getAllPersonNames().toString();
      String username=loginDto.getUsername();
      String password=loginDto.getPassword();


        boolean UserLdap=uid.contains(username);

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()&&UserLdap==true) {

            ldapTemplate.authenticate(query().where("uid").is(username), password, mapper);
        }


    if  (UserLdap==false){
        throw new ApplicationException("You dont have  acces from Ldap ","102");

    }



       if(UserLdap==true&& user.isPresent()==false)  {

           throw new ApplicationException("You must have a Profil to authenticate ","102");
     }

      return userRepository.findByUsername(username);


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









