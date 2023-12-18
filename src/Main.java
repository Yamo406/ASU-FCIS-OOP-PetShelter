package main;
import User.*;
import  User.Vet.*;
import Rooms.*;
import Pet.*;
//added the Pet Class
import java.util.*;
import Exceptions.*;
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
                                boolean found=false;
                                int target=0;
                                for(Vet item: Vet.registeredVet)
                                {
                                    if((Name.compareTo(item.getName())==0)&&Password.compareTo(item.getPassword())==0)
                                    {
                                        found =true;
                                        target=item.getVetId();

                                    }


                                }
                                Vet currently_Vet=Vet.registeredVet.get(target);
                                System.out.println("press 1 to give prescription of a pet or 2 to reserve operation or 3 to add pet ");
                                Scanner in= new Scanner(System.in);
                                int num=in.nextInt();
                                Pet item2 =new Pet();
                                 
                                if(num==1)
                                    currently_Vet . prescription(item2.getID());
                                     else if(num==2)
                                    currently_Vet. reserveOperationRoom() ;
                            else
                                    currently_Vet.addPet(item2.getID());
                                // at this line we will write all the menus possible for a vet user
                                break;
                            case 2:
                                Donor current_Donor=new Donor();
                                System.out.println("press 1 to give make donation  or press 2 to ask for adoption");
                                Scanner inp= new Scanner(System.in);
                                int nm=inp.nextInt();
                                if(nm==1){
                                    current_Donor.MakeDonation ();
                                }
                                else
                                     current_Donor.AskForAdoption();
                                break;
                            case 3:
                                Admin currently_Admin=new Admin();
                                System.out.println("press 1 to add pets or press 2 to dalete any entity or 3 to Display Available OperationSlots or 4 to Display Donor theData or 5 to  Display the Vet Data or 6 toDisplay Pet Data or 7 to Display Ready ForAdoptionPets or 8 to Calulate Donated or 8 to Update the Pet Data  ");
                                Scanner inpt= new Scanner(System.in);
                                int nmb=inpt.nextInt();
                                if(nmb==1)
                                    currently_Admin.AddPets();
                                else if (nmb==2)
                                    currently_Admin. DeleteEntity();
                                else if (nmb==3)
                                    currently_Admin.DisplayAvailableOperationSlots();
                                else if (nmb==4)
                                    currently_Admin. DisplayDonorData();
                                else if (nmb==5)
                                    currently_Admin.DisplayVetData();
                                else if (nmb==6)
                                    currently_Admin.DisplayPetData();
                                else if (nmb==7)
                                    currently_Admin. DisplayReadyForAdoptionPets();
                                else if(nmb==8)
                                    currently_Admin.  CalulateDonated();
                                else
                                    currently_Admin.UpdatePetData();


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
                if (inp_1 == 1) {
                    System.out.println("Enter your username");
                    String inp_2 = input.next();
                    System.out.println("Enter your password");
                    String inp_3 = input.next();
                    Vet user = new Vet(inp_2, inp_3);
                    user.Register(user);
                } else if (inp_1 == 2) {
                }
            }
            else if (inp_1==3)
            {
                running=false;
            }
        }
    }
}
