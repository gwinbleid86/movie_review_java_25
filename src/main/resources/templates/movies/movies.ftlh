<#import "../layout.ftlh" as main>
<@main.layout>
    <table class="table table-success table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Director</th>
            <th>Release Year</th>
        </tr>
        </thead>
        <tbody>
        <#list movies as movie>
            <tr>
                <td>${movie?index + 1}</td>
                <td>${movie.name}</td>
                <td>${movie.director.fullName}</td>
                <td>${movie.year?c}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@main.layout>