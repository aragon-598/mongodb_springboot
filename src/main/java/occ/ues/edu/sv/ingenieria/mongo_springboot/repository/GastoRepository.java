package occ.ues.edu.sv.ingenieria.mongo_springboot.repository;

import occ.ues.edu.sv.ingenieria.mongo_springboot.models.Gasto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface GastoRepository extends MongoRepository<Gasto, String> {

    @Query("{'name':?0}")
    public Optional<Gasto> findByNombre(String nombre);
}
