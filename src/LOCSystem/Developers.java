package LOCSystem;

public abstract class Developers
{
    int NofTotalEmp; //Number of total employees
    int NofProjectEmp; //Number of employees working on project
    int NofNonProjectEmp; //Number of employees not working on project
    int Price; //price to hire an employee
    int LinePerSecond; //Millisecond per line

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

    abstract public void setPrice(int Price);

    public int getLinePerSecond()
    {
        return LinePerSecond;
    }

    abstract public void setLinePerSecond(int LinePerSecond);

    public Developers()
    {
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
    }
}
