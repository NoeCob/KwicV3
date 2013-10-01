package Kwicv3;
/**
 *
 * @author Noé
 */
public class Pipeline implements Runnable{
    	private filters.Filter[] filters;
	
	public Pipeline(filters.Filter ... filters ) {
		this.filters = filters;
		
		for(int i = 0; i < filters.length - 1; i++) {
			filters.Pipe p = new filters.Pipe();
			filters[i].setOut(p);
			filters[i+1].setIn(p);
		}
	}

	@Override
	public void run() {
		for(filters.Filter f : filters) {
			(new Thread(f)).start();
		}
	}
}
