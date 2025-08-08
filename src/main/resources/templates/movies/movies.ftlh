<#import "../layout.ftlh" as main>
<@main.layout>
    <table class="table table-success table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Director</th>
            <th>Release Year</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list movies as movie>
            <tr>
                <td>${movie?index + 1}</td>
                <td>${movie.name}</td>
                <td>${movie.director.fullName!'some director'}</td>
                <td>${movie.year?c}</td>
                <td><a href="/movies/${movie.id}" class="btn btn-info">More</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@main.layout>