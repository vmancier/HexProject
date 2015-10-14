package Application;

/**
 * Created by Valentin on 14/10/2015.
 */
public class Main {
    public Main() {

    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}