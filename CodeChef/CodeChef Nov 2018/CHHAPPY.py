t = int(input())

for i in range(t):
	n = int(input())

	l = list(map(int, input().strip().split(' ')))
	
	# All numbers we have
	a = set(l)

	# The numbers we have seen till now and their idx is present in a
	seen = set()

	found = False

	for idx, j in enumerate(l):
		idx += 1
		# If j has already been seen before, and the current idx is our list, then we have found a match
		if j in seen and idx in a:
			found = True
			break

		if idx in a:
			seen.add(j)

	if found:
		print('Truly Happy')
	else:
		print('Poor Chef')


