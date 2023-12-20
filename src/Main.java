import Rooms.*;
import Users.*;
import Pet.*;
import Exceptions.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception
    {
        File userFile= new File("F:\\OOP Project\\User data.txt");
        File vetFile= new File("F:\\OOP Project\\Vet data.txt");
        File donorFile= new File("F:\\OOP Project\\Donor data.txt");
        File petFile= new File("F:\\OOP Project\\Pet data.txt");
        File operationFile=new  File("F:\\OOP Project\\Operation.txt");
        readOnBoot(vetFile,donorFile,petFile,operationFile);
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
                                int targetV=0;
                                for(Vet item: registeredVet)
                                {
                                    if((Name.compareTo(item.getName())==0)&&Password.compareTo(item.getPassword())==0)
                                    {
                                        targetV=item.getVetId();
                                    }
                                }
                                Vet currently_Vet=registeredVet.get(targetV);
                                System.out.println("press 1 to give prescription of a pet or 2 to reserve operation or 3 to add pet ");
                                Scanner in= new Scanner(System.in);
                                int num=in.nextInt();
                                System.out.println("Enter the pet ID");
                                int id_P=in.nextInt();
                                if(num==1)
                                    currently_Vet . prescription(id_P);
                                else if(num==2)
                                    currently_Vet. reserveOperationRoom() ;
                                else if (num==3)
                                    currently_Vet.addPet(id_P);
                                break;
                            case 2:
                                int targetD=0;
                                for(Donor item: Donor.registeredDonor)
                                {
                                    if((Name.compareTo(item.getName())==0)&&Password.compareTo(item.getPassword())==0)
                                    {
                                        targetD=item.getDonor_ID();
                                    }
                                }
                                Donor currently_Donor=Donor.registeredDonor.get(targetD);
                                System.out.println("press 1 to give make donation  or press 2 to ask for adoption");
                                Scanner inp= new Scanner(System.in);
                                int nm=inp.nextInt();
                                if(nm==1){
                                    Scanner Don= new Scanner(System.in);
                                    String DonInput= Don.next();
                                    currently_Donor.MakeDonation (donation_Type.valueOf(DonInput));
                                }
                                else if(nm==2)
                                    currently_Donor.AskForAdoption();
                                break;
                            case 3:
                                Admin currently_Admin=new Admin();
                                System.out.println("press 1 to add pets or press 2 to delete any entity or 3 to Display Available OperationSlots or 4 to Display Donor theData or 5 to  Display the Vet Data or 6 toDisplay Pet Data or 7 to Display Ready ForAdoptionPets or 8 to Calculate Donated or 8 to Update the Pet Data  ");
                                Scanner inpt= new Scanner(System.in);
                                int nmb=inpt.nextInt();
                                if(nmb==1) {
                                    currently_Admin.AddPets();
                                }
                                else if (nmb==2) {
                                    currently_Admin.DeleteEntity();
                                }
                                else if (nmb==3){
                                    currently_Admin.DisplayAvailableOperationSlots();
                                }
                                else if (nmb==4) {
                                    System.out.println("Input the Donor's ID");
                                    Scanner zz= new Scanner(System.in);
                                    int Req_ID=zz.nextInt();
                                    currently_Admin.DisplayDonorData(Req_ID);
                                }
                                else if (nmb==5) {
                                    System.out.println("Input the Vet's ID");
                                    Scanner zz= new Scanner(System.in);
                                    int Req_ID=zz.nextInt();
                                    currently_Admin.DisplayVetData(Req_ID);
                                }
                                else if (nmb==6){
                                    System.out.println("Input the Pet's ID");
                                    Scanner zz= new Scanner(System.in);
                                    int Req_ID=zz.nextInt();
                                    currently_Admin.DisplayPetData(Req_ID);
                                }
                                else if (nmb==7) {
                                    currently_Admin.DisplayReadyForAdoptionPets();
                                }
                                else if(nmb==8) {
                                    currently_Admin.CalculateDonated();
                                }
                                else {
                                    System.out.println("Input the Pet's ID");
                                    Scanner zz= new Scanner(System.in);
                                    int Req_ID=zz.nextInt();
                                    currently_Admin.UpdatePetData(Req_ID);
                                }
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
                    try {
                        user.Register(user);
                    } catch (RegisterException e) {
                    System.out.println("This account may not exist, you should register an account.");
                } catch (Exception e) {
                    System.out.println("it appears that there is an error" + e.getMessage());
                }
                }
                else if (inp_1 == 2)
                {
                    System.out.println("Enter your username");
                    String inp_2 = input.next();
                    System.out.println("Enter your password");
                    String inp_3 = input.next();
                    Donor user = new Donor(inp_2, inp_3);
                    try {
                        user.Register(user);
                    } catch (RegisterException e) {
                        System.out.println("This account may not exist, you should register an account.");
                    } catch (Exception e) {
                        System.out.println("it appears that there is an error" + e.getMessage());
                    }                }
            }
            else if (inp_1==3)
            {
                running=false;
            }
        }
        writeOnExit(userFile,vetFile,donorFile,petFile,operationFile);
    }
    public static void readOnBoot( File pathVet, File pathDonor, File pathPet,File pathOperation) throws IOException {
      BufferedReader READ=new BufferedReader(new FileReader(pathVet));
        String lineV;
        int yrs = -1;
        String nameV = null;
        String passwordV;
        while ((lineV = READ.readLine()) != null)
        {
            if (yrs == -1) {
                yrs = Integer.parseInt(lineV);
            } else if (nameV == null) {
                nameV = lineV;
            } else {
                passwordV = lineV;
                registeredVet.add(new Vet(nameV, passwordV,yrs));
                yrs = 0;
                nameV = null;
            }
        }
        READ=new BufferedReader(new FileReader(pathDonor));
        String sSum=READ.readLine();
        if(sSum!= null){
            Donor.setSumMoney(Integer.parseInt(sSum));
        }
        String lineD;
        int card = -1;
        String nameD = null;
        String passwordD=null;
        delivery_Type deliD=null;
        donation_Type donaD=null;
        while ((lineD = READ.readLine()) != null)
        {
            if (card == -1) {
                card = Integer.parseInt(lineD);
            }
            else if (nameD == null) {
                nameD = lineD;
            }
            else if (passwordD==null) {
                passwordD = lineD;
            }
            else if (deliD==null) {
                if(lineD.equals("null"))
                {
                    deliD=null;
                }
                else {
                    deliD = delivery_Type.valueOf(lineD);
                }
            }
            else if (donaD==null) {
                if(lineD.equals("null"))
                {
                    donaD=null;
                }
                else {
                    donaD = donation_Type.valueOf(lineD);

                }
                Donor.registeredDonor.add(new Donor(nameD, passwordD, card, donaD, deliD));
                card = 0;
                nameD = null;
                deliD = null;
                donaD = null;
            }
        }
        READ=new BufferedReader(new FileReader(pathPet));
        String lineP;
        int ageP=-1;
        String nameP=null;
        Pet_type petType= null;
        Adoption_status adoptionStatus=null;
        Ready_for_adoption_status readyForAdoptionStatus=null;
        Treatment_Status treatmentStatus=null;
        while ((lineP=READ.readLine())!=null)
        {
            if(ageP==-1)
            {
                ageP=Integer.parseInt(lineP);
            }
            else if(nameP==null)
            {
                nameP=lineP;
            }
            else if (petType==null)
            {
                if(lineP=="null"){
                    petType=null;}
                else {petType=Pet_type.valueOf(lineP);}
            }
            else if(adoptionStatus==null)
            {
                if(lineP=="null"){
                    adoptionStatus=null;}
                else {adoptionStatus=Adoption_status.valueOf(lineP);}
            }
            else if (readyForAdoptionStatus==null)
            {
                if(lineP=="null"){
                    readyForAdoptionStatus=null;}
                else {readyForAdoptionStatus=Ready_for_adoption_status.valueOf(lineP);}
            }
            else if(treatmentStatus==null)
            {
                if(lineP=="null"){
                    treatmentStatus=null;}
                else {treatmentStatus=Treatment_Status.valueOf(lineP);}
                Pet.shelteredPets.add(new Pet(nameP,petType,ageP,adoptionStatus,readyForAdoptionStatus,treatmentStatus));
                ageP=-1;
                nameP=null;
                petType= null;
                adoptionStatus=null;
                readyForAdoptionStatus=null;
                treatmentStatus=null;
            }
        }
        READ=new BufferedReader(new FileReader(pathOperation));
        operation.availableRoom.add(new operation());
        operation.availableRoom.add(new operation());
        operation.availableRoom.add(new operation());
        String lineO;

        for(operation item: operation.availableRoom)
        {
            int maxCounter=0;
            while((lineO=READ.readLine())!=null&&maxCounter<10)
            {
                boolean slotO=Boolean.parseBoolean(lineO);
                if(maxCounter==0)
                {
                    item.reservedSlots.add(slotO);
                }
                else {
                    item.reservedSlots.set(maxCounter, slotO);
                }
            }
        }
        READ.close();
        User.registeredUser.add(new Admin());
        User.registeredUser.addAll(Donor.registeredDonor);
        User.registeredUser.addAll(registeredVet);
    }
    public static void writeOnExit(File pathUser, File pathVet, File pathDonor, File pathPet,File pathOperation) throws IOException {
        BufferedWriter WRITE = new BufferedWriter(new FileWriter(pathUser));
        for(User item:User.registeredUser)
        {
            WRITE.write(item.getName()+"\n");
            WRITE.write(item.getPassword()+"\n");
        }
        WRITE.flush();
        WRITE.close();
        WRITE = new BufferedWriter(new FileWriter(pathVet));
        for(Vet item:registeredVet)
        {
            WRITE.write((item.getYrs_exp())+"\n");
            WRITE.write(item.getName()+"\n");
            WRITE.write(item.getPassword()+"\n");
        }
        WRITE.flush();
        WRITE.close();
        WRITE = new BufferedWriter(new FileWriter(pathDonor));
        WRITE.write((Donor.getSumMoney())+"\n");
        for(Donor item:Donor.registeredDonor)
        {
            WRITE.write((item.getCard_Number())+"\n");
            WRITE.write(item.getName()+"\n");
            WRITE.write(item.getPassword()+"\n");
            WRITE.write((item.getDelivery())+"\n");
            WRITE.write((item.getDonation())+"\n");
        }
        WRITE.flush();
        WRITE.close();
        WRITE = new BufferedWriter(new FileWriter(pathPet));
        for(Pet item:Pet.shelteredPets)
        {
            WRITE.write((item.getAge())+"\n");
            WRITE.write(item.getName()+"\n");
            WRITE.write((item.getType())+"\n");
            WRITE.write((item.getAdoptionStatus())+"\n");
            WRITE.write((item.getReadyForAdoptionStatus())+"\n");
            WRITE.write((item.getTreatmentStatus())+"\n");
        }
        WRITE.flush();
        WRITE.close();
        WRITE = new BufferedWriter(new FileWriter(pathOperation));
            for (operation item : operation.availableRoom) {
                for (int i = 0; i < 10; i++) {
                    WRITE.write((item.reservedSlots.indexOf(i))+"\n");
                }
            }
        WRITE.flush();
        WRITE.close();
    }
}
