n, q = list(map(int, input().strip().split()))
arr = list(map(int, input().strip().split()))

set_bit_count = [[0 for j in range(31)] for i in range(n)]


for i in range(n):
    cur_bit_count = set_bit_count[i]
    num = arr[i]
    for j in range(31):
        if num & (1 << j) > 0:
            cur_bit_count[j] += 1
    if i != n - 1:
        next_bit_count = set_bit_count[i+1]
        for j in range(31):
            next_bit_count[j] = cur_bit_count[j]

for i in range(q):
    l, r = list(map(int, input().strip().split()))
    l -= 1
    r -= 1
    num_count = r - l + 1
    r_bit_count = set_bit_count[r]
    x = 0
    if l == 0:
        l_bit_count = [0 for j in range(31)]
    else:
        l_bit_count = set_bit_count[l - 1]
    for j in range(31):
        bit_count = r_bit_count[j] - l_bit_count[j]
        if bit_count < num_count - bit_count:
            x = (1 << j) + x
    print(x)
