package ra.bussiness;
import java.util.Arrays;
import java.util.Scanner;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    static Book[] books = new Book[100];
    static int index = 0;
    public static void main(String[] args) {
        while (true){
            System.out.println("""
                    ****************JAVA-HACKATHON-05-BASIC-MENU***************
                    1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách
                    2. Hiển thị thông tin tất cả sách trong thư viện
                    3. Sắp xếp sách theo lợi nhuận tăng dần
                    4. Xóa sách theo mã sách
                    5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả
                    6. Thay đổi thông tin sách theo mã sách
                    7. Thoát
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    handleAddNew();
                    break;
                case 2:
                    handleShowDetal();
                    break;
                case 3:
                    handleSort();
                    break;
                case 4:
                    handleDelete();
                    break;
                case 5:
                    handleSearch();
                    break;
                case 6:
                    handleUpdate();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void handleUpdate() {
        System.out.println("Nhập id sách bạn muốn sửa");
        int idEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (books[i].getBookId() == idEdit){
                System.out.println("Thông tin cuốn sách cần sửa là:");
                books[i].displayData();
                System.out.println();
                books[i].inputData(scanner);
                System.out.println("Cập nhật thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sách có id: " + idEdit);
    }

    private static void handleSearch() {
        System.out.println("Nhập thông tin tìm kiếm");
        String searchText = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm:");
        for (int i = 0; i < index; i++) {
            if (books[i].getBookName().toLowerCase().contains(searchText.trim().toLowerCase())|| books[i].getDescriptions().toLowerCase().contains(searchText.trim().toLowerCase())) {
            books[i].displayData();
            }
        }
    }

    private static void handleDelete() {
        System.out.println("Nhập id sách bạn muốn xóa");
        int idDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < index; i++) {
            if (books[i].getBookId() == idDelete){
                for (int j = i; j < index; j++) {
                    books[j] = books[j+1];
                }
                System.out.println("Xóa thành công");
                index--;
                return;
            }
        }
        System.out.println("Không tìm thấy sách có id: " + idDelete);
    }

    private static void handleSort() {
        Arrays.sort(books, 0, index, (a, b) -> Float.compare(a.getInterest(), b.getInterest()));
        System.out.println("Đã sắp xếp xong");
    }

    private static void handleShowDetal() {
        for (int i = 0; i < index; i++) {
            System.out.println("Thông tin cuốn sách thứ " + (i+1) + " :");
            books[i].displayData();
        }
    }

    private static void handleAddNew() {
        System.out.println("Bạn muốn thêm bao nhiêu cuốn sách?");
        int countAdd = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countAdd; i++) {
            System.out.println("Thêm mới sách " + (i+1) + " :");
            Book book = new Book();
            book.inputData(scanner);
            books[index++] = book;
        }
    }

}
