/**
 * CidadeServicoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.projeto.pontuacaocidades.remote;

public class CidadeServicoLocator extends org.apache.axis.client.Service implements com.projeto.pontuacaocidades.remote.CidadeServico {

    public CidadeServicoLocator() {
    }

    public CidadeServicoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CidadeServicoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WsTesteWebServiceCidadeServico_basicHttpBinding
    private java.lang.String WsTesteWebServiceCidadeServico_basicHttpBinding_address = "http://wsteste.devedp.com.br/Master/CidadeServico.svc";

    public java.lang.String getWsTesteWebServiceCidadeServico_basicHttpBindingAddress() {
        return WsTesteWebServiceCidadeServico_basicHttpBinding_address;
    }

    // The WSDD remote name defaults to the port name.
    private java.lang.String WsTesteWebServiceCidadeServico_basicHttpBindingWSDDServiceName = "WsTeste.WebService.CidadeServico_basicHttpBinding";

    public java.lang.String getWsTesteWebServiceCidadeServico_basicHttpBindingWSDDServiceName() {
        return WsTesteWebServiceCidadeServico_basicHttpBindingWSDDServiceName;
    }

    public void setWsTesteWebServiceCidadeServico_basicHttpBindingWSDDServiceName(java.lang.String name) {
        WsTesteWebServiceCidadeServico_basicHttpBindingWSDDServiceName = name;
    }

    public com.projeto.pontuacaocidades.remote.ICidadeServico getWsTesteWebServiceCidadeServico_basicHttpBinding() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WsTesteWebServiceCidadeServico_basicHttpBinding_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWsTesteWebServiceCidadeServico_basicHttpBinding(endpoint);
    }

    public com.projeto.pontuacaocidades.remote.ICidadeServico getWsTesteWebServiceCidadeServico_basicHttpBinding(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.projeto.pontuacaocidades.remote.WsTesteWebServiceCidadeServico_basicHttpBindingStub _stub = new com.projeto.pontuacaocidades.remote.WsTesteWebServiceCidadeServico_basicHttpBindingStub(portAddress, this);
            _stub.setPortName(getWsTesteWebServiceCidadeServico_basicHttpBindingWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWsTesteWebServiceCidadeServico_basicHttpBindingEndpointAddress(java.lang.String address) {
        WsTesteWebServiceCidadeServico_basicHttpBinding_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this remote has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.projeto.pontuacaocidades.remote.ICidadeServico.class.isAssignableFrom(serviceEndpointInterface)) {
                com.projeto.pontuacaocidades.remote.WsTesteWebServiceCidadeServico_basicHttpBindingStub _stub = new com.projeto.pontuacaocidades.remote.WsTesteWebServiceCidadeServico_basicHttpBindingStub(new java.net.URL(WsTesteWebServiceCidadeServico_basicHttpBinding_address), this);
                _stub.setPortName(getWsTesteWebServiceCidadeServico_basicHttpBindingWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this remote has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WsTeste.WebService.CidadeServico_basicHttpBinding".equals(inputPortName)) {
            return getWsTesteWebServiceCidadeServico_basicHttpBinding();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "CidadeServico");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WsTeste.WebService.CidadeServico_basicHttpBinding"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WsTesteWebServiceCidadeServico_basicHttpBinding".equals(portName)) {
            setWsTesteWebServiceCidadeServico_basicHttpBindingEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
