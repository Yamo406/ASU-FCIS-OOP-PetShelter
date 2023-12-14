public class PetDoesnotExistException extends Exception
{
    public PetDoesnotExistException()
    {
        super("There are no pets with this ID");
    }
}
