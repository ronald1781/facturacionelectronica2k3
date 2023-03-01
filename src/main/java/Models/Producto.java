package Models;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer indice;
    @NotNull
    private String codigo;
    @NotNull
    private String undmed;
    @NotNull
    private Integer stock;
    @NotNull
    private String descripcion;
    @NotNull
    private Double preciovta;
    private Double costo;
    @NotNull
    private String igv;
    @NotNull
    private String icbper;
    private Integer idmarca;
}
