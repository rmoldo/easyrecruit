<%-- 
    Document   : hero-section
    Created on : Dec 27, 2020, 1:52:21 PM
    Author     : Dragos
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="generator" content="Jekyll v3.8.5">
    <title></title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/starter-template/">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Bootstrap core CSS -->
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
        
        body  {
        background-image: url(${pageContext.request.contextPath}/images/bgphoto.jpg);
        background-repeat: no-repeat, repeat;
        background-color: #D3D3D3;
        height: 800px; 
        background-position: center; 
        background-repeat: no-repeat; 
        background-size: cover;
        width: 100%;
        max-height: 100px;
        height: 100px;
        }
        
        h1 {
        left: 0;
        line-height: 200px;
        margin-top: -350px;
        position: absolute;
        text-align: center;
        top: 50%;
        width: 100%;
        color: #FFFFFF;
        text-shadow: 2px 2px #778899;
        font-size: 80px;
        padding-left: 159px;
        padding-right: 159px;
        
    }
        
    #container {
    width: 100%;
    height: 330px
}

#part1 {
    width: 100%;
    height: 295px;
    background-color: #D3D3D3;
    margin-top: 586px;
}

#part2 {
    width: 100%;
    height: 50px;
    background-color: #D3D3D3;
    position: relative;
    top: -15px
}

#companyinfo {
    width: 14%;
    height: 280px;
    position: relative;
    left: 8%;
    top: 30px;
    font-size: 35px;
    color: black;
}

#detail {
    color: gray;
    font-size: 16px
}

#explore {
    width: 14%;
    height: 280px;
    position: relative;
    top: -235px;
    left: 29%
}

#txt1,
#txt2,
#txt3,
#txt4,
#txt5 {
    color: white;
    font-size: 20px
}

.link {
    display: flex;
    width: 90px;
    height: 40px;
    color: grey;
    background-color: transparent;
    border-top: 2px solid white;
    position: relative;
    top: -10px
}

.link:hover,
.link1:hover {
    color: #e65100
}

#visit {
    width: 14%;
    height: 280px;
    position: relative;
    top: -515px;
    left: 42%
}

.text {
    color: gray;
    font-size: 14px;
    margin-top: -10px
}

#legal {
    width: 14%;
    height: 280px;
    position: relative;
    top: -800px;
    left: 59.5%
}

.link1 {
    display: flex;
    width: 150px;
    height: 40px;
    color: grey;
    background-color: transparent;
    border-top: 2px solid white;
    position: relative;
    top: -10px;
    margin-top: 7px
}

#connect {
    position: relative;
    top: -1080px;
    left: 78%;
    width: 14%;
    height: 280px
}

#txt5 {
    position: relative;
    top: 0px
}

.social {
    position: relative;
    top: -5px;
    margin-right: 10px;
    color: white;
    cursor: pointer
}

.fa-facebook-square:hover {
    color: #3B579D
}

.fa-linkedin:hover {
    color: #007BB6
}

.fa-twitter-square:hover {
    color: #2CAAE1
}

#txt6 {
    color: white;
    position: relative;
    top: 13px;
    left: 8%;
    width: 80%;
    color: #aaa7a7
}

.material-icons {
    position: relative;
    top: 3px
}  
    
    </style>
  </head>
  <body>
    
<main role="main" class="container">
   
     <h1> EasyRecruit is your go-to company for effortless and quick recruiting. </h1>
     
     
  <div id="container">
         <div id="part1">
             <div id="companyinfo"> <p>EasyRecruit</p>
                 <p id="detail">We are leaders in our industry when it comes to quick, effortless and efficient recruiting. </p>
             </div>
             <div id="explore">
                 <p id="txt1">Explore</p> <a class="link" href="#">Home</a> <a class="link" href="#">About us</a> <a class="link" href="#">Gallery</a> <a class="link" href="#">Careers</a>
             </div>
             <div id="visit">
                 <p id="txt2">Visit</p>
                 <p class="text">Univeristy of Lucian Blaga </p>
                 <p class="text">Victoriei Blvd. </p>
                 <p class="text">Sibiu </p>
                 <p class="text">Phone: (40) 258-880-038 </p>
                 <p class="text">E-mail: easyRecruit@ulbsibiu.ro</p>
             </div>
             <div id="legal">
                 <p id="txt3">Legal</p> <a class="link1" href="#">Terms and Conditions</a> <a class="link1" href="#">Private Policy</a>
             </div>
             <div id="connect">
                 <p id="txt5">Connect With US</p> <i class="fab fa-facebook-square social fa-2x"></i> <i class="fab fa-linkedin social fa-2x"></i> <i class="fab fa-twitter-square social fa-2x"></i>
             </div>
         </div>
         <div id="part2">
             <p id="txt6"><i class="material-icons tiny"> copyright</i> 2021 EasyRecruit - All right reserved</p>
         </div>
     </div>
     
   
</main><!-- /.container -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script></body>
</html>


