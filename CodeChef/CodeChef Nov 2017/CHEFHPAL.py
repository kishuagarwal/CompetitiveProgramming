import string
import math
t = int(input())

def test(s, largest):
    found = 0
    for i in range(len(s)):
        for j in range(i, len(s)):
            if s[i:j+1] == s[i:j+1][::-1]:
                found = max(found, j - i + 1)
    if found != largest:
        print('Mismatch', s, largest, found)


for i in range(t):
    n, a = list(map(int, input().strip().split(' ')))
    if a == 1:
        print(n, 'a' * n)
       #test('a'*n, n)
        continue
    if a > 2:
        c = string.ascii_lowercase[:a]
        ans = c * (n // a) + c[:n % a]
        print(1, ans)
        #test(ans, 1)
        continue

    if n < 7:
        ans = 'a' * (int(math.ceil(n / 2))) + 'b' * (n // 2)
        print((int(math.ceil(n / 2))), ans)
        #test(ans, (int(math.ceil(n / 2))))
        continue
    if n == 7:
        print(3, 'aaababb')
        continue
    if n == 8:
        print(3, 'aaababbb')
        continue
    s = 'abaabb'
    ans = s * (n // len(s)) + s[: n % len(s)]
    print(4, ans)
    #test(ans, 4)


