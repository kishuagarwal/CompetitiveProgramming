import sys
t = int(raw_input())

for i in xrange(t):
    n, l = map(int, raw_input().strip().split(' '))
    g = raw_input().strip().split(' ')
    b = raw_input().strip()
    sys.stdout.write('Case #{0}: '.format(i+1))
    if b in g:
        sys.stdout.write('IMPOSSIBLE\n')
        continue
    for c in b:
        if c == '0':
            sys.stdout.write('1?')
        else:
            sys.stdout.write('0?')
    sys.stdout.write(' ')
    if len(b) == 1:
        if b[0] == '0':
            sys.stdout.write('1')
        else:
            sys.stdout.write('0')
    for c in b[:-1]:
        if c == '0':
            sys.stdout.write('10')
        else:
            sys.stdout.write('01')
    sys.stdout.write('\n')