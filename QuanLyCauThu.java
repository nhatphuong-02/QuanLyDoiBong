package BAITAPLTHDT;


import java.util.ArrayList;

public class QuanLyCauThu implements IQuanLy<CauThu>, IThongKe<CauThu>, IReadWrite{
    private static final QuanLyCauThu instance = new QuanLyCauThu(); //Chỉ cho phép 1 lớp quản lý cầu thủ duy nhất
    private  ArrayList<CauThu> dsCauThu;

    public QuanLyCauThu(){
        dsCauThu = new ArrayList<>();
    }

    public static QuanLyCauThu getInstance() {
        return instance;
    }
    
    //Get
    public ArrayList<CauThu> getDsCauThu() {
        return dsCauThu;
    }

    //==========================================================Các hàm từ INTERFACE IReadWrite==========================================================
    
    //Lệnh ghi file
    public void ghiFile(String fileName) {
        FileHelper.writeFile(fileName, dsCauThu);
    }

    //Lệnh đọc file
    public void docFile(String fileName) {
       ArrayList<CauThu> temp = (ArrayList<CauThu>) FileHelper.readFile(fileName, CauThu.class);

        if(temp != null) 
            dsCauThu.addAll(temp);
    }

    //==========================================================CÁC HÀM INTERFACE IQuanLy==========================================================
    //Hàm thêm
    @Override 
    public void them(){
        CauThu ct = new CauThu();
        ct.nhap();

        for(CauThu a : dsCauThu)
            if(ct.id.equalsIgnoreCase(a.id)){
                System.out.println("Ma thanh vien da ton tai!");
                return;
            }

        dsCauThu.add(ct);
        System.out.println("Them cau thu thanh cong!");
    }

    //Hàm xóa
    @Override
    public void xoa(){
        System.out.print("Nhap ma cau thu muon xoa: ");
        String id = Input.sc.nextLine();

        boolean removed = dsCauThu.removeIf(a->a.id.equalsIgnoreCase(id));
        if(removed)
            System.out.println("Xoa cau thu thanh cong!");
        else
            System.out.println("Cau thu khong ton tai!");
    }

    //Hàm tìm kiếm
    @Override
    public CauThu timKiem(String id){
        for(CauThu a : dsCauThu)
            if(a.id.equalsIgnoreCase(id))
                return a; 
        return null;
    }
    public void timKiem(){
        System.out.print("Nhap ma cau thu muon tim kiem: ");
        String id = Input.sc.nextLine();

        for(CauThu a : dsCauThu)
            if(a.id.equalsIgnoreCase(id)){
                a.hienThiThongTin();
                return;
            }
        System.out.println("Cau thu khong ton tai");
   }

    //Hàm cập nhật
    @Override
    public void capNhat(){
        System.out.print("Nhap ma cau thu muon cap nhat: ");
        String id = Input.sc.nextLine();
        for(CauThu a: dsCauThu)
            if(a.id.equalsIgnoreCase(id)){
                int choose = 1;
                while(choose!=0){
                   Input.clearScreen();
                    System.out.println("1.Cap nhat ho ten");
                    System.out.println("2.Cap nhat tuoi");
                    System.out.println("3.Cap nhat luong co ban");
                    System.out.println("4.Cap nhat vi tri");
                    System.out.println("5.Cap nhat so ao");
                    System.out.println("6.Tang so ngay nghi");
                    System.out.println("7.Cap nhat thong tin lien lac");
                    System.out.println("8.Cap nhat so ban thang");
                    System.out.println("9.Cap nhat so tran dau");
                    System.out.println("10.Cap nhat so kien tao");
                    System.out.println("11.Cap nhat so the do");
                    System.out.println("12.Cap nhat so the vang");
                    System.out.println("13.Cap nhat tinh trang");
                    System.out.println("14.Cap nhat ghi chu");
                    
                    choose = Input.nhapSoGioiHan("Chon phan muon cap nhat: ", 1, 14);

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
                            System.out.print("Cap nhat vi tri: ");
                            a.setViTri(Input.sc.nextLine().toUpperCase());
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 5:
                            System.out.print("Cap nhat so ao: ");
                            a.setSoAo(Integer.parseInt(Input.sc.nextLine()));
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 6:
                            System.out.println("Tang so ngay nghi ");
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
                            System.out.print("Cap nhat so ban thang: ");
                            a.setSoBanThang(Integer.parseInt(Input.sc.nextLine()));
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 9:
                            System.out.print("Cap nhat so tran dau: ");
                            a.setSoTranDau(Integer.parseInt(Input.sc.nextLine()));
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 10:
                            System.out.print("Cap nhat so kien tao: ");
                            a.setSoKienTao(Integer.parseInt(Input.sc.nextLine()));
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 11:
                            System.out.print("Cap nhat so the do: ");
                            a.setSoTheDo(Integer.parseInt(Input.sc.nextLine()));
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 12:
                            System.out.print("Cap nhat so the vang: ");
                            a.setSoTheVang(Integer.parseInt(Input.sc.nextLine()));
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 13:
                            System.out.print("Cap nhat tinh trang(binh thuong/chan thuong): ");
                            String tinhTrang = Input.sc.nextLine().trim();

                            if(tinhTrang.equalsIgnoreCase("chan thuong"))
                                a.setDaChanThuong(true);
                            else    
                                a.setDaChanThuong(false);
                            
                            if(a.getDaChanThuong())
                                a.setDaChanThuong(false);
                            else
                                a.setDaChanThuong(true);
                                
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 14:
                            System.out.print("Cap nhat ghi chu: ");
                            a.setGhiChu(Input.sc.nextLine());

                            System.out.println("Cap nhat thanh cong");
                    }
                    
                    System.out.print("Ban co muon tiep tuc cap nhat hay khong?(1/0)\n");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ", 0, 1);
                }
                return;
            }
        
        System.out.println("Cau thu khong ton tai");
    }

    //Hàm hiển thị danh sách
    @Override
    public void hienThiDanhSach(){
        if(dsCauThu.isEmpty())
            System.out.println("Danh sach cau thu rong!");
        else{
            dsCauThu.sort((ct1,ct2)->ct1.id.compareToIgnoreCase(ct2.id));
            System.out.println("=============================================================================DANH SACH CAU THU=============================================================================");
            System.out.printf("%-11s|%-29s|%-7s|%-10s|%-7s|%-11s|%-11s|%-14s|%-13s|%-13s|%-14s|\n",
                            "Ma cau thu","            Ho ten"," Tuoi","  Vi tri"," So ao"," So ban thang "," So kien tao ","  So tran dau","  Luong($)","  Hieu suat","  Tinh trang");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for(CauThu a : dsCauThu){
                a.hienThiBang();
            }
        }
    }
    
    //==========================================================CÁC HÀM INTERFACE IThongKe==========================================================
    //Tính tổng lương
    @Override
    public double tongLuong(){
        double sum = 0;
        for(CauThu a : dsCauThu){
            sum+=a.tinhLuong();
        }
        return sum;
    }

    //Tìm cầu thủ lương cao nhất
    @Override
    public void timLuongCaoNhat(){
        if(dsCauThu.isEmpty()){
            System.out.println("Danh sach cau thu rong");
            return;
        }
        double max = 0;
        CauThu ct = new CauThu();
        for(CauThu a : dsCauThu)
            if(max<a.tinhLuong()){
                max = a.tinhLuong();
                ct = a;
            }
        
        System.out.println("Cau thu co luong cao nhat la: ");
        ct.hienThiThongTin();
    }

    //Tính lương trung bình
    @Override
    public double luongTrungBinh(){
        return dsCauThu.isEmpty() ? 0 : tongLuong()/soLuongThanhVien();
    }

    //Số lượng thành viên
    @Override
    public int soLuongThanhVien(){
        return dsCauThu.size();
    }


    //==========================================================Các hàm khác==========================================================
    //Hiệu suất trung bình
    public double hieuSuatTB(int soTranDau){
        return (double)soTranDau == 0 ? 0 : (double) tongSoBanThang()/ (double) soTranDau ;
    }

    //Tổng số bàn thắng
    public int tongSoBanThang(){
        int tongBanThang = 0;
        for(CauThu a:dsCauThu)
            tongBanThang+=a.getSoBanThang();
        return tongBanThang;
    }

    //Tổng số kiến tạo
    public int tongSoKienTao(){
        int tongKienTao = 0;
        for(CauThu a:dsCauThu)
            tongKienTao+=a.getSoKienTao();
        return tongKienTao;
    }

    //Tổng số thẻ vàng
    public int tongSoTheVang(){
        int tongTheVang = 0;
        for(CauThu a:dsCauThu)
            tongTheVang+=a.getSoTheVang();
        return tongTheVang;
    }

    //Tổng số thẻ đỏ
    public int tongSoTheDo(){
        int tongTheDo = 0;
        for(CauThu a:dsCauThu)
            tongTheDo+=a.getSoTheDo();
        return tongTheDo;
    }
}