package model2;

import model.Patient;

import java.io.IOException;
import java.util.Scanner;

import static model1.ArrayVersion.boothNum;

public class Application {

    static Scanner input = new Scanner(System.in);
    public static Booth[] booths = new Booth[6];

    public static void main(String[] args) throws IOException {
        booths[0] = new Booth("empty");
        booths[1] = new Booth("empty");
        booths[2] = new Booth("empty");
        booths[3] = new Booth("empty");
        booths[4] = new Booth("empty");
        booths[5] = new Booth("empty");

        VaccinationCenter vaccinationCenter = new VaccinationCenter(booths);

        VaccinationCenter.initialise();


        while (true) {
            System.out.println("\n");
            System.out.print(" 100 0r VVB:   View all Vaccination Booths \n " +
                    "101 or VEB:   View all Empty Booths \n " +
                    "102 or APB:   Add Patient to a Booth \n " +
                    "103 or RPB:   Remove Patient from a Booth \n " +
                    "104 or VPS:   View Patients Sorted in alphabetical order \n " +
                    "105 or SPD:   Store Program Data into file\n " +
                    "106 or LPD:   Load Program Data from file \n " +
                    "107 or VRV:   View Remaining Vaccinations \n " +
                    "108 or AVS:   Add Vaccinations to the Stock \n " +
                    "999 or EXT:   Exit the Program \n" +
                    "              \n " +
                    "Enter your choice: ");

            String choice = input.next();
            System.out.println("\n");

            if (choice.equals("999") || (choice.equals("EXT"))) {
                break;
            }
            else {

                switch (choice) {
                    case "100":
                    case "VVB": {
                        System.out.println("---View all Vaccination Booths---");
                        VaccinationCenter.viewAllVaccinationBooths(); //method for viewing all Vaccination Booths
                        break;
                    }
                    case "101":
                    case "VEB": {
                        System.out.println("---View all Empty Booths---");
                        VaccinationCenter.viewAllEmptyBooths(); //method for viewing empty booths
                        break;
                    }
                    case "102":
                    case "APB": {
                        System.out.println("---Add Patient to a Booth--");
                        System.out.println(" ");

                        System.out.print("Enter booth number (0-5) or 6 to stop: ");
                        boothNum = input.nextInt();

                        System.out.print("ENTER YOUR FIRST NAME TO THE BOOTH NUMBER " + boothNum + ": ");
                        String firstname = input.next();

                        System.out.print("ENTER YOUR SURNAME: ");
                        String surname = input.next();

                        System.out.print("ENTER YOUR AGE: ");
                        int age = input.nextInt();

                        System.out.print("ENTER YOUR CITY: ");
                        String city = input.next();

                        System.out.print("ENTER YOUR NIC OR PASSPORT NUMBER: ");
                        long nic = input.nextLong();

                        System.out.print("ENTER THE VACCINATION TYPE THAT YOU HAVE REQUESTED: ");
                        String vaccinationRequested = input.next();

                        Patient patient = new Patient(firstname, surname, age, city, nic, vaccinationRequested);

                        VaccinationCenter.addPatient(boothNum, patient);
                        break;
                    }



                    case "103":
                    case "RPB": {
                        System.out.println("---Remove Patient from a Booth---");
                        VaccinationCenter.removePatient(); //method for remove patients
                        break;
                    }

                    case "104":
                    case "VPS": {
                        System.out.println("---View Patients Sorted in alphabetical order---");//method for view patients  alphabetically by name.
                        VaccinationCenter.viewPatient(); //method for view patients
                        break;
                    }
                    case "105":
                    case "SPD": {
                        System.out.println("---Store Program Data into file---");
                        VaccinationCenter.storeData(); //method for store data
                        break;
                    }
                    case "106":
                    case "LPD": {
                        System.out.println("---Load Program Data from file---");
                        VaccinationCenter.loadData(); //method for load data
                        break;
                    }
                    case "107":
                    case "VRV": {
                        System.out.println("---View Remaining Vaccinations---");
                        VaccinationCenter.viewRemainVaccinations(); //method for viewing remaining stocks
                        break;
                    }
                    case "108":
                    case "AVS": {
                        System.out.println("---Add Vaccinations to the Stock---");
                        VaccinationCenter.addVaccinations(); //method for adding new stock
                        break;
                    }
                    default:
                        System.out.println("*** Invalid input ***");
                        break;
                }


            }


        }
    }
}


