package ohm.softa.a03;

public class DigestingState extends State {

    int remaining;

    public DigestingState(int d, int remaining) {
        super(d);
        this.remaining = remaining;
    }

    @Override
    public State successor(Cat cat) {

            logger.info("Getting in a playful mood!");
            return new PlayfulState(remaining - cat.getDigest());
    }
}
