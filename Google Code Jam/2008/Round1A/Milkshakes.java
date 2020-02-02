package Round1A;

import java.util.*;

/**
 * @author kishu.agarwal
 */
public class Milkshakes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i += 1) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Map<Integer, Integer>> customerLikes = new ArrayList<>();
            for (int j = 0; j < m; j += 1) {
                customerLikes.add(new HashMap<>());
                int numLikes = in.nextInt();
                for (int k = 0; k < numLikes; k += 1) {
                    int type = in.nextInt() - 1;
                    int isMalted = in.nextInt();
                    customerLikes.get(j).put(type, isMalted);
                }
            }
            int[] typesRequired = new int[n];
            boolean isPossible = true;
            for (int k = 0; k < m; k += 1) {
                for (int j = 0; j < m; j += 1) {
                    // Check if the customer is satisfied
                    Map<Integer, Integer> thisCustomerLikes = customerLikes.get(j);
                    // Whether any of the customer flavour preference is possible, with the current types
                    boolean anyTypeSatisfied = false;
                    // Which is the malted type for the customer, if any
                    int maltedType = -1;

                    for (Integer type: thisCustomerLikes.keySet()) {
                        if (typesRequired[type] == thisCustomerLikes.get(type)) {
                            anyTypeSatisfied = true;
                            break;
                        }
                        if (thisCustomerLikes.get(type) == 1) {
                            maltedType = type;
                        }
                    }
                    if (!anyTypeSatisfied) {
                        if (maltedType != -1) {
                            // We are forced to make this malted
                            typesRequired[maltedType] = 1;
                        } else {
                            // If the customer only likes non-malted flavours, then the solution is not possible
                            isPossible = false;
                            break;
                        }
                    }
                }
                if (!isPossible) {
                    break;
                }
            }
            if (isPossible) {
                System.out.format("Case #%d: ", i);
                for (int j = 0; j < n; j += 1) {
                    System.out.print(typesRequired[j]);
                    System.out.print(" ");
                }

                System.out.println();
            } else {
                System.out.format("Case #%d: IMPOSSIBLE\n", i);
            }
        }
    }
}
