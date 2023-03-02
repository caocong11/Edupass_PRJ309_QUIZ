<%-- 
    Document   : main
    Created on : Oct 26, 2022, 11:14:19 AM
    Author     : ASUS
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>EduEasy</title>

        <!-- swiper css link  -->
        <link rel="stylesheet" href="https://unpkg.com/swiper@8/swiper-bundle.min.css" />

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>

        <!-- header section starts  -->

        <header class="header">

            <section class="flex">

                <a href="#home" class="logo">EduEasy</a>

                <nav class="navbar">
                    <a href="#home">Trang chủ</a>
                    <a href="#about">Về chúng tôi</a>
                    <a href="#courses">Môn học</a>
                    
                    <c:if test="${sessionScope.accS=='admin'}">
                        <a href="listuser">Dashboad</a>
                    </c:if>
                  <c:if test="${not empty sessionScope.accS}">
                       
                            <a href="#">Welcome,${sessionScope.accS}</a>
                            
                            <a href="index.html" style="background: white ; padding: 10px 15px; border-radius: 10px ;">Đăng xuất</a>
                            <a href="forgetPass.jsp" style="background: white ; padding: 10px 15px; border-radius: 10px ;">Đổi mật khẩu</a>
                          
                          
                        </c:if>
                          <c:if test="${empty sessionScope.accS}"> <a href="signup.jsp    " style="background: white ; padding: 10px 15px; border-radius: 10px ;">Đăng kí</a>
                            <a href="login.jsp" style="background: white ; padding: 10px 15px; border-radius: 10px ;">Đăng nhập</a>
                            <a href="forgetPass.jsp" style="background: white ; padding: 10px 15px; border-radius: 10px ;">Quên mật khẩu</a>
                    </c:if>


                </nav>

                <div id="menu-btn" class="fas fa-bars"></div>

            </section>

        </header>

        <!-- header section ends -->

        <!-- home section starts  -->

        <section class="home" id="home">

            <div class="row">

                <div class="content">
                    <h3>Ôn thi <br><span>Hiệu quả</span></h3>
                    <a href="#contact" class="btn">contact us</a>
                </div>

                <div class="image">
                    <img src="images/homg-img.svg" alt="">
                </div>

            </div>

        </section>

        <!-- home section ends -->

        <!-- couter section stars  -->

        <section class="count">

            <div class="box-container">

                <div class="box">
                    <i class="fas fa-graduation-cap"></i>
                    <div class="content">
                        <h3>20</h3>
                        <p>Môn học</p>
                    </div>
                </div>

                <div class="box">
                    <i class="fas fa-user-graduate"></i>
                    <div class="content">
                        <h3>1300+</h3>
                        <p>students</p>
                    </div>
                </div>

               

               

            </div>

        </section>

        <!-- couter section ends -->

        <!-- about section starts  -->

        <section class="about" id="about">

            <div class="row">

                <div class="image">
                    <img src="images/about-img.svg" alt="">
                </div>

                <div class="content">
                    <h3>Tại sao lại chọn chúng tôi?</h3>
                    <p>Vì chúng tôi cung cấp cho bạn những tài liệu quan trọng và giải đáp mọi thắc mắc của các bạn trong quá trình ôn thi</p>
                    <a href="#contact" class="btn">contact us</a>
                </div>

            </div>

        </section>

        <!-- about section ends -->

        <!-- courses section starts  -->

        <section class="courses" id="courses">

            <h1 class="heading">Môn <span>Học</span></h1>

            <div class="swiper course-slider">

                <div class="swiper-wrapper">

<!--                    <div class="swiper-slide slide">
                        <img src="images/course-1.svg" alt="">
                        <h3><a href="mas.jsp" style="color: white; border: white solid 2px; border-radius: 2px; padding: 2px;">MAS291</a></h3>
                        <p></p>
                    </div>-->

                    <div class="swiper-slide slide">
                        <img src="images/course-2.svg" alt="">
                        <form action="quiz">
                            <input type="hidden" name="sid" value="2" style="display: none" ><h3 style="color: white; border: white solid 2px; border-radius: 2px; padding: 2px;">CSD201</h3> <BR> <BR>
                        <select name="level">
            <option>Easy</option>
             <option>Medium</option>
              <option>Hard  </option>
        </select> <input type="submit" value="Chọn">
                        </form>
       
                        <p></p>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/course-3.svg" alt="">
                          <form action="quiz">
                              <input type="hidden" name="sid" value="3" style="display: none" ><h3 style="color: white; border: white solid 2px; border-radius: 2px; padding: 2px;">DBI202</h3> <BR> <BR>
                        <select name="level">
            <option>Easy</option>
             <option>Medium</option>
              <option>Hard  </option>
        </select> <input type="submit" value="Chọn">
                        </form>
                        <p></p>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/course-4.svg" alt="">
                         <form action="quiz">
                             <input type="hidden" name="sid" value="1" style="display: none" ><h3 style="color: white; border: white solid 2px; border-radius: 2px; padding: 2px;">PRJ301</h3> <BR> <BR>
                        <select name="level">
            <option>Easy</option>
             <option>Medium</option>
              <option>Hard  </option>
        </select> <input type="submit" value="Chọn">
                        </form>
                        <p></p>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/course-5.svg" alt="">
                        <h3><a href="#" style="color: white; border: white solid 2px; border-radius: 2px; padding: 2px;">MAS291</a></h3>
                        <p></p>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/course-6.svg" alt="">
                        <h3><a href="#" style="color: white; border: white solid 2px; border-radius: 2px; padding: 2px;">MAS291</a></h3>
                        <p></p>
                    </div>

                </div>

                <div class="swiper-pagination"></div>

            </div>

        </section>

        <!-- courses section ends -->

        <!-- teachers section starts  -->

        <section class="teachers" id="teachers">

            <h1 class="heading">Chuyên <span>gia</span></h1>

            <div class="swiper teachers-slider">

                <div class="swiper-wrapper">

                    <div class="swiper-slide slide">
                        <img src="images/GettyImages-1371740975.jpg" alt="">
                        <div class="share">
                            <a href="https://www.facebook.com/HarryMaguire93" class="fab fa-facebook-f"></a>


                        </div>
                        <h3>Harry</h3>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/lukaku-1239.jpg" alt="">
                        <div class="share">
                            <a href="#" class="fab fa-facebook-f"></a>

                        </div>
                        <h3>Lukaku</h3>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/raheem-sterling-9688.jpeg" alt="">
                        <div class="share">
                            <a href="#" class="fab fa-facebook-f"></a>

                        </div>
                        <h3>Sterling</h3>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/kantei.jpg" alt="">
                        <div class="share">
                            <a href="https://www.facebook.com/sterling7official" class="fab fa-facebook-f"></a>

                        </div>
                        <h3>Kankute</h3>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/ronaldo-beo-xin-loi-cac-ba-me-vi-kieu-toc-ngoai-hanh-tinh.jpg" alt="">
                        <div class="share">
                            <a href="#" class="fab fa-facebook-f"></a>

                        </div>
                        <h3>Rô béo</h3>
                    </div>

                    <div class="swiper-slide slide">
                        <img src="images/linga.jpg" alt="">
                        <div class="share">
                            <a href="#" class="fab fa-facebook-f"></a>

                        </div>
                        <h3>Jessie</h3>
                    </div>

                </div>

                <div class="swiper-pagination"></div>

            </div>

        </section>

        <!-- teachers section ends -->

        <!-- reviews section starts  -->

<!--        <section class="reviews" id="reviews">

            <h1 class="heading"> Phản hồi <span>Của sinh viên</span></h1>

            <div class="swiper reviews-slider">

                <div class="swiper-wrapper">

                    <div class="swiper-slide slide">
                        <p>Tài liệu rất bổ ích và thầy cô rất nhiệt tình. Hy vọng đây sẽ là nơi mà các bạn sinh viên sẽ rút ngắn thời gian ôn thi của mình và đạt được kết quả tốt hơn trong mọi kì thi</p>
                        <div class="user">
                            <img src="images/pic-1.png" alt="">
                            <div class="user-info">
                                <h3>Harry</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Tài liệu rất bổ ích và thầy cô rất nhiệt tình. Hy vọng đây sẽ là nơi mà các bạn sinh viên sẽ rút ngắn thời gian ôn thi của mình và đạt được kết quả tốt hơn trong mọi kì thi</p>
                        <div class="user">
                            <img src="images/pic-2.png" alt="">
                            <div class="user-info">
                                <h3>An</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Tài liệu rất bổ ích và thầy cô rất nhiệt tình. Hy vọng đây sẽ là nơi mà các bạn sinh viên sẽ rút ngắn thời gian ôn thi của mình và đạt được kết quả tốt hơn trong mọi kì thi</p>
                        <div class="user">
                            <img src="images/pic-3.png" alt="">
                            <div class="user-info">
                                <h3>Bình</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Tài liệu rất bổ ích và thầy cô rất nhiệt tình. Hy vọng đây sẽ là nơi mà các bạn sinh viên sẽ rút ngắn thời gian ôn thi của mình và đạt được kết quả tốt hơn trong mọi kì thi</p>
                        <div class="user">
                            <img src="images/pic-4.png" alt="">
                            <div class="user-info">
                                <h3>Ngô</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Tài liệu rất bổ ích và thầy cô rất nhiệt tình. Hy vọng đây sẽ là nơi mà các bạn sinh viên sẽ rút ngắn thời gian ôn thi của mình và đạt được kết quả tốt hơn trong mọi kì thi</p>
                        <div class="user">
                            <img src="images/pic-5.png" alt="">
                            <div class="user-info">
                                <h3>Bá</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide slide">
                        <p>Tài liệu rất bổ ích và thầy cô rất nhiệt tình. Hy vọng đây sẽ là nơi mà các bạn sinh viên sẽ rút ngắn thời gian ôn thi của mình và đạt được kết quả tốt hơn trong mọi kì thi</p>
                        <div class="user">
                            <img src="images/pic-6.png" alt="">
                            <div class="user-info">
                                <h3>Khá</h3>
                                <div class="stars">
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star"></i>
                                    <i class="fas fa-star-half-alt"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="swiper-pagination"></div>

            </div>

        </section>-->

        <!-- reviews section ends -->

        <!-- contact section starts  -->

<!--        <section class="contact" id="contact">

            <h1 class="heading"><span>Đăng Kí</span> Nhanh</h1>

            <div class="row">

                <div class="image">
                    <img src="images/contact-img.svg" alt="">
                </div>

                <form action="" method="post">
                    <span>Tên</span>
                    <input type="text" required placeholder="Nhập tên bạn " maxlength="50" name="name" class="box">
                    <span>Tài khoản</span>
                    <input type="email" required placeholder="Nhập tài khoản bạn " maxlength="50" name="acc" class="box">
                    <span>Mật khẩu</span>
                    <input type="password" required placeholder="Nhập mật khẩu của bạn " maxlength="50" name="name" class="box">
                    <span>Số điện thoại</span>
                    <input type="number" required placeholder="Nhập số điện thoại của bạn" max="9999999999" min="0" name="number" class="box" onkeypress="if (this.value.length == 10)
                     return false;">
                    <span>select course</span>

                    <span>Giới tính</span>
                    <div class="radio">
                        <input type="radio" name="gender" value="male" id="male">
                        <label for="male">Nam</label>
                        <input type="radio" name="gender" value="female" id="female">
                        <label for="female">Nữ</label>
                    </div>
                    <input type="submit" value="Đăng kí" class="btn" name="register">
                </form>-->


        <!-- contact section ends -->

        <!-- footer section starts  -->

        <footer class="footer">

            <section>

                <div class="share">
                    <a href="#" class="fab fa-facebook-f"></a>
                    <a href="#" class="fab fa-twitter"></a>
                    <a href="#" class="fab fa-linkedin"></a>
                    <a href="#" class="fab fa-instagram"></a>
                    <a href="#" class="fab fa-youtube"></a>
                </div>

                <div class="credit">&copy;Liên hệ <span>Cao Công</span> | Chúc bạn ôn thi hiệu quả</div>

            </section>

        </footer>

        <!-- footer section ends -->















        <!-- swiper js link  -->
        <script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>

        <!-- custom js file link  -->
        <script src="js/script.js"></script>

    </body>
</html>
