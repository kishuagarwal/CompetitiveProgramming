import sys
sys.setrecursionlimit(19000100)
n,e = map(int, raw_input().split())

edges = []
uedges = {node: [] for node in xrange(n)}
fedges = {node: [] for node in xrange(n)}
bedges = {node: [] for node in xrange(n)}
for i in xrange(e):
    a,b = map(int, raw_input().split())
    a -= 1
    b -= 1
    edges.append([a,b,False])
    fedges[a].append(i)
    bedges[b].append(i)
    uedges[a].append(b)
    uedges[b].append(a)

def possible():
    visited = [False for _ in xrange(n)]
    stack = [0]
    poss = True
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
            poss = False
            break
    return poss and not odd
visited = [False for i in xrange(n)]
edges_visited = 0
vertex_visited = 0
def visit(node):
    global edges_visited
    global vertex_visited
    if not visited[node]:
        visited[node] = True
        vertex_visited += 1
    
    while len(fedges[node]) > 0:
        neigh_pointer = fedges[node][0]
        neigh = edges[neigh_pointer][1]
        fedges[node].pop(0)
        if not edges[neigh_pointer][2]: 
            edges[neigh_pointer][2] = True
            edges_visited += 1
            return visit(neigh)

  
    while len(bedges[node]) > 0:
        neigh_pointer = bedges[node][0]
        neigh = edges[neigh_pointer][0]
        bedges[node].pop(0)
        if not edges[neigh_pointer][2]:
            temp = edges[neigh_pointer][0]
            edges[neigh_pointer][0] = edges[neigh_pointer][1]
            edges[neigh_pointer][1] = temp
            edges[neigh_pointer][2] = True
            edges_visited += 1
            return visit(neigh)
    if start_node == node:
        return True
    return False
if not possible():
    print 'NO'
else:
    for i in edges:
        if not i[2]:
            start_node = i[0]
            result = visit(start_node)
            if not result:
                break
    if result and vertex_visited == n and edges_visited == e:
        print 'YES'
        for edge in edges:
            print edge[0]+1, edge[1]+1
    else:
        print 'NO'