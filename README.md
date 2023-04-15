## step5 - 자동차 경주(리팩토링)

---
### step5 피드백 내용
- [X] .gitkeep 파일 삭제
- [X] List.of 사용
- [X] Integer.compare 사용
- [X] 메서드명 변경
  - Stages 클래스 내 isRunning 메서드 -> hasMoreStages 메서드
- [X] 패키지 구조 분리

---
### step4 피드백 내용
- [X] 의미있고 구체적인 변수명 사용
- [X] 의미있고 구체적인 메서드명 사용
- [X] Car 클래스 주생성자/부생성자 수정
- [X] Cars 클래스의 진정한 일급컬렉션 구현
- [X] Stages 클래스 테스트 케이스 추가
- [X] Cars 객체 내 View 관련 상수값 분리
- [X] Car 클래스에서 max position 값 찾아서 가져오기 및 우승자 선정 방식 수정

### 추가 구현 내용
- [X] 자동차 이름이 같을 경우 에러 반환

---
## step4 - 자동차 경주(우승자)

---
### 1차 피드백 내용
- [X] 테스트 코드 작성 관련 클래스 테스트 패키지로 이동
- [X] 전략이 boolean 을 반환
- [X] SCANNER.nextInt() 사용 검토
- [X] 자동차가 현재 위치를 정수로 갖도록 수정
- [X] Cars 에서 Count 를 받아 Cars 생성 검토
- [X] 도메인로직(핵심 로직)과 ui 를 분리

---
### 기능 요구사항
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

---
###  구현 내용
- [X] 자동차 이름 입력 기능
  - [X] 5자 초과 방지
  - [X] Comma(,) 기준으로 구분
- [X] 우승자 선정 기능
- [X] 자동차 이름 출력 기능

---
### 2차 피드백 내용
- [X] 이전 구현 내용 docs 추가
- [X] Cars 클래스 run 메소드 객체 주입 방식 변경
  - RandomMovementStrategy 객체를 매번 생성하는 방식이 아닌 방식으로 수정
- [X] CarNames 클래스 삭제 및 관련 구현 내용 수정
  - [X] String 타입으로 input 받아서 Car 클래스에서 name 관련 유효성 검사 실행
  - [X] 자동차 이름은 5자를 초과 검증은 Car 클래스에서 검증
- [X] 우승자 선정 방식 변경
  - Car 클래스가 Comparable 을 구현(X)
    - 수정 과정에서 구현할 필요가 없어졌음
  - [X] max position 선정 방식 수정
    - 정렬하지 않고 stream을 사용하여 구하는 방식으로 수정
  - [X] Car 객체에 우승 자동차인지 확인하는 메시지를 보내는 코드로 수정
  - [X] 테스트 코드 수정

---
### step3 2차 피드백 반영
- [X] 정적 팩토리 메서드 사용
- [X] 전략 테스트 코드 수정

---
## Step3 - 자동차 경주

---
### 기능 요구사항
* 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
* 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

---
### 구현 내용
- [X] 입력 기능
  - [X] 자동차 대수 입력 기능
  - [X] 게임 시도 회수 입력 기능
- [X] 게임 실행 기능
  - [X] 자동차 랜덤 전진 기능
- [X] 결과 출력 기능
---

## 학습 내용 정리

---
### 정적 팩토리 메소드 정리
- 직접적으로 생성자를 통해 객체를 생성하는 것이 아닌 메서드를 통해서 객체를 생성하는 것
- 정적 팩토리 메서드를 사용하면 메서드 이름에 객체의 생성 목적을 담아 낼 수 있음
- 객체 생성을 캡슐화 할 수 있음
---

### 람다 함수 사용
```java
car.run(new MovementStrategy() {
@Override
public boolean movement() {
        return true;
        }
        });
```
위와 같이 표현한 방식을 아래와 같이 람다 식으로 바꿀 수 있음!
```java
car.run(() -> true);
```
이렇게 바꿀 수 있는 이유는 인터페이스가 단 하나의 추상 메서드만을 갖고있기 때문!

### Arrays.asList()와 List.of()의 차이
- Arrays.asList()의 리턴값은 java.util.ArrayList이 아닌 Arrays 클래스의 내부클래스 ArrayList
- ArrayList는 삽입, 삭제로 이뤄지는 구조적인 변경을 허용하지 않고 내부 원소들의 값을 변경하는건 허용
- Java 9 버전 부터는  List.of(array)라는 새로운 팩토리 메소드를 도입
- List.of() 메서드의 리턴되값은 List는 불변객체이고 내부 원소값 수정 불가
- Array.asList()는 null을 허용하지만 List.of()는 null을 허용하지 않음
- Arrays.asList()는 List.of()보다 힙에 더 많은 개체를 생성하기 때문에 더 많은 오버헤드 공간을 차지

- 참고자료
  - https://kim-jong-hyun.tistory.com/31
  - https://jaehoney.tistory.com/144
  - https://inpa.tistory.com/entry/JAVA-%E2%98%95-ArraysasList-%EC%99%80-Listof-%EC%B0%A8%EC%9D%B4-%ED%95%9C%EB%B0%A9-%EC%A0%95%EB%A6%AC

### Integer.compare()
```java
public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
```
- 정수값 비교 메서드로 x값이 y값보다 크면 1, 같으면 0, 작으면 -1을 반환
- 아래 코드와 위 코드는 동일
```java
Integer.valueOf(x).compareTo(Integer.valueOf(y))
```