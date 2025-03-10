package fr.ensai.library;

public class Magazine extends Item{
    private String issn;
    private String issueNumber;

    public Magazine(String issn, String issueNumber){
        this.issn = issn;
        this.issueNumber = issueNumber;
    }
}
