import java.util.Scanner;

/*
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * TODO: Documentation
 * Usage:
 * Enter eight numbers (integers or with decimal point) separated by spaces. 
 * These are used to create objects in a 2D coordinate system.
 * The first three numbers are used to define the first circle. 
 * The first number is the x coordinate, the second number is the y, 
 * and the third is the radius of the circle. The 4th, 5th and 6th numbers
 * are to define another circle, the x coordinate, the y coordinate and the radius, in that order.
 * The last two numbers represent the x and y coordinates of a point.
 * The program's job is to tell which circles the point touches or is in the area of.
 * END TODO
 * 
 * @author Matyas Szabolcs
 * @ID 1835521
 * @author Quinn Caris
 * @ID 20222730
 * 
 */

class HitDetection {

    public void run() {
        // TODO: Hit detection
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");

        scanner.close();

        float[] circle1 = new float[] { Float.valueOf(numbers[0]), Float.valueOf(numbers[1]),
                Float.valueOf(numbers[2]) };
        float[] circle2 = new float[] { Float.valueOf(numbers[3]), Float.valueOf(numbers[4]),
                Float.valueOf(numbers[5]) };
        float[] point = new float[] { Float.valueOf(numbers[6]), Float.valueOf(numbers[7]) };

        boolean hit1 = Math.pow(circle1[0] - point[0], 2) + Math.pow(circle1[1] - point[1], 2) <= Math.pow(circle1[2],
                2);
        boolean hit2 = Math.pow(circle2[0] - point[0], 2) + Math.pow(circle2[1] - point[1], 2) <= Math.pow(circle2[2],
                2);

        if (circle1[2] < 0 || circle2[2] < 0) {
            System.out.println("Input error");
            return;
        }
        if (hit1 && hit2) {
            System.out.println("The point hits both circles");
        } else if (hit1) {
            System.out.println("The point hits the first circle");
        } else if (hit2) {
            System.out.println("The point hits the second circle");
        } else {
            System.out.println("The point does not hit either circle");
        }
        // END TODO
    }

    public static void main(String[] args) {
        new HitDetection().run();
    }
}