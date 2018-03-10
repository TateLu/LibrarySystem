package CSE105;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input {
	
	Scanner input=new Scanner(System.in);
	
	//make sure the string input is legal
    public static String InputString(){
        Scanner input = new Scanner(System.in);
        String S=input.nextLine();
        while(S.isEmpty()){
            System.out.println("You Just Entered Nothing");
            System.out.println("Please Enter Again");
            S=input.nextLine();
        }
        return S;
    }
    
    //make sure the boolean input is legal
    public static boolean InputBoolean(){
    	Scanner input=new Scanner(System.in);
        String S="";
        S=input . nextLine();
        while(!(S.toLowerCase().equals("y")|S.toLowerCase().equals("n") ) ){
            System.out.println("Invalid Input");
            System.out.println("Please Enter Again");
            S=input . nextLine();
        }
        return S.equals("y");
    }
    
    //Input Command Code, and user can enter number or words as they choose        
    public static int[] InputCommand(){
    	Scanner input=new Scanner(System.in);
        System.out.println("Command:");
        String Command=input .nextLine();
        int[] CommandNumform= {-1,0};
        try{
            CommandNumform[0]=Integer.parseInt(Command);
            CommandNumform[1]=1;
        }catch(final NumberFormatException e){
            switch(Command){
                case "end":CommandNumform[0]=0;
                CommandNumform[1]=1;
                break;
                case "add":CommandNumform[0]=1;
                CommandNumform[1]=1;
                break;
                case "borrow":CommandNumform[0]=2;
                CommandNumform[1]=1;
                break;
                case "return":CommandNumform[0]=3;
                CommandNumform[1]=1;
                break;
                case "all":CommandNumform[0]=4;
                CommandNumform[1]=1;
                case "lent":CommandNumform[0]=5;
                CommandNumform[1]=1;
                break;
                case "overdue":CommandNumform[0]=6;
                CommandNumform[1]=1;
                break;
                case "help":CommandNumform[0]=7;
                CommandNumform[1]=1;
                break;
                default:System.out.println("\""+Command+ "\" is not a valid command code");
               
            }
        }
        return CommandNumform;
    }
    
  //make sure the int input is legal
    public static int InputInt(){
        String n;
        int m=0;
        boolean isLegal=false;
        n = "";
        Scanner input=new Scanner(System.in);
        while (!isLegal){
            try{
            	n=input .nextLine();
                m=Integer.parseInt(n);
                isLegal=true;
            }catch(final NumberFormatException e){
                System.out.println("Error!It's not a integer!!");
            }
        }
        return m;
        
    }
    
}
