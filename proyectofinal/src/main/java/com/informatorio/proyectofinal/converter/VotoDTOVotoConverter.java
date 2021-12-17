package com.informatorio.proyectofinal.converter;

import com.informatorio.proyectofinal.dto.VotoDTO;
import com.informatorio.proyectofinal.entity.Voto;
import com.informatorio.proyectofinal.repository.EmprendimientoRepository;
import com.informatorio.proyectofinal.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VotoDTOVotoConverter implements Converter<VotoDTO, Voto> {

    public VotoDTOVotoConverter(EmprendimientoRepository emprendimientoRepository,
                                UsuarioRepository usuarioRepository) {
    }
    @Override
    public Voto convert(VotoDTO votoDto) {
        Voto voto = new Voto();
        voto.setGenerado(votoDto.getGenerado());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmprendimientoId());
        voto.setFechaDeCreacion(LocalDateTime.now());
        return voto;
    }
}
