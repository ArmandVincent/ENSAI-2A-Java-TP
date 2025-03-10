package fr.ensai.library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private String name;
    private ArrayList<Item> books;
    private ArrayList<Loan> activeLoans;
    private ArrayList<Loan> completedLoans;

    public Library(String name){
        this.name = name;
        this.books = new ArrayList<Item>();
        this.activeLoans = new ArrayList<Loan>();
        this.completedLoans = new ArrayList<Loan>();
    }

    public void addItem(Item book){
        this.books.add(book);
    }

    public void displayItems(){
        if (this.books.size() == 0){
        System.out.println("Il n'y a pas de livres dans la library.");
    } else{for(int i = 0; i< this.books.size(); i++){
        System.out.println(books.get(i).toString());
    }}
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName, 0, "");
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Book book = new Book(isbn, title, author, year, pageCount);

                    this.addItem(book);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public Loan findActiveLoanForItem(Item item){
        if (this.activeLoans.size()>0){
        for(Loan loan : this.activeLoans){
            if (loan.getItem().equals(item)){
                return loan;
            }
        }}
        return null;
    }
    
    public ArrayList<Book> getBooksByAuthor(Author author){
        
        ArrayList<Book> liste= new ArrayList<Book>();
        for (Item book: this.books){
            if (book instanceof Book){ Book book1 = (Book) book;
                if(book1.getAuthor().equals(author)){

                liste.add(book1);

            }}
        }
    if(liste.size()>0){
        return liste;}
    return null;
    }
    
    public boolean loanItem(Item item, Student student){
        boolean result = false;

        for(Item item1 : this.books){
            if (item1.equals(item)){
                result = true;
            }
        
        Date date = new Date();
        Loan loan = new Loan(item, student, date);    
        
        activeLoans.add(loan);}

        return result;
    }

    public boolean renderItem(Item item){
        
        boolean result = false;
        for(Loan loan : this.activeLoans){
            if (loan.getItem().equals(item) && result == false){
                result = true;
                Loan loan1 = loan;
                this.activeLoans.remove(loan);
                if (result){
                    Date date = new Date();
                    loan1.setReturnDate(date);
                    
                    this.completedLoans.add(loan1);
                }
        
            }
        }

        return result;
    }

    public void displayActiveLoans(){

        for (Loan loan: this.activeLoans){

            String message = loan.toString();
            System.out.println(message);
        }
    }

    public ArrayList<Loan> getActiveLoans(){
        return this.activeLoans;
    }

}
