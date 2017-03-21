t = int(raw_input())

def so(order, size):
    if size == len(order):
        return
    for i in xrange(0,pow(2,n),2 * size):
        first = i
        second = i+size
        if order[second:second+size] < order[first:first+size]:
            for j in xrange(size):
                order[first + j], order[second + j] = order[second + j], order[first + j] 

    so(order, size * 2)

def check(c, level,pos):
    global _r,_p,_s
    if level == max_level:
        if c == 'R':
            _r -= 1
        elif c == 'P':
            _p -= 1
        else:
            _s -= 1
        order[pos] = c
        return
    if c == 'R':
        check('R', level+1, 2 * pos)
        check('S', level+1, 2 * pos+1)
    elif c == 'P':
        check('P', level+1, 2 * pos)
        check('R', level+1, 2 * pos + 1)
    elif c == 'S':
        check('P', level+1, 2 * pos)
        check('S', level+1, 2 * pos + 1)


for i in xrange(t):
    n,r,p,s = map(int, raw_input().strip().split(' '))
    print 'Case #{0}:'.format(i+1),
    max_level = n
    order = ['R'] * pow(2, n)
    possible = False
    ans = None
    for c in 'RPS':
        _r,_p,_s = r,p,s
        check(c, 0,0)
        if _r == 0 and _p == 0 and _s == 0:
            possible = True
            so(order,1)
            if ans is None:
                ans = order[:]
            else:
                ans = min(ans, order[:])

    if possible:
        print ''.join(ans)
    else:
        print 'IMPOSSIBLE'