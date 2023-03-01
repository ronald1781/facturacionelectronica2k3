package Models;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer docu_codigo; // autoincremental
    private String nrocuota;// nrocuota a factura al credito
    private Date fecha;// fecha de vencimiento de la cuota
    private String monto;// monto de pago del nro de cuota
    private Integer cabecera_docu_codigo; // codigo de la cebecera
    @ManyToOne(fetch = FetchType.EAGER)
    private Cabecera cabecera;

    public Integer getDocu_codigo() {
        return docu_codigo;
    }

    public void setDocu_codigo(Integer docu_codigo) {
        this.docu_codigo = docu_codigo;
    }

    public String getNrocuota() {
        return nrocuota;
    }

    public void setNrocuota(String nrocuota) {
        this.nrocuota = nrocuota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public Integer getCabecera_docu_codigo() {
        return cabecera_docu_codigo;
    }

    public void setCabecera_docu_codigo(Integer cabecera_docu_codigo) {
        this.cabecera_docu_codigo = cabecera_docu_codigo;
    }

    public Cabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }
}
