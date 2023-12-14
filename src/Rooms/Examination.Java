public class Examination {
    private int roomId;
    private static int no_Examination_Rooms=0;
   private boolean reserved=false;
    public Examination(){roomId=no_Examination_Rooms;
    no_Examination_Rooms++;}
    public int getRoomId() {
        return roomId;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

   void displayAvailableRooms() {
          if(this.isReserved())
          {
              System.out.println("Room"+this.getRoomId()+"is not available");
          }
          else
          {
              System.out.println("Room"+this.getRoomId()+"is available");
          }
   }
}
