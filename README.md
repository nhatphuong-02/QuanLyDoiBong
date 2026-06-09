# ⚽ Hệ Thống Quản Lý Đội Bóng

## 📖 Giới thiệu

Hệ Thống Quản Lý Đội Bóng là dự án được xây dựng bằng ngôn ngữ Java nhằm mô phỏng việc quản lý một đội bóng chuyên nghiệp. Hệ thống hỗ trợ quản lý cầu thủ, huấn luyện viên, trận đấu và các chức năng thống kê liên quan.

Dự án được thực hiện nhằm vận dụng các kiến thức về Lập trình Hướng Đối Tượng (OOP), cấu trúc dữ liệu, xử lý tập tin và thiết kế phần mềm trong Java.

---

## 🎯 Mục tiêu

- Áp dụng các nguyên lý lập trình hướng đối tượng.
- Xây dựng hệ thống quản lý đội bóng trên nền tảng Console.
- Thực hành thiết kế lớp, kế thừa và đa hình.
- Thực hiện lưu trữ dữ liệu bằng File.
- Xây dựng các chức năng thống kê và tính toán.

---

## 🛠 Công nghệ sử dụng

- Java Core
- OOP (Object-Oriented Programming)
- Collections Framework
- File I/O
- LocalDate / LocalTime API
- Singleton Pattern
- Generic Interface

---

## 🏗 Kiến trúc hệ thống

### Lớp trừu tượng

#### ThanhVien

Là lớp cha của các thành viên trong đội bóng.

Thông tin quản lý:

- Mã thành viên
- Họ tên
- Tuổi
- Lương cơ bản
- Ngày vào đội
- Số điện thoại
- Email
- Số ngày nghỉ
- Ghi chú

---

### Cầu thủ

Quản lý:

- Vị trí thi đấu
- Số áo
- Số bàn thắng
- Số trận đấu
- Số kiến tạo
- Số thẻ vàng
- Số thẻ đỏ
- Tình trạng chấn thương
- Hiệu suất thi đấu
- Điểm thành tích

---

### Huấn luyện viên

Quản lý:

- Chuyên môn
- Số năm kinh nghiệm
- Số trận thắng
- Số trận hòa
- Số trận thua

---

### Trận đấu

Quản lý:

- Mã trận đấu
- Đội nhà
- Đội khách
- Ngày thi đấu
- Thời gian thi đấu
- Sân vận động
- Kết quả
- Danh sách cầu thủ tham gia
- Huấn luyện viên hai đội

---

## ✨ Chức năng chính

### Quản lý cầu thủ

- Thêm cầu thủ
- Xóa cầu thủ
- Tìm kiếm cầu thủ
- Cập nhật thông tin cầu thủ
- Hiển thị danh sách cầu thủ
- Cập nhật thành tích thi đấu

### Quản lý huấn luyện viên

- Thêm huấn luyện viên
- Xóa huấn luyện viên
- Tìm kiếm huấn luyện viên
- Cập nhật thông tin huấn luyện viên
- Hiển thị danh sách huấn luyện viên

### Quản lý trận đấu

- Thêm trận đấu
- Cập nhật kết quả trận đấu
- Thêm cầu thủ tham gia trận đấu
- Theo dõi lịch thi đấu
- Hiển thị danh sách trận đấu

### Thống kê

- Tổng lương đội bóng
- Lương trung bình
- Thành viên có lương cao nhất
- Số lượng thành viên
- Hiệu suất cầu thủ
- Tỷ lệ thắng của huấn luyện viên

### Lưu trữ dữ liệu

- Đọc dữ liệu từ file
- Ghi dữ liệu ra file
- Tự động lưu thông tin cầu thủ
- Tự động lưu thông tin huấn luyện viên
- Tự động lưu thông tin trận đấu

---

## 📚 Các kỹ thuật OOP được áp dụng

### Tính đóng gói (Encapsulation)

- Sử dụng thuộc tính private/protected
- Cung cấp getter/setter

### Tính kế thừa (Inheritance)

```text
ThanhVien
├── CauThu
└── HuanLuyenVien
```

### Tính đa hình (Polymorphism)

- Override phương thức tính lương
- Override phương thức hiển thị

### Trừu tượng hóa (Abstraction)

- Abstract Class: ThanhVien
- Interface:
  - ITinhLuong
  - IQuanLy<T>
  - IThongKe<T>
  - IReadWrite

### Singleton Pattern

- QuanLyCauThu
- QuanLyHLV

---

## 📌 Kết quả đạt được

- Xây dựng thành công hệ thống quản lý đội bóng bằng Java.
- Áp dụng đầy đủ các nguyên lý OOP.
- Thực hiện lưu trữ dữ liệu bằng File.
- Triển khai các chức năng thống kê và tính lương.
- Tăng khả năng tổ chức và quản lý mã nguồn Java.

---

## 👨‍💻 Tác giả

**Quách Nhật Phương**

Sinh viên ngành Công nghệ Thông tin trường Đại học Sư phạm Kỹ thuật Đà Nẵng.

---

## ⚠️ Lưu ý

Dự án được xây dựng với mục đích học tập và nghiên cứu môn Lập trình Hướng Đối Tượng.
