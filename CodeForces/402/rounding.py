n,k = map(int, raw_input().strip().split(' '))

ns = str(n)

zero = ord('0')
nine = ord('9')

zeroCount = 0
for c in ns:
    if c == '0':
        zeroCount += 1

if zeroCount >= k:
    # possible
    ns = ns[::-1]
    zeroCount = 0
    numbers = 0
    for c in ns:
        if c == '0':
            zeroCount += 1
            if zeroCount == k:
                print numbers
                break
        else:
            numbers += 1

else:
    print len(ns) - 1
