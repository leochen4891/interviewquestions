__author__ = 'Lei Chen'
'''
Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
'''

class Solution(object):
    def ladderLength(self, beginWord, endWord, wordDict):

        length = 2
        width = len(beginWord)
        front = set([beginWord])
        back = set([endWord])
        chars = set('abcdefghijklmnopqrstuvwxyz')
        while front:
            newFront = set()
            for word in front:
                for index in range(width):
                    for c in chars:
                        nw = word[:index] + c + word[index+1:]
                        if nw in back: return length
                        if nw in wordDict: newFront.add(nw)
            front = newFront
            if len(front) > len(back):
                front, back = back, front
            wordDict -= front
            length += 1
        return 0

    def ladderLength1(self, beginWord, endWord, wordDict):
        """
        :type beginWord: str
        :type endWord: str
        :type wordDict: Set[str]
        :rtype: int
        """
        wordDict.add(beginWord)
        wordDict.add(endWord)
        nodes = set()
        beginNode = None
        endNode = None
        for word in wordDict:
            newNode = GraphNode(word)
            if beginWord == word: beginNode = newNode
            if endWord == word: endNode = newNode

            for existingNode in nodes:
                if newNode.getDistance(existingNode) == 1:
                    newNode.addNeighbor(existingNode)
                    existingNode.addNeighbor(newNode)

            nodes.add(newNode)

        # for node in nodes:
        #     print(node)

        # print('beginNode = ', beginNode)
        # print('endNode = ', endNode)

        tovisit = set([beginNode])
        nodeDistance = dict()
        nodeDistance[beginNode] = 1

        while tovisit:
            cur = tovisit.pop()
            # print('cur = ', cur)
            dist = nodeDistance[cur]
            for nei in cur.neighbors:
                # print('nei = ', nei)
                if nei == endNode:
                    # print('found!!')
                    return dist+1
                if not nei in nodeDistance:
                    tovisit.add(nei)
                    nodeDistance[nei] = dist+1

        return 0

class GraphNode :

    def __init__(self, str):
        self.str = str
        self.neighbors = set()

    def addNeighbor(self, neighbor):
        self.neighbors.add(neighbor)

    def isNeighbor(self, neighbor):
        return neighbor in self.neighbors

    def getDistance(self, node):
        dist = 0
        for i in range(len(self.str)):
            if self.str[i] != node.str[i]:
                dist+=1
        return dist

    def __str__(self):
        neilist = ''
        for nei in self.neighbors:
            neilist += ' ' + nei.str
        return self.str + ":" + neilist

s = Solution()

beginWord = 'hit'
endWord = 'cog'
words = set(['hot', 'dot', 'dog', 'lot', 'log'])


print(s.ladderLength(beginWord, endWord, words))


