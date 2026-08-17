class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = [(position[i], speed[i]) for i in range(len(position))]
        sorted_cars = sorted(cars, reverse = True)

        stack = []
        for car in sorted_cars:
            if not stack:
                stack.append(car)
            else:
                front_pos, front_speed = stack[-1]
                front_time = (target - front_pos) / front_speed

                curr_pos, curr_speed = car
                curr_time = (target - curr_pos) / curr_speed

                if curr_time > front_time:
                    stack.append(car)
        
        return len(stack)
