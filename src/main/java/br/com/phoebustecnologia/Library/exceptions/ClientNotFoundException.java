package br.com.phoebustecnologia.Library.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(){
        super("the client with the specific id does not exist ");
    }
}
