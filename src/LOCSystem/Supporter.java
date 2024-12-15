package LOCSystem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Supporter extends Employee
{
    /**
     * This constructor, constructs Supporter objects when creating empty supporters.
     * @param Type
     * @param Price
     */
    public Supporter(String Type, float Price)
    {
        super(Type, Price);
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
    }

    /**
     * This constructor, construct Supporter object when creating object with json string in LOC.CreateSavedSupporters
     * @param Price
     * @param Type
     * @param NofNonProjectEmp
     * @param NofTotalEmp
     * @param NofProjectEmp
     */
    @JsonCreator
    public Supporter(@JsonProperty("price") float Price, @JsonProperty("type") String Type,
                     @JsonProperty("nofNonProjectEmp") int NofNonProjectEmp, @JsonProperty("nofTotalEmp") int NofTotalEmp,
                     @JsonProperty("nofProjectEmp") int NofProjectEmp)

    {
        super(Type, Price);
        this.NofTotalEmp = NofTotalEmp;
        this.NofProjectEmp = NofProjectEmp;
        this.NofNonProjectEmp = NofNonProjectEmp;
    }

    /**
     * Changes supporters price after buying.
     * @param BuyAmount
     */
    @Override
    public void setPriceAfterBuy(int BuyAmount)
    {
        for (int i = 0; i<BuyAmount; i++)
        {
            setPrice(getPrice()*1.05f);
        }
    }

    /**
     * Get supporters buying price with buyamount paramater.
     * @param BuyAmount
     * @return
     */
    @Override
    public float getTotalPrice(int BuyAmount)
    {
        float TotalPrice = 0;
        float ActivePrice = getPrice();
        for (int i = 0; i<BuyAmount; i++)
        {
            TotalPrice += ActivePrice;
            ActivePrice *= 1.05f;
        }
        return TotalPrice;
    }

    /**
     * Set supporter's Number of Total Employee and Number of non Project Employee
     * @param nofTotalEmp
     */
    public void setNTEandNNPE(int nofTotalEmp)
    {
        this.NofTotalEmp = nofTotalEmp;
        setNofNonProjectEmp();
    }

    /**
     * Set supporter's Number of Project Employee and Number of non Project Employee
     * @param nofProjectEmp
     */
    public void setNPEandNNPE(int nofProjectEmp)
    {
        this.NofProjectEmp = nofProjectEmp;
        NofNonProjectEmp = NofTotalEmp - NofProjectEmp;
    }

}
