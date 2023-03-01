package com.Facturacion2023.Facturacion2023.Controllers;

import com.Facturacion2023.Facturacion2023.Exception.ResourceNotFoundException;
import com.Facturacion2023.Facturacion2023.Models.Marca;
import com.Facturacion2023.Facturacion2023.Repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaRepository marcaRepository;

    @GetMapping
    public ResponseEntity<List<Marca>> listarMarcas(){

       return ResponseEntity.ok(marcaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Marca> guardarMarca(@Valid @RequestBody Marca marcaAregistrar){
    Marca marcaGuardada = marcaRepository.save(marcaAregistrar);
    URI rutaEnvio= ServletUriComponentsBuilder.fromCurrentRequest().path("/{idmarca}").buildAndExpand(marcaGuardada.getIdmarca()).toUri();
    return ResponseEntity.created(rutaEnvio).body(marcaGuardada);
    }

    @PutMapping("/{idmarca}")
    public ResponseEntity<Marca> actualizaMarca(@PathVariable Integer idmarca, @Valid @RequestBody Marca marcaAactualizar){
        Optional<Marca> marcaVerificar =marcaRepository.findById(idmarca);

        if(!marcaVerificar.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        marcaAactualizar.setIdmarca(marcaVerificar.get().getIdmarca());
        marcaRepository.save(marcaAactualizar);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idmarca}")
    public ResponseEntity<Map<String,Boolean>> eliminarMarca(@PathVariable Integer idmarca){
        Marca marcaEliminar = marcaRepository.findById(idmarca).
                orElseThrow(() -> new ResourceNotFoundException("No Existe la marca con el id "+ idmarca));
        marcaRepository.delete(marcaEliminar);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
    return ResponseEntity.ok(respuesta);
    }

}
