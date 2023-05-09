package com.example.emailregistration.appuser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, UserDetailsPasswordService {
    private final static String USER_NOT_FOUND_MSG="user with email %s not found";
    private final UserRepository appUserRepository;

    public UserService(UserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override

    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(String.format((USER_NOT_FOUND_MSG))));
    }

    @Override
    public UserDetails updatePassword(UserDetails user,
                                      String newPassword) {
        return null;
    }
}
