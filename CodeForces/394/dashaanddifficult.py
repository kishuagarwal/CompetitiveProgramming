n, l , r = map(int, raw_input().split(' '))

a = map(int, raw_input().split(' '))
c = map(int, raw_input().split(' '))
b = [0] * n

pos = [0] * n
for index, i in enumerate(c):
    pos[n-i] =  index
lar = r
isPossible = True
b[pos[0]] = lar
lar = b[pos[0]] - a[pos[0]] - 1
for i in pos[1:]:
    if a[i] + lar < l:
        isPossible = False
        break
    b[i] = min(lar + a[i], r)
    lar = b[i] - a[i] - 1

if isPossible:
    for x in b:
        print x,
else:
    print -1