n, m, q =map(int, raw_input().strip().split(' '))
words = raw_input().strip().split(' ')
d = {}
for index, word in enumerate(words):
    d[word] = index

parent = [i for i in xrange(2*n)]
size = [1 for i in xrange(n)] + [0 for i in xrange(n)]

def p(pos):
    if parent[pos] == pos:
        return pos
    parent[pos] = p(parent[pos])
    return parent[pos]

def union(fp, sp):
    if fp == sp:
        return
    if size[fp] > size[sp]:
        parent[sp] = fp
        size[fp] += size[sp]
    else:
        parent[fp] = sp
        size[sp] += size[fp]

def get_opposite(p):
    if p < n:
        return n + p
    else:
        return p - n

for i in xrange(n):
    t,f,s = raw_input().strip().split(' ')
    t = int(t)
    print
    first = p(d[f])
    second = p(d[s])
    print first,second
    if t == 1:
        if second == get_opposite(first):
            print 'NO'
        else:
            print 'YES'
            union(first, second)
    else:
        if first == second:
            print 'NO'
        else:
            print 'YES'
            union(first, get_opposite(second))
            union(second, get_opposite(first))
    print parent
    print size

for i in xrange(q):
    first, second = raw_input().strip().split(' ')
    first = p(d[f])
    second = p(d[s])
    if first == second:
        print 1
    elif second == get_opposite(first):
        print 2
    else:
        print 3