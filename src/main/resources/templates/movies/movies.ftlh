<#import "../layout.ftlh" as main>
<@main.layout>
    <select class="form-select" aria-label="Default select example" onchange="window.location=this.value">
        <option selected>Open this select menu</option>
        <option value="/movies/sorted?sort=name">Name</option>
        <option value="/movies/sorted?sort=year">Release Year</option>
        <option value="/movies/sorted?sort=rating">Rating</option>
    </select>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/movies/sorted?page=0&size=3&sort=releaseYear,desc">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="/movies/sorted?page=1&size=3&sort=releaseYear,desc">1</a>
            </li>
            <li class="page-item"><a class="page-link" href="/movies/sorted?page=2&size=3&sort=releaseYear">2</a></li>
            <li class="page-item"><a class="page-link" href="/movies/sorted?page=3&size=3&sort=releaseYear">3</a></li>
            <li class="page-item"><a class="page-link" href="/movies/sorted?page=4&size=3&sort=releaseYear">Next</a>
            </li>
        </ul>
    </nav>
    <table id="movies" class="table table-success table-striped">
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