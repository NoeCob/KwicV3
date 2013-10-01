package Kwicv3;

import java.io.EOFException;

/**
 *
 * @author Noé
 */
public abstract class Filter implements Runnable {

    protected Pipe in, out;

    public void setIn(Pipe p) {
        in = p;
    }

    public void setOut(Pipe p) {
        out = p;
    }

    /**
     * Writes to it's pipe
     *
     * @param s
     */
    public void write(String s) {
        if (s == null) {
            out.close();
            return;
        }
        out.write(s);
    }

    /**
     * Reads from it's pipe
     *
     * @return
     * @throws EOFException
     */
    public String read() throws EOFException {
        return in.read();
    }
}
