package LOCSystem;

public abstract class Developers
{
    int NofTotalEmp; //Number of total employees (NTE)
    int NofProjectEmp; //Number of employees working on project (NPE)
    int NofNonProjectEmp; //Number of employees not working on project (NNPE)
    int Price; //price to hire an employee
    int LinePerSecond; //line per second (LPS)
    int NofTotalLOC; //Number of total loc written by NonProject employee (NTL)

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

    public int getPrice()
    {
        return Price;
    }

    public void setPrice(int price)
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

    public Developers()
    {
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
    }
}
