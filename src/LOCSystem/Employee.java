package LOCSystem;

/**
 * Represents a generic employee in the system. This is an abstract class, meaning it is intended to be extended
 * by specific types of employees (e.g., developers, supporters).
 */
public abstract class Employee
{
    /**
     * Number of total employees (NTE)
     */
    protected int NofTotalEmp;
    /**
     * Number of employees working on project (NPE)
     */
    protected int NofProjectEmp;
    /**
     * Number of employees not working on project (NNPE)
     */
    protected int NofNonProjectEmp;
    /**
     * Price to hire an employee
     */
    protected float Price;
    /**
     * Type of Employee
     */
    protected String Type;

    /**
     * Constructs an Employee object with a specified type and price.
     * This constructor is used when creating an employee with both type and price information.
     *
     * @param Type
     * @param Price
     */
    public Employee(String Type, float Price)
    {
        setType(Type);
        setPrice(Price);
    }

    /**
     * Constructs an Employee object with a specified type.
     * This constructor is used when creating an employee with only the type information.
     *
     * @param Type
     */
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

    /**
     * Abstract method to adjust the price of an employee after purchasing.
     * This method will be implemented by subclasses to define how the price changes when an employee is bought.
     *
     * @param BuyAmount
     */
    abstract public void setPriceAfterBuy(int BuyAmount);

    /**
     * Abstract method to calculate the total price for purchasing a certain number of employees.
     * This method will be implemented by subclasses to define how the total price is calculated based on the number of units being purchased.
     *
     * @param BuyAmount
     * @return The total price to hire the specified number of employees.
     */
    abstract public float getTotalPrice(int BuyAmount);
}
