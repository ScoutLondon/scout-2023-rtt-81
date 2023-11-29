<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
<div class="container pt-5">
    <h1 class="pb-3">Employee Search</h1>

    <form action="/employee/search">
        <label for="search3">First Name</label>
        <br>
        <input type="text" id="search3" name="search3" placeholder="Search by first name" value="${search3}"/>
        <br>
        <label for="search4">Last Name</label>
        <br>
        <input type="text" id="search4" name="search4" placeholder="Search by last name" value="${search4}"/>
        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <!--c:if represents a conditional jstl test-->
    <c:if test="${not empty employeeVar}">

        <h1 class="pt-5">Employees Found ${employeeVar.size()}</h1> <!--pt refers to padding top-->

        <table class="table table-hover"> <!--class=table formats with nice spaces, table-hover makes rows highlighted on hover-->
            <tr>
                <td>Id</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Department</td>
            </tr>
            <c:forEach items="${employeeVar}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.department}</td>
                </tr>
            </c:forEach>

        </table>
    </c:if>

</div>
</section>

<jsp:include page="../include/footer.jsp"/>