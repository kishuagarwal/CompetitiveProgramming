t = int(raw_input())

def floyd_marshall(graph, n):
    for i in xrange(n):
        graph[i][i] = 0

    for k in xrange(n):
        for i in xrange(n):
            for j in xrange(n):
                if graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]



for i in xrange(t):
    n,m,k = map(int, raw_input().split())
    graph = [[] for j in xrange(n)]
    for j in xrange(n):
        graph[j] = [1e30   for _ in xrange(n)]

    for j in xrange(m):
        a,b,g = map(int, raw_input().split())
        a -= 1
        b -= 1
        graph[a][b] = min(graph[a][b], g)
        graph[b][a] = min(graph[b][a], g)

    floyd_marshall(graph, n)
    cur = [0,0]
    f = []
    for j in xrange(k):
        s,d = map(int, raw_input().split())
        f.append((s-1,d-1))
    
    cur[0] = graph[0][f[0][0]] + graph[f[0][0]][f[0][1]]
    cur[1] = 1e30
    prev = [0,0]
    if k > 1:
        cur[1] = graph[0][f[0][0]] + graph[f[0][0]][f[1][0]] + graph[f[1][0]][f[0][1]]
    for j in xrange(1,k):
        prev[0],prev[1] = cur[0],cur[1]
        if j == k-1:
            temp1 = prev[0] + graph[f[j-1][1]][f[j][0]] + graph[f[j][0]][f[j][1]]
            temp2 = prev[1] + graph[f[j-1][1]][f[j][1]]
            cur[0] = min(temp1, temp2)
            cur[1] = 1e30
        else:
            temp1 = prev[0] + graph[f[j-1][1]][f[j][0]] + graph[f[j][0]][f[j][1]]
            temp2 = prev[1] + graph[f[j-1][1]][f[j][1]]
            cur[0] = min(temp1, temp2)

            temp1 = prev[0] + graph[f[j-1][1]][f[j][0]] + graph[f[j][0]][f[j+1][0]] + graph[f[j+1][0]][f[j][1]]
            temp2 = prev[1] + graph[f[j-1][1]][f[j+1][0]] + graph[f[j+1][0]][f[j][1]]
            cur[1] = min(temp1, temp2)
    gas = min(cur[0], cur[1])
    if gas >= 1e29:
        gas = -1
    print 'Case #{0}: {1}'.format(i+1, gas)