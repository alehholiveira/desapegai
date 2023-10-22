package br.com.api.desapegai.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        Iterable<UserModel> usersIterable = userRepository.findAll();
        List<UserModel> usersList = new ArrayList<>();
        usersIterable.forEach(usersList::add);
        return usersList;
    }

    // Implemente outros métodos de serviço, se necessário
}
