package User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
enum medicine
{
    FIRST_DOSE,FINAL_DOSE
}
public class Vet extends User {
    private int yrs_exp;
    private int vetId;
    public ArrayList<Pet> pets= new ArrayList<>(20);
    private static int no_Vets=0;
    public static ArrayList<Vet> registeredVet= new ArrayList<>();

    public int getYrs_exp() {
        return yrs_exp;
    }

    public int getVetId() {
        return vetId;
    }
    public Vet()
    {
        super();
    }
    public Vet(String username,String password,int yrs_exp)
    {
        super(username, password);
        this.vetId = no_Vets;
        no_Vets++;
        this.yrs_exp= yrs_exp;
    }

    public Vet(String username, String password)
    {
        super(username, password);
        this.vetId = no_Vets;
        no_Vets++;
        System.out.println("Please enter your years of experience");
        Scanner inf= new Scanner(System.in);
        this.yrs_exp= inf.nextInt();
    }
    public void prescription(int pet_id) throws PetDoesnotExistException {
        boolean found=false;
        for (Pet item:pets)
        {
            if(item.getID()==pet_id)
            {
                found=true;
                if(item.getTreatmentStatus()==Treatment_Status.SICK)
                {
                    System.out.println("This pet needs"+medicine.FIRST_DOSE);
                }
                else if(item.getTreatmentStatus()==Treatment_Status.RECOVERING)
                {
                    System.out.println("This pet needs"+medicine.FINAL_DOSE);
                }
                else
                {
                    System.out.println("This pet is already treated");
                }
            }
        }
        if(!found)
        {
            throw new PetDoesnotExistException();
        }
    }
    public void reserveOperationRoom()
    {
        System.out.println("Choose a Room to reserve in");
        Scanner input= new Scanner(System.in);
        int reserved=input.nextInt();
        if(!operation.availableRoom.get(reserved).isReserved())
        {
            operation.availableRoom.get(reserved).isReserved();
            System.out.println("Choose a slot to take an appointment in");
            int appointed=input.nextInt();
            operation.availableRoom.get(reserved).reserveSlot(appointed);
        }
    }
    public void addPet(int pet_ID) throws PetLimitException,PetDoesnotExistException
    {
        boolean found=false;
        for(Pet item: Pet.shelteredPets)
        {
            int i=0;
            if (i>=20)
            {
                throw new PetLimitException();
            }
            else
            {
                if(item.getID()==pet_ID)
                {
                    pets.add(item);
                    found=true;
                }
            }
            i++;
        }
        if(!found)
        {
            throw new PetDoesnotExistException();
        }
    }

    public void updatePetStatus(Pet p,Treatment_Status TS)
    {
        for(Pet item:pets)
        {
            if(item.compareTo(p)==0)
            {
                if(TS == Treatment_Status.TREATED)
                {
                    p.setReadyForAdoptionStatus(Ready_for_adoption_status.READY);

                }

            }
        }
    }
    @Override
    public void Register(User user) throws RegisterException {
        Vet v = (Vet) user;

        for(User item:registeredVet)
        {
            if ((v.compareTo(item)==0))
            {
                throw new RegisterException();
            }
        }
        registeredUser.add(v);
        registeredVet.add(v);
    }

    public void setYrs_exp(int yrs_exp) {
        this.yrs_exp = yrs_exp;
    }

    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public static void setNo_Vets(int no_Vets) {
        Vet.no_Vets = no_Vets;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public static int getNo_Vets() {
        return no_Vets;
    }
}
