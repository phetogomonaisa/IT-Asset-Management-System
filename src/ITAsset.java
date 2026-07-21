/**PHETOGO MONAISA: IT ASSET MANAGEMENT SYSTEM(JAVA) PROJECT
 * Abstract superclass representing a general IT asset.
 * Every IT asset has an ID, name and purchase cost.
 */
public abstract class ITAsset {

    // Instance variables
    private String assetID;
    private String assetName;
    private double purchaseCost;

    /**
     * Constructor
     */
    public ITAsset(String assetID, String assetName, double purchaseCost) {
        this.assetID = assetID;
        this.assetName = assetName;
        this.purchaseCost = purchaseCost;
    }

    // Getters
    public String getAssetID() {
        return assetID;
    }

    public String getAssetName() {
        return assetName;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    // Setters
    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setPurchaseCost(double purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    /**
     * Every subclass must calculate its own asset value.
     */
    public abstract double calculateAssetValue();

    /**
     * Every subclass must generate its own report.
     */
    public abstract void generateReport();
}
