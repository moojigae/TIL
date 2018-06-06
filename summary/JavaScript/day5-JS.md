- Call-by-value VS Call-by-reference 인수에 데이터값을 넣었을 때 인수에 들어가는 데이터의 값이 달라짐 
  - Call-by-value : 기본자료형. 값을 복사
  - Call-by-reference : 객체에서 사용. 참조하고 있는 주소를 보유

- prototype 객체 : 상속의 개념. 부모의 프로퍼티나 메소드 자유롭게 사용 가능/부모역할 

- [[Prototype]] 프로퍼티 vs prototype 프로퍼티 
  - __proto__ : 모든 객체가 가짐/자식은 객체 
  - prototype : 생성되는 함수만 가질 수 있음

- navtive object VS Host object 
  - navtive object : 규칙에 있는거/빌트인 
  - Host object : 웹브라우저에 특화됨. 규정에 무시될 수 있음.   

- 함수는 객체이므로 프로퍼티(5개)를 갖는다 
 - argument 객체 : 파라미터를 정의할 수 없는 상황에서 인수의 정보를 가지고 있음?
 - 유사배열객체 : 순서보장하는 객체. length를 가지고 있음
- native object: 자바스크립트가 어떤 환경이든 돌아가는 빌트인 (node.js : 자바스크립트 환경이다)
- 레퍼객체 : 기본자료형에 .을 찍어서 객체처럼 동작. 객체로 임시적으로 전환함 `null, undefined 는 생성자함수가 없음`

- 프로토타입 객체만 constructor를 가지고 있다 (constructor : 생성자 함수)
- 문자열은 객체화 됐을 때 유사형객체다
- [[PrimitiveValue]]: 'Lee' [[]]는 숨겨둔 프로퍼티/함부로 접근 하면 안됨 
- 문자열에 숫자 강제 형변환
  - +를 붙인다
  - parseInt
  - Number(‘-‘) :  new를 안붙일 경우 강제 형변환 됨,사용하지 않는게 좋음
- ASCII -> Unicode 로 쓰게되면서 영어만 되던 것에서 다른 언어도 가능해짐
- String Method -> 기본 자료형은 변경 불가기 때문에 리턴으로 변환 값을 반환해야하고, 객체는 자동 변경되므로 필요 없음
- index = 색인 
```
var str = 'Hello';
console.log(str.charAt(0)); // H    <- str['0']으로 조회 가능하고 더 편하기 때문에 charAt은 잘 안씀
str = str.concat(name); // str = str + name;    str에 name을 연결한다/ + 연산자가 있기 때문에 concat은 쓸 필요없다

var str = 'Hello World';
console.log(str.indexOf('l'));  // 2      str에 i의 인덱스가 뭐냐
str.indexOf(searchString[, fromIndex])    []대괄호는 옵션 ()필수

String.prototype.replace(searchValue: string | RegExp, replaceValue: string): string 
searchValue를 찾아서 sting으로 변환해라
string | RegExp : string or 정규표현식 
- replacedStr = str.replace(/hello/gi, 'Lee');  gi < 정규표현식

// 인수가 없는 경우, 대상 문자열 전체를 단일 요소로 하는 배열을 반환한다.
splitStr = str.split();
console.log(splitStr); // [ 'How are you doing?' ]        = 복사
```
- string의 모든 메소드는 결과값을 받아줘야 한다 
- Number.EPSILON 대문자인 이유는 상수(절대로 변환하지 말아야한다) : 자바스크립트에서 표현할 수 있는 가장 작은 수. 수와 수 사이 a와 b의 차이가 EPSILON보다 작으면 의미없는 수라 판단되어 같은 값으로 봄
- 1.7976931348623157e+308   지수표기법
- NaN 유한도 무한수도 아님
```
Number.isFinite(2e64)      // true        < 지수표기법 2의64승
Number.isFinite(null)      // false. isFinite(null) => true(암묵적으로 형변환을 하기 때문에 null을 0으롱변경함)
Number.isFinite의 위치는 생성자 함수에 있음(Number)
```
- static method  객체생성필요없이 언제든지 그냥 호출 가능(함수 부르듯이)
```
Number.isFinite(Infinity)  // false
Number.isFinite(NaN)       // false
Number.isFinite('Hello')   // false
Number.isFinite('2005/12/12')   // false
```
- (function printNow()      < ()되어 있는 함수는 즉시함수
- hour = hour ? hour : 12; // 0 => 12     0일 때는 12로 출력 /앞은 false 뒤는 true
- setTimeout : 시간 다룸 
```
setTimeout(printNow, 1000);       함수명은 디버거에서 사용 할 때, 자기 자신을 재귀적으로 호출할 때 
setTimeout 앞에 아무것도 없어서 전역 method     콜백함수,밀리세컨드 초    
setInterval   
```
- 재귀함수 : 자기 자신을 1초에 한 번씩 부름