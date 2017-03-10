n = int(raw_input())
l  = map(int, raw_input().strip().split(' '))

x = [False for i in xrange(n+1)]
current_pos = n
for i in l:
    x[i] = True
    while x[current_pos] and current_pos > 0:
        print current_pos,
        current_pos -= 1
    print ''

while x[current_pos] and current_pos > 0:
    print current_pos,
    current_pos -= 1
    an = True
