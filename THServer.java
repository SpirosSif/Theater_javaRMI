import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.*;

public class THServer{
    public THServer(){
        try{
            THImpl in= new THImpl();
            // Registry reg=LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost:1099/TH",in);
        }catch (Exception e){
            e.printStackTrace(); //ektypwnei to eidos sfalmatos
        }
    }

    public static void main(String args[]) throws Exception{
        new THServer();
        try{
            //Δημιουργεί registry την πόρτα 1099
            Registry reg=LocateRegistry.createRegistry(1099);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

