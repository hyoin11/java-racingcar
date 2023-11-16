### 2단계 - 문자열 덧셈 계산기
기능 요구사항   
- [x] 빈 문자열 또는 null 값인 경우 0을 반환 ("" -> 0, null -> 0)
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환 ("1" -> 1)
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환 ("1,2" -> 3)
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용("1,2:3" -> 6)
- [x] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정 ("//;\n1;2;3" -> 6)
- [x] 음수를 전달할 경우 RuntimeException 예외 ("-1,2,3" -> RuntimeException)

### 4단계 - 자동차 경주(우승자)
기능 요구사항
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.

수정 사항
- [x] 사용하지 않는 주석과 메소드 삭제
- [x] 삼항 연산자(if-else)문 else 사용 금지
- [x] Car 테스트 추가 및 상세 테스트 작성
- [x] setter 사용 금지
- [x] 적절한 매개변수, 클래스이름 사용
- [x] 변수, 메소드명 낙타 표기법 사용
- [x] 여러 결과값을 가질 경우 목록 등의 형식으로 다루기
- [x] 컬렉션 사용하기
---
이펙티브 자바 내용
매개 변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 메서드는 from,
매개 변수를 2개 이상 받아 적합한 타입의 인스턴스를 반환하는 메서느는 of를 사용한다.