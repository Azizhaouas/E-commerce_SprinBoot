<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${product != null ? "Modifier Produit" : "Ajouter Produit"}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body class="bg-light">

<div class="container mt-5 p-4 bg-white rounded shadow">
    <div class="text-center mb-4">
        <h1 class="text-primary">${product != null ? "Modifier Produit" : "Ajouter Produit"}</h1>
        <p class="text-muted">Complétez les informations ci-dessous pour gérer vos produits.</p>
    </div>

    <form id="productForm" action="${product != null ? 'Update' : 'addProduct'}" method="post">

        <c:if test="${product != null}">
            <input type="hidden" name="id" value="${product.id}" />
        </c:if>

        <div class="mb-3">
            <label for="productName" class="form-label fw-bold">Nom du Produit</label>
            <input type="text" class="form-control" id="productName" name="Nom" placeholder="Entrez le nom du produit" value="${product != null ? product.name : ''}" required>
        </div>

        <div class="mb-3">
            <label for="productPrice" class="form-label fw-bold">Prix du Produit</label>
            <input type="number" class="form-control" id="productPrice" name="Prix" step="0.01" placeholder="Entrez le prix du produit" value="${product != null ? product.prix : ''}" required>
        </div>

        <div class="mb-3">
            <label for="productQuantity" class="form-label fw-bold">Quantité</label>
            <input type="number" class="form-control" id="productQuantity" name="Quantite" placeholder="Entrez la quantité disponible" value="${product != null ? product.quantite : ''}" required>
        </div>

        <div class="mb-3">
            <label for="category" class="form-label fw-bold">Catégorie</label>
            <select class="form-select" id="category" name="categorieId" required>
                <option value="">Sélectionnez une catégorie</option>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}" ${product != null && product.categorie.id == category.id ? 'selected' : ''}>${category.nom}</option>
                </c:forEach>
            </select>
        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success">
                ${product != null ? "<i class='fa fa-save'></i> Mettre à Jour" : "<i class='fa fa-plus'></i> Ajouter Produit"}
            </button>
            <a href="all" class="btn btn-warning">
                <i class="fa fa-arrow-left"></i> Retour
            </a>
        </div>

        <c:if test="${product != null}">
            <div class="mt-3 text-center">
                <button type="reset" class="btn btn-secondary">Annuler les modifications</button>
            </div>
        </c:if>

    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-FWmFWDrh1jpd9NQHVlrB01eygvKZhPHB4jzv7CNdJZp2UocjDXA/rz81S6VxqLY/" crossorigin="anonymous"></script>

</body>
</html>
