class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # key -> list
        str_map = {}
        
        for s in strs:
            key = [0] * 26
            for c in s:
                key[ord(c) - ord('a')] += 1
            key_tuple = tuple(key)
            if key_tuple not in str_map:
                str_map[key_tuple] = []
            str_map[key_tuple].append(s)
        return list(str_map.values())