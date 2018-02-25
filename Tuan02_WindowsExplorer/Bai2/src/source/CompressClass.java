// Class này dùng để nén folder thành file *.zip
package source;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author thanhtri
 */
public class CompressClass {

    public CompressClass() {
    }

    // Dùng để nén một thư mục.
    public void zipItem(File inputDir, File outputZipFile) {

        if (inputDir.isFile()) {
            byte[] buffer = new byte[1024];

            try {
                // lấy tên của file cần nén
                String fileName = inputDir.toString();
                fileName = fileName.substring(fileName.lastIndexOf("\\"));
                FileOutputStream fos = new FileOutputStream(outputZipFile);
                ZipOutputStream zos = new ZipOutputStream(fos);
                ZipEntry ze = new ZipEntry(fileName);
                zos.putNextEntry(ze);
                FileInputStream in = new FileInputStream(inputDir);

                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }

                in.close();
                zos.closeEntry();

                //remember close it
                zos.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            // Tạo thư mục cha cho file đầu ra (output file).
            outputZipFile.getParentFile().mkdirs();

            String inputDirPath = inputDir.getAbsolutePath();
            byte[] buffer = new byte[1024];

            FileOutputStream fileOs = null;
            ZipOutputStream zipOs = null;
            try {

                List<File> allFiles = this.listChildFiles(inputDir);

                // Tạo đối tượng ZipOutputStream để ghi file zip.
                fileOs = new FileOutputStream(outputZipFile);
                // 
                zipOs = new ZipOutputStream(fileOs);
                for (File file : allFiles) {
                    String filePath = file.getAbsolutePath();

                    //System.out.println("Zipping " + filePath);
                    String entryName = filePath.substring(inputDirPath.length() + 1);

                    ZipEntry ze = new ZipEntry(entryName);
                    // Thêm entry vào file zip.
                    zipOs.putNextEntry(ze);
                    // Đọc dữ liệu của file và ghi vào ZipOutputStream.
                    FileInputStream fileIs = new FileInputStream(filePath);

                    int len;
                    while ((len = fileIs.read(buffer)) > 0) {
                        zipOs.write(buffer, 0, len);
                    }
                    fileIs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeQuite(zipOs);
                closeQuite(fileOs);
            }
        }
    }

    private void closeQuite(OutputStream out) {
        try {
            out.close();
        } catch (Exception e) {
        }
    }

    // Phương thức này trả về danh sách các file,
    // bao gồm tất cả các file con của thư mục đầu vào.
    private List<File> listChildFiles(File dir) throws IOException {
        List<File> allFiles = new ArrayList<File>();

        File[] childFiles = dir.listFiles();
        for (File file : childFiles) {
            if (file.isFile()) {
                allFiles.add(file);
            } else {
                List<File> files = this.listChildFiles(file);
                allFiles.addAll(files);
            }
        }
        return allFiles;
    }
}
