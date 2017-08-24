/**
 * ICidadeServico.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.projeto.pontuacaocidades.remote;

public interface ICidadeServico extends java.rmi.Remote {
    public com.projeto.pontuacaocidades.remote.Cidade[] buscaTodasCidades() throws java.rmi.RemoteException;
    public java.lang.Integer buscaPontos(com.projeto.pontuacaocidades.remote.Cidade cidade) throws java.rmi.RemoteException;
}
