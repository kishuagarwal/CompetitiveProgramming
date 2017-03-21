import sys
import threading

countV = 0
countE = 0
n, m = map(int, raw_input().strip().split(' '))

f = {i: set() for i in xrange(n)}

for i in xrange(m):
    a,b = map(int, raw_input().strip().split(' '))
    f[a-1].add(b-1)
    f[b-1].add(a-1)

res = True

visited = [False for i in xrange(n)]


def dfs(node):
    global countV, countE
    visited[node] = True
    countV = countV + 1
    for child in f[node]:
        if not visited[child]:
            dfs(child)
        if node < child:
            countE += 1

def main():
    global countE, countV, res
    for i in xrange(n):
        if not visited[i]:
            countV = 0
            countE = 0
            dfs(i)
            if countV * (countV -1) != countE * 2:
                res = False
                break
    if res:
        print 'YES'
    else:
        print 'NO'

sys.setrecursionlimit(1024000)
threading.stack_size(102400000)
thread = threading.Thread(target=main)
thread.start()