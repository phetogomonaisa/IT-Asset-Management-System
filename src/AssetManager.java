import java.util.ArrayList;

public class AssetManager {

    private ArrayList<ITAsset> assets;


    // Constructor
    public AssetManager() {
        assets = new ArrayList<>();
    }


    // ADD ASSET
    public boolean addAsset(ITAsset asset) {

        // Check duplicate IDs
        for (ITAsset existingAsset : assets) {

            if(existingAsset.getAssetID()
                    .equalsIgnoreCase(asset.getAssetID())) {

                return false;
            }
        }

        assets.add(asset);
        return true;
    }



    // DISPLAY ALL ASSETS
    public void displayAssets() {

        if(assets.isEmpty()) {

            System.out.println("No assets available.");
            return;
        }


        System.out.println("\n========== ALL ASSETS ==========");


        for(ITAsset asset : assets) {

            asset.generateReport();

        }

    }




    // SEARCH ASSET
    public ITAsset searchAsset(String assetID) {


        for(ITAsset asset : assets) {


            if(asset.getAssetID()
                    .equalsIgnoreCase(assetID)) {


                return asset;

            }

        }


        return null;

    }




    // REMOVE ASSET
    public boolean removeAsset(String assetID) {


        for(int i = 0; i < assets.size(); i++) {


            if(assets.get(i)
                    .getAssetID()
                    .equalsIgnoreCase(assetID)) {


                assets.remove(i);

                return true;

            }

        }


        return false;

    }





    // UPDATE ASSET NAME
    public boolean updateAssetName(String assetID,
                                   String newName) {


        ITAsset asset = searchAsset(assetID);


        if(asset != null) {

            asset.setAssetName(newName);

            return true;
        }


        return false;

    }






    // TOTAL VALUE OF ALL ASSETS
    public double calculateTotalAssetValue() {


        double total = 0;


        for(ITAsset asset : assets) {


            total += asset.calculateAssetValue();

        }


        return total;

    }





    // AVERAGE ASSET VALUE
    public double calculateAverageValue() {


        if(assets.isEmpty())
            return 0;


        return calculateTotalAssetValue()
                / assets.size();

    }







    // FIND HIGHEST VALUE ASSET
    public ITAsset getHighestValueAsset() {


        if(assets.isEmpty())
            return null;



        ITAsset highest = assets.get(0);



        for(ITAsset asset : assets) {


            if(asset.calculateAssetValue()
                    > highest.calculateAssetValue()) {


                highest = asset;

            }

        }


        return highest;

    }








    // FIND LOWEST VALUE ASSET
    public ITAsset getLowestValueAsset() {


        if(assets.isEmpty())
            return null;



        ITAsset lowest = assets.get(0);



        for(ITAsset asset : assets) {


            if(asset.calculateAssetValue()
                    < lowest.calculateAssetValue()) {


                lowest = asset;

            }

        }


        return lowest;

    }








    // COMPANY REPORT
    public void generateReports() {


        int networkCount = 0;

        int securityCount = 0;



        for(ITAsset asset : assets) {


            if(asset instanceof NetworkDevice) {

                networkCount++;

            }


            else if(asset instanceof SecuritySystem) {

                securityCount++;

            }

        }





        System.out.println("\n========== COMPANY REPORT ==========");


        System.out.println("Total Assets: "
                + assets.size());


        System.out.println("Network Devices: "
                + networkCount);


        System.out.println("Security Systems: "
                + securityCount);



        System.out.println("Total Value: R"
                + calculateTotalAssetValue());


        System.out.println("Average Value: R"
                + calculateAverageValue());



        ITAsset highest = getHighestValueAsset();


        if(highest != null) {


            System.out.println("\nHighest Value Asset:");

            System.out.println(highest.getAssetName()
                    + " - R"
                    + highest.calculateAssetValue());

        }




        ITAsset lowest = getLowestValueAsset();



        if(lowest != null) {


            System.out.println("\nLowest Value Asset:");

            System.out.println(lowest.getAssetName()
                    + " - R"
                    + lowest.calculateAssetValue());

        }


    }

}