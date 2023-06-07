import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class THClient{
    public static char input() throws RemoteException{
        Scanner scan= new Scanner(System.in);
        System.out.println("give answer y:yes or n:no");
        char opt=scan.next().charAt(0);
        return opt;
    }
    public static void main(String[] args){
        try{
            if(args.length==0){
                System.out.println("\nYou can only use:\n");
                System.out.println("java THClient list <hostname>");
                System.out.println("java THClient book <hostname> <type> <number> <name>");
                System.out.println("java THClient guests <hostname>");
                System.out.println("java THClient cancel <hostname> <type> <number> <name>");
                return;
            }

            THInterface c=(THInterface)Naming.lookup("rmi://Localhost:1099/TH");
            switch(args[0]){
                case "list":
                    if(args.length==2)
                       System.out.println(c.clist()); 
                    break;
                case "book":
                    if(args.length==5){
                        char opt;
                        try{
                            int num=Integer.parseInt(args[3]);
                            int cost=c.book(args[2],num,args[4]);
                            if(cost<0){
                                System.out.println("Δεν υπάρχουν διαθέσιμα εισητήρια όσα ζητάτε");
                                System.out.println("θες να πάρεις όσα υπάρχουν σε αυτή τη θέση?");
                                opt=input();
                                if(opt=='y')
                                    cost=c.book(args[2],-cost,args[4]);
                                    System.out.println("cost is = "+cost);
                            }else{
                                System.out.println(cost);
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }  
                    }
                    break;
                case "guests":
                    if(args.length==2){
                        ArrayList<ArrayList<String>> Ar=c.guest();
                        for(int i=0;i<Ar.size();i++){
                            ArrayList<String> esAr=Ar.get(i);
                            for(int j=0;j<esAr.size();j++)
                                System.out.println(esAr.get(j));
                        }
                    }
                    break;
                // case "cancel":
                //     int num=Integer.parseInt(args[3]);
                //     System.out.println(c.cancel(args[3],num,args[4]));
                //     break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}