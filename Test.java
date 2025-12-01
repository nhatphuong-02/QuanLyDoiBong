package BAITAPLTHDT;

public class Test {
    public static void Menu(){
        QuanLyCauThu qlct = QuanLyCauThu.getInstance();
        QuanLyHLV qlhlv = QuanLyHLV.getInstance();
        QuanLyTranDau qltd = new QuanLyTranDau(); 

        System.out.print("Nhap ten giai dau se tham gia: ");
        qltd.setTenGiaiDau(Input.sc.nextLine());

        qlct.docFile("CauThu.txt");
        qlhlv.docFile("HLV.txt");
        qltd.docFile(qltd.getTenGiaiDau().toLowerCase().replaceAll("\\s+", "")+".txt");

        int choose = 1;
        while(choose != 0 ){
            Input.clearScreen();
            System.out.println("=============MENU=============");
            System.out.println("1.Tran Dau");
            System.out.println("2.Cau Thu");
            System.out.println("3.Huan Luyen Vien");
            System.out.println("4.Danh Sach Tran Dau");
            System.out.println("5.Danh Sach Cau Thu");
            System.out.println("6.Danh Sach Huan Luyen Vien");
            System.out.println("===============================");
            choose = Input.nhapSoGioiHan("Nhap lua chon: ",1,6);
            switch (choose) {
                case 1:
                    Input.clearScreen();
                    System.out.println("====================Tran Dau====================");
                    System.out.println("1.Hien thi thong tin");
                    System.out.println("2.Cap nhat ket qua");
                    System.out.println("3.Them cau thu tham gia");
                    System.out.println("4.Xoa cau thu tham gia");
                    System.out.println("5.Lay danh sach cau thu tham gia");
                    System.out.println("6.Tong ban thang");
                    System.out.println("7.Tong ban thua");
                    System.out.println("8.Cap nhat tran dau cho cac cau thu");
                    System.out.println("=================================================");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ", 1, 8);

                    System.out.print("Nhap ma tran dau: ");
                    String idTran1 = Input.sc.nextLine();
                    TranDau td1 = qltd.timKiem(idTran1);

                    if(td1 == null){
                        System.out.println("Khong tim thay tran dau co ma: "+idTran1);
                        System.out.println();
                        break;
                    }
                    System.out.println();

                    switch (choose){
                        case 1:
                            Input.clearScreen();
                            System.out.println("Hien thi thong tin");
                            td1.hienThiThongTin();
                            break;
                        case 2:
                            Input.clearScreen();
                            System.out.println("Cap nhat ket qua");
                            System.out.print("Nhap ket qua(Doi minh:Doi doi thu): ");
                            String ketQua = Input.sc.nextLine().trim();

                            td1.capNhatKetQua(ketQua);
                            System.out.println("Cap nhat ket qua thanh cong!");

                            break;
                        case 3:
                            Input.clearScreen();
                            System.out.println("Them cau thu tham gia");
                            td1.themCauThuThamGia();
                            break;
                        case 4:
                            Input.clearScreen();
                            System.out.println("Xoa cau thu tham gia");
                            td1.xoaCauThuThamGia();
                            break;
                        case 5:
                            Input.clearScreen();
                            System.out.println("Danh sach cau thu tham gia");
                            td1.dsCauThuThamGia();
                            System.out.println();
                            break;
                        case 6:
                            Input.clearScreen();
                            System.out.println("Tong ban thang: "+td1.tinhTongBanThang());
                            break;
                        case 7:
                            Input.clearScreen();
                            System.out.println("Tong ban thua: "+td1.tinhTongBanThua());
                            break;
                        case 8:
                            Input.clearScreen();
                            td1.capNhatKetQua();
                            break;
                    }
                    break;
                case 2:
                    Input.clearScreen();
                    System.out.println("====================Cau Thu====================");
                    System.out.println("1.Thong tin cau thu");
                    System.out.println("2.Tinh luong");
                    System.out.println("3.Cap nhat tran dau");
                    System.out.println("4.Tinh hieu suat");
                    System.out.println("5.Cap nhat diem thanh tich");
                    System.out.println("6.Cau thu co ra san hay khong");
                    System.out.println("7.Tang so ngay nghi");
                    System.out.println("8.Cap nhat thong tin lien lac");
                    System.out.println("9.Dat lai thong ke");
                    System.out.println("===============================================");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ",1,9);

                    System.out.print("Nhap ma cau thu: ");
                    String idCauThu = Input.sc.nextLine();
                    CauThu ct = qlct.timKiem(idCauThu);

                    if(ct == null){
                        System.out.println("Khong tim thay cau thu voi ma: "+idCauThu);
                        System.out.println();
                        break;
                    }
                    System.out.println();

                    switch (choose) {
                        case 1:
                            Input.clearScreen();
                            System.out.println("Hien thi thong tin");
                            ct.hienThiThongTin();
                            break;
                        case 2:
                            Input.clearScreen();
                            System.out.println("Tinh luong: "+ct.tinhLuong());
                            break;
                        case 3:
                            Input.clearScreen();
                            System.out.println("Cap nhat tran dau");
                            System.out.print("Nhap ma tran dau: ");
                            String idTran3 = Input.sc.nextLine();
                            TranDau td3 = qltd.timKiem(idTran3);

                            if(td3==null){
                                System.out.println("Tran dau khong ton tai!");
                                break;
                            }

                            if(!ct.coRaSan(td3)){
                                System.out.println("Cau thu khong tham gia tran dau nay!");
                                break;
                            }

                            int banThang = Input.nhapSoGioiHan("Nhap so ban thang: ", 0, 20);
                            int kienTao = Input.nhapSoGioiHan("Nhap so kien tao: ", 0, 20);
                            int theDo = Input.nhapSoGioiHan("Nhap so the do: ", 0, 1);
                            int theVang = Input.nhapSoGioiHan("Nhap so the vang: ", 0, 2);

                            ct.capNhatTranDau(banThang,kienTao,theDo,theVang);

                            System.out.println("Cap nhat tran dau thanh cong");

                            break;
                        case 4:
                            Input.clearScreen();
                            System.out.println("Tinh hieu suat: "+ct.tinhHieuSuat());
                            break;
                        case 5:
                            Input.clearScreen();
                            System.out.println("Cap nhat diem thanh tich");
                            ct.capNhatDiemThanhTich();

                            break;
                        case 6:
                            Input.clearScreen();
                            System.out.println("Kiem tra cau thu co ra san hay khong");

                            System.out.print("Nhap ma tran dau: ");
                            String idTran = Input.sc.nextLine();

                            TranDau td = qltd.timKiem(idTran);
                            if(td == null) {
                                System.out.println("Khong tim thay tran dau voi ma: " + idTran);
                                break;
                            }

                            if(ct.coRaSan(td))
                                System.out.println(ct.hoTen+" co ra san");
                            else
                                System.out.println(ct.hoTen+" khong ra san");

                            break;
                        case 7:
                            Input.clearScreen();
                            System.out.println("Tang so ngay nghi");
                            ct.tangSoNgayNghi();
                            System.out.println("Tang so ngay nghi thanh cong!");
                            break;
                        case 8:
                            Input.clearScreen();
                            System.out.println("Cap nhat thong tin lien lac");

                            System.out.print("Cap nhat sdt: ");
                            String sdt = Input.sc.nextLine();

                            System.out.print("Cap nhat email: ");
                            String email = Input.sc.nextLine();

                            ct.capNhatThongTinLienLac(sdt, email);
                            System.out.println("Cap nhat thanh cong");

                            break;
                        case 9:
                            Input.clearScreen();
                            if(Input.nhapSoGioiHan("Ban co chac chan muon dat lai thong ke?(1/0) ", 0, 1) == 1)
                                ct.resetThongKe();
                            else
                                break;

                            break;
                    }
                    break;
                case 3:
                    Input.clearScreen();
                    System.out.println("====================Huan Luyen Vien====================");
                    System.out.println("1.Hien thi thong tin");
                    System.out.println("2.Tinh luong");
                    System.out.println("3.Cap nhat tran dau");
                    System.out.println("4.Ty le thang");
                    System.out.println("5.Tang so ngay nghi");
                    System.out.println("6.Cap nhat thong tin lien lac");
                    System.out.println("=======================================================");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ", 1, 6);

                    System.out.print("Nhap ma huan luyen vien: ");
                    String idHlv = Input.sc.nextLine().trim();
                    HuanLuyenVien hlv = qlhlv.timKiem(idHlv);

                    if(hlv == null){
                        System.out.println("Khong tim thay huan luyen vien co ma "+idHlv);
                        System.out.println();
                        break;
                    }
                    System.out.println();

                    switch (choose) {
                        case 1:
                            Input.clearScreen();
                            System.out.println("Hien thi thong tin");
                            hlv.hienThiThongTin();
                            break;
                        case 2:
                            Input.clearScreen();
                            System.out.println("Tinh luong: "+hlv.tinhLuong());
                            break;
                        case 3:
                            Input.clearScreen();
                            if(!hlv.getChuyenMon().equalsIgnoreCase("truong")){
                                System.out.println("Thao tac chi co the su dung voi hlv truong!");
                                break;
                            }
                            System.out.println("Cap nhat tran dau");
                            hlv.capNhatThongKe(qltd.getDsTranDau());
                            System.out.println("Cap nhat thanh cong");
                            break;
                        case 4:
                            Input.clearScreen();
                            if(!hlv.getChuyenMon().equalsIgnoreCase("truong")){
                                System.out.println("Thao tac chi co the su dung voi hlv truong!");
                                break;
                            }
                            System.out.println("Ty le thang: "+hlv.tinhTyLeThang());
                            break;
                        case 5:
                            Input.clearScreen();
                            System.out.println("Tang so ngay nghi");
                            hlv.tangSoNgayNghi();
                            System.out.println("Tang so ngay nghi thanh cong!");
                            break;
                        case 6:
                            Input.clearScreen();
                            System.out.println("Cap nhat thong tin lien lac");

                            System.out.print("Cap nhat sdt: ");
                            String sdt = Input.sc.nextLine();

                            System.out.print("Cap nhat email: ");
                            String email = Input.sc.nextLine();

                            hlv.capNhatThongTinLienLac(sdt, email);
                            System.out.println("Cap nhat thanh cong");

                            break;
                    }
                    break;
                case 4:
                    Input.clearScreen();
                    System.out.println("====================Danh Sach Tran Dau====================");
                    System.out.println("1.Them tran dau");
                    System.out.println("2.Xoa tran dau");
                    System.out.println("3.Tim kiem tran dau");
                    System.out.println("4.Cap nhat tran dau");
                    System.out.println("5.Danh sach cac tran dau");
                    System.out.println("6.Tong so tran dau");
                    System.out.println("7.Thong ke ban thang");
                    System.out.println("8.Thong ke ban thua");
                    System.out.println("===========================================================");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ", 1, 8);
                    System.out.println();

                    switch (choose) {
                        case 1:
                            Input.clearScreen();
                            System.out.println("Them tran dau");
                            qltd.them();
                            break;
                        case 2:
                            Input.clearScreen();
                            System.out.println("Xoa tran dau");
                            qltd.xoa();
                            break;
                        case 3:
                            Input.clearScreen();
                            System.out.println("Tim kiem tran dau");
                            qltd.timKiem();
                            break;
                        case 4:
                            Input.clearScreen();
                            System.out.println("Cap nhat tran dau");
                            qltd.capNhat();
                            break;
                        case 5:
                            Input.clearScreen();
                            System.out.println("Danh sach cac tran dau");
                            qltd.hienThiDanhSach();
                            break;
                        case 6:
                            Input.clearScreen();
                            System.out.println("Tong so tran dau: "+qltd.tongSoTranDau());
                            break;
                        case 7:
                            Input.clearScreen();
                            qltd.thongKeBanThang();
                            break;
                        case 8:
                            Input.clearScreen();
                            System.out.println();
                            qltd.thongKeBanThua();
                            break;
                    }
                    break;
                case 5:
                    Input.clearScreen();
                    System.out.println("====================Danh Sach Cau Thu====================");
                    System.out.println("1. Them cau thu");
                    System.out.println("2. Xoa cau thu");
                    System.out.println("3. Tim kiem cau thu");
                    System.out.println("4. Cap nhat cau thu");
                    System.out.println("5. Hien thi danh sach cau thu");
                    System.out.println("6. Tong luong cac cau thu");
                    System.out.println("7. Cau thu luong cao nhat");
                    System.out.println("8. Luong binh quan");
                    System.out.println("9. So luong thanh vien");
                    System.out.println("10.Hieu suat trung binh");
                    System.out.println("11.Tong so ban thang");
                    System.out.println("12.Tong so kien tao");
                    System.out.println("13.Tong so the vang");
                    System.out.println("14.Tong so the do");
                    System.out.println("========================================================");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ", 1,14);
                    System.out.println();

                    switch (choose) {
                        case 1:
                            Input.clearScreen();
                            System.out.println("Them cau thu");
                            qlct.them();
                            break;
                        case 2:
                            Input.clearScreen();
                            System.out.println("Xoa cau thu");
                            qlct.xoa();
                            break;
                        case 3:
                            Input.clearScreen();
                            System.out.println("Tim kiem cau thu");
                            qlct.timKiem();
                            break;
                        case 4:
                            Input.clearScreen();
                            System.out.println("Cap nhat cau thu");
                            qlct.capNhat();
                            break;
                        case 5:
                            Input.clearScreen();
                            System.out.println("Hien thi danh sach cau thu");
                            qlct.hienThiDanhSach();
                            break;
                        case 6:
                            Input.clearScreen();
                            System.out.println("Tong luong: "+qlct.tongLuong());
                            break;
                        case 7:
                            Input.clearScreen();
                            qlct.timLuongCaoNhat();
                            break;
                        case 8:
                            Input.clearScreen();
                            System.out.println("Luong binh quan: "+qlct.luongTrungBinh());
                            break;
                        case 9:
                            Input.clearScreen();
                            System.out.println("So luong cau thu: "+qlct.soLuongThanhVien());
                            break;
                        case 10:
                            Input.clearScreen();
                            System.out.println("Hieu suat trung binh: "+qlct.hieuSuatTB(qltd.getDsTranDau().size()));
                            break;
                        case 11:
                            Input.clearScreen();
                            System.out.println("Tong so ban thang: "+qlct.tongSoBanThang());
                            break;
                        case 12:
                            Input.clearScreen();
                            System.out.println("Tong so kien tao: "+qlct.tongSoKienTao());
                            break;
                        case 13:
                            Input.clearScreen();
                            System.out.println("Tong so the vang: "+qlct.tongSoTheVang());
                            break;
                        case 14:
                            Input.clearScreen();
                            System.out.println("Tong so the do: "+qlct.tongSoTheDo());
                            break;
                    }

                    break;
                case 6:
                    Input.clearScreen();
                    System.out.println("====================Danh Sach Huan Luyen Vien====================");
                    System.out.println("1. Them huan luyen vien");
                    System.out.println("2. Xoa huan luyen vien");
                    System.out.println("3. Tim kiem huan luyen vien");
                    System.out.println("4. Cap nhat huan luyen vien");
                    System.out.println("5. Hien thi danh sach huan luyen vien");
                    System.out.println("6. Tong luong huan luyen vien");
                    System.out.println("7. Huan luyen vien luong cao nhat");
                    System.out.println("8. Luong binh quan");
                    System.out.println("9. So luong thanh vien");
                    System.out.println("10.So tran thang");
                    System.out.println("11.So thang hoa");
                    System.out.println("12.So tran thua");
                    System.out.println("==================================================================");
                    choose = Input.nhapSoGioiHan("Nhap lua chon: ", 1,12);
                    System.out.println();
                    switch (choose) {
                        case 1:
                            Input.clearScreen();
                            System.out.println("Them huan luyen vien");
                            qlhlv.them();
                            break;
                        case 2:
                            Input.clearScreen();
                            System.out.println("Xoa huan luyen vien");
                            qlhlv.xoa();
                            break;
                        case 3:
                            Input.clearScreen();
                            System.out.println("Tim kiem huan luyen vien");
                            qlhlv.timKiem();
                            break;
                        case 4:
                            Input.clearScreen();
                            System.out.println("Cap nhat huan luyen vien");
                            qlhlv.capNhat();
                            break;
                        case 5:
                            Input.clearScreen();
                            System.out.println("Danh sach huan luyen vien");
                            qlhlv.hienThiDanhSach();
                            break;
                        case 6:
                            Input.clearScreen();
                            System.out.println("Tong luong: "+qlhlv.tongLuong());
                            break;
                        case 7:
                            Input.clearScreen();
                            qlhlv.timLuongCaoNhat();
                            break;
                        case 8:
                            Input.clearScreen();
                            System.out.println("Luong binh quan: "+qlhlv.luongTrungBinh());
                            break;
                        case 9:
                            Input.clearScreen();
                            System.out.println("So luong huan luyen vien: "+qlhlv.soLuongThanhVien());
                            break;
                        case 10:
                            Input.clearScreen();
                            System.out.println("Tong so tran thang: "+qlhlv.soTranThang());
                            break;
                        case 11:
                            Input.clearScreen();
                            System.out.println("Tong so tran hoa: "+qlhlv.soTranHoa());
                            break;
                        case 12:
                            Input.clearScreen();
                            System.out.println("Tong so tran thua: "+qlhlv.soTranThua());
                            break;
                    }
                    break;
            }
            System.out.println();
            System.out.print("Ban co muon tiep tuc hay khong?(1/0)\n");
            choose = Input.nhapSoGioiHan("Nhap lua chon: ",0,1);
        }
        System.out.println("Ket thuc chuong trinh");
        qlct.ghiFile("CauThu.txt");
        qlhlv.ghiFile("HLV.txt");
        qltd.ghiFile(qltd.getTenGiaiDau().replaceAll("\\s+", "")+".txt");
    }
    public static void main(String[] args) {
        System.out.println();
        Menu();
    }
}