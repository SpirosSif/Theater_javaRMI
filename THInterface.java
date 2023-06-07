import java.rmi.*;
import java.util.ArrayList;

//αρχικοποίηση συναρτήσεων
public interface THInterface extends Remote{
    String clist() throws RemoteException;
    int book(String type, int num, String name) throws RemoteException;
    ArrayList<ArrayList<String>> guest() throws RemoteException;
    // ArrayList<String> cancel(String type,int num,String name) throws RemoteException;
}