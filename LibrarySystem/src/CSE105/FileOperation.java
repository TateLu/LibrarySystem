package CSE105;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class FileOperation {
    //Write all the object to DataFile.txt
    public static void WriteFile(ArrayList<Book> List){
    	
        //File fileBefore = new File("DataFile.txt");
        //fileBefore.delete();
        File file1 =new File("DataFile.txt");
        file1.setWritable(true);
        try {
            if(!file1.exists()) {
                file1.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file1);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        File file = new File("DataFile.txt");
        file.setWritable(true);
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(file,true));
            
            for (int i=1;i<=List.size();i++){
            	String s=List.get(i-1).ToString();
                fw.write(s);
                fw.newLine();
            }       
            fw.flush();
            fw.close();
            file.setWritable(false);
            //System.out.println("Objects written to file");
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
    
    
    //Read DateFil.txt, and load object to ArrayList<Car>
    public static ArrayList<Book> ReadObject(){
        ArrayList<Book> AllBook = new ArrayList<Book>();
        File file = new File("DataFile.txt");
        String line;
        try {
            BufferedReader fr = new BufferedReader(new FileReader(file));
           
            while ((line = fr.readLine()) != null) {
                String[] s = line.split("%");
                String title = s[0];
                String author = s[1];
                String validdate=s[2];
                String status=s[3];
                String dateofborrow=s[4];
                String duedate=s[5];
                String student=s[6];
                
                
                Book A = new Book(title, author, validdate, status, dateofborrow, duedate, student);
                
                AllBook.add(A);
               
            }
        
            
            fr.close();
            System.out.println("Success to reading file");
        } catch (IOException e1) {
            System.out.println("Error reading file");
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("Error. Wrong number of fields");
        } catch (NumberFormatException e3) {
            System.out.println("Error. Date is not a long or id number not an integer");
        }
        return AllBook;
    }
        
}