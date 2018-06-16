package Support;

import Model.GamePlay;
import Model.Message;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.exit;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.ConnectFrame;
import main.GameFrame;

/**
 *
 * @author thanhtri
 */
public class ServerService extends Thread {

    public ServerSocket listener;

    public ServerService(int Port) {
        try {
            this.listener = new ServerSocket(Port);
        } catch (Exception ex) {
            Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket();
            socket = listener.accept();
            new Recevice(socket).start();
        } catch (Exception ex) {
            Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static class Recevice extends Thread {

        public Recevice(Socket socket) {
            try {
                this.socket = socket;
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());
            } catch (Exception ex) {
                Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            while (!stop) {
                try {
                    Message receiveMessage = (Message) ois.readObject();
                    if (receiveMessage.getTitle().equals("sendNewPlayerJoinRoom")) {
                        sendNewPlayerJoinRoom(receiveMessage);
                    } 
                    if (receiveMessage.getTitle().equals("sendNewPlayer")) {
                        sendNewPlayer(receiveMessage);
                    } 
                    if (receiveMessage.getTitle().equals("sendPlayerExitGame")) {
                        sendPlayerExitGame(receiveMessage);
                    } 
                    if (receiveMessage.getTitle().equals("sendPlayerExitRoom")) {
                        sendPlayerExitRoom(receiveMessage);
                    } 
                    if (receiveMessage.getTitle().equals("startPlaying")) {
                        GamePlay _gamePlay = (GamePlay) receiveMessage.getContent();
                        startPlaying(_gamePlay);
                    } 
                    if (receiveMessage.getTitle().equals("sendGamePlay")) {
                        GamePlay _gamePlay = (GamePlay) receiveMessage.getContent();
                        draw(_gamePlay);
                    } 
                    if (receiveMessage.getTitle().equals("winGame")) {
                        GamePlay _gamePlay = (GamePlay) receiveMessage.getContent();
                        winGame();
                    } 
                    if (receiveMessage.getTitle().equals("exit")) {
                        socket.close();
                        exit(0);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        Socket socket = new Socket();
        private boolean stop = false;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        void sendNewPlayerJoinRoom(Message message) {
            Common.INSTANCE.room.addPlayer(message.getString());
            ((ConnectFrame) (Common.INSTANCE.mainFrame)).updateRoom();
        }

        void sendNewPlayer(Message message) {
            Common.INSTANCE.g_PlayerNameList.add(message.getString());
            ((ConnectFrame) (Common.INSTANCE.mainFrame)).showData();
        }

        void startPlaying(GamePlay _gamePlay) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        this.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Common.INSTANCE.roomFrame.setVisible(false);
                    Common.INSTANCE.gamePlay = _gamePlay;
                    Common.INSTANCE.gameFrame = new GameFrame();
                    Common.INSTANCE.gameFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            Common.INSTANCE.client.removePlayerOutRoom();
                            Common.INSTANCE.client.exitGame();
                        }
                    });
                }
            }.start();
        }

        void draw(GamePlay _gamePlay) {
            //System.out.println("cap nhat ne");
            Common.INSTANCE.gamePlay = _gamePlay;
        }

        void winGame() {
            System.out.println("playing...");
        }

        void sendPlayerExitRoom(Message message) {
            Common.INSTANCE.room.removePlayer(message.getString());
            ((ConnectFrame) (Common.INSTANCE.mainFrame)).updateRoom();
        }

        void sendPlayerExitGame(Message message) {
            Common.INSTANCE.g_PlayerNameList.remove(message.getString());
            ((ConnectFrame) (Common.INSTANCE.mainFrame)).showData();
        }
    }
}
