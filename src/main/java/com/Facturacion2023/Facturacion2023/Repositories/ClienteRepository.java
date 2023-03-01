package com.Facturacion2023.Facturacion2023.Repositories;

import com.Facturacion2023.Facturacion2023.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
