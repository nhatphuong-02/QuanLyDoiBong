package BAITAPLTHDT;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    // Ghi danh sách đối tượng ra file
    public static <T> void writeFile(String fileName, List<T> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (T t : list) {
                // Gọi toFile() để chuyển đối tượng thành String
                bw.write(t.getClass().getMethod("toFile").invoke(t).toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    // Đọc file và chuyển thành danh sách đối tượng
    public static <T> List<T> readFile(String fileName, Class<T> clazz) {
        ArrayList<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Gọi fromFile(String) trong class để tạo đối tượng
                T t = (T) clazz.getMethod("fromFile", String.class).invoke(null, line);
                list.add(t);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File khong ton tai: " + fileName);
        } catch (Exception e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
        return list;
    }
}
