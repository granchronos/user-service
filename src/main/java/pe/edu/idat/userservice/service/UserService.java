package pe.edu.idat.userservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pe.edu.idat.userservice.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User addOrUpdateUser(User user);

    User getUser(Long id);

    List<User> getUsers();

}
