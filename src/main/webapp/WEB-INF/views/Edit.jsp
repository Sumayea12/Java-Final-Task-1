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
                <!-- Add other table headers for additional student details -->
            </tr>
        </thead>
        <tbody>
             <tr>
             <form action="${pageContext.request.contextPath}/updateStudent" method="post">

                     <tr>
                         <td>
                             <input type="text" readonly name="id" value="${users.id}">
                             ${user.id}
                         </td>
                         <td>
                             <input type="text" name="fullname" value="${users.fullname}">
                         </td>
                         <td>
                             <input type="text" name="email" value="${users.email}">
                         </td>

                         <td>
                             <input type="text" readonly name="dateOfBirth" value="${users.dateOfBirth}">
                         </td>
                         <td>
                             <input type="text" readonly name="gender" value="${users.gender}">
                         </td>
                         <td>
                             <input type="text" readonly name="quota" value="${users.quota}">
                         </td>
                         <td>
                             <input type="text" readonly name="country" value="${users.country}">
                         </td>
                         <td><input type="submit" value="Update"></td>
                     </tr>


             </form>


             </tr>
        </tbody>
    </table>
</body>
</html>
