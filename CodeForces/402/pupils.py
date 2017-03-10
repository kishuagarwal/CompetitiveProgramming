n = int(raw_input())
a = map(int, raw_input().strip().split(' '))
b = map(int, raw_input().strip().split(' '))

countA = [0 for i in xrange(6)]
countB = [0 for i in xrange(6)]
for i in a:
    countA[i] += 1

for i in b:
    countB[i] += 1

ans = 0
for i in xrange(6):
    #print countA[i], countB[i]
    if (countA[i] + countB[i]) % 2 == 1:
        print -1
        exit(0)
    diff = abs(countA[i] - countB[i])
    ans += diff / 2


print ans / 2