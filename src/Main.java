import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception
    {
        boolean running=true;
        while (running)
        {
            Scanner input= new Scanner(System.in);
            System.out.println("To Log in press 1, to register press 2, to exit press 3");
            int inp_1= input.nextInt();
            if (inp_1==1) {
                System.out.println("Choose your account type:");
                System.out.println("1 for Vet");
                System.out.println("2 for Donor");
                System.out.println("3 for Admin");
                int choice= input.nextInt();
                try {
                    Scanner login = new Scanner(System.in);
                    System.out.println("Please Enter Your Username ");
                    String Name = login.next();
                    System.out.println("Please Enter Your Password");
                    String Password = login.next();
                    if (User.Login(Name,Password)) {
                        switch (choice)
                        {
                            case 1:
                                boolean Vfound=false;
                                int Vtarget=0;
                                for(Vet item: Vet.registeredVet)
                                {
                                    if((Name.compareTo(item.getName())==0)&&Password.compareTo(item.getPassword())==0)
                                    {
                                        Vfound =true;
                                        Vtarget=item.getVetId();
                                    }
                                }
                                Vet currently_Vet=Vet.registeredVet.get(Vtarget);
                                 // at this line we will write all the menus possible for a vet user
                                break;
                            case 2:
                                boolean Dfound=false;
                                int Dtarget=0;
                                for(Donor item: Donor.registeredDonor)
                                {
                                    if((Name.compareTo(item.getName())==0)&&Password.compareTo(item.getPassword())==0)
                                    {
                                        Dfound =true;
                                        Dtarget=item.getDonor_ID();
                                    }
                                }
                                Donor currently_Donor=Donor.registeredDonor.get(Dtarget);
                                // at this line we will write all the menus possible for a donor user
                                break;
                            case 3:
                                Admin currently_Admin=new Admin();
                                break;
                        }
                    }
                } catch (LoginException e) {
                    System.out.println("This account may not exist, you should register an account.");
                } catch (Exception e) {
                    System.out.println("it appears that there is an error" + e.getMessage());
                }
            }
            else if (inp_1==2) {
                System.out.println("You are now creating an account");
                System.out.println("To create a Vet account press 1, to create a Donor account press 2");
                inp_1 = input.nextInt();
                System.out.println("Enter your username");
                String inp_2 = input.next();
                System.out.println("Enter your password");
                String inp_3 = input.next();
                if (inp_1 == 1) {
                    Vet user = new Vet(inp_2, inp_3);
                    user.Register(user);
                } else if (inp_1 == 2)
                {
                    Donor user = new Donor(inp_2, inp_3);
                    user.Register(user); 
                }
            }
            else if (inp_1==3)
            {
                running=false;
            }
        }
    }
}
