package Server;

import static java.lang.System.exit;
import Model.Message;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thanhtri
 */
public class ServerFrame extends javax.swing.JFrame {

    public ServerSocket listener;
    private boolean stop = false;
    private ExecutorService threadManagement = Executors.newFixedThreadPool(10);

    public ServerFrame() throws IOException {
        initComponents();
        this.listener = new ServerSocket(Common.gPort);
    }

    public void run() {
        while (!stop) {
            try {
                Socket socket = new Socket();
                socket = listener.accept();
                threadManagement.execute(new serverThread(socket));
            } catch (IOException ex) {
                Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static class serverThread implements Runnable {

        private Socket serverSocket;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        RoomManagement roomManage;
        String name;

        public serverThread(Socket serverSocket) throws IOException {
            this.serverSocket = serverSocket;
            oos = new ObjectOutputStream(serverSocket.getOutputStream());
            ois = new ObjectInputStream(serverSocket.getInputStream());
        }

        @Override
        public void run() {
            Message receiveMessage = null;
            while (true) {
                try {
                    receiveMessage = (Message) ois.readObject();
                    if (receiveMessage.getTitle().equals("checkPlayerName")) {
                        ArrayList<Object> s = (ArrayList<Object>) receiveMessage.getContent();
                        String name = s.get(0).toString();
                        int port = (int) s.get(1);
                        checkPlayerName(name, port);
                    }
                    if (receiveMessage.getTitle().equals("createRoom")) {
                        createRoom();
                    }
                    if (receiveMessage.getTitle().equals("joinRoom")) {
                        int port = receiveMessage.getInt();
                        joinRoom(port);
                    } 
                    if (receiveMessage.getTitle().equals("startPlaying")) {
                        startPlaying();
                    } 
                    if ((receiveMessage.getTitle().equals("playerMove"))) {
                        playerMove((String[]) receiveMessage.getContent());
                    } 
                    if (receiveMessage.getTitle().equals("removePlayerOutRoom")) {
                        removePlayerOutRoom(receiveMessage.getString());
                    } 
                    if (receiveMessage.getTitle().equals("exitGame")) {
                        exitGame(receiveMessage.getString());
                    }
                } catch (IOException ex) {
                    if (roomManage == null) {
                        try {
                            exitGame(name);
                        } catch (IOException ex2) {
                            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex2);
                        }
                    } else {
                        try {
                            removePlayerOutRoom(name);
                        } catch (IOException ex2) {
                            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex2);
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        void checkPlayerName(String name, int port) throws IOException {
            List<String> res = Common.INSTANCE.g_PlayerManagement.checkPlayerName(name, serverSocket.getLocalAddress(), port);
            if (res != null) {
                oos.writeObject(new Message(null, res));
                this.name = name;
            } else {
                oos.writeObject(new Message(null, null));
            }
        }

        public void createRoom() throws IOException {
            roomManage = Common.INSTANCE.g_PlayerManagement.createRoom(name);
            if (roomManage == null) {
                oos.writeObject(new Message(null, null));
            } else {
                oos.writeObject(new Message(null, roomManage.getRoom()));
            }
        }

        public void joinRoom(int port) throws IOException {
            roomManage = Common.INSTANCE.g_PlayerManagement.joinRoom(name, port);
            if (roomManage == null) {
                oos.writeObject(new Message(null, null));
            } else {
                oos.writeObject(new Message(null, roomManage.getRoom()));
            }
        }

        public void startPlaying() throws IOException {
            roomManage.startPlaying();
            roomManage.sendGamePlay();
        }

        public void playerMove(String[] s) throws IOException {
            roomManage.playerMove(s);
        }

        public void exitGame(String nameout) throws IOException {
            Common.INSTANCE.g_PlayerManagement.exitGame(nameout);
        }

        public void removePlayerOutRoom(String playerName) throws IOException {
            int idx = roomManage.removePlayerOutRoom(playerName);
            if (idx == 0) {
                Common.INSTANCE.g_PlayerManagement.removeRoom(roomManage);
            }
            roomManage = null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("SERVER IS RUNNING...");

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("CLOSE CONNECTION");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
