<%@ include file="Header.jsp"%>
<br>
<br>
<br>
<c:choose>
<c:when test="${!empty mycartList}">
MY CART<br>
<table class="table table-hover">

<tr style=" background-color:#D8D4D4">
<th>Product Name</th>
<th>Product Description</th>
<th>quantity</th>
<th>Price</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach items="${mycartList}" var="cart">
<tr>
<td>${cart.cartproduct.name}</td>
<td>${cart.cartproduct.description}</td>
<td>${cart.quantity}</td>
<td>${cart.price}</td>
<td><a href="<c:url value='cartupdate${product.id}'/>"><span class="glyphicon glyphicon-pencil"></a></td>
<td><a href="<c:url value='cartitemdelete${cartid}'/>"><span class="glyphicon glyphicon-trash"></span></td>
</tr>
</c:forEach>
</table>
<a href="checkout">checkout</a>
</c:when>
<c:otherwise>
No Products in your Cart
</c:otherwise>
</c:choose>

<%@ include file="Footer.jsp"%>