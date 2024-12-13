package LOCSystem;

public class Supporter extends Employee
{
    public Supporter(String Type, float Price)
    {
        super(Type, Price);
        setNofTotalEmp(0);
        setNofProjectEmp(0);
        setNofNonProjectEmp();
    }

    @Override
    public void setPriceAfterBuy(int BuyAmount)
    {
        for (int i = 0; i<BuyAmount; i++)
        {
            setPrice(getPrice()*1.05f);
        }
    }

    @Override
    public float getTotalPrice(int BuyAmount) {
        return 0;
    }
}
