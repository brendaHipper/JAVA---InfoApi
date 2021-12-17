package com.informatorio.proyectofinal.repository;

import com.informatorio.proyectofinal.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // cuando la query es precisa va aca
    //@Query(SELECT....por ejemplo para crear la query a mano)
    // List<Usuario> findByFechaDeCreacionAfter(LocalDateTime fechaDesde);
    //List<Usuario> creacionDespuesDeFecha(LocalDate fechaDesde);

    List<Usuario> findByCiudad(String ciudad);
    @Query("from Usuario where fechaDeCreacion >= ?1")
    List<Usuario> findByFechaDeCreacion(LocalDateTime fechaDeCreacion);
}
