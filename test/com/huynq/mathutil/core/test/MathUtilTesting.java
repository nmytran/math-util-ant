package com.huynq.mathutil.core.test;

import com.huynq.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

public class MathUtilTesting {

    //Framework ép dev phải tuân theo 1 khung dựng sẵn
    // thường khung dùng ký hiệu @ (annotation - flag đánh đấu 1 điều gì đó sẽ diễn ra lúc runtime, compile)
    //
    @Test //test thử hàm so sánh 2 value EXPECTED vs ACTUAL
    // máy tự so sánh giùm, kh nhìn = mắt để tự so sánh
    // như bên main xài sout()
    // mà FW JUnit tự generate code so sánh, tự show màu XANH ĐỎ mang ý nghĩa PASSED/FAILED
    public void tryAssert() {
        Assert.assertEquals(100, 100);
    }
    //TestCase #1
    //Qui tắc tên hàm cho test
    // Tên hàm bao hàm ngữ nghĩa cửa việc kiểm thử
    // Test này kiểm tra tính gt với tham số 0....20

    @Test
    public void testGetFactotialGivenRightArgumentReturnWell() {
        //Case #1: n = 0 -> getFactotial(0) -> expected : 1
        Assert.assertEquals(1, MathUtil.getFactotial(0));

        //Case #2: n = 1 -> getFactotial(1) -> expected : 1 
        Assert.assertEquals(1, MathUtil.getFactotial(1));

        //Case #3: n = 5 -> getFactotial(5) -> expected : 120
        Assert.assertEquals(120, MathUtil.getFactotial(5));

    }

    //TEST Except values
    //n < 0, kh tính gt âm
    //n > 20, kh tính giai thừa tràn kiểu long
    //hàm dc thiết kế: NÉM RA NGOẠI LỆ TÊN LÀ IllegalArgumentException
    //Nhận 1 error msg
    // Ta đo lường có câu chửi xuất hiện hay kh khi n = -5
    //NẾU -5 mà app ném ra ngoại lệ IllegalArgumentException
    // nghĩa là hàm ổn, chạy như thiết kế, như kỳ vọng
    // vậy nghĩa là hàm PASSED (XANH)
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactotialGivenWrongArgumentThrowsException() {
        //Case #4: n = -5 -> getFactotial(-5) -> expected : exception
//        MathUtil.getFactotial(-5);
        //Case #5: n = 21 -> getFactotial(21) -> expected : exception
        MathUtil.getFactotial(21);

    }
    //nếu tất cả các test case màu xanh -> hàm đúng cho những thứ mình đã test
    // XANH cuối cùng khi tất cả @Test xanh
    // 1. XANH khi tất cả đều xanh
    // Nếu trong các @Test có ít nhất 1 Đỏ -> tất cả là đỏ
    // ý nghĩa là hàm đúng thì phải đúng hết
    // Có 1 sai -> hàm kh ổn định về kết quả -> hàm sai
    // 2. Đỏ khi có ít nhất 1 thằng đỏ
    // Đỏ đến từ 1 tình huống
    // Expected đã tính đúng, Actual trả sai -> BUG CỦA HÀM
    // EXPECTED đã tính/ gõ sai, Actual sai đúng

}
//@Test là 1 annotation để báo với jnut, jvm, để generate ra hàm tryAssert thành hàm main()
//và gửi cho JVM để chạy. App chạy từ main()
// thiếu @Test == app thiếu main -> no-runnable method
