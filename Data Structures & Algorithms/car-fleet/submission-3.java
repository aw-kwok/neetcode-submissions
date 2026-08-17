class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < position.length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        for(int[] car : cars) {
            if (stack.isEmpty()) {
                stack.push(car);
            }
            else {
                int[] carFront = stack.peek();
                double timeFront = (double) (target - carFront[0]) / carFront[1];
                double timeBehind = (double) (target - car[0]) / car[1];
                System.out.println(timeFront + " " + timeBehind);
                if (timeFront < timeBehind) {
                    stack.push(car);
                }
            }
        }
        return stack.size();
    }
}
