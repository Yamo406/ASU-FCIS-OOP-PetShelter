package User;

import Exceptions.*;
import java.util.*;
import java.io.*;
import Pet.*;
import Rooms.*;
import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.Scanner;

public class Admin extends User
{

  public Admin ()
  {
      super("ADMIN","ADMIN");
      registeredUser.add(this);
  }
  Scanner scanner = new Scanner(System.in);
  public void AddPets()
  {
    Scanner petInput=new Scanner(System.in);
    System.out.println("Enter the pet's name");
    String pName= petInput.next();
    System.out.println("Enter the pet's type (CAT/DOG)");
    String pType= petInput.next();
    System.out.println("Enter the pet's age");
    int pAge=petInput.nextInt();
    System.out.println("Enter the pet's adoption status (ADOPTED/NOT_ADOPTED)");
    String pAdoption_status=petInput.next();
    System.out.println("Choose whether the pet is ready for adoption or not (READY/NOT_READY)");
    String pReady=petInput.next();
    System.out.println("Enter the pet's health status (SICK/RECOVERING/TREATED");
    String pTreatment=petInput.next();
    Pet addTarget=new Pet(pName,Pet_type.valueOf(pType),pAge,Adoption_status.valueOf(pAdoption_status),Ready_for_adoption_status.valueOf(pReady),Treatment_Status.valueOf(pTreatment));
    Pet.shelteredPets.add(addTarget.getID(),addTarget);
  }

  public void DeleteEntity()
  {
    Scanner deleteInput=new Scanner(System.in);
    System.out.println("Enter 1 to delete a vet, 2 to delete a donor, 3 to delete a vet.");
    int deleteTarget=deleteInput.nextInt();
    int i=0;
    switch (deleteTarget)
    {
      case 1:
        System.out.println("Enter the vet ID");
        int Req_vetID= scanner.nextInt();
        for (Vet item: Vet.registeredVet)
        {
          if(item.getVetId()==Req_vetID)
          {
            Vet.registeredVet.remove(i);
          }
          i++;
        }
        break;
      case 2:
        System.out.println("Enter the donor ID");
        int Req_donorID= scanner.nextInt();
        for (Donor item: Donor.registeredDonor)
        {
          if(item.getDonor_ID()==Req_donorID)
          {
            Donor.registeredDonor.remove(i);
          }
          i++;
        }
        break;
      case 3:
        System.out.println("Enter the pet ID");
        int Req_petID= scanner.nextInt();
        for (Pet item:Pet.shelteredPets)
        {
          if(item.getID()==Req_petID)
          {
            Pet.shelteredPets.remove(i);
          }
          i++;
        }
        break;
    }
  }
  public void DisplayAvailableOperationSlots()
  {
    for (operation room : operation.availableRoom) {
      if (!room.isReserved()) {
        System.out.println("Room ID: " + room.getRoomId());
      }
    }
  }

  public void DisplayDonorData(int donorIDInt)
  {
    for (Donor indexDonor : Donor.registeredDonor) {
      if (indexDonor.getDonor_ID() == donorIDInt) {
        System.out.println( indexDonor.getDonor_ID());
        System.out.println(indexDonor.getName());
        System.out.println(indexDonor.getCard_Number());
      }
    }
  }

  public void DisplayVetData(int vetIdInt)
  {
    for (Vet indexVet : Vet.registeredVet) {
      if (indexVet.getVetId() == vetIdInt)
      {
        System.out.println(indexVet.getVetId());
        System.out.println(indexVet.getName());
        System.out.println(indexVet.getYrs_exp());
      }
    }
  }

  public void DisplayPetData(int petIDint)
  {
    for (Pet indexPet : Pet.shelteredPets) {
      if (indexPet.getID() == petIDint) {
        System.out.println(indexPet.getID());
        System.out.println(indexPet.getName());
        System.out.println(indexPet.getAge());
        System.out.println(indexPet.getType());
        System.out.println(indexPet.getAdoptionStatus());
        System.out.println(indexPet.getTreatmentStatus());
      }
    }
  }

  public void DisplayReadyForAdoptionPets()
  {
    for(Pet item : Pet.ReadyPets )
    {
      System.out.println("Pet Number " +item.getID()+ "Pet Name" + item.getName() + " Pet Type " +item.getType());
    }

  }

  public void CalculateDonated()
  {
    int sumDonated = Donor.SumMoney;
    System.out.println("The Total Donated Money = "+ sumDonated);
  }

  public void UpdatePetData(int petIDint)
  {
    for (Pet itemPet : Pet.shelteredPets) {
      if (itemPet.getID() == petIDint)
      {
        System.out.println("Enter Pet Name:");
        itemPet.setName(scanner.nextLine());

        System.out.println("Enter Pet Age:");
        itemPet.setAge(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter Pet Type (CAT or DOG): ");
        String petTypeInput = scanner.nextLine();
        Pet_type petType = Pet_type.valueOf(petTypeInput.toUpperCase());
        itemPet.setType(petType);

        System.out.println("Enter Pet Adoption Status (Adopted or Not_Adopted):");
        String petAdoptionStatusInput = scanner.nextLine();
        Adoption_status adoptionStatus = Adoption_status.valueOf(petAdoptionStatusInput.toUpperCase());
        itemPet.setAdoptionStatus(adoptionStatus);

        System.out.println("Enter Pet Treatment Status (Sick, recovering, or treated):");
        String petTreatmentStatusInput = scanner.nextLine();
        Treatment_Status treatmentStatus = Treatment_Status.valueOf(petTreatmentStatusInput.toUpperCase());
        itemPet.setTreatmentStatus(treatmentStatus);

        String petReadyforAdoptionStatusInput = scanner.nextLine();
        Ready_for_adoption_status ready_for_adoption_status = Ready_for_adoption_status
                .valueOf(petReadyforAdoptionStatusInput);
        itemPet.setReadyForAdoptionStatus(ready_for_adoption_status);
      }
    }
  }

  @Override
  public void Register(User user) throws RegisterException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'Register'");
  }

}
