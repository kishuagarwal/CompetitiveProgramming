t = int(raw_input())
for i in range(t):
    n = int(raw_input())
    p = map(int, raw_input().split())
    m = {pop: index for index, pop in enumerate(p)}
    edges = {}
    p.sort(reverse=True)
    
    if n == 1:
        print 0
        continue
    for e in xrange(n-1):
        u,v = map(int ,raw_input().split())
        u -= 1
        v -= 1
        if u in edges:
            edges[u].append(v)
        else:
            edges[u] = [u,v]
        if v in edges:
            edges[v].append(u)
        else:
            edges[v] = [v,u]
    highest_node = m[p[0]]
    

    for node in xrange(n):
        if highest_node in edges[node]:
            found = False
            for value in p:
                nod = m[value]
                if nod not in edges[node]:
                    print nod+1,
                    found = True
                    break
            if not found:
                print 0,
        else:
           print highest_node+1,

    print
