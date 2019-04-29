<#--
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
</head>
<body>
<p>Welcome</p>
</body>
</html>-->
<#import "common/common.ftl" as c>

<@c.page>
    <div align="center">
        <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/login'">Login</button>
        <button class="w3-btn w3-hover-blue w3-round-large" onclick="location.href='/registration'">Registration</button>
    </div>
<div class="left">
    <h2>Welcome to the CI-161`s group main page.</h2>
    <p>Here you can see our schedule and some info about our group.</p>
</div>
</@c.page>
