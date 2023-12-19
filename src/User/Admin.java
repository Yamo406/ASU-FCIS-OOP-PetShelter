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
      scanner.nextLine();

      System.out.println("Pet Type (Cat or Dog):");
      String petTypeString = scanner.nextLine().toUpperCase(); 
      Pet_type pet_type = Pet_type.valueOf(petTypeString);
      pet.setType(pet_type);
      
      System.out.println("Pet Adoption Status (Adopted or Not_Adopted):");
      String petAdoptionStatus = scanner.nextLine().toUpperCase();
      Adoption_status adoption_status = Adoption_status.valueOf(petAdoptionStatus);
      pet.setAdoptionStatus(adoption_status);

      System.out.println("Pet Treatment Status: (Sick, recovering, or treated)");
      String petTreatmentStatus = scanner.nextLine().toUpperCase();
      Treatment_Status treatment_Status = Treatment_Status.valueOf(petTreatmentStatus);
      pet.setTreatmentStatus(treatment_Status);

      bufferedWriter.write(pet.toString());
      bufferedWriter.newLine();

      bufferedWriter.close();
      fileWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void DeleteEntity(String filepath, int deleteLine)
  {
    char answer;
    System.out.println("Delete entitiy?");
    do 
    {
      System.out.println("Please enter your choice: (y/n)");
      answer = scanner.next().charAt(0);

    } while (answer != 'y' || answer != 'Y' || answer != 'N' || answer != 'n');
    if (answer == 'y' || answer == 'Y')
    {
      String tempFile = "temp.txt";
      File oldFile = new File(filepath);
      File newFile = new File(tempFile);
      int line = 0;
      String currentLine;
      try {
        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);

        while((currentLine = br.readLine()) != null)
        {
          line++;

          if (deleteLine != line) {
            pw.println(currentLine);
          }
        }

        pw.flush();
        pw.close();
        fr.close();
        br.close();
        bw.close();
        fw.close();

        oldFile.delete();
        File dump = new File(filepath);
        newFile.renameTo(dump);

      } catch (Exception e) {
        System.out.println("Error in deleting line");
      }

    }
    else if (answer == 'N' || answer == 'n')
    {
      System.out.println("Okay! Exiting the program");
      System.exit(1);
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