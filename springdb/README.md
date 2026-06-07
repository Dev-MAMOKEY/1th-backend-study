# 과제명
게시판 + DB연동

## ⚙️ 실행 방법
1. mysql 생성 후 SCHEMAS 생성(board)
2. .env 에 DB정보 입력
3.  SpringdbApplication 실행 

## 💡 작업 내용
- 게시글 CRUD 구성
- 댓글 CRUD 구성
- MYSQL 연동 
- JPA사용

#  API 명세

| Method | URI | 설명 |
|--------|-----|------|
| POST | /post | 게시글 생성 |
| GET | /post | 게시글 목록 조회 |
| GET | /post/{id} | 게시글 단건 조회 |
| PUT | /post/{id} | 게시글 수정 |
| DELETE | /post/{id} | 게시글 삭제 |
|Post|/post/{id}/comment| 댓글 추가|
|GET|/post/{id}/comment|댓글 전체 조회|
|GET|post/{id}/comment/{commentId}|댓글 단건 조회|
|PUT|post/{id}/comment/{commentId}|댓글 수정|
|DELETE|post/{id}/comment/{commentId}|댓글 삭제|


# API 성공 세부 사항 
- 200-1: 게시물 등록 성공
- 200-2: 게시물 단건 조회 선공
- 200-3: 게시물 수정 조회 선공 
- 200-4: 게시물 삭제 선공
- 200-5: 게시물 전체 조회 선공 

## 🤔 느낀 점 / 어려웠던 점
- 저번주에 피드백 주신 내용을 중점으로 작성해보았습니다
- jpa를 사용하더라도 DB 구조 설계에 대해서 더욱 학습이 필요하다는 것을 느끼게 되었습니다.
- 게시물도 처음부터 작성해보고 댓글도 만들어보면서 dto의 흐름이나 전체적인 흐름을 알 수 있었습니다.
- domain 계층구조를 사용해서 작성해보았습니다. 이것이 관리하거나 찾기가 더욱 편리한것 같습니다 . 