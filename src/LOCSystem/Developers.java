package LOCSystem;

public abstract class Developers extends Employee
{
    /**
     * Developer's LOC create amount in one second (LPS)
     */
    protected int LinePerSecond;
    /**
     * Number of total loc written by NonProject employee (NTL)
     */
    protected int NofTotalLOC;
    /**
     * Rank of Developer
     */
    protected String Rank;

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

    public int getLinePerSecond()
    {
        return LinePerSecond;
    }

    public void setLinePerSecond(int linePerSecond)
     {
         LinePerSecond = linePerSecond;
     }

    public int getNofTotalLOC()
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
     * Set Developer's Number of Total Employee , Number of non Project Employee and Number of Total LOC
     * @param nofTotalEmp
     */
    public void setNTEandNNPEandNTL(int nofTotalEmp)
    {
        this.NofTotalEmp = nofTotalEmp;
        setNNPEandNTL();
    }

    /**
     * Set Developer's Number of Project Employee , Number of non Project Employee and Number of Total LOC
     * @param nofProjectEmp
     */
    public void setNPEandNNPEandNTL(int nofProjectEmp)
    {
        this.NofProjectEmp = nofProjectEmp;
        setNNPEandNTL();
    }

    /**
     * Set Developer's Number of Non Project Employee and Number of Total LOC
     */
    public void setNNPEandNTL()
    {
        this.NofNonProjectEmp = this.NofTotalEmp - this.NofProjectEmp;
        setNofTotalLOC();
    }


    //Set abstract functions for child functions.
    abstract public void setPriceAfterBuy(int BuyAmount);

    abstract public float getTotalPrice(int BuyAmount);
}
