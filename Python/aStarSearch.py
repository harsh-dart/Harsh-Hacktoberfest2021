from heapq import heappush, heappop, heapify
import random
import time

"""
opt = 1 -> h(n) : distance of n from the target calculated with manhattan distance
opt = 2 -> h(n) : number of pieces in the wrong place
opt = 2 -> dfs
g(n) -> quantity of movements
"""

xs = [1, -1, 0, 0]
ys = [0, 0, 1, -1]

def manhattan(x, y, xs, ys):
    return abs(x-xs) + abs(y-ys)

class Puzzle:
    def __init__(self):
        self.cont = 0
        self.puzzle = []
        self.parent = None
        self.cost = 0

    def __eq__(self, other):
        return self.puzzle == other.puzzle

    def __lt__(self, other):
        return self.cost < other.cost

    def __str__(self):
        res = ""
        for i in range(0, 3):
            for j in range(0, 3):
                res += str(self.puzzle[i][j])
        return res

    def createPuzzle(self):
        self.puzzle = []
        choosen = []

        while len(choosen) != 9:
            num = random.randint(1, 9)
            if not num in choosen:
                choosen.append(num)

        aux = []
        for i in range(0, len(choosen)):
            aux.append(choosen[i] if choosen[i] != 9 else -1)
            if (i+1) % 3 == 0:
                self.puzzle.append(aux)
                aux = []

    def printPuzzle(self):
        for i in range(0, 3):
            for j in range(0, 3):
                if j : print(" ", end="")
                print(self.puzzle[i][j], end="")
            print("")

    def printPathPuzzle(self):
        path = []
        actual = self
        while True:
            path.append(actual)
            if actual.parent:
                actual = actual.parent
            else:
                break

        path = path[::-1]
        for i in range(0, len(path)):
            print("")
            path[i].printPuzzle()

    def findBlank(self):
        for i in range(0, 3):
            for j in range(0, 3):
                if self.puzzle[i][j] == -1:
                    return i, j

    def f(self, opt):
        self.cost = self.g() + self.h(opt)

    def g(self):
        return self.cont;

    def h(self, opt):
        sum = 0

        posNums = {
            1 : (0, 0),
            2 : (0, 1),
            3 : (0, 2),
            4 : (1, 0),
            5 : (1, 1),
            6 : (1, 2),
            7 : (2, 0),
            8 : (2, 1)
        }

        for i in range(0, 3):
            for j in range(0, 3):
                if self.puzzle[i][j] != -1:
                    if opt == 1:
                        x, y = posNums[self.puzzle[i][j]]
                        sum += manhattan(i, j, x, y)
                    elif opt == 2:
                        x, y = posNums[self.puzzle[i][j]]
                        if x != i or y != j: sum += 1

        return sum

    def isSolved(self):
        if self == correctPuzzle:
            return True
        else:
            return False

    def isSolvable(self):
        if self.puzzle == []: return False
        inversions = 0
        aux = []
        for i in range(0, 3):
            for j in range(0, 3):
                if self.puzzle[i][j] != -1:
                    aux.append(self.puzzle[i][j])

        for i in range(0, len(aux)):
            for j in range(i+1, len(aux)):
                if(aux[j] > aux[i]):
                    inversions += 1

        if inversions%2 == 0:
            return True
        else:
            return False

    def solvePuzzle(self, opt = 1):
        if opt == 1 or opt == 2:
            self.astar(opt)
        else:
            self.dfs()

    def dfs(self):
        expandedNodes = 0
        visited = {}
        stack = []

        stack.append(self)
        visited[hash(str(self))] = self

        while len(stack) != 0:
            actualPuzzle = stack.pop()

            expandedNodes += 1

            if actualPuzzle.isSolved():
                print("\nThe solution was found with dfs")
                print("Depth: {}".format(actualPuzzle.cont))
                print("Expanded nodes: {}".format(len(visited)))
                print("Generated nodes: {}".format(len(visited)))
                actualPuzzle.printPathPuzzle()
                return

            line, column = actualPuzzle.findBlank()

            for i in range(0, 4):
                newLine = line + xs[i]
                newColumn = column + ys[i]

                if newLine < 0 or newLine >= 3 or newColumn < 0 or newColumn >= 3:
                    continue

                auxPuzzle = Puzzle()
                auxPuzzle.parent = actualPuzzle
                auxPuzzle.cont = actualPuzzle.cont + 1
                auxPuzzle.puzzle = [x[:] for x in actualPuzzle.puzzle]
                auxPuzzle.puzzle[line][column], auxPuzzle.puzzle[newLine][newColumn] = \
                    auxPuzzle.puzzle[newLine][newColumn], auxPuzzle.puzzle[line][column]

                if hash(str(auxPuzzle)) not in visited:
                    visited[hash(str(auxPuzzle))] = auxPuzzle
                    stack.append(auxPuzzle)

    def astar(self, opt):
        generatedNodes = 0
        expandedNodes = 0

        openList = []
        heapify(openList)
        heappush(openList, (0, self))

        closeList = {}
        closeList[hash(str(self))] = self

        while len(openList) != 0:
            (cost, actualPuzzle) = heappop(openList)
            expandedNodes += 1

            #Find the blank space
            line, column = actualPuzzle.findBlank()

            if actualPuzzle.isSolved():
                heuristic = ""
                heuristic = "manhattan distance" if opt == 1 else "number of wrong pieces"
                print("\nThe solution was found with heuristic: {}".format(heuristic))
                print("Depth: {}".format(actualPuzzle.cont))
                print("Expanded nodes: {}".format(expandedNodes))
                print("Generated nodes: {}".format(generatedNodes))
                actualPuzzle.printPathPuzzle()
                return

            for i in range(0, 4):
                newLine = line + xs[i]
                newColumn = column + ys[i]

                if newLine < 0 or newLine >= 3 or newColumn < 0 or newColumn >= 3:
                    continue

                auxPuzzle = Puzzle()
                auxPuzzle.parent = actualPuzzle
                auxPuzzle.cont = actualPuzzle.cont + 1
                auxPuzzle.puzzle = [x[:] for x in actualPuzzle.puzzle]
                auxPuzzle.puzzle[line][column], auxPuzzle.puzzle[newLine][newColumn] = \
                    auxPuzzle.puzzle[newLine][newColumn], auxPuzzle.puzzle[line][column]
                auxPuzzle.f(opt)

                if hash(str(auxPuzzle)) not in closeList:
                    generatedNodes += 1
                    heappush(openList, (auxPuzzle.cost, auxPuzzle))
                    closeList[hash(str(auxPuzzle))] = auxPuzzle

        print("\nThe solution was not found")
        print("Depth: {}".format(actualPuzzle.cont))
        print("Expanded nodes: {}".format(expandedNodes))
        print("Generated nodes: {}".format(generatedNodes))

correctPuzzle = Puzzle()
correctPuzzle.puzzle = [[1, 2, 3], [4, 5, 6], [7, 8, -1]]

if __name__ == "__main__":
    puzzle = Puzzle()

    while True:
        print("\nCreating the puzzle randomly ")
        puzzle.createPuzzle()
        puzzle.printPuzzle()
        if puzzle.isSolvable():
        	print("Is Solvable")
        	puzzle.solvePuzzle(1)
        	break
        else:
            print("Not Solvable")
