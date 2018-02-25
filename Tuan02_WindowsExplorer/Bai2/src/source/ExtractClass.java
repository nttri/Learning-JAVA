// Class này dùng để giải nén từ file *.zip
package source;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author thanhtri
 */
public class ExtractClass {
    
    private int g_subItem = 0;

    public int getG_subItem() {
        return g_subItem;
    }

    public void extract(String input, String output) {

        // Tạo một buffer
        byte[] buffer = new byte[1024];

        ZipInputStream zipIs = null;
        try {
            // Tạo đối tượng ZipInputStream để đọc file từ 1 path
            zipIs = new ZipInputStream(new FileInputStream(input));

            ZipEntry entry = null;
            // Duyệt từng Entry (Từ trên xuống dưới cho tới hết)
            while ((entry = zipIs.getNextEntry()) != null) {
                String entryName = entry.getName();
                String outFileName = output + File.separator + entryName;
                File newFile = new File(outFileName);

                // Tạo các thư mục.
                new File(newFile.getParent()).mkdirs();
                // Tạo một Stream để ghi dữ liệu vào file.
                FileOutputStream fos = new FileOutputStream(outFileName);

                int len;
                // Đọc dữ liệu trên Entry hiện tại.
                while ((len = zipIs.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                g_subItem++;
                fos.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zipIs.close();
            } catch (Exception e) {
            }
        }
    }
}
