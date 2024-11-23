import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class danhSachTaiLieu {
    private ArrayList<Document> DSTL;

    public danhSachTaiLieu() {
        DSTL = new ArrayList<>();
    }

    public void them(Document tailieu) {
        DSTL.add(tailieu);
        System.out.println("Da them tai lieu: " + tailieu.getName());
    }

    public void xoa(String id) {
        boolean removed = false;
        for (int i = 0; i < DSTL.size(); i++) {
            if (DSTL.get(i).getId().equalsIgnoreCase(id)) {
                DSTL.remove(i);
                removed = true;
                System.out.println("Da xoa tai lieu: " + id);
                break;
            }
        }
        if (!removed) {
            System.out.println("Khong tim thay tai lieu de xoa: " + id);
        }
    }

    public void sua(String id) {
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        for (Document tl : DSTL) {
            if (tl.getId().equalsIgnoreCase(id)) {
                System.out.println("Thong tin hien tai cua tai lieu:");
                tl.xuat();
                System.out.println("Nhap thong tin moi:");
                tl.nhap();
                found = true;
                System.out.println("Da sua tai lieu: " + id);
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu de sua: " + id);
        }
    }

    public void searchbyName(String ten) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getName().equalsIgnoreCase(ten)) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi ten: " + ten);
        }
    }

    public void searchbyID(String ma) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getId().equalsIgnoreCase(ma)) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi ID: " + ma);
        }
    }

    public void searchbyYear(int year) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getNamxuatban() == year) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi nam xuat ban: " + year);
        }
    }
    
    public void searchbyType(String type) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getType().equalsIgnoreCase(type)) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi the loai: " + type);
        }
    }

    public void searchbyAuthor(String tacgia) {
        boolean found = false;
        for (Document tl : DSTL) {
            if (tl.getTacgia().equalsIgnoreCase(tacgia)) {
                tl.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay tai lieu voi tac gia: " + tacgia);
        }
    }

    
    public void xuatDanhSach() {
        if (DSTL.isEmpty()) {
            System.out.println("Danh sach tai lieu trong!");
            return;
        }
    
        // Tách danh sách theo loại tài liệu
        ArrayList<Document> books = new ArrayList<>();
        ArrayList<Document> magazines = new ArrayList<>();
        ArrayList<Document> dias = new ArrayList<>();
    
        for (Document doc : DSTL) {
            if (doc instanceof Book) {
                books.add(doc);
            } else if (doc instanceof Magazine) {
                magazines.add(doc);
            } else if (doc instanceof Dia) {
                dias.add(doc);
            }
        }
    
        // Xuất danh sách theo thứ tự: Book -> Magazine -> Dia
        System.out.println("=== Danh sach Sach ===");
        for (Document book : books) {
            book.xuat();
            System.out.println("-------------------");
        }
    
        System.out.println("=== Danh sach Tap chi ===");
        for (Document magazine : magazines) {
            magazine.xuat();
            System.out.println("-------------------");
        }
    
        System.out.println("=== Danh sach Dia ===");
        for (Document dia : dias) {
            dia.xuat();
            System.out.println("-------------------");
        }
    }
    

public void ghiVaoFile(String fileName) throws IOException{
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
        for (Document doc : DSTL) {
            String line = "";
            if (doc instanceof Book) {
                Book book = (Book) doc;
                line = "Book; ID: " + book.getId() + "; Ten: " + book.getName() + "; Ma so ke: " + book.getMaSoKe() + "; Nam: "
                    + book.getNamxuatban() + "; So luong: " + book.getSoluong() + "; Tac gia: " + book.getTacgia() + "; The loai: "
                    + book.getType() + "; Tinh trang: " + book.getTinhTrangTL() + "; Ma sach: " + book.getBookid() + "; Ngon ngu: " + book.getNgonNgu();
            } else if (doc instanceof Magazine) {
                Magazine magazine = (Magazine) doc;
                line = "Magazine; ID: " + magazine.getId() + "; Ten: " + magazine.getName() + "; Ma so ke: " + magazine.getMaSoKe() + "; "
                    + "Nam: " + magazine.getNamxuatban() + "; So luong: " + magazine.getSoluong() + "; Tac gia: " + magazine.getTacgia() + "; "
                    + "The loai: " + magazine.getType() + "; Tinh trang: " + magazine.getTinhTrangTL() + "; So phat hanh: " + magazine.getSoPhatHanh() + "; "
                    + "Thang phat hanh: " + magazine.getThangPhatHanh() + "; Ngon ngu: " + magazine.getNgonNgu();
            } else if (doc instanceof Dia) {
                Dia dia = (Dia) doc;
                line = "Dia; ID: " + dia.getId() + "; Ten: " + dia.getName() + "; Ma so ke: " + dia.getMaSoKe() + "; "
                    + "Nam: " + dia.getNamxuatban() + "; So luong: " + dia.getSoluong() + "; Tac gia: " + dia.getTacgia() + "; "
                    + "The loai: " + dia.getType() + "; Tinh trang: " + dia.getTinhTrangTL() + "; Dung luong: " + dia.getDungLuong() + "; "
                    + "Loai dia: " + dia.getLoaiDia();
            }
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        System.out.println("Da ghi du lieu vao file: " + fileName);
    } catch (IOException e) {
        System.out.println("Loi khi ghi file: " + e.getMessage());
    }
}

public void docTuFile(String fileName) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("; ");
            if (arr.length < 2) {
                System.out.println("Du lieu khong hop le: " + line);
                continue; 
            }

            String loaiTaiLieu = arr[0];
            String ten = "", id = "", maSoKe = "", nam = "", soLuong = "", tacGia = "", theLoai = "", tinhTrang = "", maSach = "", ngonNgu = "";
            String soPhatHanh = "", thangPhatHanh = "", dungLuong = "", loaiDia = "";

            for (String pair : arr) {
                String[] keyValue = pair.split(": ");
                if (keyValue.length == 2) {
                    switch (keyValue[0].trim()) {
                        case "Ten":
                            ten = keyValue[1].trim();
                            break;
                        case "ID":
                            id = keyValue[1].trim();
                            break;
                        case "Ma so ke":
                            maSoKe = keyValue[1].trim();
                            break;
                        case "Nam":
                            nam = keyValue[1].trim();
                            break;
                        case "So luong":
                            soLuong = keyValue[1].trim();
                            break;
                        case "Tac gia":
                            tacGia = keyValue[1].trim();
                            break;
                        case "The loai":
                            theLoai = keyValue[1].trim();
                            break;
                        case "Tinh trang":
                            tinhTrang = keyValue[1].trim();
                            break;
                        case "Ma sach":
                            maSach = keyValue[1].trim();
                            break;
                        case "Ngon ngu":
                            ngonNgu = keyValue[1].trim();
                            break;
                        case "So phat hanh":
                            soPhatHanh = keyValue[1].trim();
                            break;
                        case "Thang phat hanh":
                            thangPhatHanh = keyValue[1].trim();
                            break;
                        case "Dung luong":
                            dungLuong = keyValue[1].trim();
                            break;
                        case "Loai dia":
                            loaiDia = keyValue[1].trim();
                            break;
                        default:
                            System.out.println("Khong nhan dien duoc khoa: " + keyValue[0].trim());
                    }
                }
            }

            try {
                switch (loaiTaiLieu) {
                    case "Book":
                        if (!ten.isEmpty() && !id.isEmpty() && !maSoKe.isEmpty() && !nam.isEmpty() && !soLuong.isEmpty() &&
                            !tacGia.isEmpty() && !theLoai.isEmpty() && !tinhTrang.isEmpty() && !maSach.isEmpty() && !ngonNgu.isEmpty()) {
                            DSTL.add(new Book(
                                id, ten, maSoKe, Integer.parseInt(nam),
                                Integer.parseInt(soLuong), tacGia, theLoai,
                                tinhTrang, maSach, ngonNgu
                            ));
                        } else {
                            System.out.println("Du lieu sach khong hop le: " + line);
                        }
                        break;
                    case "Magazine":
                        if (!ten.isEmpty() && !id.isEmpty() && !maSoKe.isEmpty() && !nam.isEmpty() && !soLuong.isEmpty() &&
                            !tacGia.isEmpty() && !theLoai.isEmpty() && !tinhTrang.isEmpty() && !soPhatHanh.isEmpty() &&
                            !thangPhatHanh.isEmpty() && !ngonNgu.isEmpty()) {
                            DSTL.add(new Magazine(
                                id, ten, maSoKe, Integer.parseInt(nam),
                                Integer.parseInt(soLuong), tacGia, theLoai,
                                tinhTrang, Integer.parseInt(soPhatHanh),
                                Integer.parseInt(thangPhatHanh), ngonNgu
                            ));
                        } else {
                            System.out.println("Du lieu tap chi khong hop le: " + line);
                        }
                        break;
                    case "Dia":
                        if (!ten.isEmpty() && !id.isEmpty() && !maSoKe.isEmpty() && !nam.isEmpty() && !soLuong.isEmpty() &&
                            !tacGia.isEmpty() && !theLoai.isEmpty() && !tinhTrang.isEmpty() && !dungLuong.isEmpty() &&
                            !loaiDia.isEmpty()) {
                            DSTL.add(new Dia(
                                ten, id, maSoKe, Integer.parseInt(nam),
                                Integer.parseInt(soLuong), tacGia, theLoai,
                                tinhTrang, Double.parseDouble(dungLuong), loaiDia
                            ));
                        } else {
                            System.out.println("Du lieu dia khong hop le: " + line);
                        }
                        break;
                    default:
                        System.out.println("Loai tai lieu khong hop le: " + loaiTaiLieu);
                }
            } catch (NumberFormatException e) {
                System.out.println("Du lieu khong hop le trong file (sai dinh dang so): " + e.getMessage());
            }
        }
        System.out.println("Da doc du lieu tu file: " + fileName);
    } catch (IOException e) {
        System.out.println("Loi khi doc file: " + e.getMessage());
    }
}
}



