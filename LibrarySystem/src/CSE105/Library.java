package CSE105;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Library {
	
	private static ArrayList<Book> List = new ArrayList();
	
	private static int BookNum;//the number of the all books that is able to borrrow
    private static int AllBookNum;
    Scanner input=new Scanner(System.in);
    
    //create MyLibrary, and load book to ArrayList<Book>
    public Library(ArrayList<Book > List,int BookNum,int AllBookNum){
        this.List=List;
        this.BookNum=BookNum;
        this.AllBookNum=AllBookNum;
    }
	
    
    //Add books to library
    public void AddBooks(){
    	
    	this.BookNum ++;
    	this.AllBookNum ++;
    	
    	System.out.println("Please Enter Book Title:");
       
        String title ="";
      
        title=Input .InputString();
      
        //judge if the book exit in the library
        Iterator<Book> it=List.iterator();
        Book book=new Book();
        
        while(it.hasNext()){
        	book=it.next();
        	if(book.getTitle().equals(title)){
        		System.out .println("The book named "+title+" had existed in Library");
        		System.out.println("That is not valid");
        		return;
        	}
        	
        }
        
        System.out.println("Please Enter Author Name:");
       
        String author ="";
        author=Input .InputString();
       
        
        //postpone it for 5 years
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)+5);
		Date date=curr.getTime();
        String validdate=date.toLocaleString();
        
        //Book A=new Book(title, author, validDate, status, dateOfBorrow, dueDate, student)
        
        Book A=new Book(title, author, validdate, "Available", null, null,null);
        List.add(A);
        System.out.println("Add Book to　Library Successfully");
    	
    }
    
    //Borrow books from library
    public void BorrowBooks(){
    	if(BookNum==0){
            System.out.println("There is No Book in Library");
            System.out.println("Failed To Borrow");
        }else{
        	System.out.println("Which Book Do You Want To Borrow?");
            System.out.println("Please Enter The Title or Author Of The Book");
            
            
           
            String S ="";
            S=Input .InputString();
           
            
            //search book by title or author
           
            Book book=new Book();
            boolean find=false;
            int bookindex=0;
            boolean lend=false;
            
            for(int i=0;i<List.size();i++){
            	book=List.get(i);
            	if(book.getTitle().equals(S)||book .getAuthor().equals(S)){
            		
            		find=true;
            		bookindex=i;
            		System.out .println("The book Detail");
            		System.out.println();
            		System.out .println("Title   Author  Validdate       Status      DateOfBorrow            DueDate         Student");
            		book .ShowDetil();
            		if(book.getStatus().equals("Borrowed"))
            			lend=true;
            		
            		break;
            		
            		
            	}
            	
            }
            //if the book can not find
            if(!find){
            	System.out.println("The book named "+S+" can not find");
            	return;
            }
            //if the book had been lent out
            if(lend){
            	System.out.println();
            	System.out.println("The book named "+S+" had been lent out ");
            	return;
            	
            }
            
            boolean borrow=false;
            System.out.println();
            System.out .println("Do you want to Borrow this Book ?(y/n)");
            borrow=Input.InputBoolean();
            
            if(!borrow){
            	return;
            }
            else{
            	System.out.println("Input your Name:");
            	String student=Input .InputString();
            	
            	//postpone it for 2 months
            	Calendar curr = Calendar.getInstance();
            	curr.set(Calendar.MONTH,curr.get(Calendar.MONTH)+2);
            	
            	Date date1=new Date();
            	Date date2=curr.getTime();
            	String dateOfBrrow=date1 .toLocaleString();
            	String dueDate=date2.toLocaleString();
                
            	List.get(bookindex).setDateOfBrrow(dateOfBrrow);//dateOfBrrow
            	List.get(bookindex ).setDueDate(dueDate);		//dueDate
            	List.get(bookindex ).setStatus("Borrowed");		//Status
            	List.get(bookindex).setStudent(student);   			//student
            	
            	System.out.println();
            	System.out .println("Success to borrow");
            	
            	BookNum--;
            }
                	
        	
        }
    	
    }
    
    //List all Book borrowed,listed by due date
    public void ShowBorrowedBooks(){
    	if(BookNum==0){
    		System.out .println("Library haven't Lent a Book");
    		
    	}
    	else{
    		System.out .println("Lent Out Books:");
    		System.out .println("(Listed By Due Date)");
    		System.out .println("Title   Author  Validdate       Status      DateOfBorrow            DueDate         Student");
    		
    		ArrayList<Book> demo1=new ArrayList<Book>();
    		
    		for(int i=0;i<List.size();i++){
    			if(List.get(i).getStatus().equals("Borrowed")){
    				demo1.add(List.get(i));	
    				
    			}
    		}
    		//ArrayList<Book> demo2=new ArrayList<Book>();
    		
    		int size=demo1.size();
    		Book temp=new Book();
    		 for(int i=0;i<size-1;i++) {
    			   for(int j=1;j<size-i;j++) {
    			    int value=compare_date(demo1.get(j-1).getDueDate(), demo1.get(j).getDueDate());
    			    if(value>0) {   //compare two date
    			     
    			     temp=demo1.get(j-1);
    			     demo1.set((j-1),demo1.get(j));
    			     demo1.set(j,temp);
    			    }
    			   }
    		
    	
    		 	}
    		 
    		 for(int v=0;v<demo1.size();v++){
    			 
    			 demo1.get(v).ShowDetil();
    		 }
    		}
    	
    	

 }
    
    //return books,search book by title
    public void ReturnBooks(){
    	
    	System.out .println("Input Title of the Book you want to Return: ");
    	String title ="";
        
        title=Input.InputString();
      
        //judge if the book had been lent out
        Book book=new Book();
        boolean find=false;
        int bookindex=0;
        boolean lend=false;
        
        for(int i=0;i<List.size();i++){
        	book=List.get(i);
        	if(book.getTitle().equals(title)){
        	
        		find=true;
        		bookindex=i;
        		
        		if(book.getStatus().equals("Borrowed"))
        			List.get(i).setStatus("Available");
        			List.get(i).setDueDate(null);
        			List.get(i).setDateOfBrrow(null);
        			List.get(i).setStudent(null);
        			lend=true;
        		
        		break;
        		
        	}
        	
        	
        	
        }
        if(!lend){
    		System.out.println();
    		System.out .println("the Book has not been lent out ");
    		System.out .println("You can not Return this Book ");
    		return;
    	}
    	else{
    		System.out.println();
    		System.out .println("Return the Book Successfully ");
    	}
    	
    }
    
    //list all books
    public void ListAllBooks(){
    	System.out.println();
    	System.out .println("All Books of the Library:");
    	Book book=new Book();
    	System.out .println("Title   Author  Validdate       Status      DateOfBorrow            DueDate         Student");
    	
    	for(int i=0;i<List.size();i++){
         	book=List.get(i);
         	book.ShowDetil();
    	
    }
    	 
    }
   
    
    //search overdue books
    public void OverdueBooks(){
    	int size=List.size();
    	boolean outdate=false;
    	Date date=new Date();
    	String s=date.toLocaleString();
    	ArrayList<Book> demo1=new ArrayList<Book>();
    	for(int i=0;i<size;i++ ){
    		boolean tag=false;
    		String validdate=List.get(i).getValidDate();
    		if(validdate!=null)
    			tag=true;
    		if(tag){
    			if(compare_date(validdate, s)<0){
        			demo1.add(List.get(i));
        			outdate=true;
        			
        		}
    			
    		}
    		
    		
    		
    	}
    	//if the book is overdue
    	if(outdate){
    		System.out.println("Overdue Books:");
    		System.out .println("Title   Author  Validdate       Status      DateOfBorrow            DueDate         Student");
    		for(int j=0;j<demo1.size();j++){
    			demo1.get(j).ShowDetil();
    			
    		}
    		System.out.println();
    		System.out.println("Input the Book Title you want to delete:");
    		String title=Input.InputString();
    		
    		for(int i=0;i<size;i++ ){
        		if(List.get(i).getTitle().equals(title)){
        			List.remove(i);
        			System.out.println("Delete the Book Successfully");
            		System.out.println();
        			break;
        			
        		}
        			
        		
        		
        	}
    		
    	}
    	
    	else{
    		System.out.println("Libary have no Overdue Books");
    		System.out.println();
    	}
    	
    }
    
    //return book list
    public static ArrayList GetList(){
        return List;
    }
    
    //compare two date
    public static int compare_date(String DATE1, String DATE2) {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        
        	if(DATE1==null||DATE2==null){
        		return 0;
        	}
        	else{
        		  
				try {
					Date dt1 = df.parse(DATE1);
					Date dt2 = df.parse(DATE2);
					
					if (dt1.getTime() > dt2.getTime()) {
	                    
	                     return 1;
	                 } else if (dt1.getTime() < dt2.getTime()) {
	                    
	                     return -1;
	                 } else {
	                     return 0;
	                 }
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
                 
             } 
        	
        	return 0;
        	}
   
        		
        	
          
       
    


}
