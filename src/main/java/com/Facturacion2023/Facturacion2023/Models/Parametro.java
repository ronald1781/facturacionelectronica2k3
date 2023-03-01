package Models;

import javax.persistence.*;

@Entity
@Table(name = "parametro")
public class Parametro {
    @Id
    @Column(unique = true,nullable = false)
    private  String nombre;
    private Integer valorentero;
    private Double valordecimal;
    private String valorString;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValorentero() {
        return valorentero;
    }

    public void setValorentero(Integer valorentero) {
        this.valorentero = valorentero;
    }

    public Double getValordecimal() {
        return valordecimal;
    }

    public void setValordecimal(Double valordecimal) {
        this.valordecimal = valordecimal;
    }

    public String getValorString() {
        return valorString;
    }

    public void setValorString(String valorString) {
        this.valorString = valorString;
    }
}
