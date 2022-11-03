package com.ecodeup.biblioteca.dto;

import com.ecodeup.biblioteca.model.Autor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AutorDTO {
    private Integer id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private List<LibroDTO> libroDTO;

    public AutorDTO(Autor autor) {
        this.id =autor.getId();
        this.nombres = autor.getNombres();
        this.apellidos = autor.getApellidos();
        this.telefono = autor.getTelefono();

        this.libroDTO = new ArrayList<>();
        autor.getLibros().forEach(
                libro -> libroDTO.add(new LibroDTO(libro))
        );
    }
}
