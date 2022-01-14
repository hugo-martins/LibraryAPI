package br.com.phoebustecnologia.Library.exceptions;

public class CategoryExistException extends RuntimeException{
    public CategoryExistException(){
        super("the category with the specific exist");
    }
}
