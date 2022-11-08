/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huynq.mathutil.main;

import com.huynq.mathutil.core.MathUtil;

/**
 *
 * @author huy
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        //Case #1: n=0 -> getFactotial(0) -> expected : 1
        System.out.println("Result(0): " + MathUtil.getFactotial(0) + "| expected: 1");
        //Case #2: n=1 -> getFactotial(1) -> expected : 1 
        System.out.println("Result(1): " + MathUtil.getFactotial(1) + "| expected: 1");
        //Case #3: n=5 -> getFactotial(5) -> expected : 120
        System.out.println("Result(5): " + MathUtil.getFactotial(5) + "| expected: 120");
        java.util.concurrent.TimeUnit.SECONDS.sleep(1);
            //Case #4: n=-5 -> getFactotial(-5) -> expected : exception
            System.out.print("Result(-5): | expected: ");
            MathUtil.getFactotial(-5);

        
        java.util.concurrent.TimeUnit.SECONDS.sleep(1);
        try {
            //Case #5: n=21 -> getFactotial(21) -> expected : exception
            System.out.print("Result(21): | expected: ");
            MathUtil.getFactotial(21);

        } catch (IllegalArgumentException ex) {
            System.err.println("Invalid!!! N must be > 0 and < 20");
        }
        
    }
    //VIỆC CHẠY BỘ TEST/ XEM TỪNG DÒNG KQ ĐƯỢC IN RA. ĐỂ SUY LUẬN
    //SO SÁNH, ĐỂ KẾT LUẬN -> VỤ NÀY MẤT SỨC
    // VÌ PHẢU DÙNG MẮT + SUY LUẬN -> MANUAL TEST, RẤT CẢM GIÁC THỬ CÔNG
    
    //KHÔNG HIỆU QUẢ NẾU CODE DC CHỈNH SỬA, TA LẠI PHẢI LUẬN LẠI KẾT
    //QUẢ BẰNG THỦ CÔNG: MẮT QUÉT QUA CÁC KQ, TỰ SO SÁNH, TỰ KL
    
    //KỸ THUẬT THỨ 2 XUẤT HIỆN: TEST AUTOMATION
    //TỨC LÀ VẪN CHẠY BỘ TEST NHƯ MANUAL, NHƯNG KH CẦN MẮT NHÌN TỪNG KQ
    // ĐỂ SOO SÁNH / ĐỂ KL, MÁY DƯ SỨC SO SÁNH
    // TA CHỈ NHÌN 2 THỨ DUY NHẤT SAU QUA TEST CASES
    // ĐÚNG : XANH - SAI : ĐỞ
    

}
