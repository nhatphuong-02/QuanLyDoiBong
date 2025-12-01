package BAITAPLTHDT;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Input {
    public static final Scanner sc = new Scanner(System.in);

    //Hàm xóa màn hình
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Hàm nhập ngày
    public static LocalDate nhapNgay() {
        while (true) {
            try {
                LocalDate ngay = LocalDate.parse(sc.nextLine(), DinhDangThoiGian.dfNgay);

                while(ngay.isAfter(LocalDate.now())){
                    System.out.println("Ngay nhap vao khong duoc lon hon ngay hien tai!");
                    System.out.print("Nhap lai ngay thang: ");
                    ngay = LocalDate.parse(sc.nextLine(), DinhDangThoiGian.dfNgay);
                }
                return ngay;
                
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang! Hay nhap lai dang dd/MM/yyyy.");
            }
        }
    }
    
    //Hàm nhập giờ
    public static LocalTime nhapGio() {
        while (true) {
            try {
                LocalTime gio = LocalTime.parse(sc.nextLine(), DinhDangThoiGian.dfGio);
                return gio;
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang! Hay nhap lai dang HH:mm:ss");
            }
        }
    }

    //Hàm nhập số nguyên giới hạn trong khoảng a đến b
    public static int nhapSoGioiHan(String msg, int a, int b){
        while (true) {
            try{
                System.out.print(msg);
                int so = Integer.parseInt(sc.nextLine());

                if(so<a || so>b)
                    System.out.println("Gia tri nhap vao phai nam trong khoang "+a+"-"+b+"\n");
                else
                    return so;
            }catch(Exception e){
                System.out.println("Gia tri nhap vao phai la so nguyen\n");
            }
        }
    }

    //Hàm nhập vị trí
    public static String nhapViTri(){
        while(true){
            System.out.print("Nhap vi tri (GK/DF/MF/FW): ");
            String viTri = sc.nextLine().trim().toUpperCase();
            if(viTri.equals("GK") || viTri.equals("DF") || viTri.equals("MF") || viTri.equals("FW"))
                return viTri;
            System.out.println("Vi tri khong hop le!");
        }
    }
}