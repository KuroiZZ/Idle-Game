package LOCSystem;

import javax.sound.sampled.Line;

public class Beginner extends Developers
{
    public Beginner(String type, String rank)
    {
        super(type, rank);
        setPrice(5);
        setLinePerSecond(1000);
    }

    @Override
    public void setPriceAfterBuy(int BuyAmount)
    {
        for (int i = 0; i<BuyAmount; i++)
        {
            setPrice(getPrice()*1.02f);
        }
    }

    @Override
    public float getTotalPrice(int BuyAmount)
    {
        float TotalPrice = 0f;
        float ActivePrice = getPrice();
        for (int i = 0; i<BuyAmount; i++)
        {
            TotalPrice += ActivePrice;
            ActivePrice *= 1.02f;
        }
        return TotalPrice;
    }
}
