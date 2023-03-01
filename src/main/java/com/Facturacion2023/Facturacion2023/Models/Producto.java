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
    @ManyToOne(fetch = FetchType.EAGER)
    private Marca marca;

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUndmed() {
        return undmed;
    }

    public void setUndmed(String undmed) {
        this.undmed = undmed;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPreciovta() {
        return preciovta;
    }

    public void setPreciovta(Double preciovta) {
        this.preciovta = preciovta;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIgv() {
        return igv;
    }

    public void setIgv(String igv) {
        this.igv = igv;
    }

    public String getIcbper() {
        return icbper;
    }

    public void setIcbper(String icbper) {
        this.icbper = icbper;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
