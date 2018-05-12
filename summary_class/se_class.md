## 수업내용 정리

### Pseudocode
1. Pseudocode란? 
- 가짜코드로 프로그램이나 알고리즘이 수행할 내용을 인간이 이해할 수 있는 언어로 표현하는 것
- 프로그램을 설께 할 때 밑그림의 역할을 하게 된다
- 목적과 수행과정이 명확해 코드 수정과 분해가 편하다
- Pseudocode가 comment의 역할을 수행 할 수 있다
- 작성할 언어와 가급적 비슷하게 작성하는 것이 좋다
```
- 영화를 보고 싶다가 true가 됨
- 돈이 있을 때, 집에 있을 때, 
    - 소장하고 있는 영화가 있다면 그 영화를 본다
    - 영화가 없다면 보지 않는다
- 돈이 있고, 밖에 있다면,
    - 어벤저스를 보지 않는다면 챔피언을 본다
    - 어벤저스를 보고 돈이 17,000원 이상 있다면 IMAX로 본다
    - 어벤저스를 보고 돈이 없다면 2D로 본다
```

2. fizzbuzz를 pseudo code로 만들어 보자
1부터 n까지 반복하면서, 3의 배수는 "fizz"
5의 배수는 "buzz", 15의 배수는 "fizzbuzz", 나머지는 숫자
```
1. 사용자로부터 숫자 하나를 받아 n에 할당한다.
2. 1부터 n까지 숫자를 진행시키면서,
3. 만약에 해당숫자가 15의 배수라면, "fizzbuzz"를 출력한다.
4. 만약에 해당숫자가 3의 배수라면, "fizz"를 출력한다.
5. 만약에 해당숫자가 5의 배수라면, "buzz"를 출력한다.
6. 3,4,5의 경우를 만족하지 못한 경우, 해당숫자를 그대로 출력한다.

1. get integer from user ==> num, i == 1
2. WHILE i is less than or equal to num
3. if i is divisible by 15, print "fizzbuzz"
4. if i is divisible by 3, print "fizz"
5. if i is divisible by 5, print "buzz"
6. else, print i
```
* 3번과 5번의 위치가 바뀌면 작업의 횟수가 늘어나서 작업의 효율성이 떨어지므로 두 줄의 스크립트를 바꿔주므로써 퍼포먼스가 향상된다

3. 부가가치세를 pseudo code로 만들어 보자
- Korea: 10%
- Japan: 8%
- USA: 주마다 다름
- UK: 20%
제품 가격과 나라에 따라 다른 부가가치세를 계산해 그 가격을 출력
```
1. get price of item ==> item_price
2. set tax rate (kor == 0.1, jap == 0.08, usa == "depend on state", uk == 0.2)
3. get contry code(example: kor, jap, usa, uk) ==> contry_code
4. tax_rate is matched price with contry_code
5. sales tax is item_price times tax rate
5. total price is item_price plus sales tax
```