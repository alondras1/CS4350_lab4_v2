package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object

//        String conURL = "jdbc:mysql://localhost:3306/cs4350_lab4";
//        String user = "root";
//        //          SQL statements
//        String display_bus = "SELECT * FROM Bus";
//
//        make_connection();

        int user_selection;

        do {
//            show the menu
            menu();

//           ask for user selection
            System.out.println("make your selection: ");
            user_selection = input.nextInt();


//            evaluate user input with switch case
            switch (user_selection){
                case 1:
//                    call display function
                    displaySchedule();
                    break;
                case 2:
//                    delete a trip
                    deleteTripOffering();
                    break;
                case 3:
//                    Add a Trip Offering
                    addTripOffering();
                    break;
                case 4:
//                    Change a Driver
                    changeDriver();
                    break;
                case 5:
//                    Change a Bus
                    changeBus();
                    break;
                case 6:
//                    Display Trip Stops
                    displayTripStops();
                    break;
                case 7:
//                    Display Weekly Schedule for Driver
                    dispWeeklySchedule();
                    break;
                case 8:
//                    Add a Driver
                    addDriver();
                    break;
                case 9:
//                    Add a Bus
                    addBus();
                    break;
                case 10:
//                    Delete a Bus
                    deleteBus();
                    break;
                case 11:
//                    Insert Actual Trip Info
                    insert_Actual_TripInfo();
                    break;
            }

        }while (user_selection != 0);
    }

    private static void make_connection() {
        String conURL = "jdbc:mysql://localhost:3306/cs4350_lab4";
        String user = "root";
        String password = "Pemd@sislife!12";
        try {

            // get connection
            Connection myConn = DriverManager.getConnection(conURL, user, password);

            // create statement
            Statement mystatement = myConn.createStatement();

        } catch (Exception exc) {
            exc.printStackTrace();


        }
    }

    private static void menu(){
        System.out.println("1:\tDisplay a Schedule\n"
                +"2:\tDelete a Trip Offering\n"
                +"3:\tAdd a Trip Offering\n"
                +"4:\tChange a Driver\n"
                +"5:\tChange a Bus\n"
                +"6:\tDisplay Trip Stops\n"
                +"7:\tDisplay Weekly Schedule for Driver\n"
                +"8:\tAdd a Driver\n"
                +"9:\tAdd a Bus\n"
                +"10:\tDelete a Bus\n"
                +"11:\tInsert Actual Trip Info\n"
                +"x:\tExit program\n"
        );
    }

    /**
     * 1. Display the schedule of all trips for a given StartLocationName and Destination Name,
     * and Date
     * addition to these attributes, the schedule includes: Scheduled StartTime,ScheduledArrivalTime , DriverID, and BusID
     * */
    public static void displaySchedule(){}

    /**
     * 2. Delete a trip offering specified by Trip#, Date, and ScheduledStartTime
     * */
    public static void deleteTripOffering(){}

    /**
     * 3. Add a set of trip offerings assuming the values of all attributes are given (the software
     * asks if you have more trips to enter)
     * */
    public static void addTripOffering(){}

    /**
     * 4. Change the driver for a given Trip offering (i.e given TripNumber, Date,
     * ScheduledStartTime)
     * */
    public static void changeDriver(){}

    /**
     * 5. Change the bus for a given Trip offering
     * */
    public static void changeBus(){
        String oldBusID = "";
        String newBusID = "";
        String tripOffering = "";
        System.out.println("Please provide the TripID whose bus you'd like to change: ");

        System.out.println("Please provide the new BusID: ");
    }

    /**
     * 6. Display the stops of a given trip ( i.e. the attributes of the table TripStopInfo)
     * */
    public static void displayTripStops(){}

    /**
     * 7. Display the weekly schedule of a given driver and date
     * */
    private static void dispWeeklySchedule(){}

    /**
     * 8. Add a driver
     * */
    private static void addDriver(){}

    /**
     * 9. Add a bus
     * */
    private static void addBus(){}

    /**
     * 10. Delete a bus
     * */
    private static void deleteBus(){}

    /**
     * 11. Record (insert) the actual data of a given trip offering specified by its key. The actual
     * data include the attributes of the table ActualTripStopInfo
     * */
    private static void insert_Actual_TripInfo(){}

}
