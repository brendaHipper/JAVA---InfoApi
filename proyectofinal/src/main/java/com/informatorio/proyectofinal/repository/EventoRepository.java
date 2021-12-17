package com.informatorio.proyectofinal.repository;

import com.informatorio.proyectofinal.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// EST ESTA OK

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
