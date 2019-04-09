package ohm.softa.a03;

public class SleepingState extends State {

    SleepingState(int d)
    {
        super(d);
    }

    @Override
    public State successor(Cat cat) {
            logger.info("Yoan... getting hungry!");
            return new HungryState(cat.getAwake());
    }
}
