package Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cabecera")
public class Cabecera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer docu_codigo; // auto incrementable
    private String idExterno; // RUC_EMPRESA + SERIE_COMPROBANTE + CORRELATIVO : 20531014708FF01-123
    private String empr_razonsocial; // NOMBRE DE LA EMPRESA QUE EMITE LA FAC / BOL
    private String empr_ubigeo; // CODIGO DE UBIGEO SEGUN INEI
    private String empr_nombrecomercial; // MARCA DE TU EMPRESA
    private String  empr_direccion; // AV CONSTRUCTORES 665 LA MOLINA - LIMA
    private String empr_provincia; // LIMA
    private String empr_departamento; // LIMA
    private String empr_distrito;// MOLINA
    private String empr_pais;//  PE
    private String empr_nroruc; // 11 DIGITOS
    private String empr_tipodoc; // 06 : RUC - 01: DNI - 04: PASAPORTE
    private String clie_numero; // 8 DIGITOS
    private String clie_tipodoc;// 6 : RUC - 1: DNI - 4: PASAPORTE
    private String clie_nombre; // NOMBRE O RAZON SOCIAL DEL CLIENTE
    private Date docu_fecha; // YYYY-MM-DD
    private String docu_hora;// HH:MM:SS
    private String docu_tipodocumento; // 03 : BOLETA  - 01: FACTURA - 07: NOTA DE CRED - 08 : NOTA DE DEB - 09 : GUIA DE REMISION - 31: GUIA DE TRANSPORTISTA
    private String docu_numero;//  SERIE + CORRELATIVO   FF01-00000007 - BB01-0000007
    private String docu_moneda;// CODIGO DE MONEDA PERU : PE
    private String docu_gravada;// MONTO AFECTADO POR IGV / IVA
    private String docu_inafecta;// MONTO INAFECTO SOLO A LA AMAZONIA PERUANA
    private String docu_exonerada;// MONTO EXONERADO DE ALGUNOS PROD - REGULADOS POR  SUNAT
    private String docu_gratuita;// OFERTAS Y BONIFICACIONES
    private String docu_descuento;// DESCUENTO GLOBAL
    private String docu_subtotal;// SUMATORIA DE LAS OPERACION SIN IMPUESTOS
    private String docu_total;// SUMATORIA DE OPERACION - DESCUENTO + IMPUESTOS
    private String docu_igv;// MONTO DE IMPUESTOS DE 18%
    private String tasa_igv;// 18%
    private String docu_isc;// MONTO DE IMPUESTOS 10%
    private String tasa_isc;//10%
    private String docu_otrostributos;// IMPUESTO A BOLSA PLASTICA : 0.40
    private String tasa_otrostributos;
    private String docu_otroscargos;
    private String docu_percepcion;
    private String hashcode;
    private String cdr;
    private String cdr_nota;
    private String cdr_observacion;
    private String docu_enviaws; // S - SI SE ENVIA A SUNAT  // N - NO SE ENVÍA A SUNAT
    private String docu_proce_status;// N - Nuevo // B - Bloqueo // P - Proceso //  E - Enviado //   X - Error de Envio
    private String docu_proce_fecha; //YYYY-MM-DD
    private String docu_link_pdf;
    private String docu_link_cdr;
    private String docu_link_xml;
    private String clie_correo_cpe1;
    private String  clie_correo_cpe2;
    private String docu_tipodocumento_anular; //01 - FACTURA  // 03 - BOLETA
    private String docu_tipodocumento_numero; //FF01-123  // BB02-123
    private String docu_motivoanular;// EL PORQUE SE GENERA LA NOTA DE CREDITO
    @OneToMany(mappedBy = "cabecera",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Detalle> detalles = new LinkedHashSet<>();
    @OneToMany(mappedBy = "cabecera",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Pago> pagos = new LinkedHashSet<>();
    @OneToMany(mappedBy = "cabecera",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Leyenda> leyendas = new LinkedHashSet<>();

    public Integer getDocu_codigo() {
        return docu_codigo;
    }

    public void setDocu_codigo(Integer docu_codigo) {
        this.docu_codigo = docu_codigo;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public String getEmpr_razonsocial() {
        return empr_razonsocial;
    }

    public void setEmpr_razonsocial(String empr_razonsocial) {
        this.empr_razonsocial = empr_razonsocial;
    }

    public String getEmpr_ubigeo() {
        return empr_ubigeo;
    }

    public void setEmpr_ubigeo(String empr_ubigeo) {
        this.empr_ubigeo = empr_ubigeo;
    }

    public String getEmpr_nombrecomercial() {
        return empr_nombrecomercial;
    }

    public void setEmpr_nombrecomercial(String empr_nombrecomercial) {
        this.empr_nombrecomercial = empr_nombrecomercial;
    }

    public String getEmpr_direccion() {
        return empr_direccion;
    }

    public void setEmpr_direccion(String empr_direccion) {
        this.empr_direccion = empr_direccion;
    }

    public String getEmpr_provincia() {
        return empr_provincia;
    }

    public void setEmpr_provincia(String empr_provincia) {
        this.empr_provincia = empr_provincia;
    }

    public String getEmpr_departamento() {
        return empr_departamento;
    }

    public void setEmpr_departamento(String empr_departamento) {
        this.empr_departamento = empr_departamento;
    }

    public String getEmpr_distrito() {
        return empr_distrito;
    }

    public void setEmpr_distrito(String empr_distrito) {
        this.empr_distrito = empr_distrito;
    }

    public String getEmpr_pais() {
        return empr_pais;
    }

    public void setEmpr_pais(String empr_pais) {
        this.empr_pais = empr_pais;
    }

    public String getEmpr_nroruc() {
        return empr_nroruc;
    }

    public void setEmpr_nroruc(String empr_nroruc) {
        this.empr_nroruc = empr_nroruc;
    }

    public String getEmpr_tipodoc() {
        return empr_tipodoc;
    }

    public void setEmpr_tipodoc(String empr_tipodoc) {
        this.empr_tipodoc = empr_tipodoc;
    }

    public String getClie_numero() {
        return clie_numero;
    }

    public void setClie_numero(String clie_numero) {
        this.clie_numero = clie_numero;
    }

    public String getClie_tipodoc() {
        return clie_tipodoc;
    }

    public void setClie_tipodoc(String clie_tipodoc) {
        this.clie_tipodoc = clie_tipodoc;
    }

    public String getClie_nombre() {
        return clie_nombre;
    }

    public void setClie_nombre(String clie_nombre) {
        this.clie_nombre = clie_nombre;
    }

    public Date getDocu_fecha() {
        return docu_fecha;
    }

    public void setDocu_fecha(Date docu_fecha) {
        this.docu_fecha = docu_fecha;
    }

    public String getDocu_hora() {
        return docu_hora;
    }

    public void setDocu_hora(String docu_hora) {
        this.docu_hora = docu_hora;
    }

    public String getDocu_tipodocumento() {
        return docu_tipodocumento;
    }

    public void setDocu_tipodocumento(String docu_tipodocumento) {
        this.docu_tipodocumento = docu_tipodocumento;
    }

    public String getDocu_numero() {
        return docu_numero;
    }

    public void setDocu_numero(String docu_numero) {
        this.docu_numero = docu_numero;
    }

    public String getDocu_moneda() {
        return docu_moneda;
    }

    public void setDocu_moneda(String docu_moneda) {
        this.docu_moneda = docu_moneda;
    }

    public String getDocu_gravada() {
        return docu_gravada;
    }

    public void setDocu_gravada(String docu_gravada) {
        this.docu_gravada = docu_gravada;
    }

    public String getDocu_inafecta() {
        return docu_inafecta;
    }

    public void setDocu_inafecta(String docu_inafecta) {
        this.docu_inafecta = docu_inafecta;
    }

    public String getDocu_exonerada() {
        return docu_exonerada;
    }

    public void setDocu_exonerada(String docu_exonerada) {
        this.docu_exonerada = docu_exonerada;
    }

    public String getDocu_gratuita() {
        return docu_gratuita;
    }

    public void setDocu_gratuita(String docu_gratuita) {
        this.docu_gratuita = docu_gratuita;
    }

    public String getDocu_descuento() {
        return docu_descuento;
    }

    public void setDocu_descuento(String docu_descuento) {
        this.docu_descuento = docu_descuento;
    }

    public String getDocu_subtotal() {
        return docu_subtotal;
    }

    public void setDocu_subtotal(String docu_subtotal) {
        this.docu_subtotal = docu_subtotal;
    }

    public String getDocu_total() {
        return docu_total;
    }

    public void setDocu_total(String docu_total) {
        this.docu_total = docu_total;
    }

    public String getDocu_igv() {
        return docu_igv;
    }

    public void setDocu_igv(String docu_igv) {
        this.docu_igv = docu_igv;
    }

    public String getTasa_igv() {
        return tasa_igv;
    }

    public void setTasa_igv(String tasa_igv) {
        this.tasa_igv = tasa_igv;
    }

    public String getDocu_isc() {
        return docu_isc;
    }

    public void setDocu_isc(String docu_isc) {
        this.docu_isc = docu_isc;
    }

    public String getTasa_isc() {
        return tasa_isc;
    }

    public void setTasa_isc(String tasa_isc) {
        this.tasa_isc = tasa_isc;
    }

    public String getDocu_otrostributos() {
        return docu_otrostributos;
    }

    public void setDocu_otrostributos(String docu_otrostributos) {
        this.docu_otrostributos = docu_otrostributos;
    }

    public String getTasa_otrostributos() {
        return tasa_otrostributos;
    }

    public void setTasa_otrostributos(String tasa_otrostributos) {
        this.tasa_otrostributos = tasa_otrostributos;
    }

    public String getDocu_otroscargos() {
        return docu_otroscargos;
    }

    public void setDocu_otroscargos(String docu_otroscargos) {
        this.docu_otroscargos = docu_otroscargos;
    }

    public String getDocu_percepcion() {
        return docu_percepcion;
    }

    public void setDocu_percepcion(String docu_percepcion) {
        this.docu_percepcion = docu_percepcion;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public String getCdr() {
        return cdr;
    }

    public void setCdr(String cdr) {
        this.cdr = cdr;
    }

    public String getCdr_nota() {
        return cdr_nota;
    }

    public void setCdr_nota(String cdr_nota) {
        this.cdr_nota = cdr_nota;
    }

    public String getCdr_observacion() {
        return cdr_observacion;
    }

    public void setCdr_observacion(String cdr_observacion) {
        this.cdr_observacion = cdr_observacion;
    }

    public String getDocu_enviaws() {
        return docu_enviaws;
    }

    public void setDocu_enviaws(String docu_enviaws) {
        this.docu_enviaws = docu_enviaws;
    }

    public String getDocu_proce_status() {
        return docu_proce_status;
    }

    public void setDocu_proce_status(String docu_proce_status) {
        this.docu_proce_status = docu_proce_status;
    }

    public String getDocu_proce_fecha() {
        return docu_proce_fecha;
    }

    public void setDocu_proce_fecha(String docu_proce_fecha) {
        this.docu_proce_fecha = docu_proce_fecha;
    }

    public String getDocu_link_pdf() {
        return docu_link_pdf;
    }

    public void setDocu_link_pdf(String docu_link_pdf) {
        this.docu_link_pdf = docu_link_pdf;
    }

    public String getDocu_link_cdr() {
        return docu_link_cdr;
    }

    public void setDocu_link_cdr(String docu_link_cdr) {
        this.docu_link_cdr = docu_link_cdr;
    }

    public String getDocu_link_xml() {
        return docu_link_xml;
    }

    public void setDocu_link_xml(String docu_link_xml) {
        this.docu_link_xml = docu_link_xml;
    }

    public String getClie_correo_cpe1() {
        return clie_correo_cpe1;
    }

    public void setClie_correo_cpe1(String clie_correo_cpe1) {
        this.clie_correo_cpe1 = clie_correo_cpe1;
    }

    public String getClie_correo_cpe2() {
        return clie_correo_cpe2;
    }

    public void setClie_correo_cpe2(String clie_correo_cpe2) {
        this.clie_correo_cpe2 = clie_correo_cpe2;
    }

    public String getDocu_tipodocumento_anular() {
        return docu_tipodocumento_anular;
    }

    public void setDocu_tipodocumento_anular(String docu_tipodocumento_anular) {
        this.docu_tipodocumento_anular = docu_tipodocumento_anular;
    }

    public String getDocu_tipodocumento_numero() {
        return docu_tipodocumento_numero;
    }

    public void setDocu_tipodocumento_numero(String docu_tipodocumento_numero) {
        this.docu_tipodocumento_numero = docu_tipodocumento_numero;
    }

    public String getDocu_motivoanular() {
        return docu_motivoanular;
    }

    public void setDocu_motivoanular(String docu_motivoanular) {
        this.docu_motivoanular = docu_motivoanular;
    }

    public Set<Detalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<Detalle> detalles) {
        this.detalles = detalles;
        for (Detalle det : detalles){

           det.setCabecera(this);
        }
    }

    public Set<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pago> pagos) {
        this.pagos = pagos;
        for (Pago pg : pagos){

            pg.setCabecera(this);
        }

    }

    public Set<Leyenda> getLeyendas() {
        return leyendas;
    }

    public void setLeyendas(Set<Leyenda> leyendas) {
        this.leyendas = leyendas;
        for (Leyenda  ley : leyendas){

            ley.setCabecera(this);
        }
    }
}
