
public class Pet
{
    private String name;
    private int ID;
    private Pet_type type;
    private int age;
    private Adoption_status AdoptionStatus;
    private Ready_for_adoption_status ReadyForAdoptionStatus;
    private Treatment_Status TreatmentStatus;

    public Pet()
    {

    }

    public Pet(String name, int ID, Pet_type type, int age, Adoption_status adoptionStatus, Ready_for_adoption_status readyForAdoptionStatus, Treatment_Status treatmentStatus) {
        this.name = name;
        this.ID = ID;
        this.type = type;
        this.age = age;
        AdoptionStatus = adoptionStatus;
        ReadyForAdoptionStatus = readyForAdoptionStatus;
        TreatmentStatus = treatmentStatus;
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
}

