package ru.d3m4k.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.d3m4k.auth_service.entity.RegistryRequest;
import ru.d3m4k.auth_service.entity.UserInfo;
import ru.d3m4k.auth_service.repository.UserInfoRepository;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail = userInfoRepository.findByLogin(login);

        if (!userDetail.isPresent()) {
            System.out.println("bob");
            throw new UsernameNotFoundException("User not found " + login);
        }
        return new UserInfoDetails(userDetail.get());
    }

    public UserInfo addUser(RegistryRequest registryRequest) {

        UserInfo userInfo = new UserInfo();
        userInfo.setLogin(registryRequest.getLogin());
        userInfo.setPassword(passwordEncoder.encode(registryRequest.getPassword()));
        userInfo.setName(registryRequest.getName());
        userInfo.setEmail(registryRequest.getEmail());
        userInfo.setSurname(registryRequest.getSurname());
        userInfo.setRoles("ROLE_USER");

        userInfoRepository.save(userInfo);
        return userInfo;
    }
}
