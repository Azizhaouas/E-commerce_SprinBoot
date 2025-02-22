<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ajouter une Catégorie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="bg-light">

<div class="container my-5">
    <!-- Header Section -->
    <div class="text-center mb-4">
        <h2 class="fw-bold text-primary">Gestion des Catégories</h2>
    </div>

    <!-- Add Category Form -->
    <div class="card mb-4 shadow-sm">
        <div class="card-body">
            <h5 class="card-title text-center text-secondary">Ajouter une Nouvelle Catégorie</h5>
            <form method="post" action="addCategory">
                <div class="mb-3">
                    <label for="nom" class="form-label">Nom de la Catégorie :</label>
                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom de la catégorie" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Ajouter</button>
            </form>
        </div>
    </div>

    <!-- Search Category Form -->
    <div class="card mb-4 shadow-sm">
        <div class="card-body">
            <h5 class="card-title text-center text-secondary">Rechercher une Catégorie</h5>
            <form method="get" action="searchs">
                <div class="input-group">
                    <input type="text" class="form-control" id="search" name="mc" value="${mc}" placeholder="Recherchez une catégorie">
                    <button type="submit" class="btn btn-secondary">Rechercher</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Category Table -->
    <div class="card shadow-sm">
        <div class="card-body">
            <h5 class="card-title text-secondary">Liste des Catégories</h5>
            <table class="table table-bordered table-hover">
                <thead class="table-primary text-center">
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${categorie}" var="c">
                        <tr>
                            <td class="text-center">${c.id}</td>
                            <td>${c.nom}</td>
                            <td class="text-center">
                                <a href="deletecat?id=${c.id}" class="btn btn-sm btn-danger">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Back Button -->
    <div class="mt-4 text-center">
        <a href="all" class="btn btn-light shadow-sm">Retour à la Liste des Produits</a>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-FWmFWDrh1jpd9NQHVlrB01eygvKZhPHB4jzv7CNdJZp2UocjDXA/rz81S6VxqLY/" crossorigin="anonymous"></script>

</body>
</html>
