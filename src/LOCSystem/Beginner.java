package LOCSystem;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Beginner extends Developers
{
    public Beginner(String type, String rank)
    {
        super(type, rank);
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
        setPrice(5);
        setLinePerSecond(1000);
    }

    public Beginner(@JsonProperty("rank") String Rank, @JsonProperty("price") float Price, @JsonProperty("type") String Type,
                    @JsonProperty("nofNonProjectEmp") int NofNonProjectEmp, @JsonProperty("linePerSecond") int LinePerSecond,
                    @JsonProperty("nofTotalEmp") int NofTotalEmp, @JsonProperty("nofProjectEmp") int NofProjectEmp,
                    @JsonProperty("nofTotalLOC") int NofTotalLOC)
    {
        super(Type, Rank);
        this.NofTotalEmp = NofTotalEmp;
        this.NofProjectEmp = NofProjectEmp;
        this.NofNonProjectEmp = NofNonProjectEmp;
        this.Price = Price;
        this.LinePerSecond = LinePerSecond;
        this.NofTotalLOC = NofTotalLOC;
    }

    @Override
    public void setPriceAfterBuy(int BuyAmount)
    {
        for (int i = 0; i<BuyAmount; i++)
        {
            setPrice(getPrice()*1.02f);
        }
    }

    @Override
    public float getTotalPrice(int BuyAmount)
    {
        float TotalPrice = 0f;
        float ActivePrice = getPrice();
        for (int i = 0; i<BuyAmount; i++)
        {
            TotalPrice += ActivePrice;
            ActivePrice *= 1.02f;
        }
        return TotalPrice;
    }
}
