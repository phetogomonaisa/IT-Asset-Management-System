/**
 * Represents a security system such as a firewall or IDS.
 * Inherits common properties from ITAsset.
 */
public class SecuritySystem extends ITAsset {

    // Instance variables unique to a security system
    private int threatsBlocked;
    private int securityLevel;

    /**
     * Constructor
     */
    public SecuritySystem(String assetID,
                          String assetName,
                          double purchaseCost,
                          int threatsBlocked,
                          int securityLevel) {

        super(assetID, assetName, purchaseCost);

        this.threatsBlocked = threatsBlocked;
        this.securityLevel = securityLevel;
    }

    // Getters
    public int getThreatsBlocked() {
        return threatsBlocked;
    }

    public int getSecurityLevel() {
        return securityLevel;
    }

    // Setters
    public void setThreatsBlocked(int threatsBlocked) {
        this.threatsBlocked = threatsBlocked;
    }

    public void setSecurityLevel(int securityLevel) {
        this.securityLevel = securityLevel;
    }

    /**
     * Calculates the value of the security system.
     */
    @Override
    public double calculateAssetValue() {

        return getPurchaseCost()
                + (threatsBlocked * 10)
                + (securityLevel * 5000);
    }

    /**
     * Generates a report for the security system.
     */
    @Override
    public void generateReport() {

        System.out.println("\n========== SECURITY SYSTEM ==========");
        System.out.println("Asset ID         : " + getAssetID());
        System.out.println("Asset Name       : " + getAssetName());
        System.out.println("Purchase Cost    : R" + getPurchaseCost());
        System.out.println("Threats Blocked  : " + threatsBlocked);
        System.out.println("Security Level   : " + getSecurityLevelDescription());
        System.out.println("Asset Value      : R" + calculateAssetValue());
    }

    /**
     * Converts the security level number into words.
     */
    private String getSecurityLevelDescription() {

        switch (securityLevel) {
            case 1:
                return "Low";
            case 2:
                return "Medium";
            case 3:
                return "High";
            default:
                return "Unknown";
        }
    }
}