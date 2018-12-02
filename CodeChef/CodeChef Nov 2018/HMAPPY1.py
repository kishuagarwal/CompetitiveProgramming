n, q, k = list(map(int, input().strip().split(' ')))

l = list(map(int, input().strip().split(' ')))

queries = input().strip()

pieces = []

count = 0
startingIndex = None

llen = len(l)

for idx, num in enumerate(l):
	if num == 1:
		if count == 0:
			# First 1
			startingIndex = idx
		count += 1
		if idx == llen - 1:
			# Last position 1
			if l[0] == 1 and len(pieces) > 0:
				# are series breaking at last and beginning
				length = idx - startingIndex + 1
				pieces[0] = (length + pieces[0][0], startingIndex)
			else:
				length = idx - startingIndex + 1
				pieces.append((length, startingIndex))
	elif count > 0:
		length = idx - startingIndex
		pieces.append((length, startingIndex))
		count = 0

pieces.sort(reverse=True)
pieces = pieces[:2]

shifts = 0

def getMaxPiece(totalLength, startingIndex, pieceLength):
	global shifts

	# Check if the piece is breaking
	# Get the current starting position of the piece
	startingIndex += shifts
	if startingIndex >= totalLength:
		startingIndex = startingIndex % totalLength

	if startingIndex + pieceLength > totalLength:
		return max(totalLength - startingIndex, pieceLength - (totalLength - startingIndex))
	else:
		return pieceLength

for q in queries:
	if q == '?':
		if len(pieces) == 0:
			print(0)
		elif len(pieces) == 1:
			print(min(k, getMaxPiece(llen, pieces[0][1], pieces[0][0])))
		else:
			# 2 pieces
			firstMax = getMaxPiece(llen, pieces[0][1], pieces[0][0])
			secondMax = getMaxPiece(llen, pieces[1][1], pieces[1][0])
			print(min(k, max(firstMax, secondMax)))
	else:
		shifts += 1