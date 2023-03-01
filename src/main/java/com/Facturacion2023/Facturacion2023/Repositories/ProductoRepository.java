package com.Facturacion2023.Facturacion2023.Repositories;
import com.Facturacion2023.Facturacion2023.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
