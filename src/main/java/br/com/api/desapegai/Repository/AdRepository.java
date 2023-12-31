package br.com.api.desapegai.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.desapegai.Model.Ad;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long>{
    List<Ad> findAll();
}
