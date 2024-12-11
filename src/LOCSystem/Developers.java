package LOCSystem;

public abstract class Developers
{
    protected int NofTotalEmp; //Number of total employees (NTE)
    protected int NofProjectEmp; //Number of employees working on project (NPE)
    protected int NofNonProjectEmp; //Number of employees not working on project (NNPE)
    protected float Price; //price to hire an employee
    protected int LinePerSecond; //line per second (LPS)
    protected int NofTotalLOC; //Number of total loc written by NonProject employee (NTL)
    protected String Type;
    protected String Rank;

    public Developers(String type, String rank)
    {
        Type = type;
        Rank = rank;
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

    public void setNTEandNNPEandNTL(int nofTotalEmp)
    {
        this.NofTotalEmp = nofTotalEmp;
        setNNPEandNTL();
    }

    public void setNPEandNNPEandNTL(int nofProjectEmp)
    {
        this.NofProjectEmp = nofProjectEmp;
        setNNPEandNTL();
    }

    public void setNNPEandNTL()
    {
        this.NofNonProjectEmp = this.NofTotalEmp - this.NofProjectEmp;
        setNofTotalLOC();
    }

    abstract public void setPriceAfterBuy(int BuyAmount);

    abstract public float getTotalPrice(int BuyAmount);
}
