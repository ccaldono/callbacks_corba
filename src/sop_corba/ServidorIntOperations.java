package sop_corba;


/**
* sop_corba/ServidorIntOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interfaces.idl
* martes 24 de mayo de 2016 21H48' COT
*/

public interface ServidorIntOperations 
{
  boolean registrarCliente (sop_corba.ClienteInt objcllbck, String usuario);
  void enviarMensaje (String usuario, String mensaje);
  boolean desconectarCliente (sop_corba.ClienteInt objcllbck, String usuario);
} // interface ServidorIntOperations
