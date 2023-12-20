


import java.io.IOException;
import java.util.ArrayList;
public abstract class User implements Comparable {
    protected String name;
    protected String password;
    public static ArrayList<User> registeredUser= new ArrayList<>();
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {

    }

    public abstract void Register (User user) throws RegisterException;
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
}
