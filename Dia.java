import java.util.Scanner;

class Dia extends Document {
    private double dungLuong;
    private String loaiDia;

    public Dia(){
        super();
        this.dungLuong = 0;
        this.loaiDia = "";
    }

    public Dia(String id, String name, String maSoKe, int namxuatban, int soluong, String tacgia, String type,
            String tinhTrangTL, double dungLuong, String loaiDia) {
        super(id, name, maSoKe, namxuatban, soluong, tacgia, type, tinhTrangTL);
        this.dungLuong = dungLuong;
        this.loaiDia = loaiDia;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap dung luong cua dia: ");
        this.dungLuong = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap loai dia (DVD, CD,...): ");
        this.loaiDia = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.print("Dung luong: " + dungLuong + " GB"+ "  ");
        System.out.println("Loai dia: "+ loaiDia);
    }

    public double getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(double dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getLoaiDia() {
        return loaiDia;
    }

    public void setLoaiDia(String loaiDia) {
        this.loaiDia = loaiDia;
    }

    @Override
    public String toString() {
        return super.toString()+ "Dung luong: " + getDungLuong() + ", loai dia: " + getLoaiDia();
    }

}

