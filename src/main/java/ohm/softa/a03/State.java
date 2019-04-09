package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {
    protected static final Logger logger = LogManager.getLogger();
    int time;
    int duration;

    public State(int d)
    {
        this.duration = d;
    }

    public final State tick(Cat cat)
    {
        logger.info("tick()");
        time++;

        if(duration<0)
            return this;

        if(time<duration)
        {
            return this;
        }else
        return successor(cat);
    }

    public abstract State successor(Cat cat);



}


