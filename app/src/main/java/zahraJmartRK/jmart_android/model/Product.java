package zahraJmartRK.jmart_android.model;

public class Product extends Serializable{
    public ProductCategory category;
    public int accountId;
    public boolean conditionUsed;
    public double discount;
    public double price;
    public byte shipmentPlans;
    public int weight;
    public String name;

    @Override
    public String toString(){
        return name;
    }
}
