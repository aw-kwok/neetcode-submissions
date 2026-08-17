class TimeMap:

    def __init__(self):
        self.name_map = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.name_map[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        ts = self.name_map[key]
        l, r = 0, len(ts) - 1
        res = ""
        while l <= r:
            mid = (l + r) // 2
            if timestamp > ts[r][0]:
                return ts[r][1]
            if ts[mid][0] > timestamp:
                r = mid - 1
            else:
                res = ts[mid][1]
                l = mid + 1
        return res
            