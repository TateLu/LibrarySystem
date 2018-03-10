package CSE105;

import java.util.Date;

public class Book {
	
	private String Title;
	private String Author;
	private String ValidDate;
	private String Status;
	private String DateOfBorrow;
	private String DueDate;
	private String Student;
	
	
	//title author  validdate  status  dateofborrow   duedate  student 
	 public Book(String title, String author, String validdate2, String status, String dateofborrow, String duedate,
			String student) {
		
		this.Title = title;
		this.Author = author;
		this.ValidDate = validdate2;
		this.Status = status;
		this.DateOfBorrow = dateofborrow;
		this.DueDate = duedate;
		this.Student = student;
	}



	public Book() {
		// TODO Auto-generated constructor stub
	}



	//Print the detail of the book on the screen    
    public void ShowDetil(){
        System.out.println();
        
       
        //title author  validdate  status  dateofborrow   duedate  student 
        System.out.println(this.Title +"        "+this.Author+"  "+this.ValidDate +"    "+
        		this.Status+"    "+this.DateOfBorrow+"    "+this.DueDate 
        		+"    "+this.Student );
        
            
    }
    
    //Convert book to String
    public String ToString(){
        String S=this.Title +"%"+this.Author +"%"+this.ValidDate +"%"+this.Status 
        		+"%"+this.DateOfBorrow +"%"+this.DueDate+"%"+this.Student ;
       
        return S;
    }
	
	
	
	
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getValidDate() {
		return ValidDate;
	}
	public void setValidDate(String validDate) {
		ValidDate = validDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDateOfBrrow() {
		return DateOfBorrow;
	}
	public void setDateOfBrrow(String dateOfBrrow) {
		DateOfBorrow = dateOfBrrow;
	}
	public String getDueDate() {
		return DueDate;
	}
	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}
	public String getStudent() {
		return Student;
	}
	public void setStudent(String student) {
		Student = student;
	}
	
	

}
