package LOCSystem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Supporter extends Employee
{
    public Supporter(String Type, float Price)
    {
        super(Type, Price);
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
    }

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

    @Override
    public void setPriceAfterBuy(int BuyAmount)
    {
        for (int i = 0; i<BuyAmount; i++)
        {
            setPrice(getPrice()*1.05f);
        }
    }

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

    public void setNTEandNNPE(int nofTotalEmp)
    {
        this.NofTotalEmp = nofTotalEmp;
        setNofNonProjectEmp();
    }

}
