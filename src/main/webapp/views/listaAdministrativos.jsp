<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>

<div class="container text-center">
    <h1>Lista de Administrativos</h1>
    <table class="table table-dark table-bordered">
        <tbody>
            <% int count = 0; %>
            <% for (grupal.modelo.Administrativo administrativo : (List<grupal.modelo.Administrativo>) request.getAttribute("administrativos")) { %>
            <% if (count % 10 == 0) { %>
            <% if (count != 0) { %>
            <% } %>
            <thead>
                <tr>
                    <th class="col-1">RUN</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Fecha de Nacimiento</th>
					<th>Area</th>
					<th>Experiencia Previa</th>
                    <th></th>
                </tr>
            </thead>
        </tbody>
        <tbody>
        <% } %>
        <tr>
            <td class="col-1"><%= administrativo.getRun() %></td>
			<td><%= administrativo.getNombre() %></td>
			<td><%= administrativo.getApellido() %></td>
			<td><%= administrativo.getFechaNacimiento() %></td>
			<td><%= administrativo.getArea() %></td>
			<td><%= administrativo.getExpPrevia() %></td>
            <td>
                <a href="EditarAdministrativo?id=<%= administrativo.getId() %>" class="btn btn-success">Editar</a>
            </td>
        </tr>
        <% count++; %>
        <% } %>
        </tbody>
    </table>
    <ul class="pagination">
        <% int pages = count / 10 + 1; %>
        <li class="page-item"><a class="page-link" href="?pages=<%= pages %>"><%= pages %></a></li>
    </ul>
</div>