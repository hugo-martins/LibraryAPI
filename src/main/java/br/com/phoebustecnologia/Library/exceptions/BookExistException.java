package br.com.phoebustecnologia.Library.exceptions;

public class BookExistException extends RuntimeException{
    public BookExistException(){
        super("the book with the specific exist");
    }

}
