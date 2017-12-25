package com.example.algorithm;

public class DynamicProgrammingTest {
    public DynamicProgrammingTest() {
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; ++i) {
            System.out.println(i + " : " + getMaxProduct(i));
        }

    }

    private static int getMaxProduct(int ropeLength) {
        if (ropeLength <= 0) {
            return 0;
        } else if (ropeLength <= 2) {
            return 1;
        } else if (ropeLength == 3) {
            return 2;
        } else {
            int[] products = new int[ropeLength + 1];
            products[1] = 1;
            products[2] = 2;
            products[3] = 3;

            for (int i = 4; i < ropeLength + 1; ++i) {
                int maxProduct = 0;

                for (int j = 1; j <= i / 2; ++j) {
                    int currentProduct = products[j] * products[i - j];
                    System.out.println("j:" + j + ",i-j:" + (i - j));
                    if (currentProduct > maxProduct) {
                        maxProduct = currentProduct;
                    }
                }

                products[i] = maxProduct;
            }

            return products[ropeLength];
        }
    }
}
