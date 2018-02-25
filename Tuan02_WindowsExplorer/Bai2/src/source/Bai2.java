package source;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author thanhtri
 */
public class Bai2 extends javax.swing.JFrame {

    // ****************** GLOBAL VARIABLES ******************
    // g_Disks lấy danh sách các ổ đĩa trên máy
    private final File[] g_Disks = File.listRoots();
    // g_TreeModel lưu mẫu treeview
    private final DefaultTreeModel g_TreeModel;
    // g_TableModel lưu mẫu table
    private final DefaultTableModel g_TableModel;
    // g_CurrentPath lưu đường dẫn hiện tại
    private String g_CurrentPath = "";
    // g_copyFileSource lưu đường dẫn nguồn của file cần copy
    private String g_copyFileSource = "";
    // g_copyFolderSource lưu đường dẫn nguồn của folder cần copy
    private String g_copyFolderSource = "";
    // ******************************************************

    public Bai2() {
        initComponents();

        // vô hiệu hóa thanh đường dẫn
        lblPath.setEditable(false);
        // hiện đường dẫn
        lblPath.setText("This PC\\");
        // lấy cây
        g_TreeModel = (DefaultTreeModel) jTreeView.getModel();
        // lấy bảng
        g_TableModel = (DefaultTableModel) jTable.getModel();
        // lấy gốc của cây (this PC)
        DefaultMutableTreeNode nodeRoot = (DefaultMutableTreeNode) g_TreeModel.getRoot();
        // thêm đĩa vào gốc của cây
        int i = 0;
        for (File disk : g_Disks) {

            nodeRoot.add(new DefaultMutableTreeNode(disk.getAbsolutePath()));
            // lấy node con vừa thêm
            TreeNode nodeChild = nodeRoot.getChildAt(i);
            // thêm vào node con mới 1 node phụ để node trở thành thư mục (khi nào load sẽ xóa)
            ((DefaultMutableTreeNode) nodeChild).add(new DefaultMutableTreeNode("."));
            // thêm đĩa vào bảng
            g_TableModel.addRow(new Object[]{disk.toString(), "", "Local Disk", sizeToString(disk.getTotalSpace())});
            i++;
        }
        g_TreeModel.reload();

    }

    public String sizeToString(long _size) {
        String res = String.valueOf(_size) + " B";

        if (_size >= 1024 * 1024 * 1024) {
            res = String.valueOf((((_size / 1024) / 1024) / 1024) + 1) + " GB";
        } else if (_size >= 1024 * 1024) {
            res = String.valueOf(((_size / 1024) / 1024) + 1) + " MB";
        } else if (_size >= 1024) {
            res = String.valueOf((_size / 1024) + 1) + " KB";
        } else {
        }

        return res;
    }

    public void showDiskInfoOnTable() {

        // xóa các item trên table để load lại
        int nRowsOfTable = g_TableModel.getRowCount();
        if (nRowsOfTable > 0) {
            for (int i = 0; i < nRowsOfTable; i++) {
                g_TableModel.removeRow(nRowsOfTable - i - 1);
            }
        }

        // thêm đĩa vào bảng
        for (File disk : g_Disks) {
            g_TableModel.addRow(new Object[]{disk.toString(), "", "Local Disk", sizeToString(disk.getTotalSpace())});
        }
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void deleteFolder(final Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs)
                    throws IOException {
                Files.delete(file);
                return CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(final Path file, final IOException e) {
                return handleException(e);
            }

            private FileVisitResult handleException(final IOException e) {
                e.printStackTrace(); // replace with more robust error handling
                return TERMINATE;
            }

            @Override
            public FileVisitResult postVisitDirectory(final Path dir, final IOException e)
                    throws IOException {
                if (e != null) {
                    return handleException(e);
                }
                Files.delete(dir);
                return CONTINUE;
            }
        });
    }

    public static void copyFolder(File srcFolderPath, File destFolderPath) throws IOException {
        if (!srcFolderPath.isDirectory()) {
            copyFileUsingStream(srcFolderPath, destFolderPath);
        } else {
            if (!destFolderPath.exists()) {
                destFolderPath.mkdir();
            }
            String folder_contents[] = srcFolderPath.list();
            for (String file : folder_contents) {
                File srcFile = new File(srcFolderPath, file);
                File destFile = new File(destFolderPath, file);
                copyFolder(srcFile, destFile);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTreeView = new javax.swing.JTree();
        btnBack = new javax.swing.JButton();
        lblPath = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        btnNewFile = new javax.swing.JMenuItem();
        btnCopyFile = new javax.swing.JMenuItem();
        btnPasteFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnDeleteFile = new javax.swing.JMenuItem();
        menuFolder = new javax.swing.JMenu();
        btnNewFolder = new javax.swing.JMenuItem();
        btnCopyFolder = new javax.swing.JMenuItem();
        btnPasteFolder = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        btnDeleteFolder = new javax.swing.JMenuItem();
        menuZIP = new javax.swing.JMenu();
        btnCompress = new javax.swing.JMenuItem();
        btnExtract = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 650));

        jSplitPane2.setDividerSize(3);
        jSplitPane2.setMaximumSize(new java.awt.Dimension(659, 404));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date modified", "Type", "Size"
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
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setMinWidth(200);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(1).setMinWidth(150);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(2).setMinWidth(80);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable.getColumnModel().getColumn(3).setMinWidth(80);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        jSplitPane2.setRightComponent(jScrollPane2);

        jTreeView.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("This PC");
        jTreeView.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeView.addTreeExpansionListener(new javax.swing.event.TreeExpansionListener() {
            public void treeCollapsed(javax.swing.event.TreeExpansionEvent evt) {
            }
            public void treeExpanded(javax.swing.event.TreeExpansionEvent evt) {
                jTreeViewTreeExpanded(evt);
            }
        });
        jScrollPane3.setViewportView(jTreeView);

        jSplitPane2.setLeftComponent(jScrollPane3);

        btnBack.setBackground(new java.awt.Color(41, 184, 154));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPath.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblPath.setForeground(new java.awt.Color(41, 184, 154));

        menuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        menuFile.setText("File");

        btnNewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new file.png"))); // NOI18N
        btnNewFile.setText("New File");
        btnNewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFileActionPerformed(evt);
            }
        });
        menuFile.add(btnNewFile);

        btnCopyFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/copy file.png"))); // NOI18N
        btnCopyFile.setText("Copy File");
        btnCopyFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyFileActionPerformed(evt);
            }
        });
        menuFile.add(btnCopyFile);

        btnPasteFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paste file.png"))); // NOI18N
        btnPasteFile.setText("Paste File");
        btnPasteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasteFileActionPerformed(evt);
            }
        });
        menuFile.add(btnPasteFile);
        menuFile.add(jSeparator1);

        btnDeleteFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete file.png"))); // NOI18N
        btnDeleteFile.setText("Delete File");
        btnDeleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFileActionPerformed(evt);
            }
        });
        menuFile.add(btnDeleteFile);

        jMenuBar1.add(menuFile);

        menuFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder.png"))); // NOI18N
        menuFolder.setText("Folder");

        btnNewFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new folder.png"))); // NOI18N
        btnNewFolder.setText("New Folder");
        btnNewFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFolderActionPerformed(evt);
            }
        });
        menuFolder.add(btnNewFolder);

        btnCopyFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/copy folder.png"))); // NOI18N
        btnCopyFolder.setText("Copy Folder");
        btnCopyFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyFolderActionPerformed(evt);
            }
        });
        menuFolder.add(btnCopyFolder);

        btnPasteFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paste file.png"))); // NOI18N
        btnPasteFolder.setText("Paste Folder");
        btnPasteFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasteFolderActionPerformed(evt);
            }
        });
        menuFolder.add(btnPasteFolder);
        menuFolder.add(jSeparator2);

        btnDeleteFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete folder.png"))); // NOI18N
        btnDeleteFolder.setText("Delete Folder");
        btnDeleteFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFolderActionPerformed(evt);
            }
        });
        menuFolder.add(btnDeleteFolder);

        jMenuBar1.add(menuFolder);

        menuZIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zip.png"))); // NOI18N
        menuZIP.setText("Zip/Unzip");

        btnCompress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/compress.png"))); // NOI18N
        btnCompress.setText("Compress to .zip");
        btnCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompressActionPerformed(evt);
            }
        });
        menuZIP.add(btnCompress);

        btnExtract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/extract.png"))); // NOI18N
        btnExtract.setText("Extract file");
        btnExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtractActionPerformed(evt);
            }
        });
        menuZIP.add(btnExtract);

        jMenuBar1.add(menuZIP);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPath)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblPath, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked

        if (evt.getClickCount() == 2) {
            // lấy item được chọn
            int selectedRow = jTable.getSelectedRow();
            String selectedItem = (String) g_TableModel.getValueAt(selectedRow, 0);
            // lấy đường dẫn hiện tại
            String tempPath = g_CurrentPath + File.separator + selectedItem;

            // mở đường dẫn mới lên
            File item = new File(tempPath);

            // nếu là file
            if (item.isFile()) {
                try {
                    // chạy ứng dụng để mở file
                    Desktop.getDesktop().open(item);
                } catch (IOException ex) {
                    Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            // nếu là folder
            if (item.isDirectory()) {
                // xóa các item trên table để load lại
                int nRowsOfTable = g_TableModel.getRowCount();
                if (nRowsOfTable > 0) {
                    for (int i = 0; i < nRowsOfTable; i++) {
                        g_TableModel.removeRow(nRowsOfTable - i - 1);
                    }
                }

                File[] files = item.listFiles();
                int i = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
                for (File f : files) {
                    // load các thư mục không ẩn lên treeview
                    if (!f.isHidden()) {
                        if (f.isDirectory()) {
                            // hiển thị lên table
                            g_TableModel.addRow(new Object[]{f.getName(), sdf.format(f.lastModified()), "Folder"});
                        }
                        if (f.isFile()) {
                            g_TableModel.addRow(new Object[]{f.getName(), sdf.format(f.lastModified()), "File", sizeToString(f.length())});
                        }
                    }
                }
                if (tempPath.startsWith("\\")) {
                    tempPath = tempPath.substring(1);
                }
                g_CurrentPath = tempPath;
                // hiện đường dẫn
                lblPath.setText("This PC\\" + g_CurrentPath);
            }
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jTreeViewTreeExpanded(javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_jTreeViewTreeExpanded

        TreePath path = evt.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        if (node.toString().equals("This PC")) {
            showDiskInfoOnTable();
            g_CurrentPath = "";
            // hiện đường dẫn
            lblPath.setText("This PC\\");
            return;
        }
        node.removeAllChildren();

        // lấy đường dẫn mới
        Object[] paths = path.getPath();
        g_CurrentPath = "";
        for (int i = 0; i < paths.length; i++) {
            g_CurrentPath += paths[i];
            if (i + 1 < paths.length) {
                g_CurrentPath += File.separator;
            }
        }
        // bỏ đi phần "This PC\" trong đường dẫn
        g_CurrentPath = g_CurrentPath.substring(8);

        // xóa các item trên table để load lại
        int nRowsOfTable = g_TableModel.getRowCount();
        if (nRowsOfTable > 0) {
            for (int i = 0; i < nRowsOfTable; i++) {
                g_TableModel.removeRow(nRowsOfTable - i - 1);
            }
        }

        // lấy các thư mục con
        if (node != null) {
            //JOptionPane.showMessageDialog(rootPane, g_CurrentPath);
            File parent = new File(g_CurrentPath);
            File[] files = parent.listFiles();
            int i = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            for (File f : files) {
                // load các thư mục không ẩn lên treeview
                if (!f.isHidden()) {
                    if (f.isDirectory()) {
                        node.add(new DefaultMutableTreeNode(f.getName()));
                        // lấy node con vừa thêm
                        TreeNode nodeChild = node.getChildAt(i);
                        // thêm vào node con mới 1 node phụ để node có icon thư mục (khi nào load sẽ xóa)
                        ((DefaultMutableTreeNode) nodeChild).add(new DefaultMutableTreeNode("."));
                        i++;
                        // hiển thị lên table
                        //JOptionPane.showMessageDialog(rootPane, f.getName());
                        g_TableModel.addRow(new Object[]{f.getName(), sdf.format(f.lastModified()), "Folder"});
                    }
                    if (f.isFile()) {
                        g_TableModel.addRow(new Object[]{f.getName(), sdf.format(f.lastModified()), "File", sizeToString(f.length())});
                    }
                }
            }
        }
        g_TreeModel.reload(node);
        // hiện đường dẫn
        lblPath.setText("This PC\\" + g_CurrentPath);
    }//GEN-LAST:event_jTreeViewTreeExpanded

    private void btnCopyFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyFileActionPerformed

        // lấy item được chọn
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(rootPane, "Choose a File to copy!");
            return;
        }
        String selectedItem = (String) g_TableModel.getValueAt(selectedRow, 0);
        // lấy đường dẫn hiện tại
        String tempPath = g_CurrentPath + "\\" + selectedItem;

        // mở đường dẫn mới lên
        File item = new File(tempPath);

        // nếu là file
        if (item.isFile()) {
            g_copyFileSource = tempPath;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Choose a File to copy!");
        }
    }//GEN-LAST:event_btnCopyFileActionPerformed

    private void btnPasteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasteFileActionPerformed

        if (g_copyFileSource.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please copy a file before paste it!");
            return;
        }
        Path src = Paths.get(g_copyFileSource);

        // lấy đường dẫn hiện tại
        String destStr = g_CurrentPath;

        // thêm tên file vào đuôi đường dẫn
        destStr += "\\" + src.getFileName().toString();
        Path dest = Paths.get(destStr);

        // copy
        File source = src.toFile();
        File destination = dest.toFile();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        int index = 2;
        String headName = destStr.substring(0, destStr.lastIndexOf("."));
        String ext = destStr.substring(destStr.lastIndexOf("."));
        while (destination.exists()) {
            destStr = headName + " (" + index + ")" + ext;
            destination = new File(destStr);
            index++;
        }

        try {
            copyFileUsingStream(source, destination);
            // thêm File mới copy vào jTable
            g_TableModel.addRow(new Object[]{destination.getName(), sdf.format(destination.lastModified()), "File", sizeToString(destination.length())});
        } catch (IOException ex) {
            //Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(rootPane, dest);
    }//GEN-LAST:event_btnPasteFileActionPerformed

    private void btnDeleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFileActionPerformed

        // lấy item được chọn
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(rootPane, "Choose a File to delete!");
            return;
        }
        String selectedItem = (String) g_TableModel.getValueAt(selectedRow, 0);
        // lấy đường dẫn hiện tại
        String tempPath = g_CurrentPath + "\\" + selectedItem;

        // nếu xóa file đang lưu trong copy thì xóa chuỗi đã lưu
        if (tempPath.equals(g_copyFileSource)) {
            g_copyFileSource = "";
        }

        // mở đường dẫn mới lên
        File item = new File(tempPath);

        // nếu là file
        if (item.isFile()) {
            try {
                // xóa file đó
                Files.delete(item.toPath());
                // cập nhật lại bảng jTable
                g_TableModel.removeRow(selectedRow);
            } catch (IOException ex) {
                //Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(rootPane, "Delete file completed!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Choose a File to delete!");
        }
    }//GEN-LAST:event_btnDeleteFileActionPerformed

    private void btnNewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFileActionPerformed

        if (g_CurrentPath.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Can not create new file here!");
            return;
        }
        String newFilePath = g_CurrentPath + "\\New File";
        File newFile = new File(newFilePath);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        int index = 2;
        while (newFile.exists()) {
            newFilePath = g_CurrentPath + "\\New File" + " (" + index + ")";
            newFile = new File(newFilePath);
            index++;
        }
        try {
            Files.createFile(newFile.toPath());
            // cập nhật lại jTable
            g_TableModel.addRow(new Object[]{newFile.getName(), sdf.format(newFile.lastModified()), "File", sizeToString(newFile.length())});
        } catch (IOException ex) {
            //Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewFileActionPerformed

    private void btnNewFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFolderActionPerformed

        if (g_CurrentPath.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Can not create new folder here!");
            return;
        }
        String newFolderPath = g_CurrentPath + "\\New Folder";
        File newFolder = new File(newFolderPath);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        int index = 2;
        while (newFolder.exists()) {
            newFolderPath = g_CurrentPath + "\\New Folder" + " (" + index + ")";
            newFolder = new File(newFolderPath);
            index++;
        }
        try {
            //Files.createFile(newFile.toPath());
            Files.createDirectory(newFolder.toPath());
            // cập nhật lại jTable
            g_TableModel.addRow(new Object[]{newFolder.getName(), sdf.format(newFolder.lastModified()), "Folder"});
        } catch (IOException ex) {
            //Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewFolderActionPerformed

    private void btnCopyFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyFolderActionPerformed

        // lấy item được chọn
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(rootPane, "Choose a Folder to copy!");
            return;
        }
        String selectedItem = (String) g_TableModel.getValueAt(selectedRow, 0);
        // lấy đường dẫn hiện tại
        String tempPath = g_CurrentPath + "\\" + selectedItem;

        // mở đường dẫn mới lên
        File item = new File(tempPath);

        // nếu là folder
        if (item.isDirectory()) {
            g_copyFolderSource = tempPath;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Choose a Folder to copy!");
        }
    }//GEN-LAST:event_btnCopyFolderActionPerformed

    private void btnDeleteFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFolderActionPerformed

        // lấy item được chọn
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(rootPane, "Choose a Folder to delete!");
            return;
        }
        String selectedItem = (String) g_TableModel.getValueAt(selectedRow, 0);
        // lấy đường dẫn hiện tại
        String tempPath = g_CurrentPath + "\\" + selectedItem;

        // nếu xóa folder đang lưu trong copy thì xóa chuỗi đã lưu
        if (tempPath.equals(g_copyFolderSource)) {
            g_copyFolderSource = "";
        }

        // mở đường dẫn mới lên
        File item = new File(tempPath);

        // nếu là folder
        if (item.isDirectory()) {
            try {
                deleteFolder(item.toPath());
                // cập nhật lại bảng jTable
                g_TableModel.removeRow(selectedRow);
            } catch (IOException ex) {
                //Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(rootPane, "Delete folder completed!");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Choose a Folder to delete!");
        }
    }//GEN-LAST:event_btnDeleteFolderActionPerformed

    private void btnPasteFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasteFolderActionPerformed

        if (g_copyFolderSource.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please copy a folder before paste it!");
            return;
        }
        Path src = Paths.get(g_copyFolderSource);

        // lấy đường dẫn hiện tại
        String destStr = g_CurrentPath;

        // thêm tên folder vào đuôi đường dẫn
        destStr += "\\" + src.getFileName().toString();
        Path dest = Paths.get(destStr);

        // copy
        File source = src.toFile();
        File destination = dest.toFile();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        int index = 2;
        String temp = destStr;
        while (destination.exists()) {
            destStr = temp + " (" + index + ")";
            destination = new File(destStr);
            index++;
        }

        try {
            copyFolder(source, destination);
            // thêm Folder mới copy vào jTable
            g_TableModel.addRow(new Object[]{destination.getName(), sdf.format(destination.lastModified()), "Folder"});
        } catch (IOException ex) {
            //Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(rootPane, dest);
    }//GEN-LAST:event_btnPasteFolderActionPerformed

    private void btnCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompressActionPerformed

        // lấy item được chọn
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(rootPane, "Choose a File/Folder to compress!");
            return;
        }
        String selectedItem = (String) g_TableModel.getValueAt(selectedRow, 0);
        // lấy đường dẫn hiện tại
        String tempPath = g_CurrentPath + "\\" + selectedItem;

        // mở đường dẫn mới lên
        File item = new File(tempPath);

        // kiểm tra đuôi file chọn, nếu thuộc các đuôi đã nén thì thoát
        if (item.isFile() && tempPath.lastIndexOf(".") >= 0) {
            String extension = tempPath.substring(tempPath.lastIndexOf("."));
            if (".rar".equals(extension) || ".7z".equals(extension) || ".zip".equals(extension)) {
                JOptionPane.showMessageDialog(rootPane, "File has already compressed before!");
                return;
            }
        }

        if (item.isDirectory() || item.isFile()) {
            CompressClass zipPath = new CompressClass();

            File inputDir = new File(tempPath);
            String tempPath2 = "";
            if (item.isDirectory()) {
                tempPath2 = tempPath + ".zip";
            } else {
                tempPath2 = tempPath.substring(0, tempPath.lastIndexOf("."));
                tempPath2 += ".zip";
            }
            File outputZipFile = new File(tempPath2);

            int index = 2;
            String headName = tempPath2.substring(0, tempPath2.lastIndexOf("."));
            String ext = tempPath2.substring(tempPath2.lastIndexOf("."));
            while (outputZipFile.exists()) {
                tempPath2 = headName + " (" + index + ")" + ext;
                outputZipFile = new File(tempPath2);
                index++;
            }

            zipPath.zipItem(inputDir, outputZipFile);

            // cập nhật lại jTable
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            g_TableModel.addRow(new Object[]{outputZipFile.getName(), sdf.format(outputZipFile.lastModified()), "File", sizeToString(outputZipFile.length())});

            JOptionPane.showMessageDialog(rootPane, "Compress completed to file: " + outputZipFile.getName());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Choose a Folder/File to compress!");
        }
    }//GEN-LAST:event_btnCompressActionPerformed

    private void btnExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtractActionPerformed

        ExtractClass zipPath = new ExtractClass();

        // lấy item được chọn
        int selectedRow = jTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(rootPane, "Choose a Folder to compress!");
            return;
        }
        String selectedItem = (String) g_TableModel.getValueAt(selectedRow, 0);
        // lấy đường dẫn hiện tại
        String tempPath = g_CurrentPath + "\\" + selectedItem;

        // Kiểm tra đuôi .zip, nếu khác sẽ báo lỗi cho người dùng
        String ext;
        if (tempPath.lastIndexOf(".") < 0) {
            JOptionPane.showMessageDialog(rootPane, "Only extract *.zip file.");
            return;
        }
        ext = tempPath.substring(tempPath.lastIndexOf("."));
        if (!ext.equals(".zip")) {
            JOptionPane.showMessageDialog(rootPane, "Only extract *.zip file.");
            return;
        }

        // mở đường dẫn mới lên
        File item = new File(tempPath);

        // tạo thư mục mới để lưu file/folder sau khi giải nén
        String folderName = tempPath.substring(0, tempPath.lastIndexOf("."));
        int index = 2;
        String temp = folderName;
        File folder = new File(folderName);
        while (folder.exists()) {
            folderName = temp + " (" + index + ")";
            folder = new File(folderName);
            index++;
        }
        try {
            Files.createDirectory(folder.toPath());
        } catch (IOException ex) {
            Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
        }

        zipPath.extract(tempPath, folderName);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        g_TableModel.addRow(new Object[]{folder.getName(), sdf.format(folder.lastModified()), "Folder"});
        JOptionPane.showMessageDialog(rootPane, "Extract file completed to folder " + folderName);
    }//GEN-LAST:event_btnExtractActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        // Nếu đang ở ngoài cùng (This PC) thì không được back nữa
        if (g_CurrentPath.isEmpty()) {
            return;
        }

        String labelPath = lblPath.getText();
        if (labelPath.lastIndexOf("\\") == labelPath.length() - 1) {
            // xóa các kí tự '\' ở đuôi
            String res = labelPath.substring(0, labelPath.lastIndexOf("\\"));
            int pos = res.lastIndexOf("\\");
            while (pos == res.length() - 1) {
                res = res.substring(0, res.lastIndexOf("\\"));
                pos = res.lastIndexOf("\\");
            }
            labelPath = res;
        }

        labelPath = labelPath.substring(0, labelPath.lastIndexOf("\\"));
        g_CurrentPath = labelPath;
        // bỏ đi phần "This PC" trong đường dẫn
        if (g_CurrentPath.startsWith("This PC\\")) {
            g_CurrentPath = g_CurrentPath.substring(8);
        } else {
            g_CurrentPath = g_CurrentPath.substring(7);
        }

        // cập nhật lại jtable
        if (g_CurrentPath.isEmpty()) {
            showDiskInfoOnTable();
        } else {
            // xóa các item trên table để load lại
            int nRowsOfTable = g_TableModel.getRowCount();
            if (nRowsOfTable > 0) {
                for (int i = 0; i < nRowsOfTable; i++) {
                    g_TableModel.removeRow(nRowsOfTable - i - 1);
                }
            }
            File item = new File(g_CurrentPath);

            File[] files = item.listFiles();
            int i = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            for (File f : files) {
                // load các thư mục không ẩn lên treeview
                if (!f.isHidden()) {
                    if (f.isDirectory()) {
                        // hiển thị lên table
                        g_TableModel.addRow(new Object[]{f.getName(), sdf.format(f.lastModified()), "Folder"});
                    }
                    if (f.isFile()) {
                        g_TableModel.addRow(new Object[]{f.getName(), sdf.format(f.lastModified()), "File", sizeToString(f.length())});
                    }
                }
            }
        }
        lblPath.setText("This PC\\" + g_CurrentPath);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bai2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JMenuItem btnCompress;
    private javax.swing.JMenuItem btnCopyFile;
    private javax.swing.JMenuItem btnCopyFolder;
    private javax.swing.JMenuItem btnDeleteFile;
    private javax.swing.JMenuItem btnDeleteFolder;
    private javax.swing.JMenuItem btnExtract;
    private javax.swing.JMenuItem btnNewFile;
    private javax.swing.JMenuItem btnNewFolder;
    private javax.swing.JMenuItem btnPasteFile;
    private javax.swing.JMenuItem btnPasteFolder;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTree jTreeView;
    private javax.swing.JTextField lblPath;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuFolder;
    private javax.swing.JMenu menuZIP;
    // End of variables declaration//GEN-END:variables
}
