package com.Facturacion2023.Facturacion2023.Controllers;

import com.Facturacion2023.Facturacion2023.Exception.ResourceNotFoundException;
import com.Facturacion2023.Facturacion2023.Models.Marca;
import com.Facturacion2023.Facturacion2023.Models.Producto;
import com.Facturacion2023.Facturacion2023.Repositories.MarcaRepository;
import com.Facturacion2023.Facturacion2023.Repositories.ProductoRepository;
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
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    MarcaRepository marcaRepository;
    @Autowired
    ProductoRepository productoRepository;

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){

       return ResponseEntity.ok(productoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@Valid @RequestBody Producto productoAguardar){
        Optional<Marca> marcaOp = marcaRepository.findById(productoAguardar.getMarca().getIdmarca());
        if(!marcaOp.isPresent()){

            return ResponseEntity.unprocessableEntity().build();
        }
        else {
            Producto productoGuardado = productoRepository.save(productoAguardar);
            URI rutaEnvio= ServletUriComponentsBuilder.fromCurrentRequest().path("/{indice}").buildAndExpand(productoGuardado.getIndice()).toUri();
            return ResponseEntity.created(rutaEnvio).body(productoGuardado);

        }

    }

    @PutMapping("/{indice}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer indice,@Valid @RequestBody Producto productoAactualizar){
        Optional<Producto> productoOp = productoRepository.findById(indice);
        if(!productoOp.isPresent()){

            return ResponseEntity.unprocessableEntity().build();
        }
        else{
            Optional<Marca> marcaOp = marcaRepository.findById(productoOp.get().getMarca().getIdmarca());
            if(!marcaOp.isPresent()){
                return ResponseEntity.unprocessableEntity().build();

            }
            else{
                productoAactualizar.setMarca(productoOp.get().getMarca());
                productoAactualizar.setIndice(productoOp.get().getIndice());
                productoRepository.save(productoAactualizar);
                return ResponseEntity.noContent().build();
            }
        }

    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Map<String,Boolean>> eliminarProducto(@PathVariable Integer indice){
        Producto productoAeliminar = productoRepository.findById(indice)
                .orElseThrow(() -> new ResourceNotFoundException("No se Encontró el producto con indice: "+indice));
        productoRepository.delete(productoAeliminar);
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/{indice}")
    public ResponseEntity<Producto> buscarProductoxIndice (@PathVariable Integer indice){
        Producto productoAbuscar = productoRepository.findById(indice)
                .orElseThrow(() -> new ResourceNotFoundException("No se Encontró el producto con indice: "+indice));

        return ResponseEntity.ok(productoAbuscar);

    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Producto> buscarProductoxCodigo(@PathVariable String codigo){

        return ResponseEntity.ok(productoRepository.findByCodigo(codigo));
    }




}
