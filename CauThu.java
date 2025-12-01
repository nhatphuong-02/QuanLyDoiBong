package BAITAPLTHDT;

import java.time.LocalDate;

public class CauThu extends ThanhVien {
    private String viTri;
    private int soAo;
    private int soBanThang;
    private int soTranDau;
    private int soKienTao;
    private int soTheVang;
    private int soTheDo;
    private boolean daChanThuong;
    private double hieuSuat;
    private int diemThanhTich;

    //Constructor
    public CauThu(){}
    public CauThu(String id, String hoTen, int tuoi, double luongCoBan, LocalDate ngayVaoDoi ,String SDT, String email, int soNgayNghi, String viTri, int soAo, int soBanThang, int soTranDau, int soKienTao){
        super(id,hoTen,tuoi,luongCoBan,ngayVaoDoi,SDT,email,soNgayNghi);
        this.viTri = viTri;
        this.soAo = soAo;
        this.soBanThang = soBanThang;
        this.soKienTao = soKienTao;
        this.soTranDau = soTranDau;
    }

    //Set
    public void setSoTranDau(int soTranDau) {
        this.soTranDau = soTranDau;
    }
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }
    public void setSoAo(int soAo) {
        this.soAo = soAo;
    }
    public void setSoBanThang(int soBanThang) {
        this.soBanThang = soBanThang;
    }
    public void setSoKienTao(int soKienTao) {
        this.soKienTao = soKienTao;
    }
    public void setSoTheVang(int soTheVang) {
        this.soTheVang = soTheVang;
    }
    public void setSoTheDo(int soTheDo) {
        this.soTheDo = soTheDo;
    }
    public void setDaChanThuong(boolean daChanThuong) {
        this.daChanThuong = daChanThuong;
    }
    public void setDiemThanhTich(int diemThanhTich) {
        this.diemThanhTich = diemThanhTich;
    }
    
    //Get
    public String getViTri() {
        return viTri;
    }
    public int getSoAo() {
        return soAo;
    }
    public int getSoKienTao() {
        return soKienTao;
    }
    public int getSoTranDau() {
        return soTranDau;
    }
    public int getSoBanThang() {
        return soBanThang;
    }
    public int getSoTheVang() {
        return soTheVang;
    }
    public int getSoTheDo() {
        return soTheDo;
    }
    public int getDiemThanhTich() {
        return diemThanhTich;
    }
    public boolean getDaChanThuong(){
        return daChanThuong;
    }
    public double getHieuSuat() {
        return hieuSuat;
    }

    //Chuyển dữ liệu để ghi file
    public String toFile(){
        return super.toFile()+","+this.viTri+","+this.soAo+","+this.soBanThang+","+this.soTranDau+","+this.soKienTao+","+this.soTheVang+","+this.soTheDo+","+this.daChanThuong+","+this.hieuSuat+","+this.diemThanhTich;
    }
    
    //Lấy dữ liệu từ file
    public static CauThu fromFile(String line){
        String[] part = line.split(",");

        if(part.length != 19) {
            System.out.println("Du lieu khong hop le: " + line);
            return null;
        }

        CauThu ct = new CauThu();
        ct.id = part[0];
        ct.hoTen = part[1];
        ct.tuoi = Integer.parseInt(part[2]);
        ct.luongCoBan = Double.parseDouble(part[3]);
        ct.ngayVaoDoi = LocalDate.parse(part[4],DinhDangThoiGian.dfNgay);
        ct.SDT = part[5];
        ct.email = part[6];
        ct.soNgayNghi = Integer.parseInt(part[7]);
        ct.setGhiChu(part[8]);
        ct.viTri = part[9];
        ct.soAo = Integer.parseInt(part[10]);
        ct.soBanThang=Integer.parseInt(part[11]);
        ct.soTranDau=Integer.parseInt(part[12]);
        ct.soKienTao=Integer.parseInt(part[13]);
        ct.soTheVang=Integer.parseInt(part[14]);
        ct.soTheDo=Integer.parseInt(part[15]);
        ct.daChanThuong=Boolean.parseBoolean(part[16]);
        ct.hieuSuat = Double.parseDouble(part[17]);
        ct.diemThanhTich = Integer.parseInt(part[18]);
        return ct;
    }
    
    //Hiển thị dạng bảng
    @Override
    public void hienThiBang(){
            System.out.printf("%-12s %-30s %-7d %-10s %-10d %-15d %-13d %-11d %-14.2f %-7.2f %15s\n",
                        this.id, this.hoTen, this.tuoi, this.viTri, this.soAo, this.soBanThang,this.soKienTao,this.soTranDau,this.tinhLuong(),this.tinhHieuSuat(),(this.daChanThuong?"Chan thuong":"Binh thuong"));
    }

    //Hàm nhập
    public void nhap(){
        super.nhap();

        this.viTri = Input.nhapViTri();

        this.soAo = Input.nhapSoGioiHan("Nhap so ao(1-99): ", 1,99);

        this.soBanThang = 0;

        this.soTranDau = 0;

        this.soKienTao = 0;

        this.soTheVang = 0;

        this.soTheDo = 0;

        System.out.print("Nhap tinh trang(binh thuong/chan thuong): ");
        if(Input.sc.nextLine().trim().equalsIgnoreCase("Chan thuong"))
            this.daChanThuong = true;
        else
            this.daChanThuong = false;

        while(this.id.startsWith("CT") == false){
            System.out.println("Ma cau thu phai bat dau voi 'CT'!");
            System.out.print("Nhap ma cau thu: ");
            this.id = Input.sc.nextLine().toUpperCase();
        }
    }

    //Hàm hiển thị thông tin
    public void hienThiThongTin(){
        super.hienThiThongTin();
        System.out.println("Vi tri cau thu  : "+this.viTri);
        System.out.println("So ao           : "+this.soAo);
        System.out.println("So ban thang    : "+this.soBanThang);
        System.out.println("So kien tao     : "+this.soKienTao);
        System.out.println("So tran dau     : "+this.soTranDau);
        System.out.println("So the vang     : "+this.soTheVang);
        System.out.println("So the do       : "+this.soTheDo);
        System.out.println("Tinh trang      : "+(this.daChanThuong?"Chan thuong":"Binh thuong"));
        System.out.println("Hieu suat       : "+this.tinhHieuSuat());
        System.out.println("Diem thanh tich : "+this.diemThanhTich);
        System.out.println("------------------------------------------------------------------");
    }

    //Tính lương
    public double tinhLuong(){
        double thuong = this.soBanThang*200 + this.soKienTao*100 +this.diemThanhTich*50;
        double phat = this.soTheDo*500 + this.soTheVang*100;
        return this.luongCoBan + thuong - phat;
    }

    //Cập nhật trận đấu
    public void capNhatTranDau(int soBanThang, int soKienTao, int soTheDo, int soTheVang){
        this.soBanThang = this.soBanThang + soBanThang;
        this.soKienTao = this.soKienTao + soKienTao;
        this.soTheDo = this.soTheDo + soTheDo;
        this.soTheVang = this.soTheVang + soTheVang;
        this.soTranDau++;
    }

    //Tính hiệu suất
    public double tinhHieuSuat(){
        if(soTranDau==0)
            return 0;
        return this.hieuSuat = (double) soBanThang / soTranDau;
    }

    //Cập nhật điểm thành tích
    public void capNhatDiemThanhTich(){
        int diem = Input.nhapSoGioiHan("Nhap diem cong(diem tru): ", -50, 50);
        this.diemThanhTich = this.diemThanhTich+diem;
        System.out.println("Cap nhat diem thanh tich thanh cong");
    }

    //Cầu thủ có ra sân hay không
   public boolean coRaSan(TranDau tran) {
    if (tran.getCauThuThamGia() == null)
        return false;
    
    for (CauThu ct : tran.getCauThuThamGia())
        if (ct.id.equalsIgnoreCase(this.id)) 
            return true; 
        
    return false;
}

    //Đặt lại thống kê
    public void resetThongKe(){
        this.soBanThang = 0;
        this.soKienTao = 0;
        this.soTranDau = 0;
        this.soTheDo = 0;
        this.soTheVang = 0;
        this.hieuSuat = 0;
        this.diemThanhTich = 0;
    }
}