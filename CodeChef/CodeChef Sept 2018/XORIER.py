from collections import defaultdict
t = int(input())

for i in range(t):
	n = int(input())
	nums = list(map(int, input().strip().split()))
	odds = 0
	evens = 0
	seen = set()
	num_count = defaultdict(int)

	# All the pairs of odd numbers and even numbers excluding those who
	# yield xor of 0 or 2

	# Xor is 0 when the number is repeated twice
	# Xor is 1 when bot the numbers have different bits at position 1


	ans = 0
	for num in nums:
		if num & 1 == 0:
			ans += evens
			evens += 1
		else:
			ans += odds
			odds += 1

		ans -= (num_count[num] + num_count[num ^ 2])
		
		num_count[num] += 1
	print(ans)