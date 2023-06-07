import java.rmi.*;
import java.rmi.server.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

//λειτουργίες συναρτήσεων
public class THImpl extends UnicastRemoteObject implements THInterface{
    //public global μεταβλητές
    public static int sizeA=100; 
    public static int sizeB=200;
    public static int sizeC=400;
    public static int scntr=225;
    public static int sside=75;

    public static int closedA=0;
    public static int closedB=0;
    public static int closedC=0;
    public static int closedcntr=0;
    public static int closedside=0;

    public static ArrayList<String> A=new ArrayList<>();
    public static ArrayList<String> B=new ArrayList<>();
    public static ArrayList<String> C=new ArrayList<>();
    public static ArrayList<String> cntr=new ArrayList<>();
    public static ArrayList<String> side=new ArrayList<>();

    public THImpl() throws RemoteException{
        super(0);
        int i;
        for(i=0;i<sizeC;i++)
            if(i<sizeA)
                A.add("");
            if(i<sizeB)
                B.add("");
            if(i<scntr)
                cntr.add("");
            if(i<sside)
                side.add("");
            C.add("");
    }

    public String clist(){
        int t1,t2,t3,t4,t5;
        if(sizeA-closedA<0) t1=0;
        else t1=sizeA-closedA;

        if(sizeB-closedB<0) t2=0;
        else t2=sizeB-closedB;

        if(sizeC-closedC<0) t3=0;
        else t3=sizeC-closedC; 

        if(scntr-closedcntr<0) t4=0;
        else t4=scntr-closedcntr;

        if(sside-closedside<0) t5=0;
        else t5=sside-closedside;

        String tmp1=t1+" θέσεις Πλατεία - Ζώνη Α (κωδικός: ΠΑ) - τιμή: 45 Ευρώ\n";
        String tmp2=t2+" θέσεις Πλατεία - Ζώνη Β (κωδικός: ΠΒ) - τιμή: 35 Ευρώ\n";
        String tmp3=t3+" θέσεις Πλατεία - Ζώνη Γ (κωδικός: ΠΓ) - τιμή: 25 Ευρώ\n";
        String tmp4=t4+" θέσεις Κεντρικός Εξώστης (κωδικός: ΚΕ) - τιμή: 30 Ευρώ\n";
        String tmp5=t5+" θέσεις Πλαϊνά Θεωρεία (κωδικός: ΠΘ) - τιμή: 20 Ευρώ\n";
        return tmp1+tmp2+tmp3+tmp4+tmp5;
    }

    public int book(String type,int num,String name){
        int i;
        switch(type){
            case "ΠΑ":
                if(sizeA-num>=0){
                    sizeA-=num;
                    closedA+=num;
                    for(i=0;i<num;i++)
                        A.add("name = "+name+" price = "+num*45+" type = "+type);
                    return num*45;
                } else{return -sizeA;}
            case "ΠΒ":
                if(sizeB-num>=0){
                    sizeB-=num;
                    closedB+=num;
                    for(i=0;i<num;i++)
                        B.add("name = "+name+" price = "+num*35+" type = "+type);
                    return num*35;
                } else{return -sizeB;}
            case "ΠΓ":
                if(sizeC-num>=0){
                    sizeC-=num;
                    closedC+=num;
                    for(i=0;i<num;i++)
                        C.add("name = "+name+" price = "+num*25+" type = "+type);
                    return num*25;
                } else{return -sizeC;}
            case "ΚΕ":
                if(scntr-num>=0){
                    scntr-=num;
                    closedcntr+=num;
                    for(i=0;i<num;i++)
                        cntr.add("name = "+name+" price = "+num*30+" type = "+type);
                    return num*30;
                } else{return -scntr;}
            case "ΠΘ":
                if(sside-num>=0){
                    sside-=num;
                    closedside+=num;
                    for(i=0;i<num;i++)
                        side.add("name = "+name+" price = "+num*35+" type = "+type);
                    return num*20;
                } else{return -sside;}
        }        
        return 1;
    }

    public ArrayList<ArrayList<String>> guest(){
        ArrayList<ArrayList<String>> tmp=new ArrayList<>();
        if(A!=null)
            tmp.add(A);
        if(B!=null)
            tmp.add(B);
        if(C!=null)
            tmp.add(C);
        if(cntr!=null);
            tmp.add(cntr);
        if(side!=null)
            tmp.add(side);
        return tmp;
    }

    // public ArrayList<String> cancel(String type,int num,String name){
    //     int count=0,pos;
    //     switch(type){
    //         case "ΠΑ":
    //             for (int i = 0; i < sizeA; i++)
    //                 if (A[i] == name){
    //                     pos=i;
    //                     count++; // μετράει πόσες φορές έχει κλείσει ο χρήστης
    //             }
    //             if(count<=num){
    //                 sizeA+=num;
    //                 closedA-=num;
    //                 for(i=pos;i<pos+num;i++)
    //                     A.remove(i);
    //                 return A;
    //             }else return "αποτυχία";

    //         // case "ΠΒ":
                
    //     }
    // }
}

