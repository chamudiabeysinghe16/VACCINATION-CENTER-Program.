package model2;

import model.Patient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

import static model1.ArrayVersion.*;

public class VaccinationCenter {
    static Booth[] booths;
    static int vaccineStock=150;
    static Scanner input = new Scanner(System.in);
    static Queue<Patient> waitingList;
    static ArrayList sortedBoothNames;

    public VaccinationCenter() {
        booths = new Booth[6];
      //  waitingList = new Queue<>(6);

    }

    public VaccinationCenter(int noOfBooths,int sizeOfWaitingList) {
        booths = new Booth[noOfBooths];
      //  waitingList = new Queue<>(sizeOfWaitingList);

    }


    public VaccinationCenter(Booth[] booths) {
        this.booths = booths;
    }


    public static void initialise() {
        System.out.println(" ");
        System.out.println("<<< Initialise >>>");
        for (int x = 0; x < 6; x++) {
            boothRef[x] = "empty";
            System.out.println("Booth " + x + " is empty");
        }
    }



    public static void addPatient(int boothNum, Patient Patient){                                               //method for add a customer to a room.


        vaccineStock-=1;
        Booth booth = booths[boothNum];

        for(int j=0; j<1; j++) {
            if((boothNum<6) || (boothNum>0)) {
                booth.getPatientName().equals("empty");
                booth.setPatientName(Patient.getFirstname());



            }
            else {
                //waitingList.enqueue(Patient);
                System.out.println("<<<You wanted to exit or you've entered an invalid number>>>");
                break;

            }

        }
    }

    public static void viewAllVaccinationBooths() {                                                    //method for view all rooms.
        for (int x = 0; x < 6; x++) {
            System.out.println("Booth number " + x + " is occupied by " + booths[x].getPatientName());

        }
    }

    public static void viewAllEmptyBooths() {                                                //method for display empty rooms.
        for (int x = 0; x < 6; x++) {
            if (booths[x].getPatientName().equals("empty")) {
                System.out.println("Booth " +x+ " is empty");
            }
        }
    }


    public static void removePatient() {

        System.out.println(" ");
        System.out.print("ENTER THE BOOTH NUMBER, WHICH YOU WANT TO ERASE PATIENT'S DETAILS : ");
        boothDelete = input.nextInt();

        booths[boothDelete].setPatientName("empty");
        booths[boothDelete].setSurname("");
        booths[boothDelete].setBoothNum(0);
        booths[boothDelete].setVaccinationType("");
        booths[boothDelete].setAge(0);
        booths[boothDelete].setCity("");
        booths[boothDelete].setNIC(0);


/*
        //method for delete customer from room.
        if (!waitingList.isEmpty()){
            Patient patient = waitingList.dequeue();
            booths[boothDelete].setPatientName(patient.getFirstname());
            booths[boothDelete].setVaccinationType(patient.getVaccinationRequested());
        } else {
            booths[boothDelete].setPatientName("empty");
        }

*/

    }

    public static void storeData() throws IOException {
        try {
            FileWriter Writer = new FileWriter("store.txt");
            for (int x = 0; x < 6; x++ ){
                Writer.write("Booth " + x + " occupied by " + booths[x].getPatientName() + "\n");
            }
            Writer.close();
            System.out.println("SUCCESSFULLY WROTE TO THE FILE");

        }
        //w3schools
        catch (IOException e) {
            System.out.println("AN ERROR OCCURRED");
            e.printStackTrace();
        }
    }

    public static void loadData() throws FileNotFoundException {
        //method for load data into file.
        File f = new File("store.txt");
        Scanner sc = new Scanner(f);
        while ((sc.hasNext())) {
            System.out.println(sc.nextLine());
        }
    }


    public static void viewRemainVaccinations () {
        if (vaccineStock == 20) {
            System.out.println(" WARNING: UPDATE THE STOCK. STOCK HAS REACHED TO 20!!! ");
        } else {
            System.out.println("REMAINING NUMBER OF VACCINATIONS :" + vaccineStock);

        }
    }
    public static void addVaccinations () {
        System.out.println(" ");

        System.out.print("ENTER THE NEWLY ADDED STOCK AMOUNT: ");
        addVac = input.nextInt();
        System.out.println(" ");

        //Update
        vaccineStock += addVac;
        System.out.println("TOTAL VACCINATION AMOUNT: " + vaccineStock);

    }
    public static void viewPatient () {//method for view the guests ordered alphabetically by name.

        ArrayList<Booth> sortedBoothNames = new ArrayList<Booth>(Arrays.asList(booths));
        for(int i = 0; i< sortedBoothNames.size()-1; i++)
        {
            for (int j = i+1; j< sortedBoothNames.size()-1; j++)
            {
//compares each elements of the array to all the remaining elements
                if(sortedBoothNames.get(i).getPatientName().compareTo(sortedBoothNames.get(j).getPatientName())>0)
                { //swapping array elements
                    Booth temp = sortedBoothNames.get(i);
                    sortedBoothNames.set(i,sortedBoothNames.get(j));
                    sortedBoothNames.set(j,temp);
                }
            }
        }
        for (int x = 0; x < 6; x++ ){
            if (!(sortedBoothNames.get(x).getPatientName()=="empty")){
                System.out.println(sortedBoothNames.get(x).getPatientName());
            }
        }
    }
}




