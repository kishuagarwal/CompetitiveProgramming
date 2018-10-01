t = int(input())

for i in range(t):
    n = int(input())
    colors = list(map(int, input().strip().split()))
    colors.sort()
    duplicates = 0
    for j in range(1, n):
        if colors[j] == colors[j-1]:
            duplicates += 1
    print(duplicates)
