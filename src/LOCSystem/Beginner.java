package LOCSystem;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a "Beginner" developer in the system, extending the `Developers` class.
 * This class models a developer with beginner-level skills and defines the behavior of how their price changes
 * and how their total price for purchasing is calculated.
 */
public class Beginner extends Developers
{
    /**
     * Constructs a "Beginner" developer object with the specified type and rank.
     * This constructor is used when creating an empty beginner developer.
     *
     * @param type
     * @param rank
     */
    public Beginner(String type, String rank)
    {
        super(type, rank);
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
        setPrice(5);
        setLinePerSecond(10);
    }

    /**
     * Constructs a "Beginner" developer object using data from a JSON string.
     * This constructor is used for loading a saved beginner developer from a stored JSON string.
     *
     * @param Rank
     * @param Price
     * @param Type
     * @param NofNonProjectEmp
     * @param LinePerSecond
     * @param NofTotalEmp
     * @param NofProjectEmp
     * @param NofTotalLOC
     */
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

    /**
     * Adjusts the price of a beginner developer after purchasing.
     * The price increases by 2% for each developer purchased.
     *
     * @param BuyAmount
     */
    @Override
    public void setPriceAfterBuy(int BuyAmount)
    {
        for (int i = 0; i<BuyAmount; i++)
        {
            setPrice(getPrice()*1.02f);
        }
    }

    /**
     * Calculates the total price to buy a given number of beginner developers.
     * The price for each additional developer is increased by 2% compared to the previous developer.
     *
     * @param BuyAmount
     * @return The total price for purchasing the specified number of developers.
     */
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
