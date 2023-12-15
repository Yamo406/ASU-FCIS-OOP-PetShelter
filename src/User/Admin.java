package User;

import java.util.*;
import java.io.*;
import Pet.*;
import Rooms.*;

public class Admin extends User
{

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
      
      System.out.println("Please inter the data of the pet.");
      System.out.println("Pet Name:");
      scanner.nextLine();

    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  public void DeleteEntity()
  {
    char answer;
    System.out.println("Delete this entitiy?");
    do 
    {
      System.out.println("Please enter your choice: ");
      answer = scanner.next().charAt(0);

    } while (answer != 'y' || answer != 'Y' || answer != 'N' || answer != 'n');
    if (answer == 'y' || answer == 'Y')
    {
      // delete entity
    }
    else if (answer == 'N' || answer == 'n')
    {
      // return back
    }
  }

  public void DisplayAvailableOperationSlots(String )
  {
    operation operation = new operation();
    return operation.displayAvailableRooms();
    
  }

  public void DisplayDonorData()
  {
    Donor donor = new Donor(name, password, 0);
    donor.getDonor_ID();
    donor.getName();
    donor.getCard_Number();
  }

  public void DisplayVetData()
  {
    Vet vet = new Vet(name, password, 0);
    vet.getVetId();
    vet.getName();
    vet.getYrs_exp();
  }

  public void DisplayPetData()
  {
    Pet pet = new Pet(name, null, 0, null, null, null);
    pet.getID;
    pet.getName();
    pet.getAge();
    pet.getType();
    pet.getAdoptionStatus();
    pet.getTreatmentStatus();

  }

  public void DisplayReadyForAdoptionPets()
  {
    Pet pet = new Pet(name, null, 0, null, null, null);
    pet.getReadyForAdoptionStatus();

  }

  public void CalulateDonated()
  {
    int sumDonated = 0;
    

  }

  public void UpdatePetData()
  {
    Pet pet = new Pet(name, null, 0, null, null, null);
    pet.setID(0);
    pet.setName(name);
    pet.setAge(0);
    pet.setType(null);
    pet.setAdoptionStatus(null);
    pet.setTreatmentStatus(null);
  }

  @Override
  public void Register(User user) throws RegisterException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'Register'");
  }
  
}