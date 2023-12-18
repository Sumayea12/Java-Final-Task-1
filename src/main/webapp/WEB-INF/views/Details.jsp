<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
<a href="${pageContext.request.contextPath}">Home</a>
    <h1>Student Details</h1>
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
            </tr>
        </thead>
        <tbody>
             <tr>
                                <td>${users.id}</td>
                                <td>${users.fullname}</td>
                                <td>${users.email}</td>
                                <td>${users.dateOfBirth}</td>
                                <td>${users.gender}</td>
                                <td>${users.quota}</td>
                                <td>${users.country}</td>

              </tr>
        </tbody>
    </table>
</body>
</html>
