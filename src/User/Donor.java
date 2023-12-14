package User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Donor extends User {
    private int donor_ID ;
    private int card_Number;

    public Donor(String name, String password,int donor_ID,int card_Number)
    {
        super(name, password);
        this.donor_ID=donor_ID;
        this.card_Number=card_Number;
    }

    @Override
    public void Login() {
        Scanner login = new Scanner(System.in);
        System.out.println("Please Enter Your Username ");
        name = login.next();
        System.out.println("Please Enter Your Password");
        password = login.next();
    }

    enum donation_Type { MONEY, FOOD, MEDICIN}
    enum delivery_Type {ONLINE, ONSITE }
    private donation_Type donation;

    private delivery_Type delivery;


    public void setDonor_ID(char donor_ID) {
        this.donor_ID = donor_ID;
    }

    public int getDonor_ID() {
        return donor_ID;
    }

    public void setCard_Number(char card_Number) {
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
        System.out.println("Please Enter Your Personal Card Number");
        Scanner online = new Scanner(System.in);
        card_Number = online.nextInt();
        System.out.println("Please Enter The Amount of Money you will donate");
        moneyAmount = online.nextInt();
    }

    public void OnsiteList()
    {

        String  date,time ;
        Scanner onsite = new Scanner(System.in);

        System.out.println("Please Enter your appointment");
        System.out.println("Enter A Date ");
        date = onsite.next();
        System.out.println("Enter A Time ");
        time = onsite.next();
    }


    public void MakeDonation (donation_Type donationType)
    {
        int Answer;
        switch(donationType){
            case MONEY :

                while (true)
                {
                    System.out.println("Do You Want ONLINE Deleviry OR ONSITE ?");
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
            case MEDICIN:
                OnsiteList();
                break;


        }

    }
    public void AskForAdobtion(){

        Admin admin = new Admin();
        admin. DisplayReadyForAdoptionPets();
        System.out.println("Please Choose A Pet To Adopt by choosing its number from 1 to " + Vet.readyPets);
        Scanner adoptedPet = new Scanner(System.in);









    }
}