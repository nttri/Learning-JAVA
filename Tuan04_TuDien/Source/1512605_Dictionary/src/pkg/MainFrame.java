package pkg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author thanhtri-1512605
 */
public class MainFrame extends javax.swing.JFrame {

    //--------------GLOBAL VARIABLES--------------
    HashMap g_ListAVWords = new HashMap();      // lưu các record file Anh-Việt.xml
    HashMap g_ListVAWords = new HashMap();      // lưu các record file Việt-Anh.xml
    ArrayList<Word> g_EWordLists = new ArrayList<>();    // lưu các từ TA đã tra
    ArrayList<Word> g_VWordLists = new ArrayList<>();    // lưu các từ TV đã tra
    DefaultListModel g_edlm = new DefaultListModel();      // list model TA
    DefaultListModel g_vdlm = new DefaultListModel();      // list model TV
    IOFile g_ReadFile = new IOFile();

    //--------------------------------------------
    public MainFrame() {
        initComponents();
        this.setTitle("JDictionary");
        btnAddFavor.setEnabled(false);
        btnTab2.setBackground(new Color(220,220,220));

        // load data từ 2 file xml
        try {
            g_ReadFile.ReadXML(g_ListAVWords, "resource\\Anh_Viet.xml");
            g_ReadFile.ReadXML(g_ListVAWords, "resource\\Viet_anh.xml");
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        g_EWordLists = g_ReadFile.read("resource\\dataE.DAT");
        g_VWordLists = g_ReadFile.read("resource\\dataV.DAT");

        jTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                //System.out.println("Tab: " + jTabbedPane.getSelectedIndex());
                if (jTabbedPane.getSelectedIndex() == 1) {
                    sortList(g_EWordLists);
                    sortList(g_VWordLists);

                    // thêm vào list TA
                    g_edlm.clear();
                    g_EWordLists.forEach((w) -> {
                        g_edlm.addElement(w);
                    });
                    listThongKeTA.setCellRenderer(new Renderer());
                    listThongKeTA.setModel(g_edlm);

                    // thêm vào list TV
                    g_vdlm.clear();
                    g_VWordLists.forEach((w) -> {
                        g_vdlm.addElement(w);
                    });
                    listThongKeTV.setCellRenderer(new Renderer());
                    listThongKeTV.setModel(g_vdlm);
                }
            }
        });

        pnlHeader1.setBackground(new Color(0, 0, 0, 85));
        tfInput.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        scrollPane1.setOpaque(false);
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setBorder(null);
        scrollPane1.setViewportBorder(null);

        textArea.setBorder(null);
        textArea.setBackground(new Color(0, 0, 0, 100));

        jPanel1.setBackground(new Color(0, 0, 0, 60));
        jPanel2.setBackground(new Color(0, 0, 0, 60));

        listThongKeTA.setFixedCellHeight(40);
        listThongKeTV.setFixedCellHeight(40);
        
        // xóa scrollbar
        jScrollPane1.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
        jScrollPane2.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));
        scrollPane1.getVerticalScrollBar().setPreferredSize (new Dimension(0,0));

    }

    // sắp xếp tăng dần
    public void sortList(ArrayList<Word> alWord) {
        for (int i = 0; i < alWord.size() - 1; i++) {
            for (int j = i + 1; j < alWord.size(); j++) {
                if (alWord.get(i).getnSearch() < alWord.get(j).getnSearch()) {
                    Collections.swap(alWord, i, j);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTab1 = new javax.swing.JButton();
        btnTab2 = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jTabDich = new javax.swing.JPanel();
        scrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        pnlHeader1 = new javax.swing.JPanel();
        cbbType = new javax.swing.JComboBox<>();
        tfInput = new javax.swing.JTextField();
        btnAddFavor = new javax.swing.JButton();
        tabThongKe = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listThongKeTA = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listThongKeTV = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnTab1.setBackground(new java.awt.Color(179, 55, 113));
        btnTab1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnTab1.setText("Tra từ");
        btnTab1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTab1.setPreferredSize(new java.awt.Dimension(47, 32));
        btnTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTab1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTab1);
        btnTab1.setBounds(0, 0, 400, 32);

        btnTab2.setBackground(new java.awt.Color(26, 188, 156));
        btnTab2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnTab2.setText("Thống kê - Yêu thích");
        btnTab2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTab2.setPreferredSize(new java.awt.Dimension(143, 32));
        btnTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTab2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnTab2);
        btnTab2.setBounds(400, 0, 400, 32);

        jTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane.setPreferredSize(new java.awt.Dimension(803, 655));
        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });

        jTabDich.setBackground(new java.awt.Color(179, 55, 113));
        jTabDich.setForeground(new java.awt.Color(43, 43, 43));
        jTabDich.setPreferredSize(new java.awt.Dimension(798, 630));

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        textArea.setForeground(new java.awt.Color(179, 55, 113));
        textArea.setRows(5);
        textArea.setBorder(null);
        scrollPane1.setViewportView(textArea);

        cbbType.setBackground(new java.awt.Color(179, 55, 113));
        cbbType.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cbbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anh-Việt", "Việt-Anh" }));
        cbbType.setMinimumSize(new java.awt.Dimension(90, 28));
        cbbType.setPreferredSize(new java.awt.Dimension(90, 28));

        tfInput.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfInput.setAlignmentX(3.0F);
        tfInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfInputKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeader1Layout = new javax.swing.GroupLayout(pnlHeader1);
        pnlHeader1.setLayout(pnlHeader1Layout);
        pnlHeader1Layout.setHorizontalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeader1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfInput, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeader1Layout.setVerticalGroup(
            pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeader1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        btnAddFavor.setBackground(new java.awt.Color(255, 255, 255));
        btnAddFavor.setForeground(new java.awt.Color(179, 55, 113));
        btnAddFavor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pink-heart.png"))); // NOI18N
        btnAddFavor.setText("Yêu thích");
        btnAddFavor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFavorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jTabDichLayout = new javax.swing.GroupLayout(jTabDich);
        jTabDich.setLayout(jTabDichLayout);
        jTabDichLayout.setHorizontalGroup(
            jTabDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jTabDichLayout.createSequentialGroup()
                .addGroup(jTabDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jTabDichLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jTabDichLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(btnAddFavor)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jTabDichLayout.setVerticalGroup(
            jTabDichLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTabDichLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddFavor)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Dịch", jTabDich);

        tabThongKe.setBackground(new java.awt.Color(26, 188, 156));

        jPanel1.setPreferredSize(new java.awt.Dimension(330, 520));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tiếng Anh");

        listThongKeTA.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        listThongKeTA.setForeground(new java.awt.Color(21, 150, 124));
        listThongKeTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listThongKeTAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listThongKeTA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(330, 500));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tiếng Việt");

        listThongKeTV.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        listThongKeTV.setForeground(new java.awt.Color(21, 150, 124));
        listThongKeTV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listThongKeTVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listThongKeTV);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabThongKeLayout = new javax.swing.GroupLayout(tabThongKe);
        tabThongKe.setLayout(tabThongKeLayout);
        tabThongKeLayout.setHorizontalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongKeLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        tabThongKeLayout.setVerticalGroup(
            tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabThongKeLayout.createSequentialGroup()
                .addGroup(tabThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Thống kê - Yêu thích", tabThongKe);

        getContentPane().add(jTabbedPane);
        jTabbedPane.setBounds(0, 0, 800, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfInputKeyPressed

        btnAddFavor.setEnabled(false);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && cbbType.getSelectedIndex() == 0) {
            //JOptionPane.showMessageDialog(rootPane, "you pressed enter");

            String word = tfInput.getText().toLowerCase();
            String meaning = "";
            try {
                meaning = g_ListAVWords.get(word).toString();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Từ này hiện chưa có định nghĩa.");
                textArea.setText("");
                return;
            }

            textArea.setText(meaning);

            int times = 0;
            // kiểm tra đối tượng đã có trong danh sách chưa
            for (Word mWord : g_EWordLists) {
                // nếu từ đã được tra
                if (mWord.getWord().equals(word)) {
                    if (!mWord.getIsFavorite()) {
                        btnAddFavor.setEnabled(true);
                    }
                    times = mWord.getnSearch() + 1;
                    mWord.setnSearch(times);
                    return;
                }
            }
            // từ được tra lần đầu
            btnAddFavor.setEnabled(true);
            times++;
            Word mWord = new Word(word, meaning, times, false);
            g_EWordLists.add(mWord);

        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER && cbbType.getSelectedIndex() == 1) {
            //JOptionPane.showMessageDialog(rootPane, "you pressed enter");

            String word = tfInput.getText();
            String meaning = "";
            try {
                meaning = g_ListVAWords.get(word).toString();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Từ này hiện chưa có định nghĩa.");
                textArea.setText("");
                return;
            }

            textArea.setText(meaning);
            btnAddFavor.setEnabled(true);

            int times = 0;
            // kiểm tra đối tượng đã có trong danh sách chưa
            for (Word mWord : g_VWordLists) {
                // nếu từ đã được tra
                if (mWord.getWord().equals(word)) {
                    if (!mWord.getIsFavorite()) {
                        btnAddFavor.setEnabled(true);
                    }
                    times = mWord.getnSearch() + 1;
                    mWord.setnSearch(times);
                    return;
                }
            }
            // từ được tra lần đầu
            btnAddFavor.setEnabled(true);
            times++;
            Word mWord = new Word(word, meaning, times, false);
            g_VWordLists.add(mWord);
        }
    }//GEN-LAST:event_tfInputKeyPressed

    private void btnAddFavorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFavorActionPerformed

        // thêm từ được định nghĩa trong textArea vào yêu thích
        String favorWord = tfInput.getText();

        if (favorWord.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Không phát hiện từ để thêm vào yêu thích");
            return;
        }

        // kiểm tra đang dùng loại từ điển nào
        if (cbbType.getSelectedIndex() == 0) {
            for (Word w : g_EWordLists) {
                if (w.getWord().equals(favorWord)) {
                    // bật trạng thái yêu thích cho từ đó
                    w.setIsFavorite(true);
                    break;
                }
            }
        } else {
            for (Word w : g_VWordLists) {
                if (w.getWord().equals(favorWord)) {
                    // bật trạng thái yêu thích cho từ đó
                    w.setIsFavorite(true);
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Đã thêm từ '" + favorWord + "' vào mục yêu thích.");
        btnAddFavor.setEnabled(false);
    }//GEN-LAST:event_btnAddFavorActionPerformed

    private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged

    }//GEN-LAST:event_jTabbedPaneStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        g_ReadFile.write(g_EWordLists, "resource\\dataE.DAT");
        g_ReadFile.write(g_VWordLists, "resource\\datav.DAT");
    }//GEN-LAST:event_formWindowClosing

    private void listThongKeTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listThongKeTAMouseClicked
        
        if(evt.getClickCount() == 2){
            int index = listThongKeTA.locationToIndex(evt.getPoint());
            Word wordChoose = (Word) g_edlm.getElementAt(index);
            MeaningDialog md = new MeaningDialog(this, rootPaneCheckingEnabled, wordChoose);
            this.setVisible(false);
            md.setVisible(true);
            this.setVisible(true);
        }
    }//GEN-LAST:event_listThongKeTAMouseClicked

    private void listThongKeTVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listThongKeTVMouseClicked
        
        if(evt.getClickCount() == 2){
            int index = listThongKeTV.locationToIndex(evt.getPoint());
            Word wordChoose = (Word) g_vdlm.getElementAt(index);
            MeaningDialog md = new MeaningDialog(this, rootPaneCheckingEnabled, wordChoose);
            this.setVisible(false);
            md.setVisible(true);
            this.setVisible(true);
        }
    }//GEN-LAST:event_listThongKeTVMouseClicked

    private void btnTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTab1ActionPerformed
        
        btnTab1.setBackground(new Color(179,55,113));
        jTabbedPane.setSelectedIndex(0);
        btnTab2.setBackground(new Color(220,220,220));
    }//GEN-LAST:event_btnTab1ActionPerformed

    private void btnTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTab2ActionPerformed
        
        btnTab2.setBackground(new Color(26,188,156));
        jTabbedPane.setSelectedIndex(1);
        btnTab1.setBackground(new Color(220,220,220));
    }//GEN-LAST:event_btnTab2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFavor;
    private javax.swing.JButton btnTab1;
    private javax.swing.JButton btnTab2;
    private javax.swing.JComboBox<String> cbbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jTabDich;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JList<String> listThongKeTA;
    private javax.swing.JList<String> listThongKeTV;
    private javax.swing.JPanel pnlHeader1;
    private javax.swing.JScrollPane scrollPane1;
    private javax.swing.JPanel tabThongKe;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField tfInput;
    // End of variables declaration//GEN-END:variables
}
