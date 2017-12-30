import math


class Point(object):
    def __init__(self, x, y, isRed):
        self.x = x
        self.y = y
        self.isRed = isRed


t = int(input())
points = [0 for _ in range(3000)]
eps = 1e-10
m, n = None, None
pi = math.pi
sortedVertices = [0 for _ in range(6000)]
count = [0, 0]


def mi(a, b):
    return a if a < b else b


def solve(vertex):
    global sortedVertices, count
    count = [0, 0]
    counter = 0
    for j in range(m + n):
        if j == vertex:
            continue
        dx = points[j].x - points[vertex].x
        dy = points[j].y - points[vertex].y
        #angle = math.atan2(dy, dx)
        angle = 0
        sortedVertices[counter] = [angle, j]
        counter += 1
        sortedVertices[counter] = [angle + 2 * pi, j]
        counter += 1

    sortedVerticesSubset = sortedVertices[: counter]
    sortedVerticesSubset.sort(key=lambda val: val[0])
    currentVertexColor = points[vertex].isRed
    k = 0
    currentAns = m + n
    sortedVerticesLength = counter
    for j in range(m + n - 1):
        thisVertex = sortedVerticesSubset[j]
        # Go till you reach the at   least directly opposite vertex
        while k < sortedVerticesLength and sortedVerticesSubset[k][0] - thisVertex[0] <= (pi - eps):
            count[points[sortedVerticesSubset[k][1]].isRed] += 1
            k += 1

        # Now we have reached the directly opposite point (or greater than that)
        thisVertexColor = points[thisVertex[1]].isRed
        # Current vertex is inside the line, and other inside
        count[currentVertexColor] += 1
        currentAns = mi(currentAns, mi(count[0] + n - count[1], count[1] + m - count[0]))

        # Current vertex is inside the line, and other outside
        count[thisVertexColor] -= 1
        currentAns = mi(currentAns, mi(count[0] + n - count[1], count[1] + m - count[0]))

        # Current vertex is outside the line, and other outside
        count[currentVertexColor] -= 1
        currentAns = mi(currentAns, mi(count[0] + n - count[1], count[1] + m - count[0]))

        # Current vertex is outside the line, and other inside
        count[thisVertexColor] += 1
        currentAns = mi(currentAns, mi(count[0] + n - count[1], count[1] + m - count[0]))

        # Move the second one outside for the next iteration
        count[thisVertexColor] -= 1

    return currentAns


for i in range(t):
    m, n = map(int, input().split())
    for j in range(m):
        x, y = map(int, input().split())
        points[j] = Point(x, y, 0)
    for j in range(n):
        x, y = map(int, input().split())
        points[m + j] = Point(x, y, 1)

    ans = m + n
    for j in range(m + n):
        ans = mi(ans, solve(j))
    print(ans)
