package model1;
import model2.Booth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static model2.Application.booths;

public class ArrayVersion {

    public static int boothNum;
    public static String boothName;
    static int vaccines = 150;
    public static int addVac;
    public static int boothDelete;
    static String findBoothToPatient;


    //created the global arraylist.
    public static String[] boothRef = new String[6];
    public static String[] Surname = new String[6];
    public static long[] NIC = new long[6];
    public static Integer[] Age = new Integer[6];
    public static String[] City = new String[6];
    public static String[] VaccinationType = new String[6];


    static ArrayList sortedBoothNames;
    static String name;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {         //within the main method performs some I/O related tasks, and to make sure that the program does not crash owing to some I/O related issues
        initialise();                                                   //main class  for (int x = 0; x < 6; x++ ) hotel[x] = ""; //better to initialise in a procedure
        menu();
        booths[0] = new Booth("empty");
        booths[1] = new Booth("empty");
        booths[2] = new Booth("empty");
        booths[3] = new Booth("empty");
        booths[4] = new Booth("empty");
        booths[5] = new Booth("empty");//execute the menu method.
    }

    static void initialise() {
        System.out.println("<<< Initialise >>>");
        for (int x = 0; x < boothRef.length; x++) {
            boothRef[x] = "empty";
            System.out.println("Booth " + x + " is empty");
        }
    }

    static void menu() throws IOException {//created the method called menu for stored the methods which prompt from the user.

        while (true) {
            System.out.println("\n");
            System.out.print("Enter \n " +
                    "100 0r VVB:   View all Vaccination Booths \n " +
                    "101 or VEB:   View all Empty Booths \n " +
                    "102 or APB:   Add Patient to a Booth \n " +
                    "103 or RPB:   Remove Patient from a Booth \n " +
                    "104 or VPS:   View Patients Sorted in alphabetical order \n " +
                    "105 or SPD:   Store Program Data into file\n " +
                    "106 or LPD:   Load Program Data from file \n " +
                    "107 or VRV:   View Remaining Vaccinations \n " +
                    "108 or AVS:   Add Vaccinations to the Stock \n " +
                    "999 or EXT:   Exit the Program");

            String choice = input.next();
            System.out.println("\n");

            if (choice.equals("999") || (choice.equals("EXT"))) {
                break;
            } else {
                switch (choice) {
                    case "100":
                    case "VVB": {
                        System.out.println("---View all Vaccination Booths---");
                        viewAllVaccinationBooths(); //method for viewing all Vaccination Booths
                        break;
                    }
                    case "101":
                    case "VEB": {
                        System.out.println("---View all Empty Booths---");
                        viewAllEmptyBooths(); //method for viewing empty booths
                        break;
                    }
                    case "102":
                    case "APB": {
                        System.out.println("---Add Patient to a Booth--");
                        FindBoothToPatient(); //method for adding patients to booths
                        break;
                    }
                    case "103":
                    case "RPB": {
                        System.out.println("---Remove Patient from a Booth---");
                        removePatient(); //method for remove patients
                        break;
                    }
                    case "104":
                    case "VPS": {
                        System.out.println("---View Patients Sorted in alphabetical order---");//method for view patients  alphabetically by name.
                        viewPatient(); //method for view patients
                        break;
                    }
                    case "105":
                    case "SPD": {
                        System.out.println("---Store Program Data into file---");
                        storeData(); //method for store data
                        break;
                    }
                    case "106":
                    case "LPD": {
                        System.out.println("---Load Program Data from file---");
                        loadData(); //method for load data
                        break;
                    }
                    case "107":
                    case "VRV": {
                        System.out.println("---View Remaining Vaccinations---");
                        viewRemainVaccinations(); //method for viewing remaining stocks
                        break;
                    }
                    case "108":
                    case "AVS": {
                        System.out.println("---Add Vaccinations to the Stock---");
                        addVaccinations(); //method for adding new stock
                        break;
                    }
                    default:
                        System.out.println("*** Invalid input ***");
                        break;
                }

            }
        }
    }

    public static void addPatient() {                                               //method for add a customer to a room.
        System.out.print("Please Re-enter the number: ");
        boothNum = input.nextInt();

        for (int j = 0; j < 1; j++) {
            if ((boothNum > 6) || (boothNum < 0)) {
                System.out.println("<<<You wanted to exit or you've entered an invalid number>>>");
                break;
            } else {

                System.out.print("ENTER YOUR FIRST NAME TO THE BOOTH NUMBER " + boothNum + ": ");
                boothName = input.next();
                boothRef[boothNum] = boothName;

                //reduce vaccination from the stock
                vaccines -= 1;

                System.out.print("ENTER YOUR SURNAME: ");
                String surname = input.next();
                Surname[boothNum] = surname;

                System.out.print("ENTER YOUR AGE: ");
                int age = input.nextInt();
                Age[boothNum] = age;

                System.out.print("ENTER YOUR CITY: ");
                String city = input.next();
                City[boothNum] = city;


                System.out.print("ENTER YOUR NIC OR PASSPORT NUMBER: ");
                long nic = input.nextLong();
                NIC[boothNum] = nic;

                System.out.print("ENTER THE VACCINATION TYPE THAT YOU HAVE REQUESTED: ");
                String VacType = input.next();
                VaccinationType[boothNum] = VacType;

            }

        }
    }


    public static void viewAllVaccinationBooths() {                                                    //method for view all rooms.
        for (int x = 0; x < 6; x++) {
            System.out.println("BOOTH NUMBER " + x + " OCCUPIED BY " + boothRef[x]);
        }
    }

    public static void viewAllEmptyBooths() {                                                //method for display empty rooms.
        for (int x = 0; x < 6; x++) {
            if (boothRef[x].equals("empty")) {
                System.out.println("BOOTH NUMBER " + x + " IS EMPTY");
            }
        }
    }

    public static void removePatient() {                                                   //method for delete customer from room.
        System.out.print("ENTER THE BOOTH NUMBER, WHICH YOU WANT TO ERASE PATIENT'S DETAILS : ");
        boothDelete = input.nextInt();

        boothRef[boothDelete] = "empty";
        Surname[boothDelete] = "";
        Age[boothDelete] = 0;
        City[boothDelete] = "";
        NIC[boothDelete] = 0;
        VaccinationType[boothDelete] = "";

    }

    public static void storeData() throws IOException {
        try {
            FileWriter Writer = new FileWriter("store.txt");

            for (int x = 0; x < 6; x++) {
                Writer.write("ROOM " + x + " OCCUPIED BY " + boothRef[x] + "\n");


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


    public static void viewRemainVaccinations() {
        if (vaccines == 20) {
            System.out.println(" WARNING: UPDATE THE STOCK. STOCK HAS REACHED TO 20!!! ");
        } else {
            System.out.println("REMAINING NUMBER OF VACCINATIONS :" + vaccines);

        }
    }

    public static void addVaccinations() {

        System.out.println("ENTER THE NEWLY ADDED STOCK AMOUNT: ");
        System.out.println(" ");
        addVac = input.nextInt();

        //Update
        vaccines += addVac;
        System.out.println("TOTAL VACCINATION AMOUNT: " + vaccines);

    }

    public static void viewPatient() {//method for view the guests ordered alphabetically by name.

        ArrayList<String> sortedBoothNames = new ArrayList<>(Arrays.asList(boothRef));
        for (int i = 0; i < sortedBoothNames.size() - 1; i++) {
            for (int j = i + 1; j < sortedBoothNames.size() - 1; j++) {
                //compares each elements of the array to all the remaining elements
                if (sortedBoothNames.get(i).compareTo(sortedBoothNames.get(j)) > 0) {   //swapping array elements
                    String temp = sortedBoothNames.get(i);
                    sortedBoothNames.set(i, sortedBoothNames.get(j));
                    sortedBoothNames.set(j, temp);
                }
            }
        }

        for (int x = 0; x < 6; x++) {
            if (!(sortedBoothNames.get(x) == "empty")) {
                System.out.println(sortedBoothNames.get(x));
            }

        }
    }

    public static void FindBoothToPatient() { //method for find room from customer name.
        do {
            System.out.println("\n");
            System.out.print("Enter booth number (0-5) or 6 to stop: \n " +
                    "Booth 0 & 1: AstraZeneca \n " +
                    "Booth 2 & 3: Sinopharm   \n " +
                    "Booth 4 & 5: Pfizer      \n ");

            boothNum = input.nextInt();
            System.out.println("\n");
        } while ((boothNum == 6));
            for (int x = 0; x < 1; x++) {
                  if ((boothNum == 0) || (boothNum == 1)) {
                      System.out.println("*** ASTRAZENECA ***");
                      booths[0] = new Booth("empty");
                      booths[1] = new Booth("empty");
                      addPatient();
                }
                  else if ((boothNum == 2) || (boothNum == 3)) {
                      System.out.println("*** SINOPHARM ***");
                      booths[2] = new Booth("empty");
                      booths[3] = new Booth("empty");
                      addPatient();

                }
                  else if ((boothNum == 4) || (boothNum == 5)) {
                      System.out.println("*** PFIZER ***");
                      booths[0] = new Booth("empty");
                      booths[1] = new Booth("empty");
                      addPatient();

                }
                  else {
                      System.out.println("Invalid Input");
                      continue;
                  }
            }
        }
    }







