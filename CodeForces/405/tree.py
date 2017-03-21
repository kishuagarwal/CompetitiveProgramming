import sys
sys.setrecursionlimit(1000000)

n, k = map(int , raw_input().strip().split(' '))
k += 1
t = {i : [[0] *k, [0] * k, set()] for i in xrange(n)}

for i in xrange(n-1):
    a,b = map(int , raw_input().strip().split(' '))
    t[a-1][2].add(b-1)
    t[b-1][2].add(a-1)

visited = [False for i in xrange(n)]
ans = 0
def find(s):
    global ans
    visited[s] = True
    c = t[s]
    for child in t[s][2]:
        if not visited[child]:
            find(child)
            child = t[child]
            for i in xrange(k):
                if i == 0:
                    c[0][(i+1) % k] += child[0][i]
                    c[1][(i+1) % k] += child[1][i] + child[0][i]
                else:
                    c[0][(i+1) % k] += child[0][i]
                    c[1][(i+1) % k] += child[1][i]

    if s == 0:
        c[0][1] += len(t[s][2])
        c[1][1] += len(t[s][2])
    else:
        c[0][1] += len(t[s][2])-1
        c[1][1] += len(t[s][2])-1

    print 'Node',s, t[s]
    for i in xrange(k):
        ans += c[1][i]



find(0)
print ans

