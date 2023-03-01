package Models;

import javax.persistence.*;

@Entity
@Table(name = "unidadmedida")
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private  Integer indice;
    private String nombre;
    private String simbologia;


    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbologia() {
        return simbologia;
    }

    public void setSimbologia(String simbologia) {
        this.simbologia = simbologia;
    }
}
