/**
 * Cidade.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.projeto.pontuacaocidades.remote;

public class Cidade implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Cidade.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WsTeste.Domain", "Cidade"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WsTeste.Domain", "Estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/WsTeste.Domain", "Nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    private java.lang.String estado;
    private java.lang.String nome;
    private java.lang.Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;


    public Cidade() {
    }


    public Cidade(
            java.lang.String estado,
            java.lang.String nome) {
        this.estado = estado;
        this.nome = nome;
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanSerializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Gets the estado value for this Cidade.
     *
     * @return estado
     */
    public java.lang.String getEstado() {
        return estado;
    }

    /**
     * Sets the estado value for this Cidade.
     *
     * @param estado
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }

    /**
     * Gets the nome value for this Cidade.
     *
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }

    /**
     * Sets the nome value for this Cidade.
     *
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Cidade)) return false;
        Cidade other = (Cidade) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.estado == null && other.getEstado() == null) ||
                        (this.estado != null &&
                                this.estado.equals(other.getEstado()))) &&
                ((this.nome == null && other.getNome() == null) ||
                        (this.nome != null &&
                                this.nome.equals(other.getNome())));
        __equalsCalc = null;
        return _equals;
    }

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
