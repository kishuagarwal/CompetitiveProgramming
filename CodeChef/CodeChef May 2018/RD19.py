t = int(input())

soe = [True for i in range(50002)]


def find_primes():
    soe[0] = False
    soe[1] = False
    for i in range(2, 50001):
        if not soe[i]:
            continue
        for j in range(i*i, 50001, i):
            soe[j] = False


find_primes()
for _ in range(t):
    n = int(input())
    l = map(int, input().strip().split(' '))
    count = 0
    for num in l:
        if not soe[num]:
            count += 1
    if n - count == 1:
        print(-1)
    else:
        print(count)
