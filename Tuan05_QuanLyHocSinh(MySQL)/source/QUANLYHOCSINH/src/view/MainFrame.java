package view;

import controller.DBConnect;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author thanhtri-1512605
 */
public class MainFrame extends javax.swing.JFrame {

    //------------------VARIABLES-------------------
    DefaultTableModel g_TableModel;
    DBConnect g_ConnectDB = new DBConnect();
    Connection g_Connection;
    Statement g_Statement;
    long g_currentID = 0;

    public MainFrame(DBConnect _dbconnect, Connection _connection) {
        initComponents();

        g_ConnectDB = _dbconnect;
        g_Connection = _connection;

        this.setTitle("Phần mềm quản lý học sinh");
        ((JTextField) tfNgaySinh.getDateEditor()).setEditable(false);
        tfNgaySinh.setBackground(new Color(0, 0, 0, 0));
        tfHoTen.setBackground(new Color(0, 0, 0, 0));
        tfGhiChu.setBackground(new Color(0, 0, 0, 0));
        tfHinhAnh.setBackground(new Color(0, 0, 0, 0));

        JTableHeader tableHeader = tableHocSinh.getTableHeader();
        tableHeader.setForeground(new Color(11, 110, 229));
        tableHeader.setFont(new Font("Tahoma", Font.BOLD, 18));

        btnLuu.setEnabled(false);
        tableHocSinh.setRowHeight(30);
        g_TableModel = (DefaultTableModel) tableHocSinh.getModel();

        loadDataFromMySQL();
    }

    // lấy data đổ vào bảng table và danh sách học 
    public void loadDataFromMySQL() {
        try {
            g_Statement = g_Connection.createStatement();
            ResultSet rs = g_Statement.executeQuery("select * from HOCSINH");
            while (rs.next()) {
                g_currentID = Long.parseLong(rs.getString("MaSo"));
                g_TableModel.addRow(new Object[]{rs.getString("MaSo"), rs.getString("HoTen"), rs.getString("NgaySinh"), rs.getString("GhiChu")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHocSinh = new javax.swing.JTable();
        tfHoTen = new javax.swing.JTextField();
        tfGhiChu = new javax.swing.JTextField();
        tfHinhAnh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnChonHinh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        tfNgaySinh = new com.toedter.calendar.JDateChooser();
        btnChinhSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        lblAvatar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(33, 35, 79));

        jScrollPane1.setBackground(new java.awt.Color(33, 35, 79));

        tableHocSinh.setBackground(new java.awt.Color(33, 35, 79));
        tableHocSinh.setFont(new java.awt.Font("VL BoosterNextFYThin", 0, 16)); // NOI18N
        tableHocSinh.setForeground(new java.awt.Color(33, 179, 234));
        tableHocSinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HS", "Tên HS", "Ngày sinh", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHocSinh.setToolTipText("");
        jScrollPane1.setViewportView(tableHocSinh);
        if (tableHocSinh.getColumnModel().getColumnCount() > 0) {
            tableHocSinh.getColumnModel().getColumn(0).setMinWidth(100);
            tableHocSinh.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableHocSinh.getColumnModel().getColumn(0).setMaxWidth(150);
            tableHocSinh.getColumnModel().getColumn(1).setPreferredWidth(160);
            tableHocSinh.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableHocSinh.getColumnModel().getColumn(2).setMaxWidth(150);
            tableHocSinh.getColumnModel().getColumn(3).setPreferredWidth(240);
        }

        tfHoTen.setFont(new java.awt.Font("VL BoosterNextFYThin", 1, 18)); // NOI18N
        tfHoTen.setForeground(new java.awt.Color(11, 110, 229));
        tfHoTen.setBorder(null);

        tfGhiChu.setFont(new java.awt.Font("VL BoosterNextFYThin", 1, 18)); // NOI18N
        tfGhiChu.setForeground(new java.awt.Color(11, 110, 229));
        tfGhiChu.setBorder(null);

        tfHinhAnh.setFont(new java.awt.Font("VL BoosterNextFYThin", 1, 18)); // NOI18N
        tfHinhAnh.setForeground(new java.awt.Color(11, 110, 229));
        tfHinhAnh.setBorder(null);

        jLabel1.setFont(new java.awt.Font("VL BoosterNextFYThin", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 179, 234));
        jLabel1.setText("Họ tên:");

        jLabel2.setFont(new java.awt.Font("VL BoosterNextFYThin", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 179, 234));
        jLabel2.setText("Ngày sinh:");

        jLabel3.setFont(new java.awt.Font("VL BoosterNextFYThin", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(33, 179, 234));
        jLabel3.setText("Ghi chú:");

        jLabel4.setFont(new java.awt.Font("VL BoosterNextFYThin", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 179, 234));
        jLabel4.setText("Hình:");

        btnThem.setBackground(new java.awt.Color(11, 110, 229));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(60, 60, 60));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnChonHinh.setBackground(new java.awt.Color(11, 110, 229));
        btnChonHinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChonHinh.setText("Chọn hình");
        btnChonHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonHinhActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(11, 110, 229));
        jSeparator1.setForeground(new java.awt.Color(11, 110, 229));

        jSeparator2.setBackground(new java.awt.Color(11, 110, 229));
        jSeparator2.setForeground(new java.awt.Color(11, 110, 229));

        jSeparator3.setBackground(new java.awt.Color(11, 110, 229));
        jSeparator3.setForeground(new java.awt.Color(11, 110, 229));

        jSeparator4.setBackground(new java.awt.Color(11, 110, 229));
        jSeparator4.setForeground(new java.awt.Color(11, 110, 229));

        tfNgaySinh.setForeground(new java.awt.Color(11, 110, 229));
        tfNgaySinh.setDateFormatString("yyyy-MM-dd");
        tfNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnChinhSua.setBackground(new java.awt.Color(255, 255, 0));
        btnChinhSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChinhSua.setForeground(new java.awt.Color(60, 60, 60));
        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(255, 255, 0));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(60, 60, 60));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(60, 60, 60));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel4))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfHinhAnh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfGhiChu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChonHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(tfHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnChonHinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        g_ConnectDB.closeConnection();
    }//GEN-LAST:event_formWindowClosing

    private void btnChonHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonHinhActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png", "jpeg");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            ImageIcon icon = new ImageIcon(path);
            if (icon != null) {
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                lblAvatar.setIcon(icon);
            }
            tfHinhAnh.setText(path);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }
    }//GEN-LAST:event_btnChonHinhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        String ngaySinh = ((JTextField) tfNgaySinh.getDateEditor().getUiComponent()).getText();
        if (!tfHoTen.getText().isEmpty() && !ngaySinh.isEmpty() && !tfGhiChu.getText().isEmpty() && !tfHinhAnh.getText().isEmpty()) {
            
            String maSo = Long.toString(g_currentID + 1);
            String hoTen = tfHoTen.getText().trim();
            String ghiChu = tfGhiChu.getText().trim();
            String hinhAnh = tfHinhAnh.getText();

            // thêm học sinh vào csdl
            try {
                PreparedStatement ps = g_Connection.prepareStatement("insert into hocsinh(MaSo,HoTen,NgaySinh,GhiChu,ExtInfo) values(?,?,?,?,?)");
                InputStream is = new FileInputStream(new File(hinhAnh));
                ps.setString(1, maSo);
                ps.setString(2, hoTen);
                ps.setString(3, ngaySinh);
                ps.setString(4, ghiChu);
                ps.setBlob(5, is);
                ps.executeUpdate();
                g_currentID++;
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại!");
                // clear các ô nhập
                tfHoTen.setText("");
                ((JTextField) tfNgaySinh.getDateEditor().getUiComponent()).setText("");
                tfGhiChu.setText("");
                tfHinhAnh.setText("");
                lblAvatar.setIcon(null);
                return;
            }
            // thêm học sinh vào bảng
            g_TableModel.addRow(new Object[]{g_currentID, hoTen, ngaySinh, ghiChu});
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
            // clear các ô nhập
            tfHoTen.setText("");
            ((JTextField) tfNgaySinh.getDateEditor().getUiComponent()).setText("");
            tfGhiChu.setText("");
            tfHinhAnh.setText("");
            lblAvatar.removeAll();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Hãy điền đủ thông tin cho học sinh!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        int r = tableHocSinh.getSelectedRow();
        if (r != -1) {
            tfHoTen.setText(g_TableModel.getValueAt(r, 1).toString());
            String ngaySinh = g_TableModel.getValueAt(r, 2).toString();
            ((JTextField) tfNgaySinh.getDateEditor().getUiComponent()).setText(ngaySinh);
            tfGhiChu.setText(g_TableModel.getValueAt(r, 3).toString());

            try {
                String _id = g_TableModel.getValueAt(r, 0).toString();
                Statement st = g_Connection.createStatement();
                ResultSet rs = st.executeQuery("select * from hocsinh where MaSo = '" + _id + "'");
                if (rs.next()) {
                    byte[] img = rs.getBytes("ExtInfo");
                    //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    lblAvatar.setIcon(newImage);
                } else {
                    JOptionPane.showMessageDialog(null, "No Data");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //lblAvatar.setIcon(icon);

            tableHocSinh.setEnabled(false);
            btnThem.setEnabled(false);
            btnChinhSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnLuu.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chọn 1 dòng để chỉnh sửa!");
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

        String ngaySinh = ((JTextField) tfNgaySinh.getDateEditor().getUiComponent()).getText();
        if (!tfHoTen.getText().isEmpty() && !ngaySinh.isEmpty() && !tfGhiChu.getText().isEmpty()) {

            int r = tableHocSinh.getSelectedRow();
            String maso = g_TableModel.getValueAt(r, 0).toString();

            String hoTen = tfHoTen.getText().trim();
            String ghiChu = tfGhiChu.getText().trim();
            String hinhAnh = tfHinhAnh.getText();

            // thêm học sinh vào csdl
            try {
                PreparedStatement ps;
                if(hinhAnh.isEmpty())
                    ps = g_Connection.prepareStatement("UPDATE hocsinh SET HoTen = ?, NgaySinh = ?, GhiChu = ? WHERE MaSo = ?");
                else{
                    ps = g_Connection.prepareStatement("UPDATE hocsinh SET HoTen = ?, NgaySinh = ?, GhiChu = ?, ExtInfo = ? WHERE MaSo = ?");
                    InputStream is = new FileInputStream(new File(hinhAnh));
                    ps.setBlob(4, is);
                }
                ps.setString(1, hoTen);
                ps.setString(2, ngaySinh);
                ps.setString(3, ghiChu);
                if(hinhAnh.isEmpty()){
                    ps.setString(4, maso);
                }else{
                    ps.setString(5, maso);
                }
                ps.executeUpdate();
                // sửa thông tin học sinh này trên bảng
                g_TableModel.setValueAt(hoTen, r, 1);
                g_TableModel.setValueAt(ngaySinh, r, 2);
                g_TableModel.setValueAt(ghiChu, r, 3);
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công!");
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại!");
            }

            // clear các ô nhập
            tfHoTen.setText("");
            ((JTextField) tfNgaySinh.getDateEditor().getUiComponent()).setText("");
            tfGhiChu.setText("");
            tfHinhAnh.setText("");
            lblAvatar.setIcon(null);

            tableHocSinh.setEnabled(true);
            btnThem.setEnabled(true);
            btnChinhSua.setEnabled(true);
            btnXoa.setEnabled(true);
            btnLuu.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Hãy điền đủ thông tin cho học sinh!");
        }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        
        int r = tableHocSinh.getSelectedRow();
        if (r != -1) {
            
            String maso = g_TableModel.getValueAt(r, 0).toString();
            
            // xóa học sinh trên bảng
            g_TableModel.removeRow(r);
            PreparedStatement ps;
            
            // xóa học sinh ở csdl
            try {
                ps = g_Connection.prepareStatement("DELETE FROM hocsinh WHERE MaSo = ?");
                ps.setString(1, maso);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Xóa thất bại!");
                return;
            }
            JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chọn 1 học sinh để xóa!");
        }
        
    }//GEN-LAST:event_btnXoaActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                //new MainFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnChonHinh;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JTable tableHocSinh;
    private javax.swing.JTextField tfGhiChu;
    private javax.swing.JTextField tfHinhAnh;
    private javax.swing.JTextField tfHoTen;
    private com.toedter.calendar.JDateChooser tfNgaySinh;
    // End of variables declaration//GEN-END:variables
}
