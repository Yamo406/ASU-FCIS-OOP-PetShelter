package User;

import Exceptions.*;
import java.util.*;
import java.io.*;
import Pet.*;
import Rooms.*;

public class Admin extends User
{

  public Admin (){ super();}
  public Admin(String name, String password) 
  {
    super(name, password);
  }

  Scanner scanner = new Scanner(System.in);
  public void AddPets()
  {
    String filePath = "Pet/petsData.txt";
    try 
    {
      FileWriter fileWriter = new FileWriter(filePath);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      Pet pet = new Pet(filePath, null, 0, null, null, null);
      System.out.println("Please inter the data of the pet.");
      System.out.println("Pet Name:");
      pet.setName(scanner.nextLine());
      System.out.println("Pet Age:");
      pet.setAge(scanner.nextInt());
      System.out.println("Pet Type:");
      pet.setType(scanner.nextLine());
      System.out.println("Pet Adoption Status:");
      pet.setAdoptionStatus(scanner.nextLine());
      System.out.println("Pet Treatment Status:");
      pet.setTreatmentStatus(scanner.nextLine());
 
    } catch (Exception e) {
    }
  }

  public void DeleteEntity()
  {
    char answer;
    System.out.println("Delete this entitiy?");
    do 
    {
      System.out.println("Please enter your choice: (y/n)");
      answer = scanner.next().charAt(0);

    } while (answer != 'y' || answer != 'Y' || answer != 'N' || answer != 'n');
    if (answer == 'y' || answer == 'Y')
    {
      // delete entity
      File inputFile = new File(filepath);
      File tempFile = new File();
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

      // display entities
      System.out.println("What do you want to delete?");
      System.out.println("1. Admin");
      System.out.println("2. Donor");
      System.out.println("3. User");
      System.out.println("4. Vet");
      System.out.println("5. Pet");
      System.out.println("6. Room");
      int deleteChoice = scanner.nextInt();
      switch (deleteChoice) {
        case 1:
          // display Admin File
          break;
        case 2:
          // display Donor File
          break;
        case 3:
          // display User File
          break;
        case 4:
          // display Vet File
          break;
        case 5:
          // display Pet File
          break;
        case 6:
          // display Room File
          break;
        default:
          break;
      }
      // choose index to delete
      System.out.println("Choose the index of the row you want to delete");
      int deleteIndex = scanner.nextInt();
     // after choosing the index it should begin rewriting into the new file
      int currentInt;
      while((currentInt = reader.read()) != 0)
      {
        int trimmedInt = currentInt.trim();
        if (trimmedInt = ) {
   
        }
      }
      inputFile.delete();
      boolean successful = tempFile.renameTo(inputFile);
    }
    else if (answer == 'N' || answer == 'n')
    {
      // return back
    }
  }

  public void DisplayAvailableOperationSlots()
  {
  }

  public void DisplayDonorData(int donorIDInt)
  {
    for (Donor indexDonor : Donor.registeredDonor) {
      if (indexDonor.getDonor_ID() == donorIDInt) {
          indexDonor.getDonor_ID();
          indexDonor.getName();
          indexDonor.getCard_Number();
      }
    }
  }

  public void DisplayVetData(int vetIdInt)
  {
    for (Vet indexVet : Vet.registeredVet) {
      if (indexVet.getVetId() == vetIdInt)
      {
        indexVet.getVetId();
        indexVet.getName();
        indexVet.getYrs_exp();
      }
    }
  }
  
  public void DisplayPetData(int petIDint)
  {
    for (Pet indexPet : Pet.shelteredPets) {
      if (indexPet.getID() == petIDint) {
        indexPet.getID();
        indexPet.getName();
        indexPet.getAge();
        indexPet.getType();
        indexPet.getAdoptionStatus();
        indexPet.getTreatmentStatus();

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

  public void CalulateDonated()
  {
    int sumDonated = 0;

    

  }

  public void UpdatePetData(int petIDint)
  {
    for (Pet itemPet : Pet.shelteredPets) {
      if (itemPet.getID() == petIDint)
      {
        itemPet.setName(scanner.nextLine());
        itemPet.setAge(scanner.nextInt());
        itemPet.setType(scanner.nextLine());
        itemPet.setAdoptionStatus(scanner.nextLine());
        itemPet.setTreatmentStatus(scanner.nextLine());
        itemPet.setReadyForAdoptionStatus(scanner.nextLine());
      }
    }
  }

  @Override
  public void Register(User user) throws RegisterException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'Register'");
  }
  
}