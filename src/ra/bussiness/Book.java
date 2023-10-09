package ra.bussiness;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Book {
   private int bookId;
   private String bookName;
   private String author;
   private String descriptions;
   private double importPrice;
   private double exportPrice;
   private float interest;
   private boolean bookStatus = true;

   private DecimalFormat formatter = new DecimalFormat("###,###,###");

   private static int count = 1;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Book() {
        this.bookId = Book.count++;
    }

    public void mathInterest(){
        this.interest = (float) (this.exportPrice - this.importPrice);
    }

    public void inputData(Scanner scanner) {
        do{
            System.out.println("Nhập tên sách (Không được để trống): ");
            this.bookName = scanner.nextLine();
        }while ((this.bookName.trim().isEmpty()));
        do{
            System.out.println("Nhập tên tác giả (Không được để trống): ");
            this.author = scanner.nextLine();
        }while (this.author.trim().isEmpty());
        do {
            System.out.println("Nhập mô tả  (Không được để trống, ít nhất 10 ký tự): ");
            this.descriptions = scanner.nextLine();
        }while (this.descriptions.trim().length() < 10);
        do {
            System.out.println("Giá nhập (phải lớn hơn 0): ");
            this.importPrice = Double.parseDouble(scanner.nextLine());
        }while (this.importPrice <= 0);
        do {
            System.out.println("Giá bán e (phải lớn hơn 1.2 lần giá nhập): ");
            this.exportPrice = Double.parseDouble(scanner.nextLine());
        }while (this.exportPrice/this.importPrice < 1.2);
        System.out.println("""
                Trạng thái
                1. mở bán (true)
                2. không bán (false)
                """);
        int value = Integer.parseInt(scanner.nextLine());
        this.bookStatus = (value == 1);
        mathInterest();
    }

    public void displayData() {
        System.out.println("Book{" +
                "bookId: " + bookId +
                ", bookName: '" + bookName + '\'' +
                ", author: '" + author + '\'' +
                ", descriptions: '" + descriptions + '\'' +
                ", importPrice: " + formatter.format(importPrice) + "vnd" +
                ", exportPrice: " + formatter.format(exportPrice) + "vnd" +
                ", interest: " + formatter.format(interest) + "vnd" +
                ", bookStatus: " + (bookStatus?"Bán":"Không bán") +
                '}');
    }
}
