<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
</head>
<body>
<a href="${pageContext.request.contextPath}">Home</a>
    <h1>User Details</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Date of Birth</th>
                <th>Gender</th>
                <th>Quota</th>
                <th>Country</th>
                <!-- Add other table headers for additional user details -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.fullname}</td>
                    <td>${user.email}</td>
                    <td>${user.dateOfBirth}</td>
                    <td>${user.gender}</td>
                    <td>${user.quota}</td>
                    <td>${user.country}</td>
                    <td>
                                     <!-- Show Details Button -->
                                            <form action="${pageContext.request.contextPath}/students/${user.id}" method="post">

                                                <input type="submit" value="Show Details">
                                            </form>

                    </td>
                    <td>

                                            <!-- Edit Button -->

                                            <form action="${pageContext.request.contextPath}/students/${user.id}/edit" method="post">

                                                <input type="submit" value="Edit">
                                            </form>
                    </td>
                    <td>
                                            <!-- Delete Button -->

                                            <form action="${pageContext.request.contextPath}/students/${user.id}/delete" method="post">
                                                <input type="submit" value="Delete">
                                            </form>
                    </td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
