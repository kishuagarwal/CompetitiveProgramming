import sys
sys.setrecursionlimit(19000100)
n,e = map(int, raw_input().split())

edges = []
uedges = {node: [] for node in xrange(n)}
bedges = {node: [] for node in xrange(n)}
for i in xrange(e):
    a,b = map(int, raw_input().split())
    a -= 1
    b -= 1
    edges.append([a,b, False])
    uedges[a].append(b)
    uedges[b].append(a)
    bedges[a].append(i)
    bedges[b].append(i)


def possible():
    visited = [False for _ in xrange(n)]
    stack = [0]
    possible = True
    visited[0] = True
    odd = False
    while len(stack) > 0:
        node = stack.pop()
        odd = len(uedges[node]) % 2 != 0
        if odd:
            break
        for neigh in uedges[node]:
            if not visited[neigh]:
                stack.append(neigh)
                visited[neigh] = True
    for i in visited:
        if not i:
            possible = False
            break

    return possible && not odd

if possible():
    stack = [0]

    while len(stack) > 0:
        node = stack.pop(0)
        for neigh in uedges[node]:
            if bedges[node]

else:
    print 'NO'