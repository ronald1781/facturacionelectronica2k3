package com.Facturacion2023.Facturacion2023.Controllers;

import com.Facturacion2023.Facturacion2023.Exception.ResourceNotFoundException;
import com.Facturacion2023.Facturacion2023.Models.Comprobante;
import com.Facturacion2023.Facturacion2023.Repositories.ComprobanteRepository;
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
@RequestMapping("/comprobante")
public class ComprobanteController {
    @Autowired
    ComprobanteRepository comprobanteRepository;

    @GetMapping
    public ResponseEntity<List<Comprobante>> listarComprobantes(){
        return ResponseEntity.ok(comprobanteRepository.findAll());
    }

    @PostMapping
    public  ResponseEntity<Comprobante> guardarComprobante(@Valid @RequestBody Comprobante comprobanteAregistrar){
        Comprobante comprobanteGuardado = comprobanteRepository.save(comprobanteAregistrar);
        URI rutaEnvio= ServletUriComponentsBuilder.fromCurrentRequest().path("/{indice}").buildAndExpand(comprobanteGuardado.getIndice()).toUri();
        return ResponseEntity.created(rutaEnvio).body(comprobanteGuardado);
    }
    @PutMapping("/{indice}")
    public ResponseEntity<Comprobante> actualizaComprobante( @PathVariable Integer indice,@Valid @RequestBody Comprobante comprobanteAactualizar){
        Optional<Comprobante> comprobanteOp = comprobanteRepository.findById(indice);

        if(!comprobanteOp.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        comprobanteAactualizar.setIndice(comprobanteOp.get().getIndice());
        comprobanteRepository.save(comprobanteAactualizar);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{indice}")
    public ResponseEntity<Map<String,Boolean>> eliminarMarca(@PathVariable Integer indice){
        Comprobante comprobanteAeliminar=comprobanteRepository.findById(indice).
                orElseThrow(() -> new ResourceNotFoundException("No existe el Comprobante con el indice: "+indice));
        comprobanteRepository.delete(comprobanteAeliminar);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}
