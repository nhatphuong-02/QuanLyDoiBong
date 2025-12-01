package BAITAPLTHDT;

import java.util.ArrayList;

public class QuanLyHLV implements IQuanLy<HuanLuyenVien> , IThongKe<HuanLuyenVien>, IReadWrite{
    private static final QuanLyHLV instance = new QuanLyHLV(); //Chỉ cho phép 1 lớp quản lý hlv duy nhất
    private ArrayList<HuanLuyenVien> dsHLV;

    public QuanLyHLV(){
        dsHLV = new ArrayList<>();
    }

    public static QuanLyHLV getInstance(){
        return instance;
    }
    //Get
    public ArrayList<HuanLuyenVien> getDsHLV() {
        return dsHLV;
    }

    //==========================================================Các hàm từ INTERFACE IReadWrite==========================================================

    //Lệnh đọc file
    @Override
    public void docFile(String fileName) {
        ArrayList<HuanLuyenVien> temp = (ArrayList<HuanLuyenVien>) FileHelper.readFile(fileName, HuanLuyenVien.class);
        if(temp != null) 
            dsHLV.addAll(temp);
    }

    //Lệnh ghi file
    @Override
    public void ghiFile(String fileName) {
        FileHelper.writeFile(fileName, dsHLV);
    }


    //==========================================================CÁC HÀM INTERFACE IQuanLy==========================================================
    //Hàm thêm
    @Override
    public void them(){
        HuanLuyenVien hlv = new HuanLuyenVien();
        hlv.nhap();

        for(HuanLuyenVien a : dsHLV)
            if(hlv.id.equalsIgnoreCase(a.id)){
                System.out.println("Ma thanh vien da ton tai!");
                return;
            }

        dsHLV.add(hlv);
        System.out.println("Them huan luyen vien thanh cong!");
    }

    //Hàm xóa
    @Override
    public void xoa(){
        System.out.println("Nhap ma huan luyen vien muon xoa: ");
        String id = Input.sc.nextLine();

        boolean removed = dsHLV.removeIf(a->a.id.equalsIgnoreCase(id));
        if(removed)
            System.out.println("Xoa huan luyen vien thanh cong!");
        else
            System.out.println("Huan luyen vien khong ton tai!");
    }

    //Hàm tìm kiếm
    @Override
    public HuanLuyenVien timKiem(String id){
        for(HuanLuyenVien a : dsHLV)
            if(a.id.equalsIgnoreCase(id))
                return a;
        return null;
    }
    public void timKiem(){
        System.out.println("Nhap ma huan luyen vien muon tim kiem: ");
        String id = Input.sc.nextLine();

        for(HuanLuyenVien a : dsHLV)
            if(a.id.equalsIgnoreCase(id)){
                a.hienThiThongTin();
                return;
            }

        System.out.println("Huan luyen vien khong ton tai");
    }

    //Hàm cập nhật
    @Override
    public void capNhat(){
        System.out.println("Nhap ma huan luyen vien muon cap nhat: ");
        String id = Input.sc.nextLine(); 
        for(HuanLuyenVien a: dsHLV)
            if(a.id.equalsIgnoreCase(id)){
                int choose = 1;
                while(choose!=0){
                    Input.clearScreen();
                    System.out.println("1.Cap nhat ho ten");
                    System.out.println("2.Cap nhat tuoi");
                    System.out.println("3.Cap nhat luong co ban");
                    System.out.println("4.Cap nhat chuyen mon");
                    System.out.println("5.Cap nhat nam kinh nghiem");
                    System.out.println("6.Tang so ngay nghi");
                    System.out.println("7.Cap nhat thong tin lien lac");
                    System.out.println("8.Cap nhat ghi chu");
                    
                    choose = Input.nhapSoGioiHan("Chon phan muon cap nhat: ", 1, 8);

                    switch (choose) {
                        case 1:
                            System.out.print("Cap nhat ho ten: ");
                            a.hoTen= Input.sc.nextLine();
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 2:
                            System.out.print("Cap nhat tuoi: ");
                            a.tuoi = Integer.parseInt(Input.sc.nextLine());
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 3:
                            System.out.print("Cap nhat luong co ban: ");
                            a.luongCoBan = Integer.parseInt(Input.sc.nextLine());
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 4:
                            System.out.print("Cap nhat chuyen mon: ");
                            a.setChuyenMon(Input.sc.nextLine());
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 5:
                            System.out.print("Cap nhat nam kinh nghiem: ");
                            a.setNamKinhNghiem(Integer.parseInt(Input.sc.nextLine()));
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 6:
                            System.out.println("Tang so ngay nghi: ");
                            a.tangSoNgayNghi();
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 7:
                            System.out.print("Cap nhat so dien thoai: ");
                            String sdt = Input.sc.nextLine();

                            System.out.print("Cap nhat email: ");
                            String email = Input.sc.nextLine();

                            a.capNhatThongTinLienLac(sdt, email);
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 8:
                            System.out.print("Cap nhat ghi chu: ");
                            a.setGhiChu(Input.sc.nextLine());

                            System.out.println("Cap nhat thanh cong");
                    }
                    
                    System.out.print("Ban co muon tiep tuc cap nhat hay khong?(1/0)\n");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ", 0, 1);
                }
                return;
            }
        System.out.println("Huan luyen vien khong ton tai");
    }

    //Hàm hiển thị danh sách
    @Override
    public void hienThiDanhSach(){
        if(dsHLV.isEmpty())
            System.out.println("Danh sach huan luyen vien rong!");
        else{
            dsHLV.sort((hlv1,hlv2)->hlv1.id.compareToIgnoreCase(hlv2.id));
            System.out.println("=========================================DANH SACH HUAN LUYEN VIEN=========================================");
            System.out.printf("%-8s| %-25s| %-5s| %-20s| %-18s| %-10s\n",
                            "Ma hlv","        Ho ten","Tuoi","    Chuyen mon","Nam kinh nghiem"," Luong($)");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            for(HuanLuyenVien a : dsHLV){
                a.hienThiBang();
            }
        }
    }

    //==========================================================CÁC HÀM INTERFACE IThongKe==========================================================
    //Tính tổng lương
    @Override
    public double tongLuong(){
        double sum = 0;
        for(HuanLuyenVien a : dsHLV){
            sum+=a.tinhLuong();
        }
        return sum;
    }

    //Tìm huấn luyện viên lương cao nhất
    @Override
    public void timLuongCaoNhat(){
        if(dsHLV.isEmpty()){
            System.out.println("Danh sach huan luyen vien rong");
            return;
        }

        double max = 0;
        HuanLuyenVien hlv = new HuanLuyenVien();
        for(HuanLuyenVien a : dsHLV)
            if(max<a.tinhLuong()){
                max = a.tinhLuong();
                hlv = a;
            }
        
        System.out.println("Huan luyen vien co luong cao nhat la: ");
        hlv.hienThiThongTin();
    }

    //Tính lương trung bình
    @Override
    public double luongTrungBinh(){
        return dsHLV.isEmpty() ? 0 : tongLuong()/soLuongThanhVien();
    }

    //Số lượng thành viên
    @Override
    public int soLuongThanhVien(){
        return dsHLV.size();
    }

    //==========================================================Các hàm khác==========================================================
    //Số trận thắng
    public int soTranThang(){
        int sum = 0;
        for(HuanLuyenVien a: dsHLV)
            sum+=a.getSoTranThang();
        return sum;
    }

    //Số trận thua
    public int soTranThua(){
        int sum = 0;
        for(HuanLuyenVien a: dsHLV)
            sum+=a.getSoTranThua();
        return sum;
    }

    //Số trận hòa
    public int soTranHoa(){
        int sum = 0;
        for(HuanLuyenVien a: dsHLV)
            sum+=a.getSoTranHoa();
        return sum;
    }

}