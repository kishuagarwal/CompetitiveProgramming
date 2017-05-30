t = int(raw_input())

for i in xrange(t):
    n = int(raw_input())
    l = map(int, raw_input().strip().split(' '))
    print n - max(l)