import sys
import threading
sys.setrecursionlimit(1000000)

def visit(node, visited, tree, c, count):
    visited[node] = True
    for child in tree[node]:
        if not visited[child]:
            if c[node] != c[child]:
                count[node] += 1
                count[child] += 1
            visit(child, visited, tree, c, count)

def main():
    n = int(raw_input())
    tree = [[] for i in xrange(n)]
    for i in xrange(n-1):
        u, v= map(int, raw_input().split())
        u -= 1
        v -= 1
        tree[u].append(v)
        tree[v].append(u)

    c = map(int, raw_input().split())

    count = [0 for _ in xrange(n)]
    visited = [False for _ in xrange(n)]
    visit(0, visited, tree, c, count)
    found = None
    is_possible = True
    match = 0
    an_count = 0
    an = None
    for i in xrange(n):
        if count[i] > 1:
            if found:
                is_possible = False
            found = i
        if count[i] == 1:
            an_count += 1
            an = i
    if is_possible:
        if found is not None:
            if an_count != count[found]:
                is_possible = False
        else:
            if an_count > 0 and an_count == 2:
                found =  an
            elif an_count > 2:
                is_possible = False
            else:
                found = 0

    if is_possible:
        print 'YES'
        print found + 1
    else:
        print 'NO'



if __name__ == "__main__":
    sys.setrecursionlimit(200000)
    threading.stack_size(10240000)
    thread = threading.Thread(target=main)
    thread.start()