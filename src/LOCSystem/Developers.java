package LOCSystem;

/**
 * The abstract `Developers` class represents a developer in the system. It extends the `Employee` class
 * and includes specific attributes and methods relevant to developers, such as the number of lines of code
 * they write per second, their total lines of code written, and their rank.
 * This class is extended by specific developer types like `Beginner`, `Intermediate`, and `Advanced`.
 */
public abstract class Developers extends Employee
{
    /**
     * Developer's LOC create amount in one second (LPS)
     */
    protected float LinePerSecond;
    /**
     * Number of total loc written by NonProject employee (NTL)
     */
    protected float NofTotalLOC;
    /**
     * Rank of Developer
     */
    protected String Rank;

    /**
     * Constructs a `Developers` object with the specified type and rank.
     * This constructor is called by subclasses to initialize the type and rank of the developer.
     *
     * @param type
     * @param rank
     */
    public Developers(String type, String rank)
    {
        super(type);
        setRank(rank);
    }

    public int getNofTotalEmp()
    {
        return NofTotalEmp;
    }

    public void setNofTotalEmp(int nofTotalEmp)
    {
        NofTotalEmp = nofTotalEmp;
    }

    public int getNofProjectEmp()
    {
        return NofProjectEmp;
    }

    public void setNofProjectEmp(int nofProjectEmp)
    {
        NofProjectEmp = nofProjectEmp;
    }

    public int getNofNonProjectEmp()
    {
        return NofNonProjectEmp;
    }

    public void setNofNonProjectEmp()
    {
        NofNonProjectEmp = NofTotalEmp - NofProjectEmp;
    }

    public float getPrice()
    {
        return Price;
    }

    public void setPrice(float price)
    {
        Price = price;
    }

    public float getLinePerSecond()
    {
        return LinePerSecond;
    }

    public void setLinePerSecond(int linePerSecond)
     {
         LinePerSecond = linePerSecond;
     }

    public float getNofTotalLOC()
    {
        return NofTotalLOC;
    }

    public void setNofTotalLOC()
    {
        this.NofTotalLOC = this.LinePerSecond * this.NofNonProjectEmp;
    }

    public String getType()
    {
        return Type;
    }

    public void setType(String type)
    {
        Type = type;
    }

    public String getRank()
    {
        return Rank;
    }

    public void setRank(String rank)
    {
        Rank = rank;
    }

    /**
     * Sets the developer's number of total employees, non-project employees, and total lines of code.
     * This method is used when the total number of employees changes.
     *
     * @param nofTotalEmp The new total number of employees.
     */
    public void setNTEandNNPEandNTL(int nofTotalEmp)
    {
        this.NofTotalEmp = nofTotalEmp;
        setNNPEandNTL();
    }

    /**
     * Sets the developer's number of project employees, non-project employees, and total lines of code.
     * This method is used when the number of project employees changes.
     *
     * @param nofProjectEmp The new number of project employees.
     */
    public void setNPEandNNPEandNTL(int nofProjectEmp)
    {
        this.NofProjectEmp = nofProjectEmp;
        setNNPEandNTL();
    }

    /**
     * Sets the developer's number of non-project employees and the total lines of code.
     * This method updates the number of non-project employees and recalculates the total lines of code.
     */
    public void setNNPEandNTL()
    {
        this.NofNonProjectEmp = this.NofTotalEmp - this.NofProjectEmp;
        setNofTotalLOC();
    }

    // Abstract methods to be implemented by subclasses.

    /**
     * Abstract method to set the price of a developer after buying a specified number of developers.
     * The price increase logic will be implemented in the subclasses.
     *
     * @param BuyAmount The number of developers being bought.
     */
    abstract public void setPriceAfterBuy(int BuyAmount);

    /**
     * Abstract method to calculate the total price for purchasing a specified number of developers.
     * The total price calculation logic will be implemented in the subclasses.
     *
     * @param BuyAmount The number of developers being bought.
     * @return The total price for purchasing the specified number of developers.
     */
    abstract public float getTotalPrice(int BuyAmount);
}
