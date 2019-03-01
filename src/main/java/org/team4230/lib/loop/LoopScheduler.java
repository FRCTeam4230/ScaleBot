package org.team4230.lib.loop;

import java.util.HashMap;

/** Automatically schedule loops into threads by periodicity
 * <p>
 * All loops with the same period will be added to the same thread
 * ({@link LoopBundle}) that will execute on a notifier timer.
 */
public class LoopScheduler {

    private HashMap<Double, LoopBundle> loopBundles;
    private boolean started;

    public LoopScheduler() {
        loopBundles = new HashMap<Double, LoopBundle>();
    }

    /**
     * Automatically add and schedule a loop based on it's execution periodicity
     * @param loop A object that implements the LoopI interface
     * @param period Period to the run the loop in seconds
     */
    public void addLoop(LoopI loop, double period) {
        if(loopBundles.containsKey(period)) {
            loopBundles.get(period).add(loop);
        } else {
            LoopBundle bundle = new LoopBundle(period);
            bundle.add(loop);
            loopBundles.put(period, bundle);
        }
    }

    /**
     * Start the scheduled loops.
     * <p>
     * Only run this once!
     */
    public synchronized void startLoops() {
        if(started) {
            System.out.println("Why did you try start this scheduler twice?!!");
        } else {
            for (LoopBundle bundle : loopBundles.values()) {
                System.out.println(new StringBuilder("Starting loop group with Period: ").append(bundle.period));
                bundle.start();
            }
            started = true;
        }
    }

    public void stopLoopSet(double period) {
        loopBundles.get(period).stop();
    }

    public void stopAll() {
        for(LoopBundle bundle : loopBundles.values()) {
            if(bundle.started()) {
                bundle.stop();
            }
        }
    }
}
