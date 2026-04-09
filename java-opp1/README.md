# 과제명
java-opp (3주차 과제)

## ⚙️ 실행 방법
### 1. 터미널(Terminal)에서 명령어로 실행 할 경우
**1단계: UTF-8 언어 변경**
```bash
chcp 65001
```
**2단계: 컴파일 (Compile)**
```bash
javac -d out java-opp1/Main.java java-opp1/model/Department.java
```
**3단계: 실행**
```bash
java -Dfile.encoding=UTF-8 -cp out Main
```
## 💡 작업 내용
### 1. `java-opp1/model/Department.java`
- **역할**: 학과 정보를 저장하고 관리하는 **Department** 클래스입니다.
- **주요 내용**:
    - 학과의 속성(학과명,학생 수, 건물 )을 필드로 정의
    - 생성자를 통한 데이터 초기화
    -  학과 정보를 출력하는 메서드 포함

### 2. `java-basic/Main.java`
- **역할**: 프로그램 실행
- **주요 내용**:
    - `Department` 클래스의 인스턴스(객체) 생성 (컴퓨터공학과, 경영학과, 전자공학과)
    - `Scanner` 를 사용하여 사용자가 원하는 학과 출력(컴퓨터공학과, 경영학과, 전자공학과)

## 🤔 느낀 점 / 어려웠던 점
-java 문법을 되새기는 시간을 가지게 된것 같습니다.
-CMD(MS949) 한글 2바이트 UTF-8은 3바이트라는걸 알게되었습니다.