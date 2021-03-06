
package Threads;


import ClienteSOAP.ClienteUI;
import proxy.Controle;
import proxy.Frase;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThreadExcluir extends Thread 
{
    ClienteUI UI;
    Controle control;
    int id;
    
    public ThreadExcluir(int i, ClienteUI U, Controle c)
    {
        this.UI = U;
        control = c;
        id = i;
    }
    
    public void run()
    {
        UI.bloquear(false);
        try {
            sleep(3000);
        } catch (InterruptedException ex) {
            //Logger.getLogger(ThreadConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean f = control.excluir(id);
        if(f)
        {
            UI.setStatus("OK");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao excluir");
            UI.setStatus("ERRO");
        }
            
        UI.bloquear(true);
    }
}
