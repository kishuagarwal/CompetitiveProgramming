n = int(input())
l = list(map(int, input().split(' ')))

max_ones = 0
for i in range(n):
    for j in range(i, n):
        current_ones = l[:i].count(1) + l[i:j+1].count(0) + l[j+1:].count(1)
        max_ones = max(max_ones, current_ones)

print(max_ones)


