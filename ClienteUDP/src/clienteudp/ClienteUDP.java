/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Jônatas Strapazzon
 */
public class ClienteUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        DatagramSocket soc;
        DatagramPacket pct;
        byte vet[];
        String msg;
        int porta = 2006;
        InetAddress adress;
        
        
        System.out.println("Cliente");
        soc = new DatagramSocket();
        msg = new String("oii");
        vet = msg.getBytes();
        adress = InetAddress.getLocalHost();
        
        pct = new DatagramPacket(vet, vet.length, adress, porta);
        soc.send(pct);
        System.out.println("Enviou mensagem com tamanho: " + vet.length);
        
        pct = new DatagramPacket(vet, vet.length);
        soc.receive(pct);
               
        System.out.println("Voltou: " + new String(pct.getData()) );       
        soc.close();
           
    }
    
}