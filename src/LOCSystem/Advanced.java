package LOCSystem;

public class Advanced extends Developers
{
    public Advanced()
    {
        super();
        setPrice(20);
        setLinePerSecond(10000);
    }

    @Override
    public void setPriceAfterBuy(int BuyAmount)
    {
        for (int i = 0; i<BuyAmount; i++)
        {
            setPrice(getPrice()*1.08f);
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
            ActivePrice *= 1.08f;
        }
        return TotalPrice;
    }
}
