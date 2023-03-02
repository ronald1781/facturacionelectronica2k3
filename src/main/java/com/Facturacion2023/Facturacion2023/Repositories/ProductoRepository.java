package com.Facturacion2023.Facturacion2023.Repositories;

import com.Facturacion2023.Facturacion2023.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    @Query("Select p from Producto p where codigo = :codigo")
    Producto findByCodigo(String codigo);
}
