<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>




<h1>${user.name}</h1>



<button class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">Nova Obra</button>

<form:form commandName="obra"
	cssClass="form-horizontal registrationForm">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Nova Obra</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">Descrição:</label>
						<div class="col-sm-10">
							<form:input path="description" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="money" class="col-sm-2 control-label">Valor:</label>
						<div class="col-sm-10">
							<form:input path="money" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="city" class="col-sm-2 control-label">Cidade:</label>
						<div class="col-sm-10">
							<form:input path="city" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="state" class="col-sm-2 control-label">Estado:</label>
						<div class="col-sm-10">
							<form:input path="state" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="objective" class="col-sm-2 control-label">Objetivo:</label>
						<div class="col-sm-10">
							<form:input path="objective" cssClass="form-control" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-primary" value="Salvar" />
				</div>
			</div>
		</div>
	</div>

</form:form>

<c:forEach items="${user.obras}" var="obra">

  <table id="tabelaspec">
   
   <tr><td colspan="2" class="alc">Governo federal</td></tr>
   <tr><td colspan="2" ></td></tr>

   
   <tr><td colspan="2" class="alr"> ${obra.description}</td></tr>
   <tr><td colspan="2" class="alr"></td></tr>
   <tr><td colspan="2" class="alr"></td></tr>
   
   <tr>
     <td class="ale">Objetivo: ${obra.objective}</td>
     <td class="ale">Valor: ${obra.money}</td>
   </tr>
   <tr>
   <td class="ale">Cidade:  ${obra.city}</td>
   <td class="ale">Estado:  ${obra.state}</td>
   </tr>
   <tr>
   <td class="ale">Data Inicial:  ${obra.publishedDate}</td>
   <td class="ale">Data Final:  ${obra.finalDate}</td>
   </tr>
   
   <tr>
   <c:forEach items="${obra.patrocinadores}" var="patrocinador" >
          <tr>
             <td colspan="2" class="alc" >${patrocinador.nome}</td>
             
          </tr>
       
       </c:forEach>
   </tr>
   


</c:forEach>

