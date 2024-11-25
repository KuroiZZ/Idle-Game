package LOCSystem;

import javax.sound.sampled.Line;

public class Beginner extends Developers
{
    @Override
    public void setPrice(int Price)
    {
       this.Price = Price;
    }

    @Override
    public void setLinePerSecond(int LinePerSecond)
    {
        this.LinePerSecond = LinePerSecond;
    }

    public Beginner()
    {
        super();
        setPrice(5);
        setLinePerSecond(1000);
    }
}
