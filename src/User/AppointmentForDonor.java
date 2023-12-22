package User;

import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentForDonor  {
    private int startTime;
    private int endtTime;
    private String Day;

    private ArrayList<AppointmentForDonor> Scheduler = new ArrayList<>();

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setEndtTime(int endtTime) {
        this.endtTime = endtTime;
    }

    public int getEndtTime() {
        return endtTime;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getDay() {
        return Day;
    }

    public void MakeAppoint (AppointmentForDonor app)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Appointment StartTime");
        int start = input.nextInt();
        app.setStartTime(start);
        System.out.println("Please Enter Appointment EndTime");
        int End = input.nextInt();
        app.setEndtTime(End);
        System.out.println("Please Enter Appointment Day");
        String Day = input.next();
        app.setDay(Day);

    }

    public boolean checkAvailability(AppointmentForDonor app)
    {
        if(Scheduler.contains(app))
        {
            System.out.println("Not Available Appointment......Please Choose Another One ");
            return false;
        }
        else{
            Scheduler.add(app);
            System.out.println(" Thank You For Your Help.....We are waiting you ^_^ ");
            return true;
        }
    }



}