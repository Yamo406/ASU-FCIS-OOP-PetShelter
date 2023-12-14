public class RegisterException extends Exception
{
    public RegisterException()
    {
        super("This username already exists");
    }
}
