//public class Main {
//    public static void main(String[] args) {
//        int age = 25;
//        boolean isStudent = true;
//        char grade = 'A';
//        double GPA = 3.78;
//
//        System.out.println(age);
//        System.out.println(isStudent);
//        System.out.println(grade);
//        System.out.println(GPA);
//        System.out.println(GPA);
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//      String name = "최성혁";
//        System.out.println(name);
//
//        int[] num = new int[5];
//
//        int[] fibonacci = new int[] {1,1,2,3,6};
//
//        if (fibonacci[4] == 5) {
//            System.out.println("이 수열은 올바릅니다");
//        } else {
//            System.out.println("피보나치 수열의 5번쨰 값은 5입니다");
//        }
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        String[] timetable = {"머신러닝", "컴퓨터비전", "데이터기초수학", "심층신경망", "현대사회와 법1", "알고리즘"};
//
//        for(int idx = 0; idx < timetable.length; idx++) {
//            System.out.println(timetable[idx]);
//        }
//
//        for(String str : timetable) {
//            System.out.println(str);
//        }
//    }
//}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private String owner;
    private int balance;


    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }



    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + "원이 입금 완료");
    }

    public void showInfo() {
        System.out.println("예금주:" + owner + ",잔액" + balance);
    }

    void deposit(int amount, String message) {
        balance += amount;
        System.out.println(message + "메모와 함께" + amount + "원이 입금 완료");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String owner, int balance, double interestRate) {
        super(owner, balance);
        this.interestRate = interestRate;
    }

    public void addinterest() {
        System.out.println("이자가 추가되었습니다");
    }

    public void showInfo() {
        System.out.println("예금주:" + getOwner() + ",잔액" + getBalance() + "이자율" + interestRate);
    }
}


//public class Main {
//    public static void main(String[] args) {
//        BankAccount account = new BankAccount("홍길동", 10000);
//        account.showInfo();
//
//        account.setOwner("최성혁");
//        account.showInfo();
//
//        account.deposit(5000);
//        account.deposit(5000, "Memo");
//        account.showInfo();
//    }
//}

interface Chargeable {
    void applyFee();
}

class BankAccount implements Chargeable {
    public void applyFee() {
        System.out.println("일반계좌 이체 수수료 500원 차감");
    }
}

class VIPAccount extends BankAccount {
    public VIPAccount(String owner, int balance) {
        super(owner, balance);
    }

    public void applyFee() {
        System.out.println(getOwner() + "VIP 계좌는 이체 수수료 면제");
    }
}

public class  Main {
    public static void main(String[] args) {
        BankAccount[] accounts = {
                new BankAccount("일반회원", 10000),
                new VIPAccount("우수회원", 50000)
        };

        for (BankAccount account : accounts) {
            account.applyFee();
        }

    }
}

public class Main {
    public static void main(String[] args) {


        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new BankAccount("일반인", 10000);
        accounts[1] = new SavingsAccount("홍길동", 10000, 0.05);

        for (int i = 0; i < accounts.length; i++) {
            System.out.println("...[" + i + "]번 계좌 처리 ...");
            BankAccount currentAccount = accounts[i];
            currentAccount.showInfo();

            if (currentAccount instanceof SavingsAccount) {
                SavingsAccount realAccount = (SavingsAccount) currentAccount;

                realAccount.addinterest();
                System.out.println("다운캐스팅 성공: 이자 추가 완료");

            } else {
                System.out.println("일반 계좌이므로 이자 추가 기능 없음");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("홍길동", 10000);

        try {
            int widthdrawAmount = 50000;

            if (widthdrawAmount > myAccount.getBalance()) {
                throw new Exception("잔액이 부족합니다");
            }
            System.out.println("출금 성공");
        } catch (Exception e) {
            System.out.println("출금 실패 사유: " + e.getMessage());
        }
    }
}

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> bankList = new ArrayList<>();
        bankList.add(new BankAccount("홍길동", 10000));
        bankList.add(new SavingsAccount("김철수", 50000, 0.05));

        for(BankAccount acc : bankList) {
            acc.showInfo();
        }

        System.out.println("====================");

        Map<String, String> userMap = new HashMap<>();

        userMap.put("name", "아기사자");
        userMap.put("role", "백엔드개발자");

        System.out.println("이름:" + userMap.get("name"));
    }
}




