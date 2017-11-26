t = int(input())

for i in range(t):
    n, r = list(map(int, input().strip().split(' ')))
    ratings = list(map(int, input().strip().split(' ')))
    cur_l, cur_r = 1, 10 ** 9
    possible = True
    for rat in ratings:
        if rat < cur_l or rat > cur_r:
            possible = False
            break
        if rat > r:
            cur_r = rat - 1
        else:
            cur_l = rat + 1
    if possible:
        print('YES')
    else:
        print('NO')
