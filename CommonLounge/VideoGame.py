n, h = map(int, raw_input().strip().split(' '))

count = map(int, raw_input().strip().split(' '))

ops = map(int, raw_input().strip().split(' '))

cur_pos = 0
has_box = False

for i in ops:
    if i == 0:
        break
    if i == 1:
        cur_pos = max(cur_pos - 1, 0)
    if i == 2:
        cur_pos = min(cur_pos + 1, n-1)
    if i == 3:
        if not has_box and count[cur_pos] > 0:
            has_box = True
            count[cur_pos] -= 1
    if i == 4:
        if has_box and count[cur_pos] < h:
            has_box = False
            count[cur_pos] += 1


for i in count:
    print i,