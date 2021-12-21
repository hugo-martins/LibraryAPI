package br.com.phoebustecnologia.Library.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(){
        super("the book with the specific id does not exist");
    }
}
