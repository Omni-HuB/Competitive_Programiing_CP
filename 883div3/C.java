// import java.util.*;

// public class C {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt();

//         while (t-- > 0) {
//             int n = scanner.nextInt();
//             int m = scanner.nextInt();
//             int h = scanner.nextInt();

//             List<Participant> participants = new ArrayList<>();

//             for (int i = 0; i < n; i++) {
//                 int[] times = new int[m];
//                 for (int j = 0; j < m; j++) {
//                     times[j] = scanner.nextInt();
//                 }
//                 participants.add(new Participant(times));
//             }

//             int rudolfPosition = calculateRudolfPosition(participants, m, h);
//             System.out.println(rudolfPosition);
//         }
//     }

//     static int calculateRudolfPosition(List<Participant> participants, int m, int h) {
//         int rudolfTotalPenalty = participants.get(0).totalPenalty;
//         int position = 1;

//         for (Participant participant : participants) {
//             if (participant.totalPenalty < rudolfTotalPenalty) {
//                 position++;
//             } else if (participant.totalPenalty == rudolfTotalPenalty) {
//                 int[] times = participant.times.clone();
//                 Arrays.sort(times);

//                 int problemsSolved = 0;
//                 int totalSolvingTime = 0;
//                 for (int i = 0; i < m; i++) {
//                     totalSolvingTime += times[i];
//                     if (totalSolvingTime <= h) {
//                         problemsSolved++;
//                     } else {
//                         break;
//                     }
//                 }

//                 if (problemsSolved > 0) {
//                     int rudolfProblemsSolved = 0;
//                     int rudolfTotalSolvingTime = 0;
//                     int[] rudolfTimes = participants.get(0).times.clone();
//                     Arrays.sort(rudolfTimes);

//                     for (int i = 0; i < m; i++) {
//                         rudolfTotalSolvingTime += rudolfTimes[i];
//                         if (rudolfTotalSolvingTime <= h) {
//                             rudolfProblemsSolved++;
//                         } else {
//                             break;
//                         }
//                     }

//                     if (problemsSolved > rudolfProblemsSolved) {
//                         position++;
//                     } else if (problemsSolved == rudolfProblemsSolved && participant.compareTo(participants.get(0)) != 0) {
//                         position++;
//                     }
//                 }
//             }
//         }

//         return position;
//     }

//     static class Participant implements Comparable<Participant> {
//         int[] times;
//         int totalPenalty;

//         public Participant(int[] times) {
//             this.times = times;
//             this.totalPenalty = calculateTotalPenalty(times);
//         }

//         private int calculateTotalPenalty(int[] times) {
//             int total = 0;
//             for (int time : times) {
//                 total += time;
//             }
//             return total;
//         }

//         @Override
//         public int compareTo(Participant other) {
//             if (this.totalPenalty == other.totalPenalty) {
//                 return 0;
//             } else if (this.totalPenalty < other.totalPenalty) {
//                 return -1;
//             } else {
//                 return 1;
//             }
//         }
//     }
// }

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int h = scanner.nextInt();

            List<Participant> participants = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int[] times = new int[m];
                for (int j = 0; j < m; j++) {
                    times[j] = scanner.nextInt();
                }
                participants.add(new Participant(times));
            }

            int rudolfPosition = calculateRudolfPosition(participants, m, h);
            System.out.println(rudolfPosition);
        }
    }

    static int calculateRudolfPosition(List<Participant> participants, int m, int h) {
        int rudolfTotalPenalty = participants.get(0).totalPenalty;
        int position = 1;

        for (Participant participant : participants) {
            if (participant.totalPenalty < rudolfTotalPenalty) {
                position++;
            } else if (participant.totalPenalty == rudolfTotalPenalty) {
                int[] times = participant.times.clone();
                Arrays.sort(times);

                int problemsSolved = 0;
                int totalSolvingTime = 0;
                for (int i = 0; i < m; i++) {
                    totalSolvingTime += times[i];
                    if (totalSolvingTime <= h) {
                        problemsSolved++;
                    } else {
                        break;
                    }
                }

                if (problemsSolved > 0) {
                    int rudolfProblemsSolved = 0;
                    int rudolfTotalSolvingTime = 0;
                    int[] rudolfTimes = participants.get(0).times.clone();
                    Arrays.sort(rudolfTimes);

                    for (int i = 0; i < m; i++) {
                        rudolfTotalSolvingTime += rudolfTimes[i];
                        if (rudolfTotalSolvingTime <= h) {
                            rudolfProblemsSolved++;
                        } else {
                            break;
                        }
                    }

                    if (problemsSolved > rudolfProblemsSolved) {
                        position++;
                    } else if (problemsSolved == rudolfProblemsSolved && participant.compareTo(participants.get(0)) != 0) {
                        position++;
                    }
                }
            }
        }

        return position;
    }

    static class Participant implements Comparable<Participant> {
        int[] times;
        int totalPenalty;

        public Participant(int[] times) {
            this.times = times;
            this.totalPenalty = calculateTotalPenalty(times);
        }

        private int calculateTotalPenalty(int[] times) {
            int total = 0;
            for (int i = 0; i < times.length; i++) {
                total += times[i];
            }
            return total;
        }

        @Override
        public int compareTo(Participant other) {
            if (this.totalPenalty == other.totalPenalty) {
                return 0;
            } else if (this.totalPenalty < other.totalPenalty) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
