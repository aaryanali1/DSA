public class Task1 {
    int[][] orders = {{8, 12, 5, 15}, {7, 4}, {10, 6, 13}, {}};
    
    public void summarizeDays() {
        for(int i = 0; i < orders.length; i++) {
            int total = 0, busiest_hour = 0;

            System.out.println("===== DAY " + (i + 1) + " =====");
            if(orders[i].length == 0) {
                System.out.println("Closed.");
                continue;
            }
            
            for(int j = 0; j < orders[i].length; j++) {
                total += orders[i][j];

                if(orders[i][j] > orders[i][busiest_hour]) {
                    busiest_hour = j;
                }
            }
            
            System.out.println("Total Orders: " + total);
            System.out.println("Busiest Hour: " + (busiest_hour + 1));
        }
    }

    public int firstDayMeetingTarget(int target) {
        for(int i = 0; i < orders.length; i++) {
            int total = 0; 

            for(int j = 0; j < orders[i].length; j++) {
                total += orders[i][j];
            }

            if(total >= target) {
                return i + 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Task1 t = new Task1();
        t.summarizeDays();
        System.out.println(t.firstDayMeetingTarget(25));
        System.out.println(t.firstDayMeetingTarget(100));
    }
}