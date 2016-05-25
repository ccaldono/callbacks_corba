/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import sop_corba.ClienteIntPOA;

/**
 *
 * @author claudia
 */
public class ClienteImpl extends ClienteIntPOA{

    
    private GUICliente GUIC;
    
    public ClienteImpl(GUICliente GUIC)
    {
        this.GUIC=GUIC;
    }
    
    @Override
    public void recibirMensaje(String usuario, String mensaje) {
        GUIC.fijarTexto(usuario, mensaje);
    }

    @Override
    public void recibirContacto(String usuario) {
        GUIC.fijarContacto(usuario);
    }

    @Override
    public String obtenerNombre() {
        return  GUIC.obtenerNombre();
    }

    @Override
    public void borrarListaDeContactos() {
        GUIC.borrarLista();
    }
    
}