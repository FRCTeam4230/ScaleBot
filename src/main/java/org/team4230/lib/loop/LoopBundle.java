package org.team4230.lib.loop;

import edu.wpi.first.wpilibj.Notifier;

import java.util.ArrayList;
import java.util.List;

/** A bundle of loops that run at the same rate
 * <p>
 * Loop batches are executed in the sequential order they are added.
 * Do not count on execution order within bundles, they may end up
 * reordered at any time.
 */
public class LoopBundle {

    private List<LoopI> _loops;
    private Notifier _notifier;
    private boolean _started;
    public double period;
    private Runnable execute_loops = new Runnable() {
        @Override
        public void run() {
            for(LoopI loop : _loops) {
                loop.execute();
            }
        }
    };


    public LoopBundle(double period) {
        this.period = period;
        _notifier = new Notifier(execute_loops);
        _loops = new ArrayList<LoopI>();
    }

    public void start() {
        _started = true;
        for(LoopI loop : _loops) {
            System.out.println(new StringBuilder("Starting Loop: ").append(loop.getName()));
            loop.onStart();
        }
        _notifier.startPeriodic(period);
    }

    public void add(LoopI loop) {
        _loops.add(loop);
    }

    public void stop() {
        _notifier.stop();
        _started = false;
    }

    public boolean started() {
        return _started;
    }
}
