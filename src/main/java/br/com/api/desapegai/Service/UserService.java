package br.com.api.desapegai.Service;



import java.util.List;

import br.com.api.desapegai.Model.User;
import br.com.api.desapegai.dto.UserDto;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
