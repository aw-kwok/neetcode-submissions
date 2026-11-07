class TimeMap:
    # key -> timestamp list
    # each list will have (t, v)
    tm = None

    def __init__(self):
        self.tm = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.tm[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        time_list = self.tm[key]
        l, r = 0, len(time_list) - 1
        curr = ""
        while l <= r:
            m = (l + r) // 2
            m_time, m_value = time_list[m]
            if m_time == timestamp:
                return m_value
            elif m_time > timestamp:
                r = m - 1
            else:
                curr = m_value
                l = m + 1
        return curr