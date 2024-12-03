package LOCSystem;

public class Intermediate extends Developers
{
    public Intermediate()
    {
        super();
        setPrice(10);
        setLinePerSecond(5000);
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
}
