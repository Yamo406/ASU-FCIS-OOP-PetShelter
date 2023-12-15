package User;

import java.util.ArrayList;
import java.util.Scanner;
import Exceptions.*;

public abstract class User implements Comparable {
    protected String name;
    protected String password;
    protected static ArrayList<User> registeredUser= new ArrayList<>();
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public abstract void Register (User user) throws RegisterException;

    public boolean Login() throws LoginException
    {
            Scanner login = new Scanner(System.in);
            System.out.println("Please Enter Your Username ");
            String Name = login.next();
            System.out.println("Please Enter Your Password");
            String Password = login.next();
            for(User item: User.registeredUser)
            {
                if((Name.compareTo(item.getName())==0)&&Password.compareTo(item.getPassword())==0)
                {
                    return true;
                }
                else
                {
                    continue;
                }
            }
            return false;
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
