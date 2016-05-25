/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;


import sop_corba.ClienteInt;
import sop_corba.ServidorIntPOA;
import java.util.ArrayList;


/**
 *
 * @author claudia
 */
public class ServidorImpl extends ServidorIntPOA{
    
     private ArrayList<ClienteInt> listaDeUsuarios;

    public ServidorImpl()
    {
        this.listaDeUsuarios = new ArrayList<ClienteInt>();
    }

    @Override
    public boolean registrarCliente(ClienteInt objcllbck, String usuario) {
        boolean bandera=false;
        if(!listaDeUsuarios.contains(objcllbck))
        {
            listaDeUsuarios.add(objcllbck);
            ClienteInt objcllbckAct;
            
            for (int i = 0; i < listaDeUsuarios.size(); i++) {
                objcllbckAct=listaDeUsuarios.get(i);
                objcllbckAct.borrarListaDeContactos();
                
                for (int j = 0; j <  listaDeUsuarios.size(); j++) {
                    String nombre;
                    nombre=listaDeUsuarios.get(j).obtenerNombre();
                    
                    if(objcllbckAct.obtenerNombre() !=nombre)
                    {
                        objcllbckAct.recibirContacto(nombre);
                    }
                }
            }
            System.out.println("usuario "+ usuario+ " registrado");
            bandera=true;
        }
        else
        {
            System.out.println("usuario "+ usuario+ " no registrado");
            bandera=true;
        }
        return bandera;
    }

    @Override
    public void enviarMensaje(String usuario, String mensaje) {
        for (int i = 0; i < listaDeUsuarios.size(); i++) {
            ClienteInt objcllbckAct;
            objcllbckAct=listaDeUsuarios.get(i);
            objcllbckAct.recibirMensaje(usuario, mensaje);
        }
    }

    @Override
    public boolean desconectarCliente(ClienteInt objcllbck, String usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
