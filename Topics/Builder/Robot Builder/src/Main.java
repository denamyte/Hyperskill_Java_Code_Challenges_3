import java.util.Scanner;

class Robot {

    private String cpu;
    private int legs;
    private int hands;
    private int eyes;

    Robot(String cpu, int legs, int hands, int eyes) {
        this.cpu = cpu;
        this.legs = legs;
        this.hands = hands;
        this.eyes = eyes;
    }

    public static class RobotBuilder {

        private String cpu;
        private int legs;
        private int hands;
        private int eyes;

        RobotBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        RobotBuilder setLegs(int legs) {
            this.legs = legs;
            return this;
        }

        RobotBuilder setHands(int hands) {
            this.hands = hands;
            return this;
        }

        RobotBuilder setEyes(int eyes) {
            this.eyes = eyes;
            return this;
        }

        Robot build() {
            return new Robot(cpu, legs, hands, eyes);
        }
    }

    @Override
    public String toString() {
        return "CPU : " + cpu + "\n" +
                "Legs : " + legs + "\n" +
                "Hands : " + hands + "\n" +
                "Eyes : " + eyes + "\n";
    }
}

class TestDrive {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Robot robot = new Robot.RobotBuilder()
                .setCpu("Intel Core i5")
                .setLegs(scanner.nextInt())
                .setHands(scanner.nextInt())
                .setEyes(scanner.nextInt())
                .build();

        System.out.println(robot);
        scanner.close();
    }
}