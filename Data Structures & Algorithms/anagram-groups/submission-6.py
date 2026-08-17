class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)
        for s in strs:
            key = [0] * 26
            for _, char in enumerate(s):
                key[ord(char) - ord('a')] += 1
            key_string = tuple(key)
            groups[key_string].append(s)
        return list(groups.values())