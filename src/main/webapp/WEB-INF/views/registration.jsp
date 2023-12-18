<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head></head>
<body>
<h3>Registration Page</h3>

<form:form method="post" action="store" modelAttribute="user">

<label>ID</label>
<form:input path="id" id="id"/>
<form:errors path="id"/>

<br><br>

<label>Full Name</label>
<form:input path="name" id="name"/>
<form:errors path="name"/>

<br><br>

<label>Date Of Birth</label>
<form:input type="date" path="dateOfBirth" id="dateOfBirth"/>
<form:errors path="dateOfBirth"/>

<br><br>

<label>Email</label>
<form:input path="email" id="email"/>
<form:errors path="email"/>

<br><br>

<label>Password</label>
<form:input path="password" id="password"/>
<form:errors path="password"/>

<br><br>
<label for="gender">Gender</label>
<form:select path="gender" id="gender">
    <form:option value="">Select Gender</form:option>
    <form:option value="male">Male</form:option>
    <form:option value="female">Female</form:option>
    <form:option value="other">Other</form:option>
</form:select>
<form:errors path="gender"/>
<br><br>

   <label>Quota</label><br>
   <form:checkbox path="quota" value="Freedom Fighter" id="quotaA"/>Freedom Fighter<br>
   <form:checkbox path="quota" value="Tribal" id="quotaB"/> Tribal<br>
   <form:checkbox path="quota" value="" id="Disabled"/> Disabled<br>
   <form:errors path="quota"/>

    <br><br>

  <label for="country">Country</label>
  <form:select path="country" id="country">
      <form:option value="Bangladesh">Bangladesh</form:option>
      <form:option value="India">India</form:option>
      <form:option value="United state">United State</form:option>
      <form:option value="Baharain">Baharin</form:option>
  </form:select>
  <form:errors path="country"/>


    <br><br>

<input type="submit" value="Register" />

</form:form>

<a href="${pageContext.request.contextPath}">Home</a>

</body>
</html>