# CMS

Contents Management System

---

## 필요 스펙

Java 17, Spring Boot, JPA, MariaDB, Lombok, Thymeleaf, Spring Security, Junit, Mokito

## 개발 계획

1. 프로젝트 설정
  - Spring Boot 프로젝트 생성
  - build.gradle에 의존성 추가 (MariaDB, JPA, Lombok, Thymeleaf, Spring Security, Junit, Mokito)
2. DB 연결
  - MariaDB 생성 및 연결
  - application.properties 설정
3. 게시판
  1. Entity 클래스 생성
    - 게시판, 댓글 Entity 클래스 생성
    - JPA로 DB 연동
  2. Repository 생성
    - JpaRepository를 상속받는 인터페이스 생성
  3. Service 생성
    - 게시판 비지니스 로직 서비스 생성
    - 조회, 등록, 수정, 삭제
  4. Controller 생성
    - 비동기 통신 CSR?, Thymeleaf? 아직 미정
4. 사용자
  1. Entity
  2. Repository
  3. Service
  4. Controller
  5. Spring Security를 이용한 로그인, 로그아웃
5. 테스트 코드 작성
  - Junit, Mokito 단위 테스트, 통합 테스트 작성
  - 테스트 코드 먼저 작성하는 것이 좋지만, TDD를 해본적 없으니 나중에 작성하자.
6. FE
  - BE 구현이 더 중요하다고 판단, FE는 후순위로 작업 하자.
  - vue를 사용해 보고 싶지만, Thymeleaf를 먼저 해보는 게 나을 것으로 판단 됨.
  - 사용자 화면 은 thymeleaf, 관리자 페이지는 vue 구현도 괜찮을 듯.
7. 확장
  - 메뉴 생성 :  
    게시판을 여러 게시판으로 확장하여 메뉴에 연결할 수 있도록.
  - 비게시판성 콘텐츠 :  
    메뉴 ID에 묶어서 콘텐츨를 보여주도록
    1. 공지성 html
    2. mini game
      - 랜덤 당첨
      - 랜덤 + 비중 당첨
      - 응모하기
      - 사다리게임?
  - 메뉴 카테고리, 컨텐츠 카테고리, 
  - 그렇다면 사용자 도메인 먼저 만들고 게시판 순으로 만드는 게 나을 것 같은데..

