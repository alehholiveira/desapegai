package br.com.api.desapegai.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.desapegai.Model.Role;
import br.com.api.desapegai.Model.User;
import br.com.api.desapegai.Repository.RoleRepository;
import br.com.api.desapegai.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        // Verifica se o usuário já existe com base no email
        User existingUser = userRepository.findByEmail(user.getEmail());
        
        if (existingUser != null) {
            // O usuário já existe, você pode escolher como lidar com isso, por exemplo, lançar uma exceção ou retornar um erro
            throw new RuntimeException("Um usuário com este email já existe.");
        } else {
            // O usuário não existe, você pode continuar com o processo de criação
            // Encrypt the password using Spring Security
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            
            Role role = roleRepository.findByName("ROLE_ADMIN");
            if (role == null) {
                role = checkRoleExist();
            }
            user.setRoles(Arrays.asList(role));
            userRepository.save(user);
        }
    }
    

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
