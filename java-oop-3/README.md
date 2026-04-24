# 과제명
게임 캐릭터 상속 구조

## ⚙️ 실행 방법
<!-- Java 파일 또는 Spring 프로젝트 실행 방법을 작성해 주세요 -->
1단계: src 폴더로 이동

`cd src`

2단계: 컴파일

`javac controller/*.java model/*.java view/*.java Main.java`

3단계: 실행

`java Main`

## 📂 프로젝트 구조


```
src
├─ controller
│ └─ Run.java
├─ model
│ ├─ Character.java
│ ├─ Warrior.java
│ └─ Mage.java
├─ view
│ ├─ PrintMenu.java
│ ├─ PrintInfo.java
│ ├─ ErrorMessage.java
│ └─ ExitMessage.java
└─ Main.java
```

## 💡 작업 내용
- 캐릭터 선택 메뉴 출력
- Warrior / Mage 선택 가능
- 캐릭터 정보 출력 (이름, 체력, 공격력)
- 캐릭터별 공격 방식 출력
- 잘못된 입력 시 에러 메시지 출력
- 3번 입력 시 프로그램 종료

## 🤔 느낀 점 / 어려웠던 점
- 코드 짜는것만큼 폴더 구조 설계가 중요하다는걸 다시 한번 느꼈다.
- 앞으로의 과제와 프로젝트에 SOLID원칙과 MVC구조를 잘 적용해야겠다는 생각이 들었다.