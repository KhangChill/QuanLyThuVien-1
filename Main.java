
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== MENU CHINH ===");
            System.out.println("1. Quan ly Nguoi dung");
            System.out.println("2. Quan ly Tai lieu");
            System.out.println("3. Quan ly Hoa don");
            System.out.println("4. Thoat");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Lua chon cua ban: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    quanLyNhanSu();
                    break;

                case 2:
                    quanLyTaiLieu();
                    break;

                case 3:
                    // Chức năng quản lý hóa đơn (bổ sung sau)
                    break;

                case 4:
                    System.out.println("Da thoat khoi chuong trinh. Tam biet!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long thu lai!");
                    break;
            }
        }
    }

        private static void quanLyNhanSu() {
    	danhSachNhanSu dsnd = new danhSachNhanSu();
        Scanner sc = new Scanner(System.in);
        int subChoice = 0;
        
        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== QUAN LY TAI LIEU ===");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Sua nhan vien");
            System.out.println("4. Tim kiem nhan vien");
            System.out.println("5. Hien thi danh sach nhan vien");
            System.out.println("6. Doc danh sach tu file txt");
            System.out.println("7. Ghi danh sach tu file txt");
            System.out.println("8. Quay lai menu chinh");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Lua chon cua ban la: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    System.out.println("Nhap loai nguoi dung (1. Nhan vien, 2. Doc gia, 3. Lua chon khac): ");
                    int typeChoice = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("---------------------------------------------------------------------");

                    if (typeChoice == 1) {
                        Employee nhanVien = new Employee();
                        nhanVien.nhap();
                        dsnd.them(nhanVien);
                    } else if(typeChoice == 2){
                        Reader docGia = new Reader();
                        docGia.nhap();
                        dsnd.them(docGia);
                    } else {
                        Person p = new Person();
                        p.nhap();
                        dsnd.them(p);
                    }
                    break;

                case 2:
                    System.out.print("Nhap ID nguoi dung can xoa: ");
                    String tenXoa = sc.nextLine();
                    dsnd.xoa(tenXoa);
                    break;

                case 3:
                    System.out.print("Nhap ID nguoi dung can sua: ");
                    String tenSua = sc.nextLine();
                    dsnd.sua(tenSua);
                    break;

                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Chon kieu tim kiem:");
                    System.out.println("1. Tim theo ten");
                    System.out.println("2. Tim theo ID");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("Lua chon cua ban: ");
                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Nhap ten tai lieu: ");
                            String searchName = sc.nextLine();
                            dsnd.searchbyname(searchName);
                            break;
                        case 2:
                            System.out.print("Nhap ID tai lieu: ");
                            String searchId = sc.nextLine();
                            dsnd.searchbyid(searchId);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                    break;

                case 5:
                    dsnd.xuatDanhSachNhanSu();
                    break;
                case 6:
                    try {
                        dsnd.docTuFile("input.txt");
                    } catch (IOException e) {
                        System.out.println("Loi khi doc file: " + e.getMessage());
                    }
                    break;
                case 7:
                try {
                    dsnd.ghiVaoFile("output.txt");
                } catch (IOException e) {
                    System.out.println("Loi khi ghi file: " + e.getMessage());
                }
                case 8:
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (subChoice != 8);
    }


    private static void quanLyTaiLieu() {
        danhSachTaiLieu dstl = new danhSachTaiLieu();
        Scanner sc = new Scanner(System.in);
        int subChoice;

        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("=== QUAN LY TAI LIEU ===");
            System.out.println("1. Them tai lieu");
            System.out.println("2. Xoa tai lieu");
            System.out.println("3. Sua tai lieu");
            System.out.println("4. Tim kiem tai lieu");
            System.out.println("5. Hien thi danh sach tai lieu");
            System.out.println("6. Doc danh sach tu file txt");
            System.out.println("7. Ghi danh sach tu file txt");
            System.out.println("8. Quay lai menu chinh");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Lua chon cua ban la: ");
            subChoice = sc.nextInt();
            sc.nextLine();

            switch (subChoice) {
                case 1:
                    System.out.println("Nhap loai tai lieu (1. Sach, 2. Tap chi, 3. Dia, 4. Lua chon khac): ");
                    int typeChoice = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("---------------------------------------------------------------------");

                    if (typeChoice == 1) {
                        Book book = new Book();
                        book.nhap();
                        dstl.them(book);
                    } else if(typeChoice == 2){
                        Magazine tapChi = new Magazine();
                        tapChi.nhap();
                        dstl.them(tapChi);
                    } else if(typeChoice == 3){
                        Dia dia = new Dia();
                        dia.nhap();
                        dstl.them(dia);
                    } else {
                        Document doc = new Document();
                        doc.nhap();
                        dstl.them(doc);
                    }
                    break;

                case 2:
                    System.out.print("Nhap ID tai lieu can xoa: ");
                    String tenXoa = sc.nextLine();
                    dstl.xoa(tenXoa);
                    break;

                case 3:
                    System.out.print("Nhap ID tai lieu can sua: ");
                    String tenSua = sc.nextLine();
                    dstl.sua(tenSua);
                    break;

                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Chon kieu tim kiem:");
                    System.out.println("1. Tim theo ten");
                    System.out.println("2. Tim theo ID");
                    System.out.println("3. Tim theo nam xuat ban");
                    System.out.println("4. Tim theo tac gia");
                    System.out.println("5. Tim theo the loai");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.print("Lua chon cua ban: ");
                    int searchChoice = sc.nextInt();
                    sc.nextLine();

                    switch (searchChoice) {
                        case 1:
                            System.out.print("Nhap ten tai lieu: ");
                            String searchName = sc.nextLine();
                            dstl.searchbyName(searchName);
                            break;
                        case 2:
                            System.out.print("Nhap ID tai lieu: ");
                            String searchId = sc.nextLine();
                            dstl.searchbyID(searchId);
                            break;
                        case 3:
                            System.out.print("Nhap nam xuat ban: ");
                            int searchYear = sc.nextInt();
                            dstl.searchbyYear(searchYear);
                            break;
                        case 4:
                            System.out.print("Nhap ten tac gia: ");
                            String searchAuthor = sc.nextLine();
                            dstl.searchbyAuthor(searchAuthor);
                            break;
                        case 5:
                            System.out.print("Nhap the loai sach: ");
                            String searchType = sc.nextLine();
                            dstl.searchbyType(searchType);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                    break;

                case 5:
                    dstl.xuatDanhSach();
                    break;
                case 6:
                    try {
                        dstl.docTuFile("input.txt");
                    } catch (IOException e) {
                        System.out.println("Loi khi doc file: " + e.getMessage());
                    }
                    break;
                case 7:
                try {
                    dstl.ghiVaoFile("output.txt");
                } catch (IOException e) {
                    System.out.println("Loi khi ghi file: " + e.getMessage());
                }
                case 8:
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (subChoice != 8);
    }
}



