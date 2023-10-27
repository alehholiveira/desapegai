package br.com.api.desapegai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.desapegai.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
