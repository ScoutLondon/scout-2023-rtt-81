<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<h1 class="pb-3">Customer Detail</h1>

<section>
    <table>
        <tr><td>First Name</td><td>${customer.firstName}</td></tr>
        <tr><td>Last Name</td><td>${customer.lastName}</td></tr>
        <tr><td>Image</td><td>${customer.imageUrl}</td></tr>
    </table>
</section>



<jsp:include page="../include/footer.jsp"/>