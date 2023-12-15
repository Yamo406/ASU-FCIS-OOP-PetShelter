package Exceptions;
public class PetLimitException extends Exception
{
    public PetLimitException()
    {
        super("This vet can't handle more pets");
    }
}
