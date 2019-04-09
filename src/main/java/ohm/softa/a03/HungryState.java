package ohm.softa.a03;

public class HungryState extends State {


    public HungryState(int d) {
        super(d);
    }

    @Override
    public State successor(Cat cat) {
        if(time==duration)
        {
            return new DeathState();
        }
        return this;
    }

    public State feed(Cat cat)
    {
        return new DigestingState(cat.getDigest(), duration -time);
    }
}
