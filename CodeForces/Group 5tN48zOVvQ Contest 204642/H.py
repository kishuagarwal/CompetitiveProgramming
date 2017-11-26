n = int(input())
first = list(map(int, input().split(' ')))
second = list(map(int, input().split(' ')))


def _abs(a, b):
    return min(abs(a-b), min(a, b) + n - max(a, b))


def is_valid(a, b, c):
    if _abs(a, first[0]) <= 2 and _abs(b, first[1]) <= 2 and _abs(c, first[2]) <= 2:
        return True
    if _abs(a, second[0]) <= 2 and _abs(b, second[1]) <= 2 and _abs(c, second[2]) <= 2:
        return True
    return False


count = 0

for i in range(1, n+1):
    for j in range(1, n+1):
        for k in range(1, n+1):
            if is_valid(i, j, k):
                count += 1

print(count)
