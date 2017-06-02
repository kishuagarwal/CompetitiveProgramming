t = int(raw_input())

a = []
n = None
m = None
new_a = []
max_element = 0
max_count = 0

def iterate():
    global max_count
    dr = [0,-1,-1,-1,0,1,1,1]
    dc = [-1,-1,0,1,1,1,0,-1]
    for r in xrange(n):
        for c in xrange(m):
            temp_max_element = a[r][c]

            for k in xrange(8):
                cur_r = r + dr[k]
                cur_y = c + dc[k]
                if cur_r >= 0 and cur_r < n and cur_y >=0 and cur_y < m:
                    if a[cur_r][cur_y] > temp_max_element:
                        temp_max_element = a[cur_r][cur_y]
            if a[r][c] != max_element and temp_max_element == max_element:
                max_count += 1
            new_a[r][c] = temp_max_element





for i in xrange(t):
    n,m = map(int, raw_input().strip().split(' '))
    a = []
    max_element = 0
    max_count = 0
    for j in xrange(n):
        b = map(int, raw_input().strip().split(' '))
        a.append(b)
        max_element = max(max_element, max(b))
    
    for j in xrange(n):
        for k in xrange(m):
            if a[j][k] == max_element:
                max_count += 1

    new_a = []
    for j in xrange(n):
        new_a.append([0 for _ in xrange(m)])

    count = 0
    while max_count != (n * m):
        count += 1
        iterate()
        a,new_a = new_a,a

    print count

