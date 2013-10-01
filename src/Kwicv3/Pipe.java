package Kwicv3;

import java.io.EOFException;
import java.util.LinkedList;

/**
 *
 * @author Noé
 */
public class Pipe {
    
    private LinkedList<String> buffer;
	private boolean closed;

	public Pipe() {
		buffer = new LinkedList<String>();
		closed = false;
	}

	/**
	 * Write to the pipe
	 * @param s
	 */
	public void write(String s) {
		if(closed)
			return;
		buffer.add(s);
	}
	
	/**
	 * Read from the Pipe. If it is still open it will continue to do busy
	 * waiting and will not return until the pipe is closed or the buffer
	 * get's data
	 * 
	 * @return String
	 * @throws EOFException
	 */
	public String read() throws EOFException {
		while(true) {
			if(buffer.isEmpty()) {
				if(closed)
					throw new EOFException();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.err.println("InterruptedExcpetion caught in Pipe");
				}
			} else {
				return buffer.pop();
			}
		}
	}
	
	/**
	 * Once closed it can never be reopened
	 */
	public void close() {
		closed = true;
	}
    
}
