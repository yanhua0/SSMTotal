package org.total.util;

import java.math.BigDecimal;

/**
 * 防止double运算精度丢失
 */
public class Cal {
    /**
     *      * 加法运算
     *      * @param m1
     *      * @param m2
     *      * @return
     *     
     */
    public static double add(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.add(p2).doubleValue();
    }

    /**
     *      * 减法运算
     *      * @param m1
     *      * @param m2
     *      * @return
     *     
     */
    public static double sub(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.subtract(p2).doubleValue();
    }

    /**
     *      * 乘法运算
     *      * @param m1
     *      * @param m2
     *      * @return
     *     
     */
    public static double mul(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.multiply(p2).doubleValue();
    }


    /**
     *     
     *       *  除法运算
     *       *   @param   m1  
     *       *   @param   m2        
     *       *   @param   scale      
     *       *   @return     
     *      
     */
    public static double div(double m1, double m2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("Parameter error");
        }
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.divide(p2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        int i = 1;
        int j = 3;
        double c = i * (1.0) / j;
        System.out.println(c);
    }
}
