package LOCSystem;

public abstract class Employee
{
    protected int NofTotalEmp; //Number of total employees (NTE)
    protected int NofProjectEmp; //Number of employees working on project (NPE)
    protected int NofNonProjectEmp; //Number of employees not working on project (NNPE)
    protected float Price; //price to hire an employee
    protected String Type;

    public Employee(String Type, float Price)
    {
        setType(Type);
        setPrice(Price);
    }

    public Employee(String Type)
    {
        setType(Type);
    }

    public int getNofTotalEmp() {
        return NofTotalEmp;
    }

    public void setNofTotalEmp(int nofTotalEmp) {
        NofTotalEmp = nofTotalEmp;
    }

    public int getNofProjectEmp() {
        return NofProjectEmp;
    }

    public void setNofProjectEmp(int nofProjectEmp) {
        NofProjectEmp = nofProjectEmp;
    }

    public int getNofNonProjectEmp() {
        return NofNonProjectEmp;
    }

    public void setNofNonProjectEmp() {
        NofNonProjectEmp = NofTotalEmp - NofProjectEmp;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    abstract public void setPriceAfterBuy(int BuyAmount);

    abstract public float getTotalPrice(int BuyAmount);
}
