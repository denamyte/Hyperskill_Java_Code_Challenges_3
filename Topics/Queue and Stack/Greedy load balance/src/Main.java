import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Balancer balancer = new Balancer();

        int taskCount = scanner.nextInt();
        scanner.nextLine();
        while (taskCount-- > 0) {
            balancer.addTask(parseInput(scanner.nextLine()));
        }
        System.out.println(balancer);
    }

    private static Task parseInput(String raw) {
        final String[] rawAr = raw.split(" ");
        return new Task(Integer.parseInt(rawAr[0]), Integer.parseInt(rawAr[1]));
    }

    static class Balancer {

        private QueueWrapper[] queues = {new QueueWrapper(), new QueueWrapper()};
        private QueueWrapper lessLoadedQueue = queues[0];

        public void addTask(Task task) {
            lessLoadedQueue.add(task);
            assignLessLoadedQueue();
        }

        private void assignLessLoadedQueue() {
            QueueWrapper tempQueue = queues[0];
            for (int i = 1; i < queues.length; i++) {
                if (queues[i].getLoad() < tempQueue.getLoad()) {
                    tempQueue = queues[i];
                }
            }
            lessLoadedQueue = tempQueue;
        }

        @Override
        public String toString() {
            return Arrays.stream(queues).map(QueueWrapper::toString).collect(Collectors.joining("\n"));
        }
    }

    static class Task {
        private final int id;
        private final int load;

        public Task(int id, int load) {
            this.id = id;
            this.load = load;
        }

        public int getLoad() {
            return load;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }

    static class QueueWrapper {
        private final Queue<Task> queue = new LinkedList<>();
        private int load;

        public void add(Task task) {
            load += task.getLoad();
            queue.offer(task);
        }

        public int getLoad() {
            return load;
        }

        @Override
        public String toString() {
            return queue.stream().map(Task::toString).collect(Collectors.joining(" "));
        }
    }

}