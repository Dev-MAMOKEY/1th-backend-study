# 과제명
JWT 인증 서버

## ⚙️ 실행 방법
1. mysql 생성 후 SCHEMAS 생성
2. .env 에 DB정보 입력
3.  SpringsecurityApplication 실행

## 💡 작업 내용
- 회원가입 - POST /auth/register
- 로그인 - POST /auth/login → JWT 토큰 수령
- GET /posts (protected) → Authorization: Bearer {token}

#  API 명세

| Method | URI           | 설명 |
|--------|---------------|------|
| POST   | /post         | 게시글 생성 |
| GET    | /post         | 게시글 목록 조회 |
| GET    | /post/{id}    | 게시글 단건 조회 |
| PUT    | /post/{id}    | 게시글 수정 |
| DELETE | /post/{id}    | 게시글 삭제 |
| POST   | auth/register | 회원가입|
| POST   | auth/login    | JWT 토큰 수령   |





# API 성공 세부 사항
- 200-1: 게시물 등록 성공
- 200-2: 게시물 단건 조회 선공
- 200-3: 게시물 수정 조회 선공
- 200-4: 게시물 삭제 선공
- 200-5: 게시물 전체 조회 선공
- 200-6 : 로그인 성공 

## 🤔 느낀 점 / 어려웠던 점
- 전체적인 회원가입과 로그인의 구조에 대해 알게 되었습니다.. 
- 하지만 refresh 토큰과 access 토큰을 사용해서 보안을 강화 하는법과 예외처리하는 법을 더욱 자세히 작성해야할거같습니다(시험끝나고 보안하겠습니다)
- spring security 가  Dispatcher Servlet 앞단에 어떻게 작동하는지에 대해 집중하여 학습해보았습니다.
- 헷갈리는 것도 많고 했지만 많은 자료들을 찾아보며 작성하였습니다.
- 예외처리가 많이 부족하게 되어있습니다... 