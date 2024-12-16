package LOCSystem;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an intermediate-level developer in the game.
 * This class extends the `Developers` class.
 * including methods to adjust their price and calculate the total cost based on the number of units purchased.
 */
public class Intermediate extends Developers
{
    /**
     * Constructs an empty Intermediate developer object with default values.
     * This constructor is used when creating a new intermediate developer with no data.
     *
     * @param type
     * @param rank
     */
    public Intermediate(String type, String rank)
    {
        super(type, rank);
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
        setPrice(10);
        setLinePerSecond(25);
    }

    /**
     * Constructs an Intermediate developer object with the provided data, typically used for loading saved game data.
     * This constructor is used when creating an intermediate developer object from a JSON string.
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
    public Intermediate(@JsonProperty("rank") String Rank, @JsonProperty("price") float Price, @JsonProperty("type") String Type,
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
     * Adjusts the price of the Intermediate developer after a purchase.
     * The price is increased by 5% for each unit purchased.
     *
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
     * Calculates the total price of purchasing a certain number of Intermediate developers.
     * The price increases by 5% with each additional purchase.
     *
     * @param BuyAmount
     * @return The total price for the specified number of units.
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
}
