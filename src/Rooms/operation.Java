import java.util.ArrayList;

public class operation implements ShelterRoom{
    private int roomId;
    private static int no_Operation_Rooms=0;
    public ArrayList<Boolean> reservedSlots=new ArrayList<>(10);
    private boolean isReserved = false;
    public static ArrayList<operation> availableRoom = new ArrayList<>(3);
    public operation (){
        roomId=no_Operation_Rooms;
        for (boolean item : reservedSlots)
        {
            item=false;
        }
        no_Operation_Rooms++;
        availableRoom.add(this);
    }
    public int getRoomId() {
        return roomId;
    }
    public boolean isReserved() {
        boolean found=true;
        int i=0;
        for(boolean item: reservedSlots )
        {
            if(!item)
            {
                System.out.println("Slot number: "+(i+1)+"is available");
                found=false;
            }
            i++;
        }
        return found;
    }
        public void displayAvailableRooms() {
            for (operation room : availableRoom )
            {
                if (isReserved)
                {
                    System.out.println(" the room : id "+getRoomId()+"is already reserved");
                }
                else
                {
                    System.out.println("Available operation room id :"+ getRoomId());
                    isReserved();
                }

        }
    }
    public void reserveSlot(int index)
    {
        this.reservedSlots.set(index,true);
    }
}
