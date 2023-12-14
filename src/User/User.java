package User;
import java.util.ArrayList;
public abstract class User implements Comparable {
    protected String name;
    protected String password;
    protected static ArrayList<User> registeredUser= new ArrayList<>();
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public void Register(User user)
    {
        for(User item:registeredUser)
        {
            if (user.compareTo(item)==0)
            {
                System.out.println("Invalid username or password");
            }
            else
            {
                registeredUser.add(user);
            }
        }
    }
    public abstract void Login();

    @Override
    public int compareTo(Object o)
    {
        User item=(User) o;
        if (this.name.equals(((User) o).name))
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
