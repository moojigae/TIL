```html
<!DOCTYPE html>
<!-- !!! + tab -->
<!-- doc + tab -->
<html lang="en">
<head>
  <meta charset="UTF-8">
  <!-- 인코딩 선언,head 시작하자 마자 넣는게 좋다  -->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- viewport 화면 크기에 맞춰보여줌 -->
  <!-- initial-scale 화면의 크기 조절을 사용자가 가능하게 하는 것 -->
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <!-- ua(user agent) 호환성 보기 모드/ ie=edge는 깔려있는 버전의 최신버전으로 보여줘라 -->
  <title>Document</title>
  <link rel="shortcut icon" href="images/common/webcafe.ico" type="image/x-icon">
  <!-- link + tab 파비콘은 사이트 앞에 보이는 아이콘  -->
    <link rel="apple-touch-icon" href="webcafe.png">
    <!-- link:touch +tab 휴대폰 홈 화면에 추가하는 런처 아이콘  -->
    <link rel="stylesheet" href="css/test.css">
    <!-- link:css + tab -->
</head>
<body>
  <!-- 3단구조 -->
    <div class="wrapper">
        <header class="header">헤더</header>
        <!-- header.header + tab -->
        <div class="visual">비주얼</div>
        <!-- div.visual + tab -->
        <main class="main clearfix">
          <!-- main.main + tab -->
            <div class="group group1">GROUP1</div>
            <div class="group group2">GROUP2</div>
            <div class="group group3">GROUP3</div>
            <!-- div.group.group*3 그룹 세개를 한 번에 생성함 1-->
            <!-- div.group.group${GROUP$}*3 그룹 세개를 한 번에 생성함 2 -->
            <!-- <div class="clearfix"></div> -->
        </main>
        <article class="slogan">
            <h2 class="slogan-heading">
                슬로건
              </h2>
              <!-- cmd + shift + g -> h2.slogan-heading -->
        </article>
        <div class="footer-bg">
          <footer class="footer">푸터</footer>
          <!-- div.footer-bg>footer.footer footer-bg 부모레벨, footer 자식레벨 -->
        </div>
        </div>
</body>
</html>
```