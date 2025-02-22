<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Gestion Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="bg-light">

<div class="container my-5">
    <!-- Title Section -->
    <div class="text-center mb-4">
        <h1 class="fw-bold text-primary">Gestion des Produits</h1>
    </div>

    <!-- Search Bar -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <form class="d-flex" method="get" action="search">
            <input class="form-control me-2" type="search" name="mc" placeholder="Rechercher un produit..." value="${mc}" aria-label="Search">
            <button class="btn btn-outline-primary" type="submit">Rechercher</button>
        </form>
        <div>
            <a href="addpage" class="btn btn-primary me-2">Ajouter Produit</a>
            <a href="addcatpage" class="btn btn-secondary">Ajouter Categorie</a>
        </div>
    </div>

    <!-- Product Table -->
    <div class="table-responsive shadow-sm rounded">
        <table class="table table-striped align-middle bg-white">
            <thead class="table-primary text-center">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Quantite</th>
                    <th>Categorie</th>
                    <th>Actions</th>
                </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${products}" var="p" >
                <thead class=" text-center">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.prix}</td>
                        <td>${p.quantite}</td>
                        <td>${p.categorie.nom}</td>
                        <td class="text-center">
                            <a href="delete?id=${p.id}" class="btn btn-sm btn-outline-danger">Supprimer</a>
                            <a href="modifier?id=${p.id}" class="btn btn-sm btn-outline-success"> Modifier</a>
                        </td>
                    </tr>
                  </thead>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-FWmFWDrh1jpd9NQHVlrB01eygvKZhPHB4jzv7CNdJZp2UocjDXA/rz81S6VxqLY/" crossorigin="anonymous"></script>

</body>
</html>
