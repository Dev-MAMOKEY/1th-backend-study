## 과제명
Account 클래스 구현

## ⚙️ 실행 방법

```bash
cd java-oop-2/src
javac Main.java domain\account\controller\*.java domain\account\entity\*.java domain\account\service\*.java domain\account\view\*.java
java src.Main
```

## 💡 작업 내용
- 입금 기능
- 출금 기능 (잔액 부족 시 출금 불가)
- 계좌 정보 조회
- 잘못된 입력 처리 (0원, 음수 금액 등)

## 📂 프로젝트 구조

```
src
├─ Main.java
└─ domain
   └─ account
      ├─ controller
      │  └─ AccountController.java
      ├─ entity
      │  └─ Account.java
      ├─ service
      │  └─ AccountService.java
      └─ view
         └─ AccountView.java
```

## 🔗 참고 링크
<!-- 참고한 자료를 적어주세요 -->
- 김영한의 실전 자바 기본편 - 섹션 7, 8, 9
- 2-1학기 대학교 자바 피피티 

## 🤔 느낀 점 / 어려웠던 점
<!-- 자유롭게 작성해 주세요 -->
- 기능 구현과 더불어 기능 분리에 초점을 맞춰서 과제를 했습니다. 
- MVC패턴과 단일 책임 원칙을 코드 구조 설계에 최대한 반영해 보았습니다.
- 처음에는 클래스가 많아져서 복잡하게 느껴졌지만, 이로 인해 코드 수정과 흐름 파악이 용이하게 된 것 같습니다.
- 도메인 주도 설계에 대해 알아보는 계기가 되었습니다.