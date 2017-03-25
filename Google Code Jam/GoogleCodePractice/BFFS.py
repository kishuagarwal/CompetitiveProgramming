import sys
sys.setrecursionlimit(100000)

t = int(raw_input())

def reduce(x):
    return x - 1

def find_connected_component(cur, vertices):
    visited[cur] = True
    vertices.append(cur)
    if not visited[f[cur]]:
        find_connected_component(f[cur], vertices)
    for b_node in b[cur]:
        if not visited[b_node]:
            find_connected_component(b_node, vertices)

def dfs(cur,vertices):
    if visited_cycle[cur]:
        # a cycle
        return 0, cur, True
    visited_cycle[cur] = True
    length, cycle_node, should_increase = dfs(f[cur], vertices)
    if should_increase and cur == cycle_node:
        should_increase = False
        length += 1
        vertices.append(cur)
    elif should_increase:
        length += 1
        vertices.append(cur)

    return length, cycle_node, should_increase

def find_depth(cur):
    depth = 0
    for b_node in b[cur]:
        if b_node == f[cur]:
            continue
        result = find_depth(b_node)
        depth = max(depth, result + 1)
    return depth

for i in xrange(1, t+1):
    n = int(raw_input())
    f = map(int, raw_input().strip().split(' '))
    f = map(reduce, f)
    b = {j:[] for j in xrange(n)}

    for index, x in enumerate(f):
        b[x].append(index)

    ans = 0
    cycle_ans = 0
    visited = [False for j in xrange(n)]
    visited_cycle = [False for j in xrange(n)]
    cycle_node = [False for j in xrange(n)]
    for j in xrange(n):
        if not visited[j]:
            vertices = []
            find_connected_component(j, vertices)
            # Check the cycle length
            cycle_nodes = []
            length, _,_ = dfs(vertices[0], cycle_nodes)
            if length > 2:
                cycle_ans = max(cycle_ans, length)
            elif length == 2:
                left = find_depth(cycle_nodes[0])
                right = find_depth(cycle_nodes[1])
                ans += left + right + length

    ans = max(ans, cycle_ans)
    print 'Case #{0}: {1}'.format(i, ans)
