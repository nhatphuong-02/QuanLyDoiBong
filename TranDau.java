package BAITAPLTHDT;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TranDau {
    private String idTran;
    private String doiNha;
    private String doiKhach;
    private LocalDate ngayThiDau;
    private LocalTime thoiGian;
    private String sanVanDong;
    private String ketQua;
    private ArrayList<CauThu> cauThuThamGia;
    private String hlvDoiNha;
    private String hlvDoiKhach;

    public TranDau(){
        cauThuThamGia = new ArrayList<>();
    }

    //Set
    public void setCauThuThamGia(ArrayList<CauThu> cauThuThamGia) {
        this.cauThuThamGia = cauThuThamGia;
    }
    public void setDoiKhach(String doiKhach) {
        this.doiKhach = doiKhach;
    }
    public void setDoiNha(String doiNha) {
        this.doiNha = doiNha;
    }
    public void setHlvDoiKhach(String hlvDoiKhach) {
        this.hlvDoiKhach = hlvDoiKhach;
    }
    public void setHlvDoiNha(String hlvDoiNha) {
        this.hlvDoiNha = hlvDoiNha;
    }
    public void setIdTran(String idTran) {
        this.idTran = idTran;
    }
    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }
    public void setNgayThiDau(LocalDate ngayThiDau) {
        this.ngayThiDau = ngayThiDau;
    }
    public void setSanVanDong(String sanVanDong) {
        this.sanVanDong = sanVanDong;
    }
    public void setThoiGian(LocalTime thoiGian) {
        this.thoiGian = thoiGian;
    }
    
    //Get
    public ArrayList<CauThu> getCauThuThamGia() {
        return cauThuThamGia;
    }
    public String getDoiKhach() {
        return doiKhach;
    }
    public String getDoiNha() {
        return doiNha;
    }
    public String getHlvDoiKhach() {
        return hlvDoiKhach;
    }
    public String getHlvDoiNha() {
        return hlvDoiNha;
    }
    public String getIdTran() {
        return idTran;
    }
    public String getKetQua() {
        return ketQua;
    }
    public LocalDate getNgayThiDau() {
        return ngayThiDau;
    }
    public String getSanVanDong() {
        return sanVanDong;
    }
    public LocalTime getThoiGian() {
        return thoiGian;
    }

   // Ghi dữ liệu ra file
    public String toFile() {
        StringBuilder sb = new StringBuilder();

        String ngay = (ngayThiDau == null) ? "" : ngayThiDau.format(DinhDangThoiGian.dfNgay);
        String gio  = (thoiGian == null) ? "" : thoiGian.format(DinhDangThoiGian.dfGio);

        sb.append(idTran).append(";")
        .append(doiNha).append(";")
        .append(doiKhach).append(";")
        .append(ngay).append(";")
        .append(gio).append(";")
        .append(sanVanDong).append(";")
        .append(ketQua).append(";");

        // Danh sách cầu thủ
        if (cauThuThamGia != null && !cauThuThamGia.isEmpty())
            for (int i = 0; i < cauThuThamGia.size(); i++) {
                sb.append(cauThuThamGia.get(i).toFile());
                if (i != cauThuThamGia.size() - 1)
                    sb.append("|");
            }

        sb.append(";")
        .append(hlvDoiNha).append(";")
        .append(hlvDoiKhach);

        return sb.toString();
    }


// Đọc dữ liệu từ file
    public static TranDau fromFile(String line) {
        String[] parts = line.split(";", 10); // 10 phần đầu, phần cầu thủ sẽ ở vị trí 7
        if(parts.length != 10) {
            System.out.println("Du lieu khong hop le: " + line);
            return null;
        }
        TranDau td = new TranDau();
        td.idTran = parts[0];
        td.doiNha = parts[1];
        td.doiKhach = parts[2];
        td.ngayThiDau = java.time.LocalDate.parse(parts[3], DinhDangThoiGian.dfNgay);
        td.thoiGian = java.time.LocalTime.parse(parts[4], DinhDangThoiGian.dfGio);
        td.sanVanDong = parts[5];
        td.ketQua = parts[6];

        // Danh sách cầu thủ
        if(!parts[7].isEmpty()) {
            String[] cauThus = parts[7].split("\\|");
            for(String ctStr : cauThus) {
                td.cauThuThamGia.add(CauThu.fromFile(ctStr));
            }
        }

        td.hlvDoiNha = parts[8];
        td.hlvDoiKhach = parts[9];

        return td;
    }


    //Nhập
    public void nhap(){
        System.out.print("Nhap ma tran: ");
        this.idTran = Input.sc.nextLine().toUpperCase();

        while(this.idTran.startsWith("TD") == false){
            System.out.println("Ma tran dau phai bat dau voi 'TD'!");
            System.out.print("Nhap ma tran: ");
            this.idTran = Input.sc.nextLine().toUpperCase();
        }

        System.out.print("Nhap ten doi: ");
        this.doiNha = Input.sc.nextLine();

        System.out.print("Nhap ten doi doi thu: ");
        this.doiKhach = Input.sc.nextLine();

        System.out.print("Nhap ngay thi dau(dd/MM/yyyy): ");
        this.ngayThiDau = Input.nhapNgay();

        System.out.print("Nhap thoi gian thi dau(HH:mm:ss): ");
        this.thoiGian= Input.nhapGio();

        System.out.print("Nhap ten san van dong: ");
        this.sanVanDong = Input.sc.nextLine();

        System.out.print("Nhap ket qua thi dau(Doi minh:Doi doi thu): ");
        this.ketQua = Input.sc.nextLine();

        System.out.println("\nThem danh sach cau thu tham gia.");
        int n = Input.nhapSoGioiHan("Nhap so luong cau thu tham gia: ", 14, 20);
        for(int i =0; i<n;i++){
            System.out.print("Nhap ma cau thu tham gia: ");
            String id = Input.sc.nextLine();
            CauThu ct = QuanLyCauThu.getInstance().timKiem(id);

            if(ct == null){
                System.out.println("Khong tim thay cau thu");
                i--;
            }
            else if(ct.getDaChanThuong()){
                System.out.println("Cau thu dang chan thuong khong the tham gia tran dau!");
                i--;
            }
            else{
                cauThuThamGia.add(ct);
                System.out.println("Da them cau thu "+ct.hoTen+" thanh cong\n");
            }
        }

        System.out.print("Nhap ten huan luyen vien doi nha: ");
        this.hlvDoiNha = Input.sc.nextLine();

        System.out.print("Nhap ten huan luyen vien doi khach: ");
        this.hlvDoiKhach = Input.sc.nextLine();
    }

    //Hàm hiển thị thông tin
    public void hienThiThongTin(){
        System.out.println("-------------Thong Tin Tran Dau----------------");
        System.out.println("Ma tran          : "+this.idTran);
        System.out.println("Ten doi          : "+this.doiNha);
        System.out.println("Ten doi doi thu  : "+this.doiKhach);
        System.out.println("Ngay thi dau     : "+this.ngayThiDau.format(DinhDangThoiGian.dfNgay));
        System.out.println("Thoi gian        : "+this.thoiGian.format(DinhDangThoiGian.dfGio));
        System.out.println("Ket qua thi dau  : "+this.ketQua);
    }

    //Cập nhật kết quả trận đấu
    public void capNhatKetQua(String ketQua){
        if(!ketQua.matches("\\d+:\\d+")){
            System.out.println("Nhap sai dinh dang nhap dung dinh dang so:so");
            return;
        }
        this.ketQua = ketQua;
    }

    //Thêm cầu thủ tham gia
    public void themCauThuThamGia(){
        System.out.println("Nhap ma cau thu: ");
        String id = Input.sc.nextLine().trim();
        CauThu ct = QuanLyCauThu.getInstance().timKiem(id);

        if(ct == null)
            System.out.println("Khong tim thay cau thu");
        else if(ct.getDaChanThuong())
            System.out.println("Cau thu dang chan thuong khong the tham gia tran dau!");
        else{
            cauThuThamGia.add(ct);
            System.out.println("Da them cau thu "+ct.hoTen+" thanh cong");
        }
    }

    //Xóa cầu thủ
    public void xoaCauThuThamGia(){
        System.out.println("Nhap ma cau thu: ");
        String id = Input.sc.nextLine().trim();
        CauThu ct = QuanLyCauThu.getInstance().timKiem(id);

        if(ct == null)
            System.out.println("Khong tim thay cau thu");
        else{
            cauThuThamGia.remove(ct);
            System.out.println("Da xoa cau thu "+ct.hoTen+" thanh cong");
        }
    }

    //Hiển thị danh sách cầu thủ tham gia
    public void dsCauThuThamGia(){
        int i= 1;
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-3s | %-30s | %-5s"
                        ,"STT","           Ten cau thu","So ao");
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        for(CauThu ct : cauThuThamGia){
            System.out.printf("%-6s %-32s %-5s\n",i,ct.hoTen,ct.getSoAo());
            i++;
        }
        
        System.out.println("-----------------------------------------------------------");
    }

    //Tính tổng bàn thắng
    public int tinhTongBanThang(){
        int soBanThang = 0;
        if(this.ketQua == null || !this.ketQua.matches("\\d+:\\d+"))
            return 0;

        String[] ar = this.getKetQua().split(":");
            soBanThang+=Integer.parseInt(ar[0]);
        return soBanThang;
    }

    //Tính tổng bàn thua
    public int tinhTongBanThua(){
        int soBanThua = 0;
        if(this.ketQua == null || !this.ketQua.matches("\\d+:\\d+")) 
            return 0;

        String[] ar = this.getKetQua().split(":");
            soBanThua+=Integer.parseInt(ar[1]);
        return soBanThua;
    }

    //Cập nhật kết quả trận đấu cho tất cả cầu thủ
    public void capNhatKetQua() {
        if(cauThuThamGia.isEmpty()) {
            System.out.println("Chua co cau thu nao tham gia tran dau nay!");
            return;
        }

        System.out.println("Cap nhat ket qua cho tran dau: " + this.idTran);
        
        for(CauThu ct : cauThuThamGia) {
            Input.clearScreen();
            System.out.println("Cau thu: " + ct.hoTen);

            System.out.print("Cau thu co ra san khong?(Co/Khong): ");
            String msg = Input.sc.nextLine();
            if(msg.equalsIgnoreCase("khong"))
                continue;

            int banThang = Input.nhapSoGioiHan("Nhap so ban thang: ", 0, 20);
            int kienTao = Input.nhapSoGioiHan("Nhap so kien tao: ", 0, 20);
            int theDo = Input.nhapSoGioiHan("Nhap so the do: ", 0, 1);
            int theVang = Input.nhapSoGioiHan("Nhap so the vang: ", 0, 2);

            CauThu ctgoc = QuanLyCauThu.getInstance().timKiem(ct.id);

            if(ctgoc != null){
                ctgoc.capNhatTranDau(banThang, kienTao, theDo, theVang);
                ctgoc.setDiemThanhTich(banThang*10+kienTao*5-theDo*5);
            }
        }

        System.out.println("Da cap nhat ket qua cho tat ca cau thu tham gia!");
    }

}