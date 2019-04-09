package ohm.softa.a03;

import static ohm.softa.a03.State.logger;


public class Cat {
	private int sleep;
	private int awake;
	private int digest;


	private State state;

	private String name;

	public Cat(String name, int sleep, int awake, int digest) {
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.name = name;

		this.state = new SleepingState(sleep);
		state.duration = sleep;
	}

	public void feed()
	{
		if(!isHungry())
			throw new IllegalStateException();

		logger.info("feed cat");

		state = ((HungryState) state).feed(this);
	}

	public void tick()
	{
		logger.info("tick()");
		state = state.tick(this);
	}


	public boolean isAsleep()
	{
		return state instanceof SleepingState;
	}

	public boolean isPlayful()
	{
		return state instanceof PlayfulState;
	}

	public boolean isHungry()
	{
		return state instanceof HungryState;
	}

	public boolean isDigesting()
	{
		return state instanceof DigestingState;
	}

	public boolean isDead()
	{
		return state instanceof DeathState;
	}

	public int getSleep() {
		return sleep;
	}

	public int getAwake() {
		return awake;
	}

	public int getDigest() {
		return digest;
	}

	public String getName() {
		return name;
	}


}
