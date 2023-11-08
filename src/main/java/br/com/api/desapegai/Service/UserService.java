package br.com.api.desapegai.Service;



import java.util.List;

import br.com.api.desapegai.Model.User;


public interface UserService {
    void saveUser(User user);

    User findUserByEmail(String email);

    List<User> findAllUsers();

}
