package com.huynq.mathutil.core.test;

import com.huynq.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class) //class này cbi tách data ra khỏi lệnh xanh đỏ cho dễ kiểm soát test case
//JUnit tự generate code lúc compile, để giúp thực hiện hóa ý tưởng DDT
// nó sẽ tự bt lấy data ở mảng 2 chiều nào đó để nhồi vào assertEquals()
//ép ta phải viết code theo cách nào đó định nghĩa trước mới chạy dc
// thư viện đó dc gọi là Framework
public class MathUtilDDTTest {

    // ta tự tạo ra hàm tên tùy ý trả mãng 2 chiều
    // chứa ds data ta đự định nhồi vào hàm getF() và assertEquals()
    //phần duyệt mảng để nhồi hàm test, Framework sẽ tự lo
    @Parameterized.Parameters // data collection
    public static Object[][] initData() {
        int a[] = {5, 10, 15, 20, 25};
        
        return new Integer[][] {
                            {1,0},
                            {1,1},
                            {2,2},
                            {6,3},
                            {24,4},
                            {120,5},
                            {720,6}
                        };
    }
    @Parameterized.Parameter(value = 0)
    public long expected; // expected value
    @Parameterized.Parameter(value = 1)
    public int n; // test variable
    // map 2 biến này ứng với 2 cột từng dòng
    // của mảng ở trên
    // ta phải quy ước biến expected map vào cột nào mình muốn
    // thứ tự biến kh quan trọng, thứ tự trong mãng kh quan trọng
    // vì ta sẽ cấu hình việc map tương ứng này!
    @Test
    public void testGetFactotialGivenRightArgumentReturnWell() {
        Assert.assertEquals(expected, MathUtil.getFactotial(n));
    }
    
    

}

//DDT (Data Driven Testing) là 1 kỹ thuật viết code kiểm thử
// Unit Test, dùng để test các hàm/class 1 cách dễ đọc hơn
// bằng cách tách data kiểm thử và câu lệnh test thành 2 nơi khác nhau
//cd, no-DDT
//assertEquals(0,getF(1))
//assertEquals(1,getF(1))
//assertEquals(2,getF(2))
//assertEquals(6,getF(3))
// cách này dễ viết nhưng khó kiểm tra hết tập test cases cần
//test, trộn lẫn data đưa vào, và câu lệnh gọi hàm kiểm thử
// KỸ THUẬT TÁCH DATA 00,11,22,63,244,1205,7206
//để riêng ra 1 chô, sau đó nhồi fill/feed nạp chúng vào
//lệnh gọi hàm assertEquals(?,getF(?))
//kỹ thuật này gọi là: DATA DRIVEN TESTING
//                     tách data hướng về code kiểm thử
//THAM SỐ HÓA DATA - BIẾN DATA RA 1 NƠI, ĐẶT CHO CHÚNG TÊN BIẾN
// LÁT HỜI NHỜI VÀO LỆNH SO SÁNH
// THAM SỐ HÓA - BIẾN DATA THÀNH BIẾN THAM SỐ - PARAMETERIZED


//JUNIT sẽ tự đánh giá mảng ra thành các test case
// chạy so sánh xanh đỏ của từng test case và đưa ra kết luận chung!!!
// xanh khi tất cả cùng xanh
// chỉ ra 1 thằng đỏ, tất cả đỏ - hàm ý đúng là phải đúng hết khi dc

//KHI ĐỎ THÌ TA CÓ 2 TÌNH HƯỚNG
// ĐỎ: DO CÓ SỰ != NHAU GIỮA EXPECTED VÀ ACTUAL
//ĐỎ VÌ EXPECTED != ACTUAL, VẬY KH BẰNG VÌ:
//1. EXPECTED LÀ GIÁ TRỊ TÍNH TOÁN TRƯỚC, HÀM PHẢI TRẢ VỀ DC GIÁ TRỊ NÀY
// VÀ EXPECTED MÌNH TÍNH =  TAY KHI CHƯA XÀI APP, PHẢI TÍNH ĐÚNG
// MÀU ĐỎ LÀ DO ACTUAL KH ĐÚNG -> CODE SAI, BUG!!!

//2.EXPECTED MÌNH TÍNH BẰNG TAY, VÀ BỊ SÀI, KỲ VỌNG DA SAI ĐƯỢC
// KHI ĐÓ HÀM TRẢ VỀ CHO DÙ CÓ ĐÚNG THÌ CŨNG BỊ MÀU ĐỎ
//KỲ VỌNG HÀM SAI KH KẾT LUẦN DC AP CÓ BUG HAY KH

// UNit test giúp chất lượng code dc đảm bảo, qua việc chạy thử các test case đã dc viết ra
// Nếu các test cases kh passed chứng tỏ code còn bug, cần dc fix
// Một khi code còn bug thì phải fix chứ không cho release -> cho QC kiểm thử

//Nhờ unit test thì nếu ta tối ưu code, sửa thêm code, sửa bug (có thể gây ra bug khác) thì nếu có trong tay UNIT TEST
// cứ sửa code, CH#I CẦN Có Màu Xanh
// UNIT TEST giúp ta luôn duy trì MÀU XANH DÙ CÓ BIẾN ĐỘNG THẾ NÀO!!!

//UNIT TEST QUAN TRỌNG VÀ HỮU ÍCH!!!
//Code đang có việc Unit Test vẫn độc quá trình đóng gói app
//Nếu unit màu đỏ, còn bug, nhưng kh cấm mình đóng gói thành .jar. war .dll

//ĐÓNG GÓI APP LÀ QUÁ TRÌNH BIẾN SOURCE CODE THÀNH FILE NHỊ PHÂN,, FILE THỰC THI
                        // - SAU ĐÓ GÓI TIẾP FILE THỰC THI + CÁC THƯ VIỆN ĐI KÈM THÀNH FILE
                            // SETUP.EXE ĐỂ CHO END-USER DOWNLOAD VỀ VÀ CÀI VÀO MÁY
                                //HOẶC DEPLOY APP LÊN SERVER ()WEB APP

// VD C#
//SOUCE CODE : .cs                      FILE NHỊ PHÂN / .DLL .EXE
// .java                                .JAR .WAR .APK                   ->> SETUP.EXE
/*
PROJECT
.JAVA       .CLASS
.JAVA       .CLASS -----------------> NÉN/ GOM / ĐÓNG GÓI THÀNH .JAR .WAR .APK
.JAVA       .CLASS
    COMPILE/ DỊCH
                                            PACKING/BUILD      ANT, MAVEN, GRADLE   | 3 CÔNG CỤ NẰM NGOÀI JDK GIÚP ĐÓNG GÓI TOÀN BỘ THÀNH 1 TẬP TIN DUY NHẤT .JAR.WAR.APK | ANT MAVEN GRADLE DC GỌI LÀ BUILD TOOLS
    JAVA.EXE LO VỤ NÀY
    NẰM TRONG JDK


NETBEANS
JAVA ---------F6----------- .CLASS --------SHIFT F11------MAVEN,ANT,GRADLE...................JAR.WAR
                                        CLEAN AND BUILD


NHƯNG ĐÂY 3 HÀNG KHÁU NHAU, 3 TOOL KHÁC NHAU nên đóng gói khác nhau
Do đó b muốn chơi với tool nào, thì bạn cần tạo project theo tool đó
Do đó ta có 3 loại project Ant , Maven, Gradle


DISt .jar.War
    PRESS CLEAN & BUILD SHIFT F11 -> GỌI BUILD TOOL
*/
/*
CODE CỦA DỰ ÁN DẴ VIẾT XONG, KÉM THÊM JUNIT/UNIT TEST ĐỂ ĐẢM BẢO CHẤT LƯỢNG
->
KHỌNG CÓ RÀNG BUỘC NÀO XANH ĐỎ GIỮA XANH ĐỎ VÀ VIỆC RA ĐƯỢC .JAR
tức là: nếu code vẫn đang màu đỏ do sai Unit Test, ta vẫn đóng gói app như bth
(mặc định là vậy) vì việc Unit Test là 1 kỹ thuật dc bổ sung thêm vào việc code !!! kh phải là
hành động bắt buộc 1 cách nghiêm ngặt

Đóng gòi app bao hàm ý nghĩa app phải có chất lượng, chất lượng qua màu XANH là vd
Ta nên có kỹ thuật gài XANH ĐỎ vào trong QUÁ TRÌNH ĐÓNG GÓI
THÌ ĐẢM BẢO TÍNH NHẤT QUÁN VỀ CHẤT LƯỢNG!! Code tốt mới ra app

KỸ THUẬT GÀI UNIT TEST/JUNIT VÀO TRONG QUÁ TRÌNH ĐÓNG GÓI!!!\
NGHĨA LÀ CODE ĐANG ĐỎ, DO BUG, HAY NGÁO VỀ EXPECTED, THÌ ĐỀU NGĂN LẠI KH CHO RA FILE JAR, ĐỂ TÌM NGUYÊN CỦA ĐỎ, FIX XONG MỚI ĐI TIẾP DC
CODE ĐỎ, PHẢI SỬA CHO ỔN (REFACTOR CODE), TỨC LÀ THÊM CODE, BỎ CODE ĐỂ APP/ HÀM XỬ LÝ ĐÚNG
GỌI LÀ INTERGRATED/ INTERGRATION


VIỆC GÀI UNIT TEST/JUNIT TRONG QUÁ TRÌNH ĐÓNG GÓI KH CHỈ ÁP DỤNG CHO 1
DEV RIÊNG LẺ, MÀ CẦN ÁP DỤNG CHUNG CHO TOÀN BỘ DỰ ÁN, CHO CÁC DEV CÒN LẠI
ĐIỀU NÀY TỐT NHẤT NÊN DIỄN RA Ở NƠI CHỨA CODE CỦA TEAM, TỨC SERVER CHỨA CODE CỦA TEAM
SERVER NÀY GOM CODE, MỖI LẦN MUỐN BUILD APP THÌ TOÀN BỘ TEST CỦA TOÀN BỘ DỰ ÁN CŨNG CẦN DC CHECK XANH ĐỎ
HOẶC MỖI LẦN ANH EM SỬA CODE, CẬP NHẬT CODE LÊN SERVER, LẬP TỨC PHẢI CHECK XANH ĐỎ -> PHÒNG NGỪA NHAY KHI SỬA CODE

CỨ CÓ XANH ĐỎ Ở CODE SERVER - TÍCH HỢP CODE MỚI - INTEGRATION
THÌ CẦN CHECK NGAY XANH ĐỎ, ĐỂ PHÁT HIỆN BUG TỪ SỚM, HƠN LÀ ĐỂ SAU NÀY MỚI PHÁT HIỆN
CỨ              SỬA CODE                 LÀ              CHECK XANH ĐỎ
                INTEGRATION
CỨ                                      Là              LÀ LẶP LẠI LIÊN TỰC VIỆC ANH EM SỬA CODE: CONTINUOUS
LIÊN TỤC KIỂM TRA CODE MỚI THÊM VÀO CÓ NGON HAY KH
CONTINUOUS INTERGATION, ĐẢM BẢO CODE LUÔN XANH

ĐỂ CHOI CI - TA CẦN
`1. 1 SERVER CHỨA CODE CHUNG CẢ TEAM : GITHUB, GITLAB/ BITBUCKET(ATLASIAN - CHIA SẺ CỦA JIRA, SOURCETREE) / GIT ĐỘNG CƠ 4 THÌ (ABSTRACT CLASS/INTERFACE)
`2. 1 TOOL LẮNG NGHE/ LISTENER SỰ THAY ĐỔI CỦA SERVER, KÍCH HOẠT NGAY KHI GỌI NGAY BUILDTOOL -> CI TOOLS: Jenkins, Bamboo CI, TeamCity, Circle CI, Travis CI, GitHub Actions
                                                                                           BUILD TOOLS: ANT, MAVEN, GRADLE
    ĐỂ CHECK XANH ĐỎ CODE MỚI THÊM
`3. EMAIL CHỬI DEV NÀO VỪA UPLOAD CODE GÂY RA MÀU ĐỎ
    CODE XANH, KH VẤN ĐỀ - INTEGRATION
4. NẾU RA ĐƯỢC FILE .JAR .WAR THÀNH CÔNG, ĐẨY TIẾP NÓ SANG SERVER ĐỂ CHO DÂN KIỂM THỬ VÀO TEST APP (STAGING SERVER / TESTING SERVER)
NẾU TEST NGON, THÌ ĐẨY SANG MÁY KHÁCH HÀNG, HOẶC RA FILE SETUP.EXE
PHẦN 4 NÀY GỌI LÀ CD/DEVOPS

echo "# math-util-ant" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Quanghuy128/math-util-ant.git
git push -u origin main


git config --global user.email <githubEmail>
git config --global user.name <githubUsername>

pass kh cần gõ sẽ bị hỏi lần đầu push code lên github

2. NHỮNG LỆNH XÀI 1 LẦN CHO 1 DỰ ÁN - NẾU DU ÁN MỚI THÌ XÀI 1 LẦN
git init // khởi động folder chúa code thành kho local
        // sau này đồng bộ kho local lên kho ở remote
        // tạo ra .git
        // trong đây chứa cac1y history/ thay đổi của kh local
        // cấm xóa và sửa
// những lệnh đồng bộ code lần đầu tiên, chỉ xài 1 lần cho 1 dự án
git add <files>
git add * // except file has .
git add . // all


*/


