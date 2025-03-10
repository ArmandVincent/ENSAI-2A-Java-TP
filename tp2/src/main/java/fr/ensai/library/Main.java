package fr.ensai.library;

public class Main {

    public static void main(String[] args) {

        Library library = new Library("chaine vide");

        library.loadBooksFromCSV("books.csv");

        Magazine mag1 = new Magazine("abc", "def");
        Magazine mag2 = new Magazine("ghi", "jkl");
        library.addItem(mag1);
        library.addItem(mag2);

        library.displayItems();
        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        System.out.println(fellowshipOfTheRing.toString());
    }
}