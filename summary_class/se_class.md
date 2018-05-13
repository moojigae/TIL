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

### 알고리즘
1. 알고리즘이
- 목표를 달성하거나 결과물을 생산하기 위해 필요한 과정들
- 여러 해결 방법 중에 효율성과 명확성을 지닌 프로그램을 구현하는 과정
- 수도코드를 코드로 옮길 때 어디에 주안점을 두고 옮길지 중점을 두는 것.
- time complexity == big O notation
> 자료의 수 (n)이 증가할 때 시간의 증가 패턴을 나타낸 것
- big O notation (밑으로 내려갈 수록 느려진다,3번을 넘어갈경우 서버에 과부하가 올 수 있다)
    1. 1
    2. log n
    3. n 
    4. n log n 
    5. $n^2$
    6. $n^3$
    7. $2^n$
    8. n!
    
    1. O(1) : constant    
    - 값에 대한 키 또는 인덱스를 알고 있을 경우 random access한다. 
      minsu_exam_result = {"kor":95,"math":40}
      `minsu_exam_result['kor']`
      ```
      result = 0
      n = 100
      result = n*(n+1)/2
      ```
    2. O(log n) : logarithmic
    - 배열에서 값을 접근할 때 앞 또는 뒤에서 순차적으로 접근 선택이 가능할 경우   
        `animals = ['cat', 'dog', 'fox', 'giraffe', 'hippo', 'koyote', ..]`
    3. O(n): linear
    - 자료의 수와 시도횟수가 1:1 관계인 경우
     ```
    result = 0
    for i in range(1,100+1):
	    result += i
    print(result)
    ```   
    4. O($n^2$): quadratic
    - 자료의 참조를 이중으로 하게 될 경우(반복문)
    ```
    result = 0
    for i in range(1,10+1):
	    for i in range(1,i+1):
	result += i
    ```
    5. Sort algorithms[데이터가 정렬되어 있는 방식에 따라 방식을 선택]
    - O($n^2$)
	    - Bubble sort : 1:1,2개씩 비교하며 큰 값을 택해가며 정렬, 매우 안좋다
	    - Selection sort : 가장 작은 값부터 순서대로 정렬, 인간과 가장 가까운 정렬법
	    - Insertion sort : n번째 요소를 처음부터 n-1번째까지 비교하면서 값을 끼워 넣는 방법,윗 방법보단 빠름
    - O(n log n)
	    - Merge sort : 두개씩 쪼개 각각을 비교하며 정렬하는 방법, 데이터 상태에 큰 영향을 받지 않음
	    - Heap sort : 데이터를 힙에 넣은 뒤 최대값(루트)을 출력하고 힙에서 제거
	    - Quick sort : 피벗을 기준으로 큰 값 작은 값을 나눈 뒤, 피벗을 옮겨 다시 수행하는 방법, 평균적으로 가장 빠름

### 자료구조
1. 자료구조
- 데이터를 어떻게 쌓아야 조회할 때 효율적으로 조회 가능한가     
2. Array(관계형,엑셀같은 테이블,데이터를 묶어주는 배열,왼쪽이 항상 끝) & Hash(Dictionary) - indexing post
- Tree - DOM rendering performance, reply
    - 트리 노드가 복잡할 브라우저가 읽는 시간이 오래걸림. 상하구조를 규정하는 자료구조, 브라우저가 파싱을 해서 분석을 하기 때문에 빠르게 파싱 할 수 있도록 작성해야 함 
- Binary Tree Search
	- Stack(DFS, Depth First Search) : 들어가는 순서와 나가는 순서가 다르다. LIFO(Last in,First out)
        - push: which adds an element to the collection
        - pop: which removes the most recently added element that was not yet removed
    - Queue(BFS, Breadth First Search) : 순서가 중요한 것에 사용. FIFO(First in,First out)
        - Enqueue: addition of entities to the rear terminal position
        - Dequeue: removal of entities from the front terminal position
- Linked List
    - 자바는 순서대로 데이터를 쌓지 않고 마구잡이로 쌓기 때문에,Linked List는 값에 다음 행선지의 번지수를 연결해놓고 계속 연결해서 찾아 갈 수 있도록 구성되어 있음
- Tree : 상하관계를 구조화하기 위한 축약 모델
    - 동그라미를 노드, 맨 위에 노드를 루트, 층을 레벨, 화살표를 엣지라고 함.
    - 노드를 두개까지 가질 수 있는게 바이너리트리라고하며, 일반적으로 바이너리를 사용함
    - 트리 탐색을 stack과 queue 중에 어디 쌓을 것인가에 따라 구현이 달라짐