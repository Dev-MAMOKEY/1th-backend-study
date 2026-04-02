# 과제명
java-basic (2주차 과제)

## ⚙️ 실행 방법
### 1. 터미널(Terminal)에서 명령어로 실행
**1단계: 컴파일 (Compile)**
```bash
javac -d out java-basic/Main.java java-basic/model/Student.java
```
**2단계: 실행**
```bash
java -cp out Main
```
## 💡 작업 내용
### 1. `java-basic/model/Student.java`
- **역할**: 학생 정보를 저장하고 관리하는 **Model** 클래스입니다.
- **주요 내용**:
    - 학생의 속성(이름, 학번, 전공 등)을 필드로 정의
    - 생성자를 통한 데이터 초기화
    -  학생 정보를 출력하는 메서드 포함

### 2. `java-basic/Main.java`
- **역할**: 프로그램 실행
- **주요 내용**:
    - `Student` 클래스의 인스턴스(객체) 생성
    - 생성된 객체의 메서드를 호출하여 콘솔에 데이터 출력 및 확인

## 🤔 느낀 점 / 어려웠던 점
-java 문법을 되새기는 시간을 가지게 된것 같습니다.
-객체 지향 부분을 더욱 심도있게 학습해야할것 같습니다.
