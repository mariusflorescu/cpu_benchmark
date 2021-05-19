package main.java.timing;

public class Timer implements timing.ITimer {

	private long elapsed = 0;
	private long stored = 0;
	private timing.TimerState state;

	public Timer() {
		state = timing.TimerState.Stopped;
	}

	@Override
	public void start() {
		stored = 0;
		resume();
	}

	@Override
	public long stop() {
		if (state.equals(timing.TimerState.Running)) {
			elapsed = System.nanoTime() - elapsed;
			state = timing.TimerState.Stopped;
			stored += elapsed;

			return stored;
		} else
			return stored;
	}

	@Override
	public long pause() {
		elapsed = System.nanoTime() - elapsed;
		state = timing.TimerState.Paused;
		stored += elapsed;

		return stored;
	}

	@Override
	public void resume() {
		state = timing.TimerState.Running;
		elapsed = System.nanoTime();
	}
}
