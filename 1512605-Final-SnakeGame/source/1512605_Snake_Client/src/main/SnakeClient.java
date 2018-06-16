package main;

import Model.Message;
import Model.Room;
import Support.Common;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thanhtri
 */
public class SnakeClient {

    public int index = 0;
    private String Host;
    private int Port;
    private Socket clientSocket;
    ObjectInputStream inputStream = null;
    ObjectOutputStream outputStream = null;

    public SnakeClient(String Host, int Port) {
        try {
            this.Port = Port;
            this.Host = Host;
            index = 1;
            clientSocket = new Socket(Host, Port);
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (Exception ex) {
            Logger.getLogger(SnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocketClient() {
        return clientSocket;
    }

    public void setSocketClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }

    public boolean checkPlayerName(String name, int port) {
        try {
            List<Object> ls = new ArrayList<Object>();
            ls.add(name);
            ls.add(port);
            outputStream.writeObject(new Message("checkPlayerName", ls));
            Message Message = (Message) inputStream.readObject();

            Common.INSTANCE.g_PlayerNameList = (List<String>) Message.getContent();
            if (Common.INSTANCE.g_PlayerNameList == null) {
                return false;
            }
            index++;
            return true;
        } catch (Exception ex) {
            Logger.getLogger(SnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int createRoom() {
        try {
            outputStream.writeObject(new Message("createRoom", null));
            Message message = (Message) inputStream.readObject();
            Common.INSTANCE.room = (Room) message.getContent();
            if (Common.INSTANCE.room == null) {
                return -1;
            }
            index += 4;
            return Common.INSTANCE.room.getID();
        } catch (Exception ex) {
            Logger.getLogger(SnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean joinRoom(String portphong) {
        try {
            outputStream.writeObject(new Message("joinRoom", portphong));
            Message Message = (Message) inputStream.readObject();
            Common.INSTANCE.room = (Room) Message.getContent();
            if (Common.INSTANCE.room == null) {
                return false;
            }
            index++;
            return true;
        } catch (Exception ex) {
            Logger.getLogger(SnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void startPlaying() {
        try {
            outputStream.writeObject(new Message("startPlaying", null));
        } catch (IOException ex) {
            Logger.getLogger(SnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playerMove(String move) {
        try {
            String arrStr[] = new String[2];
            arrStr[0] = Common.INSTANCE.g_PlayerName;
            arrStr[1] = move;            
            outputStream.writeObject(new Message("playerMove", arrStr));
        } catch (IOException ex) {
            Logger.getLogger(SnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removePlayerOutRoom() {
        try {
            outputStream.writeObject(new Message("removePlayerOutRoom", Common.INSTANCE.g_PlayerName));
            index--;
        } catch (IOException ex) {
            Logger.getLogger(SnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exitGame() {
        try {
            outputStream.writeObject(new Message("exitGame", Common.INSTANCE.g_PlayerName));
            index = 0;
        } catch (IOException ex) {
            Logger.getLogger(SnakeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
