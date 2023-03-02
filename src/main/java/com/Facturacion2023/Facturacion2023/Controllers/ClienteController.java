package com.Facturacion2023.Facturacion2023.Controllers;

import com.Facturacion2023.Facturacion2023.Exception.ResourceNotFoundException;
import com.Facturacion2023.Facturacion2023.Models.Cliente;
import com.Facturacion2023.Facturacion2023.Repositories.ClienteRepository;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){

        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Cliente> guardarCliente(@Valid @RequestBody Cliente clienteAguardar){
        Cliente clienteGuardado = clienteRepository.save(clienteAguardar);
        URI rutaEnvio= ServletUriComponentsBuilder.fromCurrentRequest().path("/{indice}").buildAndExpand(clienteGuardado.getIndice()).toUri();
        return ResponseEntity.created(rutaEnvio).body(clienteGuardado);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer indice, @Valid @RequestBody Cliente clienteAactualizar){
        Optional<Cliente> clienteOp = clienteRepository.findById(indice);
        if(!clienteOp.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        clienteAactualizar.setIndice(clienteOp.get().getIndice());
        clienteRepository.save(clienteAactualizar);
        return  ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{indice}")
    public ResponseEntity<Map<String,Boolean>> eliminarCliente(@PathVariable Integer indice){
        Cliente clienteAEliminar = clienteRepository.findById(indice)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con indice "+indice+ " no existe"));
        clienteRepository.delete(clienteAEliminar);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    @GetMapping("/{indice}")
    public ResponseEntity<Cliente> buscarClientexIndice(@PathVariable Integer indice){
        Cliente clienteAbuscar = clienteRepository.findById(indice)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró al cliente con indice: "+indice));
        return ResponseEntity.ok(clienteAbuscar);
    }

    @GetMapping("/dni/{dnioruc}")
    public ResponseEntity<Cliente> buscarClientexDnioRuc(@PathVariable String dnioruc){
       return ResponseEntity.ok(clienteRepository.findByDnioruc(dnioruc));

    }


}
