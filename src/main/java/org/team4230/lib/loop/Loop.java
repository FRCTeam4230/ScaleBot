package org.team4230.lib.loop;

/**Base class for periodic loops
 * <p>
 * NOTE: Implementations must be threadsafe! IF this can't be guranteed,
 * odd behaviour might ensue if multiple loop objects try modify each other.
 */
public abstract class Loop implements LoopI{
    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}
