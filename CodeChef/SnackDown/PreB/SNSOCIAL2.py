from collections import deque

t = int(raw_input().strip())

def bfs(a, n, m, queue, dist, length, max_element):
    dr = [0,-1,-1,-1,0,1,1,1]
    dc = [-1,-1,0,1,1,1,0,-1]
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
                    length += 1

for i in xrange(t):
    n,m = map(int, raw_input().strip().split())
    a = []
    dist = []
    max_element = 0
    queue = deque(maxlen=n * m)
    length = 0
    for j in xrange(n):
        b = map(int, raw_input().strip().split())
        a.append(b)
        dist.append([1000000 for _ in  xrange(m)])
        max_element = max(max_element, max(b))
    
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

