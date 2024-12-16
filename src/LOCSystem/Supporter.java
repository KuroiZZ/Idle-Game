package LOCSystem;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a supporter in the game.
 * The `Supporter` class extends the `Employee` class.
 */
public class Supporter extends Employee
{
    /**
     * Constructs a `Supporter` object when creating empty supporters.
     * Initializes the supporter with a given type and price,
     * and sets the number of employees for total, project, and non-project employees to zero.
     *
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
     * Constructs a `Supporter` object when creating an object from a JSON string.
     * This constructor is used when deserializing data from a saved game or a database.
     *
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
     * Updates the price of the supporter after purchasing.
     * Each time the supporter is bought, their price increases by 5% for each purchase.
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
     * Calculates the total price for purchasing a certain number of supporters.
     * The price increases by 5% with each purchase.
     *
     * @param BuyAmount
     * @return The total price for buying the specified number of supporters.
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
     * Sets the supporter's number of total employees and non-project employees.
     *
     * @param nofTotalEmp The total number of employees for this supporter.
     */
    public void setNTEandNNPE(int nofTotalEmp)
    {
        this.NofTotalEmp = nofTotalEmp;
        setNofNonProjectEmp();
    }

    /**
     * Sets the supporter's number of project employees and recalculates the number of non-project employees.
     *
     * @param nofProjectEmp The number of employees assigned to projects for this supporter.
     */
    public void setNPEandNNPE(int nofProjectEmp)
    {
        this.NofProjectEmp = nofProjectEmp;
        NofNonProjectEmp = NofTotalEmp - NofProjectEmp;
    }

}
