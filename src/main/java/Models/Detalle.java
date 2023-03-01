package Models;

import javax.persistence.*;

@Entity
@Table(name = "detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer iddetalle; // auto incremental
    private Integer docu_codigo;// codigo de cabecera
    private String item_orden; // 1- mas
    private String item_unidad;//  NIU UNIDAD PARA BIEN   Y ZZ UNIDAD PARA SERVICIO
    private String item_cantidad;//
    private String item_codproducto;// CODIG SUNAT CODIGOBARRA QR O COD ASIGNADO POR EL SOFTWARE
    private String item_descripcion;// DESCRIPCION DEL BIEN O SERVICIO
    private String item_afectacion;// 1 - AFECTO AL IGV Y 2 SI ES EXONERADO
    private String item_tipo_precio_venta; // 10 SI CONTIENE EL IGV
    private String item_pventa;// MAX 2 DECIMALES
    private String item_pventa_nohonerosa;// MAX 2 DECIMALES
    private String item_to_subtotal;// MAX 2 DECIMALES
    private String item_to_igv;// MAX 2 DECIMALES
    private String item_pvtaigv; // MAX 2 DECIMALES
    @ManyToOne(fetch = FetchType.EAGER)
    private Cabecera cabecera;

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Integer getDocu_codigo() {
        return docu_codigo;
    }

    public void setDocu_codigo(Integer docu_codigo) {
        this.docu_codigo = docu_codigo;
    }

    public String getItem_orden() {
        return item_orden;
    }

    public void setItem_orden(String item_orden) {
        this.item_orden = item_orden;
    }

    public String getItem_unidad() {
        return item_unidad;
    }

    public void setItem_unidad(String item_unidad) {
        this.item_unidad = item_unidad;
    }

    public String getItem_cantidad() {
        return item_cantidad;
    }

    public void setItem_cantidad(String item_cantidad) {
        this.item_cantidad = item_cantidad;
    }

    public String getItem_codproducto() {
        return item_codproducto;
    }

    public void setItem_codproducto(String item_codproducto) {
        this.item_codproducto = item_codproducto;
    }

    public String getItem_descripcion() {
        return item_descripcion;
    }

    public void setItem_descripcion(String item_descripcion) {
        this.item_descripcion = item_descripcion;
    }

    public String getItem_afectacion() {
        return item_afectacion;
    }

    public void setItem_afectacion(String item_afectacion) {
        this.item_afectacion = item_afectacion;
    }

    public String getItem_tipo_precio_venta() {
        return item_tipo_precio_venta;
    }

    public void setItem_tipo_precio_venta(String item_tipo_precio_venta) {
        this.item_tipo_precio_venta = item_tipo_precio_venta;
    }

    public String getItem_pventa() {
        return item_pventa;
    }

    public void setItem_pventa(String item_pventa) {
        this.item_pventa = item_pventa;
    }

    public String getItem_pventa_nohonerosa() {
        return item_pventa_nohonerosa;
    }

    public void setItem_pventa_nohonerosa(String item_pventa_nohonerosa) {
        this.item_pventa_nohonerosa = item_pventa_nohonerosa;
    }

    public String getItem_to_subtotal() {
        return item_to_subtotal;
    }

    public void setItem_to_subtotal(String item_to_subtotal) {
        this.item_to_subtotal = item_to_subtotal;
    }

    public String getItem_to_igv() {
        return item_to_igv;
    }

    public void setItem_to_igv(String item_to_igv) {
        this.item_to_igv = item_to_igv;
    }

    public String getItem_pvtaigv() {
        return item_pvtaigv;
    }

    public void setItem_pvtaigv(String item_pvtaigv) {
        this.item_pvtaigv = item_pvtaigv;
    }

    public Cabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }
}
