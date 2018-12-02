t = int(raw_input())

mod = 1000000007

def pow_mod(power):
	if power == 0:
		return 1
	if power == 1:
		return 2

	ans = 1
	if (power & 1) == 1:
		ans = 2

	temp = pow_mod(power >> 1)
	ans = ans * temp * temp
	if ans >= mod:
		ans = ans % mod
	return ans

ncrs = [[0] * 2001 for i in xrange(2001)]

def precompute_ncr():
	ncrs[0][0] = 1
	ncrs[1][0] = 1
	ncrs[1][1] = 1
	for i in xrange(2, 2001):
		ncrs[i][0] = 1
		for j in xrange(1, i + 1):
			ncrs[i][j] = ncrs[i - 1][j] + ncrs[i - 1][j - 1]
			if ncrs[i][j] >= mod:
				ncrs[i][j] %= mod

precompute_ncr()

for i in xrange(t):
	n = int(raw_input())
	l = map(int, raw_input().strip().split(' '))
	l.sort()

	length = len(l)
	count = 0
	# Odd length
	count = pow_mod(n - 1)
	
	last = None
	lastIndex = -1
	for index, num in enumerate(l):
		if num != last:
			last = num
			lastIndex = index
			continue

		for first in xrange(lastIndex, index):
			count += ncrs[first + length - index - 1][min(first, length - index - 1)]
			if count >= mod:
				count %= mod

	print(count)

