
package com.huynq.mathutil.core;

/**
 *
 * @author huy
 */
public class MathUtil {
    //trong class này ta sẽ viết các hàm tiện ích/ dùng chung
    // cho nhiều class khác. Cái gì mà dùng chung cho class khác
    // thì thường thiết kế là STATIC
    
    //hàm tính n! = 1.2.3...n
    //QUY ƯỚC: không có giai thừa âm
    //          0! = 1! = 1
    //          chỉ tính n từ 0...20, vì
    //          21! vượt 18 con số, out range long
    public static long getFactotial(int n) {
        if(n < 0 || n > 20) {
            throw new IllegalArgumentException("Invalid!!! N must be > 0 and < 20");
        }
        
        if(n == 0 || n == 1) {
            return 1;
        }
        
        long product = 1; //cummlative variable
        for (int i = 2; i <= n; i++) 
            product *= i;
        return product;
    }
    
}

//Học kỹ thuật viết code mới dc gọi là TDD - TEST DRIVEN DEVELOPMENT
//Là kỹ thuật ngay khi viết code, ngay khi thiết kế ra tên hàm/ class
//đã phải cbi luôn bộ kiểm thử- cbi các TEST CASE
//cbi luôn các case sẽ xài hàm này ntn
// cbi luôn các tính huống test các hàm dể xác định hàm đúng/ sai
// viết code hướng về đảm bảo các bài kiểm thử đặt ra
// các test cases - các tình huống xài hàm 1 khi hàm viết xong
//Case #1: n=0 -> getFactotial(0) -> expected : 1
//Case #2: n=1 -> getFactotial(1) -> expected : 1 
//Case #3: n=5 -> getFactotial(5) -> expected : 120
//Case #4: n=-5 -> getFactotial(-5) -> expected : exception
//Case #5: n=21 -> getFactotial(21) -> expected : exception
//                                      VALIDATOR
//TEST CASE: LÀ 1 tình huống kiểm thử app/màn hình/tính năng
//          Xem nó chạy đúng kh?
//          bằng cách đưa data cụ thể nào dó, xem nó output đúng kh
//          như dự kiến trước đó hay kh, tức là
//          đưa data, chờ app xử lý, và so sánh kq(actual) vs expected



