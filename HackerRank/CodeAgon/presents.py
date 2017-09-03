import sys
import threading


def main():

    t = int(raw_input())


    def traverse(node, parent, graph, edges):
        any_special = False
        for edge in graph[node]:
            edge = edges[edge]
            other = edge[0] if edge[0] != node else edge[1]
            if other != parent:
                is_special = traverse(other, node, graph, edges)
                if not is_special:
                    edge[3] = False
                else:
                    any_special = True
                if edge[2] == 1:
                    edge[3] = True
                    any_special = True
        return any_special


    def compute3(node, parent, graph, edges):
        include, exclude = 1, 0
        for edge in graph[node]:
            edge = edges[edge]
            other = edge[0] if edge[0] != node else edge[1]
            if other != parent:
                child_include, child_exclude = compute3(other, node, graph, edges)
                include *= (1 + child_include)
                exclude += child_exclude + child_include
                if include > 10**9 + 7:
                    include %= 10**9 + 7
                if exclude > 10**9 + 7:
                    exclude %= 10**9 + 7
        return include, exclude


    def compute2(node, parent, graph, edges):
        if len(graph[node]) == 1:
            return 2
        ways = 1
        for edge in graph[node]:
            edge = edges[edge]
            other = edge[0] if edge[0] != node else edge[1]
            if other != parent:
                ways *= compute2(other, node, graph, edges)
                if ways > 10**9 + 7:
                    ways %= 10**9 + 7
        return ways + 1


    def compute(node, parent, graph, edges):
        ways = 1
        for edge in graph[node]:
            edge = edges[edge]
            other = edge[0] if edge[0] != node else edge[1]
            if other != parent:
                if edge[3] == False:
                    ways *= compute2(other, node, graph, edges)
                    if ways > 10**9 + 7:
                        ways %= 10**9 + 7
                else:
                    ways *= compute(other, node, graph, edges)
                    if ways > 10**9 + 7:
                        ways %= 10**9 + 7

        return ways


    for i in xrange(t):
        n = int(raw_input())
        if n == 1:
            print 0
            continue
        graph = {}
        for j in xrange(n):
            graph[j] = []
        c = None
        edges = []
        for j in xrange(n-1):
            u,v,g = map(int, raw_input().strip().split())
            u -= 1
            v -= 1
            edges.append([u,v, g, True])
            graph[u].append(j)
            graph[v].append(j)
            if g == 1:
                c = u

        # print c
        # print graph
        # print edges
        if c is not None:
            traverse(c, -1, graph, edges)
            ways = compute(c, -1, graph, edges)
        else:
            #traverse(c, -1, graph, edges)
            include, exclude = compute3(0, -1, graph, edges)
            ways = include + exclude
            if ways > 10 ** 9 + 7:
                ways %= 10 ** 9 + 7

        print ways



if __name__ == "__main__":
    sys.setrecursionlimit(1000000)
    threading.stack_size(2 ** 28)
    thread = threading.Thread(target=main)
    thread.start()
