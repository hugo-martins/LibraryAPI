package br.com.phoebustecnologia.Library.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public  CategoryNotFoundException(){
        super("The category with the specific id does not exist");
    }
}
