package com.cov.covproxym.Service;

import com.sun.jndi.ldap.LdapClient;
import com.sun.jndi.ldap.LdapResult;
import com.unboundid.ldap.sdk.LDAPException;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;

import java.util.List;

public interface LoginService {
public void authenticated (String pass,String username) throws Exception;
public List<String> getAllPersonNames() ;
public List<String>gellAllPassword();
}
