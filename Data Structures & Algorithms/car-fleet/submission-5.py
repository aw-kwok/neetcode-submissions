class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        sorted_cars = sorted([(position[i], speed[i]) for i in range(len(position))])[::-1]

        stack = []
        for c in sorted_cars:
            if not stack:
                stack.append(c)
                continue
            
            front_pos, front_speed = stack[-1]
            pos, speed = c
            
            # pos + speed * t = target
            # t = (target - pos) / speed
            front_t = (target - front_pos) / front_speed
            t = (target - pos) / speed

            if t > front_t:
                stack.append(c)
        
        return len(stack)