import math
from collections import defaultdict

n , q = list(map(int, input().strip().split(' ')))

l = list(map(int, input().strip().split(' ')))
blocks_xor = []
prefix_xor = []
block_size = int(math.sqrt(n))
blocks = int(math.ceil(n / block_size))

for i in range(blocks):
    block_start = i * block_size
    block_end = min(block_start + block_size, n)
    xor_map = defaultdict(lambda: 0)
    prev = 0
    block_prefix_xor = []
    for j in range(block_start, block_end):
        prev ^= l[j]
        xor_map[prev] += 1
        block_prefix_xor.append(prev)
    blocks_xor.append(xor_map)
    prefix_xor.append(block_prefix_xor)

for i in range(q):
    typ, index, k = list(map(int, input().strip().split(' ')))
    index -= 1
    block = index // block_size
    block_start = block * block_size
    block_end = min(block_start + block_size, n)

    if typ == 1:
        xor_map = defaultdict(lambda: 0)
        prev = 0
        l[index] = k
        block_prefix_xor = []
        for j in range(block_start, block_end):
            prev ^= l[j]
            xor_map[prev] += 1
            block_prefix_xor.append(prev)

        blocks_xor[block] = xor_map
        prefix_xor[block] = block_prefix_xor
    else:
        prev = 0
        count = 0
        for j in range(block):
            xor_map = blocks_xor[j]
            if prev ^ k in xor_map:
                count += xor_map[prev ^ k]
            prev ^= prefix_xor[j][-1]
        block_prefix_xor = prefix_xor[block]
        for j in range(index - block_start + 1):
            if prev ^ block_prefix_xor[j] == k:
                count += 1
        print(count)
