package Exceptions;
public class LoginException extends Exception
{
    public LoginException()
    {
        super("Wrong username or password");
    }
}
