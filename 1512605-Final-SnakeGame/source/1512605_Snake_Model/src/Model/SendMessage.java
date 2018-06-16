package Model;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanhtri
 */
public class SendMessage implements Serializable {

    public Socket gSocket;
    ObjectInputStream inputMessage = null;
    ObjectOutputStream outputMessage = null;

    public SendMessage(InetAddress address, int port) {
        try {
            gSocket = new Socket(address, port);
            outputMessage = new ObjectOutputStream(gSocket.getOutputStream());
            inputMessage = new ObjectInputStream(gSocket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Server trả về client khi có người chơi mới vào server
    public void sendNewPlayer(String playerName) {
        try {
            outputMessage.writeObject(new Message("sendNewPlayer", playerName));
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Server trả về client khi có người chơi mới vào phòng
    public void sendNewPlayerJoinRoom(String playerName) {
        try {
            outputMessage.writeObject(new Message("sendNewPlayerJoinRoom", playerName));
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Server trả về gameplay cho các client cùng phòng
    public void sendGamePlay(GamePlay gamePlay) {
        try {
            outputMessage.writeObject(new Message("sendGamePlay", gamePlay));
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean startPlaying(GamePlay gamePlay) {
        try {
            outputMessage.writeObject(new Message("startPlaying", gamePlay));
            return true;
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void winGame(GamePlay gamePlay) {
        try {
            outputMessage.writeObject(new Message("winGame", gamePlay));
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Server trả về client khi có người chơi thoát khỏi phòng
    public void sendPlayerExitRoom(String playerName) {
        try {
            outputMessage.writeObject(new Message("sendPlayerExitRoom", playerName));
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Server trả về client khi người chơi thoát giao diện game
    public void exit() {
        try {
            outputMessage.writeObject(new Message("exit", null));
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Server trả về client khi có người chơi thoát hẳn game 
    public void sendPlayerExitGame(String playerName) {
        try {
            outputMessage.writeObject(new Message("sendPlayerExitGame", playerName));
        } catch (IOException ex) {
            Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
