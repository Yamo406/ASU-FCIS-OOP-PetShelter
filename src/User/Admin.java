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

  public void DisplayAvailableOperationSlots(int roomIDint)
  {
   for (operation operation : roomIDint) {
    
   }
    
  }

  public void DisplayDonorData(int donorIDInt)
  {
    Donor donor = new Donor(name, password, 0);
    for (Donor indexDonor : registeredDonor) {
      if (indexDonor.getDonor_ID() == donorIDInt) {
          indexDonor.getDonor_ID();
          indexDonor.getName();
          indexDonor.getCard_Number();
      }
    }
  }

  public void DisplayVetData(int vetIdInt)
  {
    for (Vet indexVet : registeredVet) {
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
    for (Pet indexPet : shelteredPets) {
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
    for(Pet item : Pet.Readypets )
    {
       System.out.println("Pet Number " +item.getID()+ "Pet Name" + item.getName() + " Pet Type " +item.getType());
    }

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