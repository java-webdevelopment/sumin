<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	
	<section class="container">
		<form method="post" action="/subjectAdd" class="form-inline mt-3">
			<input type="text" name="name" class="form-control mx-1 mx-2" placeholder="please type your name">
			<select name="subjectDivide" class="form-control mx-1 mt-2">
				<option value="history">history</option>
				<option value="Mathmatics">Mathmatics</option>
				<option value="English">English</option>
				<option value="Chemistry">Chemistry</option>
				<option value="ComputerScience">ComputerScience</option>
			</select>
			<button type="submit" class="btn btn-primary mx-1 mt-2">add</button>
		</form>
		
	</section>


<%@ include file="common/footer.jspf" %>