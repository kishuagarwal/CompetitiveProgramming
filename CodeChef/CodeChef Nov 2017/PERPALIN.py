t = int(input())

for i in range(t):
    n, p = list(map(int, input().strip().split(' ')))
    if n < 3 or p < 3:
        print('impossible')
        continue
    s = ''
    temp = 'a' + 'b' * (p - 2) + 'a'
    for j in range(int(n/p)):
        s += temp
    print(s)
