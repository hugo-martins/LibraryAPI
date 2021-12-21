package br.com.phoebustecnologia.Library.exceptions;

public class SaleNotFoundException extends RuntimeException{
    public SaleNotFoundException(){
        super("the sale with the specific id does not exist");
    }
}
