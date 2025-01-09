<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recipe4U</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body>
<header>
<nav>
            <h1>Recipes4U</h1>
            <!-- <form >
                <input type="text" placeholder="Search for recepies" class="searchBox">
                <button type="submit" class="searchButton">Search</button>
            </form> -->
</nav>

    <%@include file="all_component/navbar.jsp" %>
<header>    
    <main>
        <section>
            <div class="recipe-container">
                <h2>Search your favourite Recipe</h2>
            </div>
            <div class="recipe-details">
                <button type="button" class="recipe-close-btn">x</button>
                <div class="recipe-details-content"></div>
            </div>
        </section>
    </main>
    <script src="all_component/script.js"></script>

</body>
</html>