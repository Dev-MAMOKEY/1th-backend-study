# 과제명
Account 클래스 구현

## ⚙️ 실행 방법
1. 파일 이동
2. 컴파일
```bash
dir /s /b java-oop2\*.java > sources.txt
javac -d out @sources.txt
```
3. 실행
```bash
java -cp out Main
```

## 💡 작업 내용
- 은행 입금 출금 기능 
1. 입금
2. 출금
3. 계좌 정보
4. 현재 잔고
5. 종료
## 📡 파일 구조
```
java-oop2/
├── controller/
│   └── AccountController.java
├── model/
│   ├── bankservice/
│   └── Account.java
├── view/
│   ├── message/
│   │   ├── accountinformation/
│   │   │   ├── CheckBalance.java
│   │   │   └── UserInformation.java
│   │   └── errormessage/
│   │       └── WithdrawalError.java
│   │       
│   ├── userinput/
│   │   ├── DepositInput.java
│   │   ├── UserInput.java (interface)
│   │   └── WithdrawalInput.java
│   └── UserMenu.java
├── Main.java
└── README.md
```

## 🤔 느낀 점 / 어려웠던 점
- SOLID 구조에 맞춰서 구조화 할려고 노력했습니다.
-  하나의 파일에 하나의 기능만 들어도록 만들어봤습니다. 완벽하게는 분리하지 못한것 같습니다.
-  구조에 익숙해지도록 앞으로 과제도 구조 나눠보면서 해보겠습니다.!
- - 1회성 또는 필수적으로 필요하지 않은 객체(DepositInput, Deposit 등)는 호출 할때만 new로 호출해서 사용하고 있습니다.(DBX)

## 질문 사항
- 의존성 주입을 받기위해 생성자에서 주입 받으면 컨트롤러의 생성자 코드가 길어지고
매소드 안에다가 new로 할당해버리면 의존성 주입에 위반 되는거 같은데 이문제를 어떻게 해결해야하는지 궁금합니다.

- AccountController 현재 여러가지 기능의 흐름을 모두 제어하고 있습니다.
AccountController도 도 단일 책임 원칙에 의해 한가지 기능만 담당하고 나눠야 하는지 궁금합니다.

