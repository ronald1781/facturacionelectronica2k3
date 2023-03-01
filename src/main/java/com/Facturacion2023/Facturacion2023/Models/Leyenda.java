package Models;

import javax.persistence.*;

@Entity
@Table(name = "leyenda")
public class Leyenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
   private Integer id_leyenda; // auto incremental
    private Integer docu_codigo;// codigo de la cabecera
    private String leyenda_codigo;// 1000 - monto en letras
    private String leyenda_texto;// dos cientos ochenta y 00/100 soles
    @ManyToOne(fetch = FetchType.EAGER)
    private Cabecera cabecera;
    public Integer getId_leyenda() {
        return id_leyenda;
    }

    public void setId_leyenda(Integer id_leyenda) {
        this.id_leyenda = id_leyenda;
    }

    public Integer getDocu_codigo() {
        return docu_codigo;
    }

    public void setDocu_codigo(Integer docu_codigo) {
        this.docu_codigo = docu_codigo;
    }

    public String getLeyenda_codigo() {
        return leyenda_codigo;
    }

    public void setLeyenda_codigo(String leyenda_codigo) {
        this.leyenda_codigo = leyenda_codigo;
    }

    public String getLeyenda_texto() {
        return leyenda_texto;
    }

    public void setLeyenda_texto(String leyenda_texto) {
        this.leyenda_texto = leyenda_texto;
    }

    public Cabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }
}
