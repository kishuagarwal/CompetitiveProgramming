t = int(input())
for i in range(t):
    x, y, z, a, b, c = list(map(int, input().strip().split(' ')))
    ans = 10 ** 18

    x, y, z = sorted([x, y, z])
    # only a moves
    ans = min(ans, (x + y + z) * a)

    # only b moves
    if (x + y + z) % 2 == 0 and (x + y) >= z:
        ans = min(ans, ((x + y + z) // 2) * b)

    # only c moves
    if x == y and y == z:
        ans = min(ans, x * c)

    # only a and b moves
    # a > b / 2
    if (x + y) < z:
        ans = min(ans, (x + y) * b + (z - x - y) * a)
    elif (x + y + z) % 2 == 1:
        ans = min(ans, a + ((x + y + z) // 2) * b)

    # only a and c moves
    # a > c/3
    ans = min(ans, x * c + (y + z - 2 * x) * a)

    # only b and c moves
    # b/2 < c/3
    if ((x + y + z) % 2 != 0) and (x + y) > z:
        ans = min(ans, c + ((x + y + z - 3) // 2) * b)


    # all a, b and c moves
    # c/3 < b/2 < a
    common = min(x, z - y)
    if (a + c) <= (2 * b):
        ans = min(ans, common * (a + c) + (x - common) * c + (z - y - common) * a + (y - x) * b)
    else:
        ans = min(ans, common * (2 * b) + (x - common) * c + (z - y - common) * a + (y - x) * b)

    print(int(ans))
