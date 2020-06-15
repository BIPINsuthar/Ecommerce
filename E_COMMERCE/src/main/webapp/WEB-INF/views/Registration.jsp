<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="./shared/bootstrap1.jsp" %>
</head>
<body>
      <form:form action="registration-from" modelAttribute="regi">
      Name:<form:input type="text" path="name"></form:input><br/>
      Password:<form:password  path="pass"/><br/>
      email:<form:input type="email" path="email"/><br/>
      phone:<form:input type="text" path="phone"/><br/>
      Gender:
      male<form:radiobutton path="gender" value="male"/>
      female<form:radiobutton path="gender" value="female"/>
      <br/>
      Address:<br/><form:textarea path="address"/><br/>
      <form:button>submit</form:button>
  </form:form>
  
  <!-- bootstrap2 file -->
  <%@include file="./shared/bootstrap2.jsp" %>
</body>
</html>