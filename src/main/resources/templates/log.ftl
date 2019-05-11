<#macro login path isRegForm>

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <div class="container">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <#if isRegForm>
                        <h3 class="panel-title">Please sign up for CI-161 Journal
                            <small>It's free!</small>
                        </h3>
                        </#if>
                        <#if !isRegForm>
                            <h3 class="panel-title">Please sign in to CI-161 Journal
                            </h3>
                        </#if>
                    </div>
                    <div class="panel-body">
                        <form action="${path}" role="form" method="post">
                            <#if isRegForm>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <input type="text" name="firstName" id="first_name"
                                                   class="form-control input-sm form-control ${(firstNameError??)?string('is-invalid', '')}"
                                                   placeholder="First Name">
                                            <#if firstNameError??>
                                                <div class="invalid-feedback">
                                                    ${firstNameError}
                                                </div>
                                            </#if>
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <input type="text" name="lastName" id="last_name"
                                                   class="form-control input-sm form-control ${(lastNameError??)?string('is-invalid', '')}" placeholder="Last Name">
                                            <#if lastNameError??>
                                                <div class="invalid-feedback">
                                                    ${lastNameError}
                                                </div>
                                            </#if>
                                        </div>
                                    </div>
                                </div>
                            </#if>
                            <div class="form-group">
                                <input type="text" name="username" id="username"
                                       class="form-control input-sm form-control ${(usernameError??)?string('is-invalid', '')}"

                                       placeholder="Username">
                                <#if usernameError??>
                                    <div class="invalid-feedback">
                                        ${usernameError}
                                    </div>
                                </#if>
                            </div>
                            <#if isRegForm>
                                <div class="form-group">
                                    <input type="email" name="email" id="email"
                                           class="form-control input-sm form-control ${(emailError??)?string('is-invalid', '')}"
                                           placeholder="Email Address">
                                    <#if emailError??>
                                        <div class="invalid-feedback">
                                            ${emailError}
                                        </div>
                                    </#if>
                                </div>
                            </#if>
                            <#if isRegForm>
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="password" name="password" id="password"
                                               class="form-control input-sm form-control ${(passwordError??)?string('is-invalid', '')}"
                                               placeholder="Password">
                                        <#if passwordError??>
                                            <div class="invalid-feedback">
                                                ${passwordError}
                                            </div>
                                        </#if>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="password" name="passwordConfirmation" id="passwordConfirmation"
                                               class="form-control input-sm form-control ${(passwordConfirmationError??)?string('is-invalid', '')}"
                                               placeholder="Confirm Password">
                                        <#if passwordConfirmationError??>
                                            <div class="invalid-feedback">
                                                ${passwordConfirmationError}
                                            </div>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                                </#if>

                                <#if !isRegForm>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm"
                                           placeholder="Password">
                                </div>
                                </#if>
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

                            <#if isRegForm>
                            <input type="submit" value="Sign Up" class="btn btn-info btn-block"><br>
                                <input type="reset" value="Clear" class="btn-info">
                            </#if>

                          <#if !isRegForm>
                                <input type="submit" value="Login" class="btn btn-info btn-block">
                            </#if>

                        </form>
                        <#if !isRegForm>
                            <h5>If you are not have account, you can register it</h5><br/>
                            <a class="btn btn-info btn-block" onclick="location.href='/registration'">
                                Registration
                            </a>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>

</#macro>