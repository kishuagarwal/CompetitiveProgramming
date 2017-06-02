from collections import deque

def bfs(a, n, m, queue, dist, length, max_element):
    dr = [0,-1,-1,-1,0,1,1,1]
    dc = [-1,-1,0,1,1,1,0,-1]
    count = length
    while length > 0:
        current_position = queue.popleft()
        length -= 1
        r = current_position[0]
        c = current_position[1]
        for i in xrange(8):
            cur_r = r + dr[i]
            cur_c = c + dc[i]
            if cur_r >= 0 and cur_r < n and cur_c >=0 and cur_c < m:
                if dist[cur_r][cur_c] > dist[r][c] + 1:
                    dist[cur_r][cur_c] = dist[r][c] + 1
                    queue.append((cur_r,cur_c))
                    count += 1
                    length += 1

    print count


def solve(n, m, a):
    dist = []
    max_element = 0
    queue = deque(maxlen=n * m)
    length = 0
    for j in a:
        dist.append([10000 for _ in  xrange(m)])
        max_element = max(max_element, max(j))
    for j in xrange(n):
        for k in xrange(m):
            if a[j][k] == max_element:
                queue.append((j,k))
                dist[j][k] = 0
                length += 1
    bfs(a,n,m,queue, dist, length, max_element)

    max_element = 0
    for j in xrange(n):
        max_element = max(max_element, max(dist[j]))

    print max_element

import random
def test():
    for i in xrange(500,501):
        for j in xrange(500,501):
            a = []
            for r in xrange(i+1):
                a.append([0 for _ in xrange(j+1)])
                for c in xrange(j+1):
                    a[r][c] = random.randint(1, 100000)
            solve(i+1,j+1,a)

test()