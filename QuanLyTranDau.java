package BAITAPLTHDT;

import java.util.ArrayList;

public class QuanLyTranDau implements IQuanLy<TranDau>, IReadWrite{
    private String tenGiaiDau;
    private ArrayList<TranDau> dsTranDau = new ArrayList<>();

    //Set
    public void setTenGiaiDau(String tenGiaiDau) {
        this.tenGiaiDau = tenGiaiDau;
    }
    
    //Get
    public String getTenGiaiDau() {
        return tenGiaiDau;
    }
    public ArrayList<TranDau> getDsTranDau() {
        return dsTranDau;
    }

    //==========================================================Các hàm từ INTERFACE IReadWrite==========================================================

     //Lệnh ghi file
    public void ghiFile(String fileName) {
        FileHelper.writeFile(fileName, dsTranDau);
    }

    //Lệnh đọc file
    public void docFile(String fileName) {
       ArrayList<TranDau> temp = (ArrayList<TranDau>) FileHelper.readFile(fileName, TranDau.class);
        if(temp != null)
            dsTranDau.addAll(temp);
    }

    //==========================================================Các hàm từ INTERFACE IQuanLy==========================================================
    //Thêm trận đấu
    @Override
    public void them(){
        TranDau td = new TranDau();
        td.nhap();

        for(TranDau a : dsTranDau)
            if(a.getIdTran().equalsIgnoreCase(td.getIdTran())){
                System.out.println("Tran dau da ton tai!");
                return;
            }
        dsTranDau.add(td);
        System.out.println("Them tran dau thanh cong!");

        for(CauThu ct : td.getCauThuThamGia()){
            ct.setSoTranDau(ct.getSoTranDau()+1);
        }

    }

    //Xóa trận đấu
    @Override
    public void xoa(){
        System.out.println("Nhap ma tran muon xoa: ");
        String id = Input.sc.nextLine();
        
        boolean removed =  dsTranDau.removeIf(a->a.getIdTran().equalsIgnoreCase(id));
        if(removed)
            System.out.println("Xoa tran dau thanh cong!");
        else
            System.out.println("Tran dau khong ton tai");
    }

    //Tìm kiếm trận đấu
    @Override
    public TranDau timKiem(String id){
        for(TranDau a: dsTranDau)
            if(a.getIdTran().equalsIgnoreCase(id))
                return a;
        return null;
    }
    public void timKiem(){
        System.out.println("Nhap ma tran muon tim kiem: ");
        String id = Input.sc.nextLine();

        for(TranDau a: dsTranDau)
            if(a.getIdTran().equalsIgnoreCase(id)){
                a.hienThiThongTin();
                return;
            }
        
        System.out.println("Khong tim thay tran dau");
    }

    //Cập nhật trận đấu
    @Override
    public void capNhat(){
        System.out.println("Nhap ma tran muon cap nhat: ");
        String id = Input.sc.nextLine();

        for(TranDau a: dsTranDau){
            if(a.getIdTran().equalsIgnoreCase(id)){
                int choose = 1;
                while(choose!=0){
                    System.out.println("1.Cap nhat ten doi nha");
                    System.out.println("2.Cap nhat ten doi khach");
                    System.out.println("3.Cap nhat ngay thi dau");
                    System.out.println("4.Cap nhat thoi gian");
                    System.out.println("5.Cap nhat san van dong");
                    System.out.println("6.Cap nhat hlv doi nha");
                    System.out.println("7.Cap nhat hlv doi khach");
                    
                    choose = Input.nhapSoGioiHan("Chon phan muon cap nhat: ", 1, 7);

                    switch (choose) {
                        case 1:
                            System.out.print("Cap nhat ten doi nha: ");
                            a.setDoiNha(Input.sc.nextLine());
                            break;
                        case 2:
                            System.out.print("Cap nhat ten doi khach: ");
                            a.setDoiKhach(Input.sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Cap nhat ngay thi dau(dd/MM/yyyy): ");
                            a.setNgayThiDau(Input.nhapNgay());
                            break;
                        case 4:
                            System.out.print("Cap nhat thoi gian(HH:mm:ss): ");
                            a.setThoiGian(Input.nhapGio());
                            break;
                        case 5:
                            System.out.print("Cap nhat ten san van dong: ");
                            a.setSanVanDong(Input.sc.nextLine());
                            break;
                        case 6:
                            System.out.println("Cap nhat ten hlv doi nha: ");
                            a.setHlvDoiNha(Input.sc.nextLine());
                            break;
                        case 7:
                            System.out.print("Cap nhat ten hlv doi khach: ");
                            a.setHlvDoiKhach(Input.sc.nextLine());
                            break;
                    }
                    
                    System.out.print("Ban co muon tiep tuc cap nhat hay khong?(1/0)");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ", 0, 1);
                }
                return;
            }
        }
        System.out.println("Tran dau khong ton tai");
    }

    //Hiển thị danh sách các trận đấu
    @Override
    public void hienThiDanhSach(){
        System.out.println("Giai Dau: "+this.tenGiaiDau);
        if(dsTranDau.size() == 0)
            System.out.println("Chua co tran dau nao!");
        else{
            dsTranDau.sort((td1,td2)->td1.getIdTran().compareToIgnoreCase(td2.getIdTran()));
            for(TranDau a : dsTranDau)
                a.hienThiThongTin();
            }
    }

    //==========================================================Các hàm khác==========================================================
    //Tính tổng số trận đấu
    public int tongSoTranDau(){
        return dsTranDau.size();
    }

    //Thống kê bàn thắng
    public void thongKeBanThang(){
        if(dsTranDau.isEmpty()){
            System.out.println("Chua co tran dau nao");
            return;
        }

        System.out.println("Giai dau: "+this.tenGiaiDau);
        int tongBanThang=0;

        for(TranDau a: dsTranDau)
            tongBanThang+=a.tinhTongBanThang();

        System.out.println("So ban thang: "+tongBanThang);
    }

    //Thống kê bàn thua
    public void thongKeBanThua(){
        if(dsTranDau.isEmpty()){
            System.out.println("Chua co tran dau nao");
            return;
        }

        System.out.println("Giai dau: "+this.tenGiaiDau);
        int tongBanThua=0;

        for(TranDau a: dsTranDau)
            tongBanThua+=a.tinhTongBanThua();

        System.out.println("So ban thua: "+tongBanThua);
    }
    
}