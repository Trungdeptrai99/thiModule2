import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerData {

    Scanner sc = new Scanner(System.in);

    String arrayToTakeData[]= new String[7];

    ArrayList<String> arrayListToReadData = new ArrayList<String>();

    ArrayList<String[]> arrayListToTakeData= new ArrayList<>();

    public void writeFile(){
    try {
        File file  = new File("Data");
        if(file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file,true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(getStringToWrite()+"\n");
        bufferedWriter.close();

    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    }

    public void showInfor(){
        for (String e: arrayListToReadData
             ) {
            String[] arrayToPush = new String[1];
            System.out.println(e);
            arrayToPush[0]=e;
            arrayListToTakeData.add(arrayToPush);
        }
    }

    public void test(){
        for (String[] e:arrayListToTakeData
             ) {
            for (String hihi:e
                 ) {
                System.out.println(hihi);
            }
        }
    }


    public void readFile(){
        try {
            File file  = new File("Data");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedWriter = new BufferedReader(fileReader);
            String hihi = null;
            while ((hihi=bufferedWriter.readLine())!=null){
                arrayListToReadData.add(hihi);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void getData(){
        System.out.println("Số điện thoại");
        arrayToTakeData[0]= sc.nextLine();
        System.out.println("Nhóm");
        arrayToTakeData[1] =sc.nextLine();
        System.out.println("Họ tên");
        arrayToTakeData[2]=sc.nextLine();
        System.out.println("Giới tính");
        arrayToTakeData[3]= sc.nextLine();
        System.out.println("Địa chỉ");
        arrayToTakeData[4]= sc.nextLine();
        System.out.println("Ngày sinh");
        arrayToTakeData[5]=sc.nextLine();
        System.out.println("Email");
        arrayToTakeData[6]= sc.nextLine();
    }
    public String getStringToWrite(){
        String allInfor="";
        for (int i=0;i<7;i++){
            if(i<6){
                allInfor+= arrayToTakeData[i]+",";
            }
            if(i==6){
                allInfor+= arrayToTakeData[i];
            }
        }
        return  allInfor;
    }

    public void option() {

        System.out.println("1. Xem danh sách ");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1: {
                readFile();
                System.out.println("1.Hiển thị");
                System.out.println("2.Thêm mới");
                System.out.println("3. Sửa");
                System.out.println("4.Xóa");
                int optionOfCase1 = sc.nextInt();
                sc.nextLine();

                switch (optionOfCase1){
                    case 1:{
                        showInfor();
                        break;
                    }
                    case 2:{
                        getData();
                        break;
                    }
                    case 3:{

                    }
                    case 4:{

                    }
                }
                break;
            }
            case 2: {
                getData();
                break;
            }
            case 3: {
                writeFile();
                break;
            }
            case 4: {
                showInfor();
                break;
            }
            case 5:{
                test();
                break;
            }
            case 6:{
                readFile();
                break;
            }
            case 7:{
                writeFile();
                System.out.println("Đã lưu vào file");
                break;
            }
            case 8:{
                System.exit(0);
            }
        }
    }
}
