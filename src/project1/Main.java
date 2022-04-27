package project1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Statement mystatement;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);  // Create a Scanner object

        String conURL = "jdbc:mysql://localhost:3306/cs4350_lab4";
        String user = "root";
        String password = "";
        try {
            // get connection
            Connection myConn = DriverManager.getConnection(conURL, user, password);
            // create statement
            mystatement = myConn.createStatement();
//            ResultSet myres = mystatement.executeQuery("Select * FROM Driver");
//
//            while(myres.next()){
//                System.out.println(myres.getString("DriverName") + myres.getString("DriverTelephoneNumber"));
//            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

//        user selection
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
                    displaySchedule(mystatement);
                    break;
                case 2:
//                    delete a trip
                    deleteTripOffering(mystatement);
                    break;
                case 3:
//                    Add a Trip Offering
                    addTripOffering(mystatement);
                    break;
                case 4:
//                    Change a Driver
                    changeDriver(mystatement);
                    break;
                case 5:
//                    Change a Bus
                    changeBus(mystatement);
                    break;
                case 6:
//                    Display Trip Stops
                    displayTripStops(mystatement);
                    break;
                case 7:
//                    Display Weekly Schedule for Driver
                    dispWeeklySchedule(mystatement);
                    break;
                case 8:
//                    Add a Driver
                    addDriver(mystatement);
                    break;
                case 9:
//                    Add a Bus
                    addBus(mystatement);
                    break;
                case 10:
//                    Delete a Bus
                    deleteBus(mystatement);
                    break;
                case 11:
//                    Insert Actual Trip Info
                    insert_Actual_TripInfo(mystatement);
                    break;
            }

        }while (user_selection != 0);
    }

    private static Statement make_connection() {

        return null;
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
                +"0:\tExit program\n"
        );
    }

    /**
     * 1. Display the schedule of all trips for a given StartLocationName and Destination Name,
     * and Date
     * addition to these attributes, the schedule includes: Scheduled StartTime, ScheduledArrivalTime , DriverID , and BusID
     * */
    public static void displaySchedule(Statement mystatement) throws SQLException{

        ResultSet myres = mystatement.executeQuery("Select * FROM Driver");

        while(myres.next()){
            System.out.println(myres.getString("DriverName") + myres.getString("DriverTelephoneNumber"));
        }
    }

    /**
     * 2. Delete a trip offering specified by Trip#, Date, and ScheduledStartTime
     * */
    public static void deleteTripOffering(Statement mystatement) throws SQLException {
        ResultSet myres = mystatement.executeQuery("Select * FROM Driver");

        while(myres.next()){
            System.out.println(myres.getString("DriverName") + myres.getString("DriverTelephoneNumber"));
        }
    }

    /**
     * 3. Add a set of trip offerings assuming the values of all attributes are given (the software
     * asks if you have more trips to enter)
     * */
    public static void addTripOffering(Statement mystatement) throws SQLException{
        ResultSet myres = mystatement.executeQuery("Select * FROM Driver");

        while(myres.next()){
            System.out.println(myres.getString("DriverName") + myres.getString("DriverTelephoneNumber"));
        }
    }

    /**
     * 4. Change the driver for a given Trip offering (i.e given TripNumber, Date,
     * ScheduledStartTime)
     * */
    public static void changeDriver(Statement mystatement) throws SQLException{
        ResultSet myres = mystatement.executeQuery("Select * FROM Driver");

        while(myres.next()){
            System.out.println(myres.getString("DriverName") + myres.getString("DriverTelephoneNumber"));
        }
    }

    /**
     * 5. Change the bus for a given Trip offering
     * */
    public static void changeBus(Statement mystatement) throws SQLException{
        ResultSet myres = mystatement.executeQuery("Select * FROM Driver");

        while(myres.next()){
            System.out.println(myres.getString("DriverName") + myres.getString("DriverTelephoneNumber"));
        }
    }

    /**
     * 6. Display the stops of a given trip ( i.e. the attributes of the table TripStopInfo)
     * */
    public static void displayTripStops(Statement mystatement) throws SQLException{
        ResultSet myres = mystatement.executeQuery("Select * FROM Driver");

        while(myres.next()){
            System.out.println(myres.getString("DriverName") + myres.getString("DriverTelephoneNumber"));
        }
    }

    /**
     * 7. Display the weekly schedule of a given driver and date
     * */
    private static void dispWeeklySchedule(Statement mystatement) throws SQLException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the driver name: ");
        String driverName = input.nextLine();

//        surround driver name with %% to make sure it matches
        driverName = "'%"+ driverName + "%'";
//        format the query
        String query = String.format(   "SELECT * " +
                                        "FROM cs4350_lab4.Driver d " +
                                        "JOIN cs4350_lab4.TripOffering tof " +
                                        "ON d.DriverName = tof.DriverName " +
                                        "WHERE d.DriverName like %s", driverName
                                    );

//        execute the query
        ResultSet myres = mystatement.executeQuery(query);

//        display results
        while(myres.next()){
            System.out.println(myres.getString("DriverName")
                                + myres.getString("DriverTelephoneNumber")
                                + myres.getString("TripNumber"));
        }
    }

    /**
     * 8. Add a driver
     * */
    private static void addDriver(Statement mystatement) throws SQLException{
        Scanner input = new Scanner(System.in);

        System.out.println("What is the driver name: ");
        String driver_name = "'" + input.nextLine() + "'";

        System.out.println("Enter the driver's phone number: ");
        int driver_phone_number = input.nextInt();
        input.nextLine();

        String query =
                String.format("INSERT INTO cs4350_lab4.Driver(DriverName, DriverTelephoneNumber) " +
                                "VALUES (%s, %d);", driver_name, driver_phone_number);

        mystatement.executeUpdate(query);
    }

    /**
     * 9. Add a bus
     * */
    private static void addBus(Statement mystatement) throws SQLException{
        Scanner input = new Scanner(System.in);
        int BusID = 0;
        String Model = "";
        int Year = 2021;

        System.out.println("Enter an ID for bus: ");
        BusID = input.nextInt();
        input.nextLine();

        System.out.println("Enter model of the bus: ");
        Model = "'" + input.nextLine() + "'";

        System.out.println("Enter manufacture year: ");
        Year = input.nextInt();

        String query =
                String.format("INSERT INTO cs4350_lab4.Bus(BusID, Model, Year) " +
                                "VALUES (%d, %s, %d);", BusID, Model, Year);

        mystatement.executeUpdate(query);
    }

    /**
     * 10. Delete a bus
     * */
    private static void deleteBus(Statement mystatement) throws SQLException{
        Scanner input = new Scanner(System.in);

        System.out.println("input the bus ID to remove: ");
        int BusID = input.nextInt();
        input.nextLine();

        ResultSet myres = mystatement.executeQuery("Select * FROM Driver");

        String query =
                String.format("DELETE FROM cs4350_lab4.Bus WHERE BusID = %d", BusID);

        mystatement.executeUpdate(query);
    }

    /**
     * 11. Record (insert) the actual data of a given trip offering specified by its key. The actual
     * data include the attributes of the table ActualTripStopInfo
     * */
    private static void insert_Actual_TripInfo(Statement mystatement) throws SQLException{
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the trip number: ");
        int trip_number = input.nextInt();

//        format the query
        String query =
                String.format("SELECT * FROM cs4350_lab4.ActualTripStopInfo WHERE TripNumber = %d;", trip_number);

//        execute the query
        ResultSet myres = mystatement.executeQuery(query);

        while(myres.next()){
            System.out.println(myres.getString("TripNumber") + " "
                    + myres.getString("Date") + " "
                    + myres.getString("ScheduledStartTime") + " "
                    + myres.getString("StopNumber") + " "
                    + myres.getString("ScheduledArrivalTime") + " "
                    + myres.getString("ActualArrivalTime") + " "
                    + myres.getString("NumberOfPassengerIn") + " "
                    + myres.getString("NumberOfPassengerOut") + " "
            );
        }
    }

}
