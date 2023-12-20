//package User;
//
//import javax.sound.midi.Soundbank;
//import Exceptions.*;
//import Pet.*;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Donor extends User
{
    private int donor_ID;
    private int card_Number;
    private donation_Type donation;
    private delivery_Type delivery;
    private static int no_donors=0;
    protected static int SumMoney =0;
    protected static ArrayList<Donor> registeredDonor= new ArrayList<>();

    private String [] appointment= new String[]{" 1_ Saturday >>> From 10am To 4pm ",
            "2_ Sunday >>> From 11am To 4pm ","3_ Monday >>> From 10am To 5pm", "4_ Tuesday >>> From 12am To 3pm",
            "5_ Friday >>> All the day from 9am to 11 pm" }; //in these appointments we can welcome you and let you
    public Donor()
    {
        super();

    }
    public Donor(String name, String password)
    {
        super(name, password);
        this.donor_ID=no_donors;
        no_donors++;
    }
    public Donor(String name, String password, int card_Number,donation_Type donationType,delivery_Type delivery)
    {
        super(name, password);
        this.donor_ID=no_donors;
        this.card_Number= card_Number;
        this.donation=donationType;
        this.delivery=delivery;
        no_donors++;
    }

    @Override
    public void Register(User user) throws RegisterException
    {
        Donor d = (Donor) user;

        for(User item:registeredDonor)
        {
            if ((d.compareTo(item)==0))
            {
                throw new RegisterException();
            }
        }
        System.out.println("Please enter your card number");
        Scanner inf= new Scanner(System.in);
        int CardInfo = inf.nextInt();
        d.setCard_Number(CardInfo);
        registeredUser.add(d);
        registeredDonor.add(d);
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
        int moneyAmount;
        Scanner online = new Scanner(System.in);
        while (true) {
            System.out.println("Please Enter Your Personal Card Number");
            int This_card_Number = online.nextInt();
            if(This_card_Number == card_Number)
            {
                System.out.println("Please Enter The Amount of Money you will donate");
                moneyAmount = online.nextInt();
                SumMoney+=moneyAmount;
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
                break;

        }

    }
    public void MakeDonation (donation_Type donationType)
    {
        this.setDonation(donationType);
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
                        this.setDelivery(delivery_Type.ONLINE);
                        break;
                    }
                    else if (Answer == 2)
                    {
                        OnsiteList();
                        this.setDelivery(delivery_Type.ONSITE);
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
                this.setDelivery(delivery_Type.ONSITE);
                break;
        }
    }
    public void AskForAdoption(){

        boolean founded = false;
        Admin admin = new Admin();
        admin. DisplayReadyForAdoptionPets();
        System.out.println("Please Choose A Pet To Adopt by choosing its ID ");
        Scanner adoptedPet = new Scanner(System.in);
        int id = adoptedPet.nextInt();
        for(Pet item :Pet.ReadyPets )
        {
            if(item.getID() == id)
            {
                item.setAdoptionStatus(Adoption_status.ADOPTED);
                founded = true;
                break;
            }
        }
        if(founded)
        {
            int num;
            Scanner input = new Scanner(System.in);
            System.out.println("Please Choose An Appointment By Choosing the Appointment Number");
            for (String s: appointment)
            {
                System.out.println(s);
            }
            System.out.println("You Can Come At Any Hour That We Mentioned");
            num = input.nextInt();
        }
        else {
            System.out.println(" Invalid Pet ID ");
        }
    }

    public void setDonor_ID(int donor_ID) {
        this.donor_ID = donor_ID;
    }

    public static void setNo_donors(int no_donors) {
        Donor.no_donors = no_donors;
    }

    public static void setSumMoney(int sumMoney) {
        SumMoney = sumMoney;
    }

    public static int getNo_donors() {
        return no_donors;
    }

    public static int getSumMoney() {
        return SumMoney;
    }
}
