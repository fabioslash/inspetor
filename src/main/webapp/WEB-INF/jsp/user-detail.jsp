<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>




<h1>${user.name}</h1>

<c:forEach items="${user.obras}" var="obra" >

  <div class="row">
  <div class="col-xs-9">Governo federal</div>
  </div>


   <h2>Descrição da Obra: ${obra.description}</h2>
   <h3>Objetivo: ${obra.objective}</h3>
   <h3>Cidade:  ${obra.city}</h3>
   <h3>Estado:  ${obra.state}</h3>
   
   <table class="table table-bordered table-hover table-striped">
     <thead>
      <tr>
         <th>Patrocinadores</th>
        
      </tr>
    </thead>  
    
    <tbody>
       <c:forEach items="${obra.patrocinadores}" var="patrocinador" >
          <tr>
             <td>${patrocinador.nome}</td>
             
          </tr>
       
       </c:forEach>
    </tbody>
    
   </table>
   


</c:forEach>

