t = int(input().strip())


def findDiamonds(num):
    even = 0
    odd = 0
    while num > 0:
        rem = num % 10
        if rem % 2 == 0:
            even += rem
        else:
            odd += rem
        num //= 10
    return abs(even - odd)


precomputed = [0 for i in range((10 ** 6) + 20)]
prev_row = [0 for i in range((2 * (10 ** 6) + 20))]
prev_row[0] = 2
prev_row_count = 2
first = 0
last = 0
precomputed[1] = 2
for i in range(2, 1000001):
    prev_row_count -= prev_row[first]
    first += 1
    last += 1
    prev_row[last] = findDiamonds(2 * i - 1)
    last += 1
    prev_row[last] = findDiamonds(2 * i)
    prev_row_count += prev_row[last] + prev_row[last - 1]
    precomputed[i] = precomputed[i-1] + 2 * prev_row_count - prev_row[last]
for i in range(t):
    n = int(input().strip())
    print(precomputed[n])
