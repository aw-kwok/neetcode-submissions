class Node:
    def __init__(self):
        self.chars = defaultdict(Node)
        self.end = False

class PrefixTree:

    def __init__(self):
        self.root = None

    def insert(self, word: str) -> None:
        if not self.root:
            self.root = Node()
        
        curr = self.root

        for c in word:
            if c not in curr.chars:
                curr.chars[c] = Node()
            curr = curr.chars[c]
        
        curr.end = True


    def search(self, word: str) -> bool:
        if not self.root: return False
        
        curr = self.root
        for c in word:
            if c not in curr.chars:
                return False
            curr = curr.chars[c]
        
        return curr.end
        

    def startsWith(self, prefix: str) -> bool:
        if not self.root: return False

        curr = self.root
        for c in prefix:
            if c not in curr.chars:
                return False
            curr = curr.chars[c]
        
        return True
        
        