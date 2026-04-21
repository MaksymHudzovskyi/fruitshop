<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
</head>
<body>

<h1>${message}</h1>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
    </tr>

    <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>
    </#list>

</table>

</body>
</html>
