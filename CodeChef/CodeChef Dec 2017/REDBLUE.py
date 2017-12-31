import math


class Point(object):
    def __init__(self, x, y, isRed):
        self.x = x
        self.y = y
        self.isRed = isRed


t = int(input())
points = []
eps = 1e-10
m, n = None, None
pi = math.pi


atan2 = math.atan2


def solve(vertex):
    count = [0, 0]
    sortedVertices = []
    sortedVerticesAppend = sortedVertices.append
    for j in range(m + n):
        if j == vertex:
            continue
        dx = points[j].x - points[vertex].x
        dy = points[j].y - points[vertex].y
        angle = atan2(dy, dx)
        sortedVerticesAppend((angle, j))
        sortedVerticesAppend((angle + 2 * pi, j))

    sortedVertices.sort()
    currentVertexColor = points[vertex].isRed
    k = 0
    currentAns = m + n
    sortedVerticesLength = len(sortedVertices)
    for j in range(m + n - 1):
        thisVertex = sortedVertices[j]
        # Go till you reach the at   least directly opposite vertex
        while k < sortedVerticesLength and sortedVertices[k][0] - thisVertex[0] <= (pi - eps):
            count[points[sortedVertices[k][1]].isRed] += 1
            k += 1

        # Now we have reached the directly opposite point (or greater than that)
        thisVertexColor = points[thisVertex[1]].isRed
        # Current vertex is inside the line, and other inside
        count[currentVertexColor] += 1
        currentAns = min(currentAns, min(count[0] + n - count[1], count[1] + m - count[0]))

        # Current vertex is inside the line, and other outside
        count[thisVertexColor] -= 1
        currentAns = min(currentAns, min(count[0] + n - count[1], count[1] + m - count[0]))

        # Current vertex is outside the line, and other outside
        count[currentVertexColor] -= 1
        currentAns = min(currentAns, min(count[0] + n - count[1], count[1] + m - count[0]))

        # Current vertex is outside the line, and other inside
        count[thisVertexColor] += 1
        currentAns = min(currentAns, min(count[0] + n - count[1], count[1] + m - count[0]))

        # Move the second one outside for the next iteration
        count[thisVertexColor] -= 1

    return currentAns


pointsAppend = points.append
for _ in range(t):
    m, n = map(int, input().split())
    points.clear()
    for j in range(m):
        x, y = map(int, input().split())
        pointsAppend(Point(x, y, 0))
    for j in range(n):
        x, y = map(int, input().split())
        pointsAppend(Point(x, y, 1))

    ans = m + n
    for j in range(m + n):
        ans = min(ans, solve(j))
    print(ans)
