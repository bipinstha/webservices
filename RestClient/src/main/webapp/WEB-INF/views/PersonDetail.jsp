<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:: Rest Client ::</title>
    </head>
    <body>
        <h1>Rest Client</h1>
        <div>${error}</div>
        <table>
            <form:form modelAttribute="person">
                <tr>
                    <td><form:label path="name">Full Name:</form:label></td>
                    <td><form:input path="name" /></td>
                    <td><form:errors path="name" /></td>
                </tr>
                <tr>
                    <td><form:label path="address">Full Address:</form:label></td>
                    <td><form:input path="address" /></td>
                    <td><form:errors path="address" /></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email:</form:label></td>
                    <td><form:input path="email" /></td>
                    <td><form:errors path="email" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</a></td>
                    <td colspan="2">
                        <button type="submit" disabled="true">Submit</button>
                        &nbsp; &nbsp;<button type="reset" disable="true">Reset</button>
                    </td>
                </tr>
            </form:form>
        </table>
    </body>
</html>