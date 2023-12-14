package User;
import Pet.Pet;
public class Vet extends User {
    private int yrs_exp; //years of experience
    private int vetId;
    private Pet[] pets;

    public Vet(String username, String password, int yrs_exp, int vetId) {
        super(username, password);
        this.yrs_exp = yrs_exp;
        this.vetId = vetId;
        this.pets = new Pet[20];
    }

    public void Login(){

    }

    public void prescription(int pet_id,Donation donation)
    {


    }

    public void requestAppointment() {


    }

    public void addPet(Pet pet) {
        //check if there's space to add the pet




    }

    static int readyPets =0; // number of ready for adoption pets

    public void updatePetStatus(Pet p,Treatment_Status TS)
    {
        for(Pet item:pets)
        {
            if(item.compareTo(p)==0)
            {
                if(TS == Treatment_Status.Treated)
                {
                    p.setReadyForAdoptionStatus(Pet.Ready_for_adoption_status.Ready);
                    readyPets ++;

                }

            }
        }
    }
}