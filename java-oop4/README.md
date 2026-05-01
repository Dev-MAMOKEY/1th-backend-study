# 과제명
RemoteControl 인터페이스 -6주차 과제

## ⚙️ 실행 방법
1. 파일 이동
2. 컴파일
```bash
dir /s /b java-oop4\*.java > sources.txt
javac -d out @sources.txt
```
3. 실행
```bash
java -cp out Main
```

## 💡 작업 내용
- RemoteControl - 인터페이스 작성
- AirConditioner, Television 클래스 작성 (RemoteControl 상속)
- Tv, 에어컨 개별 조작 가능
- TV, 에어컨 동시 조작 가능( 배열로 장치 관리 + 반복문 사용)
- 전원 on/off volum up/down 기능 구현 

## 📡 구조
```bash
java-oop4/
├── controller/
│   └── RemoteController.java
├── model/
│   ├── AirConditioner.java
│   ├── RemoteControl.java (Interface)
│   └── Television.java
├── view/
│   ├── manipulation/
│   │   ├── CurrentStatus.java
│   │   └── ManipulationMessage.java
│   ├── ErrorMessage.java
│   └── ProductSelect.java
├── Main.java
├── README.md
└── Runner.java
```

## 🤔 느낀 점 / 어려웠던 점
- 인터페이스 주제로한 과제여서 RemoteControl를 인터페이스로 작성하였습니다.
- 공통으로 사용하는 클래스 변수나 전원 on/off 와 같은 공통 기능이 있기 때문에 추상 클래스로 작성해도 좋을거같습니다.
- 2~6주차 과제를 하며 JAVA 문법에 대해 정리하는 시간을 가지게 되었습니다.
- 다음 주차부터 Spring Boot에 집중하여 학습하겠습니다.