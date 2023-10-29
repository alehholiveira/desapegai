package br.com.api.desapegai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.desapegai.Model.User;



public interface UserRepository extends JpaRepository<User, Long>{
    
   User findByEmail(String email);
}
