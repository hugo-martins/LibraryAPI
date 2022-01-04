package br.com.phoebustecnologia.Library.exceptions;

public class ClientExistException extends RuntimeException{
    public ClientExistException(){
        super("the client with the specific exist");
    }

}
