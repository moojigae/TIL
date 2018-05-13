## git clone 사용하기

1. 복사할 깃의 레포를 복사하고 붙여 넣을 디렉토리에 명령어를 입력한다 (각각의 레포는 평행하게 존재해야 함, 타인의 레포여도 가능)
₩₩₩ $ git clone https://github.com/moojigae/TIL.git ₩₩₩
2. 레포를 클론했을 경우에는 `git init`을 할 필요가 없다.
3. `remote add`도 따로 해줄 필요 없다. 
4. 따라서 clone을 했을 때 필요한 명령어는 
```
- git add [file name]
- git commit [option] 
- git push [repo name][branch]
```
** 타인의 파일을 push할 경우는 소유권이 내것이 아니므로 인증 문제가 생길 수 있음 **
5. 로컬 컴퓨터에서 디렉토리가 지워져도 깃에는 내용이 남아있기 때문에 클론 받을 수 있음