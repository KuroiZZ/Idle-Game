package LOCSystem;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an "Advanced" developer in the system, extending the `Developers` class.
 * This class models a developer with advanced-level skills and defines the behavior of how their price changes
 * and how their total price for purchasing is calculated.
 */
public class Advanced extends Developers
{
    /**
     * Constructs an "Advanced" developer object with the specified type and rank.
     * This constructor is used when creating an empty advanced developer.
     *
     * @param type
     * @param rank
     */
    public Advanced(String type, String rank)
    {
        super(type, rank);
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
        setPrice(20);
        setLinePerSecond(60);
    }

    /**
     * Constructs an "Advanced" developer object using data from a JSON string.
     * This constructor is used for loading a saved advanced developer from a stored JSON string.
     *
     * @param Rank The rank of the developer (e.g., "Senior").
     * @param Price The price to hire an advanced developer.
     * @param Type The type of developer (e.g., "Advanced").
     * @param NofNonProjectEmp The number of employees not working on projects.
     * @param LinePerSecond The number of lines of code processed per second by the developer.
     * @param NofTotalEmp The total number of employees.
     * @param NofProjectEmp The number of employees working on projects.
     * @param NofTotalLOC The total number of lines of code produced.
     */
    public Advanced(@JsonProperty("rank") String Rank, @JsonProperty("price") float Price, @JsonProperty("type") String Type,
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
     * Adjusts the price of an advanced developer after purchasing.
     * The price increases by 8% for each developer purchased.
     *
     * @param BuyAmount
     */
    @Override
    public void setPriceAfterBuy(int BuyAmount)
    {
        for (int i = 0; i<BuyAmount; i++)
        {
            setPrice(getPrice()*1.08f);
        }
    }

    /**
     * Calculates the total price to buy a given number of advanced developers.
     * The price for each additional developer is increased by 8% compared to the previous developer.
     *
     * @param BuyAmount
     * @return The total price for purchasing the specified number of developers.
     */
    @Override
    public float getTotalPrice(int BuyAmount)
    {
        float TotalPrice = 0;
        float ActivePrice = getPrice();
        for (int i = 0; i<BuyAmount; i++)
        {
            TotalPrice += ActivePrice;
            ActivePrice *= 1.08f;
        }
        return TotalPrice;
    }
}
