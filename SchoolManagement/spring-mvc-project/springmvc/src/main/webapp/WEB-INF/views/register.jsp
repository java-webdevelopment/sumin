<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

 <section class="container mt-3" style="max-width: 560px;">
 	<form method="post" action="/registerProcess">
 		<div class="from-group">
 			<label>id</label>
 			<input type="text" name="name" class="form-control">
 		</div>
 		<div class="form-group">
 			<label>password</label>
 			<input type="password" name="password" class="form-control">
 		</div>
 		<button type="submit" class="btn btn-primary">register</button>
 	
 	</form>
 </section>


<%@ include file="common/footer.jspf" %>