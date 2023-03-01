package com.Facturacion2023.Facturacion2023.Models;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer idpago; // autoincremental
    private String nrocuota;// nrocuota a factura al credito
    private Date fecha;// fecha de vencimiento de la cuota
    private String monto;// monto de pago del nro de cuota
    private Integer docu_codigo; // codigo de la cebecera
    @ManyToOne(fetch = FetchType.EAGER)
    private Cabecera cabecera;

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
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

    public Integer getDocu_codigo() {
        return docu_codigo;
    }

    public void setDocu_codigo(Integer docu_codigo) {
        this.docu_codigo = docu_codigo;
    }

    public Cabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }
}
