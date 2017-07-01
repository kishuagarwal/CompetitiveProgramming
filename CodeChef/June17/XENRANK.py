t = int(raw_input())

for i in xrange(t):
    u,v = map(int, raw_input().strip().split(' '))
    dist = u + v
    rank = (dist) * (dist + 1) / 2
    print rank + (dist - v + 1)