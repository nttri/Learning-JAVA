/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import package1.HocSinh;
import package1.IOFile;

/**
 *
 * @author thanhtri
 */
public class Bai1 {

    private ArrayList<HocSinh> listHS;
    IOFile ioFile;
    private int g_MaSo = 0;
    private static final Bai1 g_b1 = new Bai1();
    private static BufferedReader g_br;

    public Bai1() {
        ioFile = new IOFile();
        listHS = new ArrayList<>();
        g_br = new BufferedReader(new InputStreamReader(System.in));
        listHS = ioFile.read("HS.dat");
        int nHS = listHS.size() - 1;
        if(nHS>=0){
            g_MaSo = listHS.get(nHS).getMHS() + 1;
        }
    }

    public void option1() throws IOException {
        String ten, diachi, ghichu;
        int err = 0;
        float diem = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n---------- THÊM HỌC SINH ----------");

        do {
            System.out.print("a. Nhập họ tên: ");
            ten = g_br.readLine();
        } while (ten.isEmpty());

        do {
            System.out.print("b. Điểm số: ");
            err = 0;
            try {
                diem = Float.parseFloat(g_br.readLine());
                if (diem < 0 || diem > 10) {
                    System.out.println("Điểm phải là số thực từ 0-10");
                    err = 1;
                }
            } catch (NumberFormatException nfe) {
                // người dùng nhập sai định dạng
                System.out.println("Điểm phải là số thực từ 0-10");
                err = 1;
            }
        } while (err != 0);

        do {
            System.out.print("c. Địa chỉ: ");
            diachi = g_br.readLine();
        } while (diachi.isEmpty());

        do {
            System.out.print("d. Ghi chú: ");
            ghichu = g_br.readLine();
        } while (ghichu.isEmpty());

        HocSinh hs = new HocSinh();
        hs.setMHS(g_MaSo);
        hs.setTenHS(ten);
        hs.setDiaChi(diachi);
        hs.setDiem(diem);
        hs.setGhiChu(ghichu);

        listHS.add(hs);
        ioFile.write(listHS, "HS.dat");
        g_MaSo++;
        System.out.print("Thêm thành công!\n\n");
    }

    public void option2() throws IOException {

        int err = 0, id;
        String ten, diachi, ghichu;
        float diem = 0;

        if (!listHS.isEmpty()) {
            System.out.println("\n--- CẬP NHẬT THÔNG TIN HỌC SINH ---");

            do {
                System.out.print("Nhập mã số HS muốn cập nhật: ");
                err = 2;
                try {
                    id = Integer.parseInt(g_br.readLine());
                    for (HocSinh hs : listHS) {
                        if (hs.getMHS() == id) {
                            System.out.println("Thông tin HS trước khi cập nhật:\n\t" + hs.toString());
                            System.out.println("Cập nhật lại:");
                            do {
                                System.out.print("a. Họ tên học sinh: ");
                                ten = g_br.readLine();
                            } while (ten.isEmpty());

                            do {
                                System.out.print("b. Điểm số: ");
                                err = 0;
                                try {
                                    diem = Float.parseFloat(g_br.readLine());
                                    if (diem < 0 || diem > 10) {
                                        System.out.println("Điểm phải là số thực từ 0-10");
                                        err = 1;
                                    }
                                } catch (NumberFormatException nfe) {
                                    // người dùng nhập sai định dạng
                                    System.out.println("Điểm phải là số thực từ 0-10");
                                    err = 1;
                                }
                            } while (err != 0);

                            do {
                                System.out.print("c. Địa chỉ: ");
                                diachi = g_br.readLine();
                            } while (diachi.isEmpty());

                            do {
                                System.out.print("d. Ghi chú: ");
                                ghichu = g_br.readLine();
                            } while (ghichu.isEmpty());

                            hs.setTenHS(ten);
                            hs.setDiaChi(diachi);
                            hs.setDiem(diem);
                            hs.setGhiChu(ghichu);
                            err = 0;
                            ioFile.write(listHS, "HS.dat");
                            System.out.print("Cập nhật thành công!");
                            break;
                        }
                    }
                    if (err == 2) {
                        System.out.println("Mã HS không tồn tại!");
                    }
                } catch (NumberFormatException nfe) {
                    // người dùng nhập sai định dạng
                    System.out.println("Mã HS phải là số nguyên dương!");
                    err = 1;
                }
            } while (err != 0);

        } else {
            System.out.println("\nKhông có dữ liệu của học sinh.");
        }
        System.out.println();
    }

    public void option3() {

        int err = 0,id;
        if (!listHS.isEmpty()) {
            System.out.println("\n---------- XÓA HỌC SINH -----------");
            //
            do {
                System.out.print("Nhập mã số HS muốn xóa: ");
                err = 2;
                try {
                    id = Integer.parseInt(g_br.readLine());
                    for (HocSinh hs : listHS) {
                        if (hs.getMHS() == id) {
                            listHS.remove(id);
                            err = 0;
                            ioFile.write(listHS, "HS.dat");
                            System.out.println("Xóa thành công!");
                            break;
                        }
                    }
                    if (err == 2) {
                        System.out.println("Mã HS không tồn tại!");
                    }
                } catch (NumberFormatException nfe) {
                    // người dùng nhập sai định dạng
                    System.out.println("Mã HS phải là số nguyên dương!");
                    err = 1;
                }catch (IOException ex) {
                    //Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (err != 0);
        } else {
            System.out.println("\nKhông có dữ liệu của học sinh.");
        }
        System.out.println();
    }

    public void option4() {
        if (!listHS.isEmpty()) {
            System.out.println("\n----- XEM DANH SÁCH HỌC SINH -----");
            for (HocSinh hs : listHS) {
                System.out.println(hs.toString());
            }
        } else {
            System.out.println("\nKhông có dữ liệu của học sinh.");
        }
        System.out.println();
    }

    public void option5() {

        if (!listHS.isEmpty()) {
            System.out.println("\n---- EXPORT DANH SÁCH HỌC SINH ----");
            try {
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("ThongTinHocSinh.csv"));
                for(HocSinh hs : listHS){
                    try {
                        dos.writeUTF(hs.toCSV());
                        dos.writeUTF("\n");
                    } catch (IOException ex) {
                        //Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("Export thành công ra file 'ThongTinHocSinh.csv'");
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("\nKhông có dữ liệu của học sinh.");
        }
        System.out.println();
    }

    public void showMenu() {
        System.out.println("********************* MENU *********************");
        System.out.println("1. Thêm học sinh");
        System.out.println("2. Cập nhật thông tin học sinh");
        System.out.println("3. Xóa học sinh");
        System.out.println("4. Xem danh sách học sinh");
        System.out.println("5. Export danh sách học sinh ra file .csv");
        System.out.println("0. Thoát chương trình");
        System.out.print("Chọn 1 chức năng(0-5): ");
    }

    public static void main(String[] args) {
        int choose = -1;

        do {
            g_b1.showMenu();
            choose = -1;
            try {
                choose = Integer.parseInt(g_br.readLine());
            } catch (NumberFormatException nfe) {
                // người dùng nhập sai định dạng
            } catch (IOException e) {
                //
            }

            switch (choose) {
                case 1: {
                    try {
                        g_b1.option1();
                    } catch (IOException ex) {
                        //Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 2: {
                    try {
                        g_b1.option2();
                    } catch (IOException ex) {
                        //Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                case 3: {
                    g_b1.option3();
                    break;
                }
                case 4: {
                    g_b1.option4();
                    break;
                }
                case 5: {
                    g_b1.option5();
                    break;
                }
                case 0: {
                    System.out.println("_________KẾT THÚC CHƯƠNG TRÌNH_________");
                    break;
                }
                default: {
                    System.out.println("Chỉ nhận số từ 0-5");
                    break;
                }
            }

        } while (choose != 0);
    }
}
