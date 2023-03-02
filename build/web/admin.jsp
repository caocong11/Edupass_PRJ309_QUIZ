<%-- 
    Document   : admin
    Created on : Oct 26, 2022, 4:55:31 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <title>Modern Admin Dashboard</title>
    <link rel="stylesheet" href="css/admin.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
</head>
<body>
   <input type="checkbox" id="menu-toggle">
    <div class="sidebar">
        <div class="side-header">
            <h3>M<span>anage</span></h3>
        </div>
        
        <div class="side-content">
            <div class="profile">
                <div class="profile-img bg-img" style="background-image: url(https://th.bing.com/th/id/R.262d193c50f3544263df1ad9120d45e7?rik=YujZ8nfH9Zkkrw&pid=ImgRaw&r=0)"></div>
                <h4>Admin</h4>
            
            </div>

            <div class="side-menu">
                <ul>

                    <li>
                       <a href="listuser">
                            <span class="las la-user-alt"></span>
                            <small>Users</small>
                        </a>
                    </li>
                    
                    <li>
                       <a href="question">
                            <span class="las la-clipboard-list"></span>
                            <small>Question</small>
                        </a>
                    </li>


                    <li>
                       <a href="">
                            <span class="las la-tasks"></span>
                            <small>Score</small>
                        </a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
    
    <div class="main-content">
        
        <header>
            <div class="header-content">
                <label for="menu-toggle">
                    <span class="las la-bars"></span>
                </label>
                
                <div class="header-menu">
                    <label for="menu-toggle">
                        <span class="las la-search"></span>
                    </label>
                    
                    
                    <div class="user">
                        <div class="bg-img" style="background-image: url(https://lichthidaueuro.com/wp-content/uploads/2021/06/Maguire-2.jpg)"></div>
                        
                        <span class="las la-power-off"></span>
                        <span><a href="logout">Logout</a></span>
                    </div>
                </div>
            </div>
        </header>
        
        
        <main>
            
            <div class="page-header">
                <h1>Dashboard</h1>
             
            </div>
            
          


                <div class="records table-responsive">

                    <div class="record-header">
                        <div class="add">
                            <!-- <span>Entries</span>
                             <select name="" id="">
                                <option value="">ID</option>
                            </select>-->
                            <a href="addUser.jsp" style="padding: 3px; background-color: #22baa0; border-radius: 5px; border: #22baa0 solid;color: white ">Add User</a>
                        </div>
                        <form action ="search" method="post">
                        <div class="browse">
                            <input type="text" placeholder="Search" class="record-search " name="text" >
                            <input type="submit" value="Search" style="width: auto">
                            
                        </div>
                        </form>
                        </div>
                    </div>

                    <div>
                        <table width="100%" >
                            <thead>
                                <tr>
                                   
                                    <th> ID</th>
                                    <th>Username</th>
                                    <th> Password</th>
                                    <th> Phone</th>
                                    <th colspan="2" style="text-align: center">Edit</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                              
                                  <c:forEach items="${list}" var="item">
                                     <tr>
                                 <td>${item.id}</td>
                                 <td>${item.acc}</td>
                                <td>${item.pass}</td>
                                <td>${item.phone}</td>
                                <td style="text-align: center"><a href="update?sid=${item.id}"><i class="fa-solid fa-plus" style="color:#22baa0"></i></a></td>
                                <td style="text-align: center"> <a href="#" onclick="showMess(${item.id})"><i class="fa-solid fa-trash-can" style="color:#22baa0;"></i></a></td>
                                </tr>
                                  </c:forEach>
                                
                            

                                
                            </tbody>
                        </table>
                    </div>

                </div>
            
            </div>
            
     
        
   
</body>
 <script>
        function showMess(id){
            var op = confirm('Are you sure delete?');
            if(op == true){
                window.location.href='delete?sid='+id;
            }
        }
    </script>
</html>
