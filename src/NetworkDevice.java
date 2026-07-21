/**
 * Represents a network device such as a router or switch.
 * Inherits common properties from ITAsset.
 */
public class NetworkDevice extends ITAsset {

    // Additional instance variables
    private double bandwidth;
    private double maintenanceCost;

    /**
     * Constructor
     */
    public NetworkDevice(String assetID, String assetName,
                         double purchaseCost,
                         double bandwidth,
                         double maintenanceCost) {

        super(assetID, assetName, purchaseCost);

        this.bandwidth = bandwidth;
        this.maintenanceCost = maintenanceCost;
    }

    // Getters
    public double getBandwidth() {
        return bandwidth;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    // Setters
    public void setBandwidth(double bandwidth) {
        this.bandwidth = bandwidth;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    /**
     * Calculates the value of the asset.
     */
    @Override
    public double calculateAssetValue() {

        return getPurchaseCost()
                + (bandwidth * 15)
                - maintenanceCost;
    }

    /**
     * Displays information about the asset.
     */
    @Override
    public void generateReport() {

        System.out.println("\n========== NETWORK DEVICE ==========");
        System.out.println("Asset ID          : " + getAssetID());
        System.out.println("Asset Name        : " + getAssetName());
        System.out.println("Purchase Cost     : R" + getPurchaseCost());
        System.out.println("Bandwidth         : " + bandwidth + " Mbps");
        System.out.println("Maintenance Cost  : R" + maintenanceCost);
        System.out.println("Asset Value       : R" + calculateAssetValue());
    }
}