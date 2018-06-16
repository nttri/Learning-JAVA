package main;

import Support.Common;
import static java.lang.System.exit;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author thanhtri
 */
public class ConnectFrame extends javax.swing.JFrame {

    private String g_PlayerName = "";

    public ConnectFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuFrame = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        btnExitGame = new javax.swing.JButton();
        btnJoinRoom = new javax.swing.JButton();
        btnNewRoom = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOnlinePlayers = new javax.swing.JList<>();
        tfRoomID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        roomFrame = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        lblRoomID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblBossName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblPlayer1Name = new javax.swing.JLabel();
        lblPlayer2Name = new javax.swing.JLabel();
        lblPlayer3Name = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnStart = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfServerIP_Frame1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfPlayerName_Frame1 = new javax.swing.JTextField();
        btnConnect_Frame1 = new javax.swing.JButton();

        menuFrame.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 0, 153));

        btnExitGame.setBackground(new java.awt.Color(255, 255, 255));
        btnExitGame.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExitGame.setForeground(new java.awt.Color(255, 0, 0));
        btnExitGame.setText("Exit");
        btnExitGame.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnExitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitGameActionPerformed(evt);
            }
        });

        btnJoinRoom.setBackground(new java.awt.Color(102, 102, 102));
        btnJoinRoom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnJoinRoom.setForeground(new java.awt.Color(255, 255, 255));
        btnJoinRoom.setText("Join room");
        btnJoinRoom.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnJoinRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinRoomActionPerformed(evt);
            }
        });

        btnNewRoom.setBackground(new java.awt.Color(255, 255, 255));
        btnNewRoom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNewRoom.setForeground(new java.awt.Color(204, 0, 204));
        btnNewRoom.setText("New room");
        btnNewRoom.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnNewRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRoomActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Online players");

        listOnlinePlayers.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        listOnlinePlayers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listOnlinePlayers);

        tfRoomID.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tfRoomID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfRoomID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfRoomIDKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Room ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(btnExitGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnJoinRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(tfRoomID)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnNewRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExitGame, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnJoinRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout menuFrameLayout = new javax.swing.GroupLayout(menuFrame.getContentPane());
        menuFrame.getContentPane().setLayout(menuFrameLayout);
        menuFrameLayout.setHorizontalGroup(
            menuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuFrameLayout.setVerticalGroup(
            menuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        roomFrame.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(153, 0, 153));

        lblRoomID.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblRoomID.setForeground(new java.awt.Color(255, 255, 255));
        lblRoomID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRoomID.setText("#roomID");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Boss");

        lblBossName.setBackground(new java.awt.Color(255, 255, 255));
        lblBossName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblBossName.setForeground(new java.awt.Color(255, 255, 255));
        lblBossName.setText("?");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Members");

        lblPlayer1Name.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayer1Name.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblPlayer1Name.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayer1Name.setText("?");

        lblPlayer2Name.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayer2Name.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblPlayer2Name.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayer2Name.setText("?");

        lblPlayer3Name.setBackground(new java.awt.Color(255, 255, 255));
        lblPlayer3Name.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblPlayer3Name.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayer3Name.setText("?");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnStart.setBackground(new java.awt.Color(0, 204, 0));
        btnStart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnStart.setText("START");
        btnStart.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 51, 51));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("BACK");
        btnBack.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblBossName, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblPlayer1Name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(lblPlayer2Name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPlayer3Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(lblRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblRoomID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlayer1Name)
                            .addComponent(lblBossName))
                        .addGap(18, 18, 18)
                        .addComponent(lblPlayer2Name)
                        .addGap(18, 18, 18)
                        .addComponent(lblPlayer3Name))
                    .addComponent(jSeparator1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roomFrameLayout = new javax.swing.GroupLayout(roomFrame.getContentPane());
        roomFrame.getContentPane().setLayout(roomFrameLayout);
        roomFrameLayout.setHorizontalGroup(
            roomFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roomFrameLayout.setVerticalGroup(
            roomFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SERVER IP");

        tfServerIP_Frame1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfServerIP_Frame1.setForeground(new java.awt.Color(204, 0, 204));
        tfServerIP_Frame1.setText("127.0.0.1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PLAYER NAME");

        tfPlayerName_Frame1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfPlayerName_Frame1.setForeground(new java.awt.Color(204, 0, 204));

        btnConnect_Frame1.setBackground(new java.awt.Color(255, 255, 255));
        btnConnect_Frame1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnConnect_Frame1.setForeground(new java.awt.Color(204, 0, 204));
        btnConnect_Frame1.setText("CONNECT");
        btnConnect_Frame1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnConnect_Frame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnect_Frame1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(tfServerIP_Frame1)
                    .addComponent(tfPlayerName_Frame1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(btnConnect_Frame1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfServerIP_Frame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPlayerName_Frame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConnect_Frame1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnect_Frame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnect_Frame1ActionPerformed
        String ip = tfServerIP_Frame1.getText();
        String playerName = tfPlayerName_Frame1.getText();

        if ((!ip.isEmpty() && !playerName.isEmpty())) {
            Common.INSTANCE.client = new SnakeClient(ip, 3222);
            if (Common.INSTANCE.client.checkPlayerName(playerName, Common.INSTANCE.g_Port)) {
                Common.INSTANCE.g_PlayerName = playerName;
                Common.INSTANCE.mainFrame.setVisible(false);
                menuFrame.setSize(540, 310);
                menuFrame.setDefaultCloseOperation(3); // 3: EXIT_ON_CLOSE
                menuFrame.setResizable(false);
                menuFrame.setLocationRelativeTo(null);
                menuFrame.setTitle(playerName);
                this.showData();
                menuFrame.setVisible(true);
                g_PlayerName = playerName;
            } else {
                JOptionPane.showMessageDialog(this, "Name is invalid. Please try another name!", "WARNING", ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "IP Address & Name can not be empty!", "WARNING", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConnect_Frame1ActionPerformed

    private void btnNewRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRoomActionPerformed
        int res = Common.INSTANCE.client.createRoom();
        if (res != -1) {
            roomFrame.setSize(490, 330);
            roomFrame.setDefaultCloseOperation(3); // 3: EXIT_ON_CLOSE
            roomFrame.setResizable(false);
            roomFrame.setLocationRelativeTo(null);
            roomFrame.setTitle(g_PlayerName);
            menuFrame.setVisible(false);
            roomFrame.setVisible(true);
            updateRoom();
        }
    }//GEN-LAST:event_btnNewRoomActionPerformed

    private void btnJoinRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinRoomActionPerformed
        String roomID = tfRoomID.getText();
        boolean res = Common.INSTANCE.client.joinRoom(roomID);
        if (res) {
            roomFrame.setDefaultCloseOperation(3); // 3: EXIT_ON_CLOSE
            roomFrame.setResizable(false);
            roomFrame.setLocationRelativeTo(null);
            roomFrame.setTitle(g_PlayerName);
            roomFrame.setSize(490, 330);
            roomFrame.setVisible(true);
            updateRoom();
            menuFrame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "You can not join this room!", "WARNING", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnJoinRoomActionPerformed

    private void btnExitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitGameActionPerformed
        Common.INSTANCE.client.exitGame();
        menuFrame.dispose();
        exit(0);
    }//GEN-LAST:event_btnExitGameActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Common.INSTANCE.client.removePlayerOutRoom();
        roomFrame.setVisible(false);
        menuFrame.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tfRoomIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfRoomIDKeyTyped
        char checkChar = evt.getKeyChar();
        if (!Character.isDigit(checkChar)) {
            evt.consume();
        }
        if (tfRoomID.getText().length() > 3) {
            evt.consume();
        }
    }//GEN-LAST:event_tfRoomIDKeyTyped

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        Common.INSTANCE.client.startPlaying();
    }//GEN-LAST:event_btnStartActionPerformed

    public void showData() {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < Common.INSTANCE.g_PlayerNameList.size(); i++) {
            listModel.addElement(Common.INSTANCE.g_PlayerNameList.get(i));
        }
        listOnlinePlayers.setModel(listModel);
    }

    public void updateRoom() {
        lblRoomID.setText("#" + String.valueOf(Common.INSTANCE.room.getID()));
        lblBossName.setText(Common.INSTANCE.room.getPlayerName(0));
        lblPlayer1Name.setText(Common.INSTANCE.room.getPlayerName(1));
        lblPlayer2Name.setText(Common.INSTANCE.room.getPlayerName(2));
        lblPlayer3Name.setText(Common.INSTANCE.room.getPlayerName(3));
        if (Common.INSTANCE.g_PlayerName.equals(Common.INSTANCE.room.getPlayerName(0))) {
            btnStart.setVisible(true);
        } else {
            btnStart.setVisible(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConnectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Common.INSTANCE.mainFrame = new ConnectFrame();
                Common.INSTANCE.mainFrame.setDefaultCloseOperation(3); // 3: EXIT_ON_CLOSE
                Common.INSTANCE.mainFrame.setResizable(false);
                Common.INSTANCE.mainFrame.setSize(400, 270);
                Common.INSTANCE.mainFrame.setLocationRelativeTo(null);
                Common.INSTANCE.mainFrame.setVisible(true);
                Common.INSTANCE.roomFrame = roomFrame;
                roomFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        Common.INSTANCE.client.removePlayerOutRoom();
                        Common.INSTANCE.client.exitGame();
                    }
                });

                menuFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        Common.INSTANCE.client.exitGame();
                    }
                });
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConnect_Frame1;
    private javax.swing.JButton btnExitGame;
    private javax.swing.JButton btnJoinRoom;
    private javax.swing.JButton btnNewRoom;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBossName;
    private javax.swing.JLabel lblPlayer1Name;
    private javax.swing.JLabel lblPlayer2Name;
    private javax.swing.JLabel lblPlayer3Name;
    private javax.swing.JLabel lblRoomID;
    private javax.swing.JList<String> listOnlinePlayers;
    private static javax.swing.JFrame menuFrame;
    private static javax.swing.JFrame roomFrame;
    private javax.swing.JTextField tfPlayerName_Frame1;
    private javax.swing.JTextField tfRoomID;
    private javax.swing.JTextField tfServerIP_Frame1;
    // End of variables declaration//GEN-END:variables
}
