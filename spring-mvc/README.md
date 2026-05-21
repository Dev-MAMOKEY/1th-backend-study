# 과제명
REST API 서버 구현

## ⚙️ 실행 방법
1. 프로젝트 클론
2. IntelliJ에서 프로젝트 열기
3. BoardApplication.java 실행

## 💡 작업 내용
- 게시글 생성(Create)
- 게시글 전체 조회(Read)
- 게시글 단건 조회(Read)
- 게시글 수정(Update)
- 게시글 삭제(Delete)
- MVC 계층 분리
- DTO 분리
- H2 Database 사용

## 📡 API 명세
| Method | URI         | 설명        |
| ------ | ----------- | --------- |
| POST   | /posts      | 게시글 생성    |
| GET    | /posts      | 게시글 전체 조회 |
| GET    | /posts/{id} | 게시글 단건 조회 |
| PUT    | /posts/{id} | 게시글 수정    |
| DELETE | /posts/{id} | 게시글 삭제    |


## 🤔 느낀 점 / 어려웠던 점
- 구글링으로 코드를 조합해서 사용했습니다..
- 자바 문법으로만 코딩할 때에서 느꼈던 불편한 점(생성자 파라미터가 많을 땐 길고 뭐가뭔지 구별이 어렵다, this.을 너무 많이 쓴다 등)이 어느정도 어노테이션을 사용하면서 해결되었던 것 같습니다.