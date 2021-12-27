<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>

<h3>Information for all employees</h3>

<security:authorize access="hasRole('DRIVER')">
<input type="button" value="salary" onclick="window.location.href = 'driver_info'"> Only for drivers
</security:authorize>

<br/>
<br/>
<security:authorize access="hasRole('ELECTRICITY')">
    <input type="button" value="performance" onclick="window.location.href = 'electricity_info'"> Only for electricity
</security:authorize>



</body>
</html>