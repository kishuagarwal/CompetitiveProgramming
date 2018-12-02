l = list(map(int, input().strip().split(' ')))

for n in l[1:]:
	pieces = pow(2, n)
	left = 0
	right = pieces

	for time in range(n):
		middle = (left + right) // 2
		if time % 2 == 0:
			right = middle
		else:
			left = middle

	print(str(middle) + " " + str(pieces), end=" ")