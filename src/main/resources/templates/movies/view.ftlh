<#import "../layout.ftlh" as main>
<@main.layout>
    <div class="card text-center">
        <div class="card-header">
            ${movie.name}
        </div>
        <div class="card-body">
            <h5 class="card-title">${movie.year}</h5>
        </div>
        <div class="card-footer text-muted">
            ${movie.description}
        </div>
    </div>
</@main.layout>