<#import "spring.ftl" as spring>
<#macro layout>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Login form</title>
        <link rel="stylesheet" href="../static/styles/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>
    </head>

    <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Movie Review</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="/movies"><@spring.message "layout.movies"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cookie"><@spring.message "layout.cookie"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login"><@spring.message "layout.login"/></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            <@spring.message "layout.navbar.chng_lang"/>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item"
                                   href="/?lang=ru"><@spring.message "layout.navbar.chng_lang.ru"/></a></li>
                            <li><a class="dropdown-item"
                                   href="/?lang=en"><@spring.message "layout.navbar.chng_lang.en"/></a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1"
                           aria-disabled="true"><@spring.message "layout.disabled"/></a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit"><@spring.message "layout.search"/></button>
                </form>
            </div>

            <#assign known = SPRING_SECURITY_CONTEXT?? >
            <#if known>
                <#assign
                user = SPRING_SECURITY_CONTEXT.authentication.principal
                name = user.getUsername()
                >
                <#if user??>
                    <a href="/profile/${name}" class="text-light m-2 m-sm-0">
                        <@spring.message "layout.hello"/>, ${name}

                        <#list user.authorities as auth>
                            <span class="text-danger">${auth}</span>
                            <#if auth?has_next>
                                /
                            </#if>
                        </#list>
                    </a>
                    <form action="/logout" method="post">
                        <#if _csrf??>
                            <input
                                    type="hidden"
                                    name="${(_csrf.parameterName)!'csrf-param-name'}"
                                    value="${(_csrf.token)!'csrf-token'}"/>
                        </#if>
                        <button type="submit" class="btn btn-outline-info m-2"
                                id="logout">
                            <@spring.message "layout.logout"/>
                        </button>
                    </form>
                </#if>
            <#else>
                <a href="/login"
                   class="btn btn-outline-info m-2"><@spring.message "layout.login"/></a>
                <a href="/register"
                   class="btn btn-outline-info m-2"><@spring.message "layout.register"/></a>
            </#if>

        </div>
    </nav>


    <div class="container">
        <#nested spring>
    </div>
    </body>

    </html>

</#macro>