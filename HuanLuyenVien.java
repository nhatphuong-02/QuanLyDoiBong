package BAITAPLTHDT;

import java.time.LocalDate;
import java.util.ArrayList;

public class HuanLuyenVien extends ThanhVien {
    private String chuyenMon;
    private int namKinhNghiem;
    private int soTranThang;
    private int soTranThua;
    private int soTranHoa;

    //Constructor
    public HuanLuyenVien(){}
    public HuanLuyenVien(String id, String hoTen, int tuoi, double luongCoBan, LocalDate ngayVaoDoi ,String SDT, String email, int soNgayNghi, String chuyenMon, int namKinhNghiem){
        super(id,hoTen,tuoi,luongCoBan,ngayVaoDoi,SDT,email,soNgayNghi);
        this.chuyenMon = chuyenMon;
        this.namKinhNghiem = namKinhNghiem;
    }

    //Get
    public String getChuyenMon() {
        return chuyenMon;
    }
    public int getNamKinhNghiem() {
        return namKinhNghiem;
    }
    public int getSoTranHoa() {
        return soTranHoa;
    }
    public int getSoTranThang() {
        return soTranThang;
    }
    public int getSoTranThua() {
        return soTranThua;
    }

    //Set
    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }
    public void setNamKinhNghiem(int namKinhNghiem) {
        this.namKinhNghiem = namKinhNghiem;
    }

    //Chuyển dữ liệu để ghi file
    public String toFile(){
        return super.toFile()+","+this.chuyenMon+","+this.namKinhNghiem+","+this.soTranThang+","+this.soTranHoa+","+this.soTranThua;
    }

    //Lấy dữ liệu từ file
    public static HuanLuyenVien fromFile(String line){
        String[] part = line.split(",");

        if(part.length != 14) {
            System.out.println("Du lieu khong hop le: " + line);
            return null;
        }

        HuanLuyenVien hlv = new HuanLuyenVien();
        hlv.id = part[0];
        hlv.hoTen = part[1];
        hlv.tuoi = Integer.parseInt(part[2]);
        hlv.luongCoBan = Double.parseDouble(part[3]);
        hlv.ngayVaoDoi = LocalDate.parse(part[4],DinhDangThoiGian.dfNgay);
        hlv.SDT = part[5];
        hlv.email = part[6];
        hlv.soNgayNghi = Integer.parseInt(part[7]);
        hlv.setGhiChu(part[8]);
        hlv.chuyenMon = part[9];
        hlv.namKinhNghiem = Integer.parseInt(part[10]);
        hlv.soTranThang = Integer.parseInt(part[11]);
        hlv.soTranHoa = Integer.parseInt(part[12]);
        hlv.soTranThua = Integer.parseInt(part[13]);
        return hlv;
    }

    //Hàm hiển thị dạng bảng
    @Override
    public void hienThiBang(){
        System.out.printf("%-9s %-27s %-8d %-25s %-13d %-10.2f\n",
                        this.id, this.hoTen, this.tuoi, this.chuyenMon, this.namKinhNghiem, this.tinhLuong());
    }

    //Hàm nhập
    public void nhap(){
        super.nhap();
        System.out.print("Nhap chuyen mon: ");
        this.chuyenMon = Input.sc.nextLine();

        this.namKinhNghiem = Input.nhapSoGioiHan("Nhap nam kinh nghiem: ", 0, 99);

        this.soTranThang=0;

        this.soTranHoa=0;

        this.soTranThua=0;

        while(this.id.startsWith("HLV") == false){
            System.out.println("Ma huan luyen vien phai bat dau voi 'HLV'!");
            System.out.print("Nhap ma huan luyen vien: ");
            this.id = Input.sc.nextLine().toUpperCase();
        }
    }

    //Hàm hiển thị thông tin
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("Chuyen mon      : "+this.chuyenMon);
        System.out.println("Nam kinh nghiem : "+this.namKinhNghiem);
        System.out.println("So tran thang   : "+this.soTranThang);
        System.out.println("So tran hoa     : "+this.soTranHoa);
        System.out.println("So tran thua    : "+this.soTranThua);
        System.out.println("------------------------------------------------------------------");
    }


    //Tính lương
    public double tinhLuong(){
        int thuong = soTranThang*50;
        int phat = soTranThua*10;
        return this.luongCoBan + (double)(this.namKinhNghiem*150) + thuong - phat;
    }

    //Tính tỷ lệ thắng
    public double tinhTyLeThang(){
        int tongTran = this.soTranThang + this.soTranHoa + this.soTranThua;
        return tongTran == 0 ? 0 : (double) this.soTranThang/tongTran;
    }

    //Cập nhật tự động từ danh sách trận đấu
    public void capNhatThongKe(ArrayList<TranDau> dsTranDau){
        soTranThang = 0;
        soTranHoa = 0;
        soTranThua = 0;
        for(TranDau td : dsTranDau){
            int banThang = td.tinhTongBanThang();
            int banThua = td.tinhTongBanThua();
            if(banThang > banThua)
                soTranThang++;
            else if(banThang == banThua)
                soTranHoa++;
            else
                soTranThua++;
        }
    }
}