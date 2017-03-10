n = int(raw_input())
l = map(int, raw_input().strip().split(' '))
count = 0
table = set()
ans = 0
for i in l:
    if i in table:
        count -= 1
        table.remove(i)
    else:
        count += 1
        table.add(i)
        ans = max(ans, count)

print ans