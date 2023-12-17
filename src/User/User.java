import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class User implements Comparable {
    protected String name;
    protected String password;
    protected int user_index;
    protected static int no_users=0;
    protected static ArrayList<User> registeredUser= new ArrayList<>(10);
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        user_index=no_users;
        no_users++;
    }

    public User() {

    }

    public abstract void Register (User user) throws RegisterException, IOException;
    public static boolean Login(String Name,String Password) throws LoginException
    {
            for(User item: registeredUser)
            {
                if((Name.compareTo(item.getName())==0)&&Password.compareTo(item.getPassword())==0)
                {
                    return true;
                }
            }
            throw new LoginException();
    }

    @Override
    public int compareTo(Object o)
    {
        User item=(User) o;
        if (this.name.equals(item.name))
        {
            return 0;
        }
        else if ((this.name.compareTo(item.name))==1)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_index() {
        return user_index;
    }
}
