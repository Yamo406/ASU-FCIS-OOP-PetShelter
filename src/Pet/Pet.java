import java.util.ArrayList;

public class Pet implements Comparable
{
    private String name;
    private int ID;
    private Pet_type type;
    private int age;
    private Adoption_status AdoptionStatus;
    private Ready_for_adoption_status ReadyForAdoptionStatus;
    private Treatment_Status TreatmentStatus;
    public static ArrayList<Pet> shelteredPets=new ArrayList<>();
    public Pet(String name, int ID, Pet_type type, int age, Adoption_status adoptionStatus, Ready_for_adoption_status readyForAdoptionStatus, Treatment_Status treatmentStatus) {
        this.name = name;
        this.ID = ID;
        this.type = type;
        this.age = age;
        AdoptionStatus = adoptionStatus;
        ReadyForAdoptionStatus = readyForAdoptionStatus;
        TreatmentStatus = treatmentStatus;
        shelteredPets.add(this);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public Pet_type getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public Adoption_status getAdoptionStatus() {
        return AdoptionStatus;
    }

    public Ready_for_adoption_status getReadyForAdoptionStatus() {
        return ReadyForAdoptionStatus;
    }

    public Treatment_Status getTreatmentStatus() {
        return TreatmentStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setType(Pet_type type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAdoptionStatus(Adoption_status adoptionStatus) {
        AdoptionStatus = adoptionStatus;
    }

    public void setReadyForAdoptionStatus(Ready_for_adoption_status readyForAdoptionStatus) {
        ReadyForAdoptionStatus = readyForAdoptionStatus;
    }

    public void setTreatmentStatus(Treatment_Status treatmentStatus) {
        TreatmentStatus = treatmentStatus;
    }
    @Override
    public int compareTo(Object o) {
        Pet target= (Pet) o;
        if(this.getID()==target.getID())
        {
            return 0;
        }
        else if (this.getID()>target.getID())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }}
