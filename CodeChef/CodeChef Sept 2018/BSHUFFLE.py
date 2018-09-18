from collections import defaultdict
import random
n = int(input())


# counts = defaultdict(int)
# hash_to_nums = {}

# found = False
# for i in range(1000000):
# 	nums = list(range(1, n+1))
# 	moves = []
# 	for i in range(n):
# 		random_pos = random.randint(0, n-1)
# 		nums[i], nums[random_pos] = nums[random_pos], nums[i]
# 		moves.append(tuple(nums))

# 	hashed = hash(tuple(nums))
# 	if nums == [2, 3, 1, 5, 6, 4] and not found:
# 		found = True
# 		print("MOves")
# 		for x in moves:
# 			print(x)
# 	counts[hashed] += 1
# 	hash_to_nums[hashed] = nums

# counts_list = [(value, hash_to_nums[key]) for key, value in counts.items()]
# counts_list.sort(reverse=True)

# for l in counts_list[:20]:
# 	print(l)

# for l in counts_list[-20:]:
# 	print(l)

def print_ans():
	global n
	import math
	half = int(math.ceil(n / 2))
	for i in range(2, half + 1):
		print(i, end=" ")
	print(1, end=" ")
	for i in range(half + 2, n + 1):
		print(i, end=" ")
	if n > 1:
		print(half + 1)
	else:
		print()
	print(n, end=" ")
	for i in range(1, n):
		print(i, end=" ")
	print()

print_ans()