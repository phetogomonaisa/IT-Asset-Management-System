import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        AssetManager manager = new AssetManager();

        int choice = 0;


        do {

            try {

                System.out.println("\n=================================");
                System.out.println("       IT ASSET MANAGEMENT");
                System.out.println("=================================");
                System.out.println("1. Add Network Device");
                System.out.println("2. Add Security System");
                System.out.println("3. Display All Assets");
                System.out.println("4. Search Asset");
                System.out.println("5. Update Asset Name");
                System.out.println("6. Remove Asset");
                System.out.println("7. Company Report");
                System.out.println("8. Exit");
                System.out.print("Enter choice: ");


                choice = input.nextInt();
                input.nextLine();



                switch(choice) {


                    // ADD NETWORK DEVICE
                    case 1:


                        System.out.print("Asset ID: ");
                        String networkID = input.nextLine();


                        System.out.print("Asset Name: ");
                        String networkName = input.nextLine();


                        System.out.print("Purchase Cost: ");
                        double networkCost = input.nextDouble();


                        System.out.print("Bandwidth (Mbps): ");
                        double bandwidth = input.nextDouble();


                        System.out.print("Maintenance Cost: ");
                        double maintenance = input.nextDouble();


                        input.nextLine();



                        NetworkDevice network =
                                new NetworkDevice(
                                        networkID,
                                        networkName,
                                        networkCost,
                                        bandwidth,
                                        maintenance
                                );



                        if(manager.addAsset(network)) {

                            System.out.println(
                                    "Network device added successfully."
                            );

                        }

                        else {

                            System.out.println(
                                    "Asset ID already exists."
                            );

                        }


                        break;




                    // ADD SECURITY SYSTEM
                    case 2:


                        System.out.print("Asset ID: ");
                        String securityID = input.nextLine();


                        System.out.print("Asset Name: ");
                        String securityName = input.nextLine();


                        System.out.print("Purchase Cost: ");
                        double securityCost = input.nextDouble();


                        System.out.print("Threats Blocked: ");
                        int threats = input.nextInt();


                        System.out.print(
                                "Security Level (1 Low, 2 Medium, 3 High): "
                        );

                        int level = input.nextInt();


                        input.nextLine();



                        SecuritySystem security =
                                new SecuritySystem(
                                        securityID,
                                        securityName,
                                        securityCost,
                                        threats,
                                        level
                                );



                        if(manager.addAsset(security)) {

                            System.out.println(
                                    "Security system added successfully."
                            );

                        }

                        else {

                            System.out.println(
                                    "Asset ID already exists."
                            );

                        }


                        break;






                    // DISPLAY
                    case 3:

                        manager.displayAssets();

                        break;






                    // SEARCH
                    case 4:


                        System.out.print(
                                "Enter Asset ID: "
                        );


                        String searchID = input.nextLine();



                        ITAsset found =
                                manager.searchAsset(searchID);



                        if(found != null) {


                            found.generateReport();


                        }

                        else {

                            System.out.println(
                                    "Asset not found."
                            );

                        }


                        break;






                    // UPDATE
                    case 5:


                        System.out.print(
                                "Enter Asset ID: "
                        );


                        String updateID = input.nextLine();



                        System.out.print(
                                "Enter new asset name: "
                        );


                        String newName = input.nextLine();




                        if(manager.updateAssetName(
                                updateID,
                                newName)) {


                            System.out.println(
                                    "Asset updated successfully."
                            );

                        }

                        else {


                            System.out.println(
                                    "Asset not found."
                            );

                        }


                        break;







                    // REMOVE
                    case 6:


                        System.out.print(
                                "Enter Asset ID to remove: "
                        );


                        String removeID =
                                input.nextLine();



                        if(manager.removeAsset(removeID)) {


                            System.out.println(
                                    "Asset removed successfully."
                            );

                        }

                        else {


                            System.out.println(
                                    "Asset not found."
                            );

                        }


                        break;







                    // REPORT
                    case 7:


                        manager.generateReports();

                        break;







                    // EXIT
                    case 8:


                        System.out.println(
                                "Closing system..."
                        );


                        break;





                    default:


                        System.out.println(
                                "Invalid option."
                        );

                }



            }


            catch(Exception e) {


                System.out.println(
                        "Invalid input. Please try again."
                );


                input.nextLine();

            }



        } while(choice != 8);



        input.close();

    }

}