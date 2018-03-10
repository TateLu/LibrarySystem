package CSE105;

import java.util.ArrayList;


public class Start {
	
	//the Menu printed in the Screen,include some Menu operation
    public static void Menu() {
        boolean run = true;
        //command code instruction
        String Help="Enter:\"0\" or \"End\" to exit the program\n"
        + "Enter:\"1\" or \"add\" to add a book\n"
        +"Enter:\"2\" or \"borrow\" to borrow a book\n"
        +"Enter:\"3\" or \"return\" to return a book\n"
        +"Enter:\"4\" or \"all\" to list all books in the library\n"
        +"Enter:\"5\" or \"lent\" to show all the books had been lent out\n"
        +"Enter:\"6\" or \"overdue\" to show all the books had been overdue\n"
        +"Enter \"7\" or \"help\" To Get Command Code List\n"
        +"Hint:Case Can Be Ingnored"        ;
        Library myLibrary = LoadBookList();//read DataFile.txt, and initialize MyGarage
        System.out.println(Help);
        while(run){
            int[] Command = Input.InputCommand();
            ArrayList<Book> List=myLibrary.GetList();
            
            if(Command[1]==1){
                switch(Command[0]){
                    case 0:run = false;
                    try {
                    	FileOperation.WriteFile(List);
                    	System.out.println("Objects written to file");
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Error writing to file");
					}
                    
                    System.out.println("Have A Nice Day");
                    break;
                    case 1:myLibrary.AddBooks(); 
                    FileOperation.WriteFile(List);
                    break;
                    
                    case 2:myLibrary.BorrowBooks();
                    FileOperation.WriteFile(List);
                    break;
                    
                    case 3:myLibrary.ReturnBooks();
                    FileOperation.WriteFile(List);
                    break;
                    
                    case 4:myLibrary.ListAllBooks();
                    break;
                    
                    case 5:myLibrary.ShowBorrowedBooks();
                    break;
                    
                    case 6:myLibrary.OverdueBooks();
                    break;
                    
                    case 7:System.out.println(Help);
                    break;
                    
                    default:System.out.println("\""+Command[0]+"\" is not a valid command code");
                    Command[1]=0;
                }
                

            }
            //Print some help on screen if user entered a invalid command code
            if(Command[1]==0){
                System.out.println("Enter \"7\" or \"help\" To Get Command Code List");
            }
            System.out.println();
            System.out.println();
        }
        
    }
    
    
    //read DataFile.txt
    private static Library LoadBookList(){
        ArrayList<Book> AllBook = FileOperation.ReadObject();
        int avaiable=AllBook.size();
        
        for(int i=0;i<AllBook.size();i++){
        	if(AllBook.get(i).getStatus().equals("Borrow")){
        		avaiable--;
        	}
        }
        
        
        Library L1 = new Library(AllBook,avaiable,AllBook.size());
        return L1;
    }
        
}
