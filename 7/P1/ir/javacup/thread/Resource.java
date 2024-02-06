package ir.javacup.thread;

public class Resource {

	private int content;

	
	public int get() {
		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return content;
		}
	}
	
	public void set(int value) {
		synchronized (this) {
			content = value;
			notify();
		}	
	}
	
}
