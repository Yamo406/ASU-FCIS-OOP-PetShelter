package User;
import Exceptions.*;
import javax.sound.midi.Soundbank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
enum donation_Type { MONEY, FOOD, MEDICINE}
enum delivery_Type {ONLINE, ONSITE }
public class Donor extends User {
    private int donor_ID;
    private int card_Number;
    private donation_Type donation;
    private delivery_Type delivery;
    private static int no_donors=0;
    protected static ArrayList<Donor> registeredDonor= new ArrayList<>();


    public Donor (){
        super();
    }
    public Donor(String name, String password, int card_Number)
    {
        super(name, password);
        this.donor_ID=no_donors+100;
        this.card_Number= card_Number;
        no_donors++;
    }

    @Override
    public void Register(User user) throws RegisterException
    {
        for(User item:registeredUser)
        {
            if (user.compareTo(item)==0)
            {
                throw new RegisterException();
            }
            else
            {
                registeredUser.add(user);
                System.out.println("Please enter your card number");
                Scanner inf= new Scanner(System.in);
                int CardInfo = inf.nextInt();
                setCard_Number(CardInfo);
                registeredDonor.add(new Donor(user.getName(), user.getPassword(), CardInfo));
            }
        }
    }
    public int getDonor_ID() {
        return donor_ID;
    }

    public void setCard_Number(int card_Number) {
        this.card_Number = card_Number;
    }

    public int getCard_Number() {
        return card_Number;
    }

    public void setDonation(donation_Type donation) {
        this.donation = donation;
    }

    public donation_Type getDonation() {
        return donation;
    }

    public void setDelivery(delivery_Type delivery) {
        this.delivery = delivery;
    }

    public delivery_Type getDelivery() {
        return delivery;
    }


    public void OnlineList()
    {
        int moneyAmount ;
        Scanner online = new Scanner(System.in);
        while (true) {
            System.out.println("Please Enter Your Personal Card Number");
            int This_card_Number = online.nextInt();
            if(This_card_Number == card_Number)
            {
                System.out.println("Please Enter The Amount of Money you will donate");
                moneyAmount = online.nextInt();
                break;
            }
            else {
                System.out.println("Invalid Card Number...... Please Try Again");
            }
        }

    }

    public void OnsiteList()
    {
        AppointmentForDonor appoint = new AppointmentForDonor();
        while(true) {
            appoint.MakeAppoint(appoint);
            boolean Done = appoint.checkAvailability(appoint);
            if(!Done)
                continue;
            else
                break;

        }

    }

    public void MakeDonation (donation_Type donationType)
    {
        int Answer;
        switch(donationType){
            case MONEY :

                while (true)
                {
                    System.out.println("Do You Want ONLINE Delivery OR ONSITE ?");
                    System.out.println("For ONLINE press 1 for ONSITE press 2");
                    Scanner answer = new Scanner(System.in);
                    Answer = answer.nextInt();
                    if (Answer == 1)
                    {
                        OnlineList();
                        break;
                    }
                    else if (Answer == 2)
                    {
                        OnsiteList();
                        break;
                    }
                    else
                    {
                        System.out.println("!invalid number Please Try Again");
                    }
                }
                break;
            case FOOD:
            case MEDICINE:
                OnsiteList();
                break;


        }

    }


//    public void AskForAdoption(){
//
//        Admin admin = new Admin();
//        admin. DisplayReadyForAdoptionPets();
//        System.out.println("Please Choose A Pet To Adopt by choosing its number from 1 to " + Vet.readyPets);
//        Scanner adoptedPet = new Scanner(System.in);
//
//
//
//
//
//
//
//
//
//    }
}