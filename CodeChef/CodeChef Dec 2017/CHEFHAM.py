t = int(input())

for i in range(t):
    n = int(input())
    a = list(map(int, input().strip().split(' ')))
    b = a[:]
    distance = 0
    for j in range(n):
        if a[j] != b[j]:
            continue
        for k in range(n):
            if a[j] != b[k] and a[k] != b[j]:
                b[j], b[k] = b[k], b[j]
                break

    for j in range(n):
        if a[j] != b[j]:
            distance += 1
    print(distance)
    print(' '.join(map(str, b)))
