<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Student Registration Confirmation</title>
</head>
<body>
    <h3>Registration Success</h3>

    <p>Your registration is successful. Please visit the login page.</p>

    <p>ID: ${student.id}</p>
    <p>Full Name: ${student.name}</p>
    <p>Email: ${student.email}</p>
    <p>Date Of Birth: ${student.dateOfBirth}</p>
    <p>Gender: ${student.gender}</p>
    <p>Quota: ${student.quota}</p>
    <p>Country: ${student.country}</p>

    <hr>

    <a href="${pageContext.request.contextPath}">Home</a>
</body>
</html>
