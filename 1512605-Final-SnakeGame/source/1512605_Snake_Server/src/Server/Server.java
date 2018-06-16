package Server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanhtri
 */
public class Server {

    public static void main(String[] args) throws IOException {
        try {
            ServerFrame sv = new ServerFrame();
            sv.setVisible(true);
            sv.run();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
