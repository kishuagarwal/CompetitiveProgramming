import sys
import threading

def main():
    n, m = map(int, raw_input().strip().split(' '))

    graph = {}

    for i in xrange(n):
        graph[i] = []

    for i in xrange(m):
        x, y = map(int, raw_input().strip().split(' '))
        graph[x-1].append(y-1)
        graph[y-1].append(x-1)

    visited = [False for _ in xrange(n)]

    hap = 0

    def visit(node, parent, graph, visited):
        stack = []
        cycle_count = 0
        size = 1
        visited[node] = True
        stack.append((node, parent))
        while len(stack) > 0:
            node, parent = stack.pop()
            for child in graph[node]:
                if child != parent:
                    if visited[child]:
                        if node < child:
                            cycle_count += 1
                        continue
                    stack.append((child, node))
                    visited[child] = True
                    size += 1
                    # visit(child, node, graph, visited)
        return cycle_count, size


    components = []
    components1 = []
    for i in xrange(n):
        if not visited[i]:
           cycle_count,size = visit(i, -1, graph, visited)
           components.append((cycle_count, size))
           components1.append((size, cycle_count))
           hap += (size - 1) * size

    # print components
    components.sort(reverse=True)
    left = 2
    for component in components:
        if component[0] > 0:
            left -= min(component[0], 2)

        if left == 0:
            break

    if left > 0:
        components1.sort(reverse=True)
        for i in xrange(len(components1)-1, -1, -1):
            if components1[i][0] > 1:
                hap -= (components1[i][0] - 1) * 2
                left -= 1
                if left == 0:
                    break
                if components1[i][0] > 2:
                    hap -= (components1[i][0] - 2) * 2
                    break

    print hap

if __name__ == "__main__":
    sys.setrecursionlimit(1000000)
    threading.stack_size(2 ** 28)
    thread = threading.Thread(target=main)
    thread.start()
