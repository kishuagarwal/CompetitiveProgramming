t = int(input())

for i in range(t):
	n, m, x, y = list(map(int, input().strip().split()))
	power = 1
	knowledge = 1
	possible = False

	# Use shareChat
	if (n - 2) >= 0 and (n - 2) % x == 0 and (m - 2) >= 0 and (m - 2) % y == 0:
		possible = True
	elif (n - 1) >= 0 and (n - 1) % x == 0 and (m - 1) >= 0 and (m - 1) % y == 0:
		# Don't use it
		possible = True
		
	if possible:
		print("Chefirnemo")
	else:
		print("Pofik")
