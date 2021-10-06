<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <span style="color: red; ">${errorMessage}</span>
    <form method="post">
        Name : <label>
        <input type="text" name="name">
    </label>
        Password : <label>
        <input type="password" name="password">
    </label>
        <input type="submit">
    </form>
</div>

<%@ include file="common/footer.jspf" %>