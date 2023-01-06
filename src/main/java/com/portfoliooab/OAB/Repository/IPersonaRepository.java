package com.portfoliooab.OAB.Repository;

import com.portfoliooab.OAB.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer> {

    public Optional<Persona> findByNombre(String nombre);

    //public Optional<Persona> findByApellido(String apellido); //agregado - descomentar para que funcione ImpPersonaService
    public boolean existsByNombre(String nombre);
    //public boolean existsByApellido(String apellido); //agregado - descomentar para que funcione ImpPersonaService
}
