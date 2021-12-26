<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <%--Choosing the type of table--%>
    <table class="table table-striped">
        <caption>Your todos are</caption>
        <thead>
        <tr>
            <th>Description</th>
            <th>Target date</th>
            <th>Is it done?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%--We use JSTl core for this--%>
        <core:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                    <%--We use JSTL fmt for this--%>
                <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
                <td>${todo.done}</td>
                <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
                <td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
            </tr>
        </core:forEach>
        </tbody>
    </table>
    <div>
        <a class="ui-button" href="/add-todo">Add a Todo</a>
    </div>
</div>

<%@ include file="common/footer.jspf" %>