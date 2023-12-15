package User;
import Exceptions.*;
import Pet.*;
import Rooms.*;
import java.util.ArrayList;
import java.util.Scanner;
enum medicine
{
    FIRST_DOSE,FINAL_DOSE
}
public class Vet extends User {
    private int yrs_exp;
    private int vetId;
    private ArrayList<Pet> pets= new ArrayList<>();

    private static int no_Vets=0;
    protected static ArrayList<Vet> registeredVet= new ArrayList<>();

    public int getYrs_exp() {
        return yrs_exp;
    }

    public int getVetId() {
        return vetId;
    }

    public Vet(){super();}
    public Vet(String username, String password, int yrs_exp) {
        super(username, password);
        this.yrs_exp = yrs_exp;
        this.vetId = no_Vets+200;
        no_Vets++;
    }
    public void prescription(int pet_id) throws PetDoesnotExistException {
        boolean found=false;
        for (Pet item:pets)
        {
            if(item.getID()==pet_id)
            {
                found=true;
                if(item.getTreatmentStatus()== Treatment_Status.SICK)
                {
                    System.out.println("This pet needs"+medicine.FIRST_DOSE);
                }
                else if(item.getTreatmentStatus()== Treatment_Status.RECOVERING)
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
                   Pet.Readypets.add(p);

                }

            }
        }
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
                System.out.println("Please enter your years of experience");
                Scanner inf= new Scanner(System.in);
                int yr_exp= inf.nextInt();
                registeredVet.add(new Vet(user.getName(), user.getPassword(), yr_exp));
            }
        }
    }
}
