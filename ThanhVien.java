package BAITAPLTHDT;

import java.time.LocalDate;

public abstract class ThanhVien implements ITinhLuong {
    protected String id;
    protected String hoTen;
    protected int tuoi;
    protected double luongCoBan;
    protected LocalDate ngayVaoDoi;
    protected String SDT;
    protected String email;
    protected int soNgayNghi;
    private String ghiChu;

    //Constructor
    public ThanhVien(){}
    public ThanhVien(String id, String hoTen, int tuoi, double luongCoBan, LocalDate ngayVaoDoi ,String SDT, String email, int soNgayNghi){
        this.id = id;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.luongCoBan = luongCoBan;
        this.ngayVaoDoi = ngayVaoDoi;
        this.SDT = SDT;
        this.email = email;
        this.soNgayNghi = soNgayNghi;
    }

    //Get
    public String getSDT() {
        return SDT;
    }
    public String getEmail() {
        return email;
    }
    public int getSoNgayNghi() {
        return soNgayNghi;
    }
    public String getGhiChu() {
        return ghiChu;
    }

    //Set
    public void setSDT(String sDT) {
        SDT = sDT;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSoNgayNghi(int soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    //Chuyển dữ liệu để ghi file
    public String toFile(){
        return this.id+","+this.hoTen+","+this.tuoi+","+this.luongCoBan+","+this.ngayVaoDoi.format(DinhDangThoiGian.dfNgay)+","+this.SDT+","+this.email+","+this.soNgayNghi+","+this.ghiChu;
    }

    //Hàm nhập
    public void nhap(){
        System.out.print("Nhap id: ");
        this.id = Input.sc.nextLine().toUpperCase();
        
        System.out.print("Nhap ho ten thanh vien: ");
        this.hoTen = Input.sc.nextLine();

        System.out.print("Nhap tuoi: ");
        this.tuoi = Integer.parseInt(Input.sc.nextLine());

        System.out.print("Nhap luong co ban: ");
        this.luongCoBan = Double.parseDouble(Input.sc.nextLine());

        System.out.print("Nhap ngay vao doi(dd/MM/yyyy): ");
        this.ngayVaoDoi = Input.nhapNgay();

        System.out.print("Nhap so ngay nghi: ");
        this.soNgayNghi = Integer.parseInt(Input.sc.nextLine());

        this.ghiChu="";
        System.out.print("Ghi chu: ");
        this.ghiChu = Input.sc.nextLine();
    }

    //Hàm hiển thị thông tin
    public void hienThiThongTin(){
        System.out.println("----------------------Thong Tin Thanh Vien------------------------");
        System.out.println("Ma thanh vien   : "+this.id);
        System.out.println("Ho ten          : "+this.hoTen);
        System.out.println("Tuoi            : "+this.tuoi);
        System.out.println("Luong co ban    : "+this.luongCoBan);
        System.out.println("Ngay vao doi    : "+this.ngayVaoDoi.format(DinhDangThoiGian.dfNgay));
    }

    //Tăng số ngày nghỉ
    public void tangSoNgayNghi(){
        this.soNgayNghi++;
    }

    //Cập nhật thông tin liên lạc
    public void capNhatThongTinLienLac(String SDT, String email){
        this.SDT = SDT;
        this.email = email;
    }

    //Phương thức trừu tượng
    public abstract void hienThiBang();
}


