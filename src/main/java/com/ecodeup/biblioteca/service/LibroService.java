package com.ecodeup.biblioteca.service;

import com.ecodeup.biblioteca.dto.LibroDTO;
import com.ecodeup.biblioteca.model.Autor;
import com.ecodeup.biblioteca.repository.AutorRepository;
import com.ecodeup.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private FabricaLibroService fabricaLibroService;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private FabricaAutorService fabricaAutorService;

    public LibroDTO save(LibroDTO libroDTO){
        //buscar autor
        Autor autor = autorRepository.findById(libroDTO.getIdAutor()).get();
        libroDTO.setAutorDto( fabricaAutorService.crearAutorDTO(autor));

        return fabricaLibroService.crearLibroDTO( libroRepository.save(fabricaLibroService.crearLibro(libroDTO) ) );
    }
    public List<LibroDTO> findAll(){
        return fabricaLibroService.crearLibrosDTO(libroRepository.findAll());
    }

    public LibroDTO findById(Integer id){
        return  fabricaLibroService.crearLibroDTO( libroRepository.findById(id).get());
    }

    public void deleteById(Integer id){
        libroRepository.deleteById(id);
    }
}
