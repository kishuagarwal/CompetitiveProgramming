import sys
sys.setrecursionlimit(3000000)

def find_temp(node):
    total_temps[node] = temps[node]
    for child in tree[node]:
        find_temp(child)
        total_temps[node] += total_temps[child] 

    if total_temps[node] == x:
        x_list[node] = True
    if total_temps[node] == 2*x:
        twox_list[node] = True

def find(node):
    two_x_found= 0
    where_found = []
    for child in tree[node]:
        x_present, where = find(child)
        if x_present:
            two_x_found += 1
            where_found.append(where)
        if two_x_found == 2:
            print where_found[0], where_found[1]
            exit(0)
        if twox_list[node] and x_present:
            print node, where
            exit(0)
    if x_list[node]:
        two_x_found += 1
        where_found.append(node)
    if two_x_found > 0:
        return True, where_found[0]
    return False, []

n = int(raw_input())
tree = [[] for i in xrange(n+1)]
temps = [0 for i in xrange(n+1)]
total_temps = [0 for i in xrange(n+1)]
total_temp = 0
for i in xrange(n):
    a, t = map(int, raw_input().split())
    if a == 0:
        root = i+1
    if a != 0:
        tree[a].append(i+1)
    temps[i+1] = t
    total_temp += t

x = total_temp / 3
x_list = [False for i in xrange(n+1)]
twox_list = [False for i in xrange(n+1)]
if total_temp % 3 == 0:
    find_temp(root)
    find(root)
print -1

